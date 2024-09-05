package Views;

import controllers.UserConfigurationController;
import controllers.UserNotificationController;
import controllers.ExpositionDetailController;
import controllers.UserController;
import controllers.ApiService;
import controllers.SensorService;
import java.util.concurrent.atomic.AtomicReference;
import java.time.format.DateTimeFormatter;
import java.awt.BorderLayout;
import java.time.LocalDate;
import javax.swing.JPanel;
import java.util.HashMap;
import java.util.Locale;
import java.awt.Dialog;
import utils.Constants;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class DashboardView extends javax.swing.JFrame {
    
    private ReportView reportView = new ReportView();
    AlertView alert = new AlertView();
    private final AtomicReference<ApiService.UvDataTemplate> latestData = new AtomicReference<>();
    UserConfigurationController userConfig = new UserConfigurationController();
    
    private Thread sensorThread;
    private Thread apiThread;
    private volatile boolean runningSensor = false;
    private volatile boolean runningApi = false;
    
    private int userId;
    
    public DashboardView() {
        initComponents();
        SetDate();
        startApi();
    }
    
    private void SetDate() {
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "ES");
        dateDash.setText(now.format(DateTimeFormatter.ofPattern("EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
    }
    
    public void checkNotification(double uvRays) {
        UserNotificationController userNotification = new UserNotificationController();
        boolean apiNotification = userConfig.validateApiNotification(userId);
        if (apiNotification) {
            String key = userNotification.validateUv(uvRays, userId);
            String notification = Constants.get_recommendation(key);
            printAlert(notification);
        }
    }
    
    public void startApi() {
        if (!runningApi) { // Solo inicia el hilo si no está corriendo
            runningApi = true;
            apiThread = new Thread(this::fetchDataApi);
            apiThread.start();
        }
    }
    
    private void fetchDataApi() {
        
        while (runningApi) {
            try {
                ApiService.buildData();
                latestData.set(ApiService.getLatestData());
                String uvRays = Double.toString(latestData.get().getUvIndex());
                String temperature = Double.toString(latestData.get().getTemperature());
                String humidity = Double.toString(latestData.get().getHumidity());
                String pressure = Double.toString(latestData.get().getPressure());
                String description = latestData.get().getDescription();
                String date = String.valueOf(latestData.get().getDate());
                String nameCity = latestData.get().getCityName();
                String feelsLike = Double.toString(latestData.get().getFeelsLike());
                String tempMin = Double.toString(latestData.get().getTempMin());
                String tempMax = Double.toString(latestData.get().getTempMax());
                String cloudCover = Double.toString(latestData.get().getCloudCover());
                this.uvRays.setText(uvRays);
                this.temperature.setText(temperature + "° C");
                reportView.setUser(userId);
                reportView.setData(humidity, pressure, description, date, nameCity, feelsLike, tempMin, tempMax, cloudCover);
                
                String validate = userConfig.validateConfiguration(userId);
                if (validate != "no_info") {
                    this.checkNotification(Double.valueOf(uvRays));
                }
                
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Api thread was interrupted.");
                break;
            } catch (Exception error) {
                System.err.println("Error: " + error.getMessage());
                break;
            }
            
        }
    }
    
    public void stopApi() {
        if (apiThread != null && apiThread.isAlive()) {
            apiThread.interrupt();
        }
        runningApi = false;
    }
    
    public void runSensor() {
        if (!runningSensor) { // Solo inicia el hilo si no está corriendo
            runningSensor = true;
            sensorThread = new Thread(this::fetchDataSensor);
            sensorThread.start();
        }
    }
    
    private void fetchDataSensor() {
        SensorService sensor = new SensorService();
        
        int exposureTime = 10;
        String uvReading = "";
        double uvRays = 0.0;
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "ES");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", spanishLocale);
        String formattedDate = now.format(formatter);
        
        while (runningSensor) {
            try {
                uvReading = sensor.getData();
                if (uvReading == "sensor_error") {
                    String alert = Constants.get_message(uvReading);
                    this.turnOnSensor.setEnabled(true);
                    this.turnOffSensor.setEnabled(false);
                    printAlert(alert);
                    stopSensor();
                }
                uvRays = calculateUvRaysSensor(uvReading);
                this.validateExposition(exposureTime, uvRays, formattedDate);
                Thread.sleep(10000);
                validateExpositionDetail(formattedDate);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Sensor thread was interrupted.");
                break;
            } catch (Exception error) {
                System.err.println("Error: " + error.getMessage());
                break;
            }
        }
    }
    
    public double calculateUvRaysSensor(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray dataArray = jsonObject.getJSONArray("data");
        double total = 0.0;
        // Iterar sobre el JSONArray y extraer los números
        for (int i = 0; i < dataArray.length(); i++) {
            total += dataArray.getDouble(i);
        }
        return total;
    }
    
    public void stopSensor() {
        runningSensor = false;
        if (sensorThread != null && sensorThread.isAlive()) {
            sensorThread.interrupt();
        }
    }
    
    public void validateExposition(int exposureTime, double uvReading, String formattedDate) {
        UserNotificationController userNotification = new UserNotificationController();
        ExpositionDetailController expositionDetail = new ExpositionDetailController();
        
        this.setExpositionUv(exposureTime, uvReading, formattedDate);
        double totalExposition = expositionDetail.getTotalExposition(userId, formattedDate);
        int totalTimeExposition = expositionDetail.getTotalTimeExposition(userId, formattedDate);
        String recommendation = userNotification.getRecommendation(totalExposition, totalTimeExposition, this.userId);
        
        if (!recommendation.isEmpty()) {
            String notification = Constants.get_recommendation(recommendation);
            printAlert(notification);
            this.setNotification(notification, formattedDate);
        }
    }
    
    public void setNotification(String notification, String date) {
        UserNotificationController userNotification = new UserNotificationController();
        Map<String, String> data = new HashMap<>();
        data.put("user_id", String.valueOf(this.userId));
        data.put("message", notification);
        data.put("date", date);
        data.put("state", "sin leer");
        userNotification.createNotification(data);
    }
    
    public void setExpositionUv(int exposureTime, double uvReading, String formattedDate) {
        ExpositionDetailController expositionDetail = new ExpositionDetailController();
        Map<String, String> data = new HashMap<>();
        data.put("user_id", String.valueOf(this.userId));
        data.put("uv_data", String.valueOf(uvReading));
        data.put("date", formattedDate);
        data.put("time", String.valueOf(exposureTime));
        expositionDetail.createExposition(data);
    }
    
    public void validateExpositionDetail(String date) {
        ExpositionDetailController expositionDetail = new ExpositionDetailController();
        boolean limite_exposition = expositionDetail.validateExposition(userId, date);
        if (limite_exposition) {
            String notification = Constants.getUvRead("limit_exposition");
            printAlert(notification);
            this.setNotification(notification, date);
        }
    }
    
    public void printAlert(String message) {
        alert.dispose();
        alert.setMessage(message);
        alert.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE); // Evita que la alerta sea modal respecto a la ventana modal
        alert.setAlwaysOnTop(true); // Asegura que la alerta esté siempre en primer plano
        alert.setVisible(true);
        alert.setLocationRelativeTo(this);
    }
    
    public void setUser(int user) {
        this.userId = user;
        updateDashboard();
        initContent();
    }
    
    private void updateDashboard() {
        UserController user = new UserController();
        Map<String, Object> userData = new HashMap<>();
        String userName = "";
        
        userData = user.getUser(this.userId);
        userName = String.valueOf(userData.get("name"));
        this.welcome.setText("Bienvenid@ " + userName);
    }
    
    private void initContent() {
        ShowJPanel(new HomepageVIew(this.userId));
    }
    
    private void ShowJPanel(JPanel views) {
        views.setSize(570, 360);
        views.setLocation(0, 0);
        
        contentPanel.removeAll();
        contentPanel.add(views, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        exit = new javax.swing.JButton();
        home1 = new javax.swing.JButton();
        notification = new javax.swing.JButton();
        report = new javax.swing.JButton();
        sentting = new javax.swing.JButton();
        user = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        uvRays = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        temperature = new javax.swing.JLabel();
        turnOnSensor = new javax.swing.JButton();
        turnOffSensor = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        dateDash = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(61, 248, 180));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.setBackground(new java.awt.Color(141, 251, 211));
        exit.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(1, 46, 67));
        exit.setText("Salir");
        exit.setBorderPainted(false);
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 80, 30));

        home1.setBackground(new java.awt.Color(141, 251, 211));
        home1.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        home1.setForeground(new java.awt.Color(1, 46, 67));
        home1.setText("Principal");
        home1.setBorder(null);
        home1.setBorderPainted(false);
        home1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home1.setMargin(new java.awt.Insets(14, 14, 14, 14));
        home1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home1ActionPerformed(evt);
            }
        });
        jPanel1.add(home1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 160, 30));

        notification.setBackground(new java.awt.Color(141, 251, 211));
        notification.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        notification.setForeground(new java.awt.Color(1, 46, 67));
        notification.setText("Notificaciones");
        notification.setBorder(null);
        notification.setBorderPainted(false);
        notification.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        notification.setMargin(new java.awt.Insets(14, 14, 14, 14));
        notification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationMouseClicked(evt);
            }
        });
        notification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificationActionPerformed(evt);
            }
        });
        jPanel1.add(notification, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 160, 30));

        report.setBackground(new java.awt.Color(141, 251, 211));
        report.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        report.setForeground(new java.awt.Color(1, 46, 67));
        report.setText("Reportes");
        report.setBorder(null);
        report.setBorderPainted(false);
        report.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        report.setMargin(new java.awt.Insets(14, 14, 14, 14));
        report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportActionPerformed(evt);
            }
        });
        jPanel1.add(report, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 160, 30));

        sentting.setBackground(new java.awt.Color(141, 251, 211));
        sentting.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        sentting.setForeground(new java.awt.Color(1, 46, 67));
        sentting.setText("Configuración");
        sentting.setBorder(null);
        sentting.setBorderPainted(false);
        sentting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sentting.setMargin(new java.awt.Insets(14, 14, 14, 14));
        sentting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senttingActionPerformed(evt);
            }
        });
        jPanel1.add(sentting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 160, 30));

        user.setBackground(new java.awt.Color(141, 251, 211));
        user.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        user.setForeground(new java.awt.Color(1, 46, 67));
        user.setText("Usuario");
        user.setBorder(null);
        user.setBorderPainted(false);
        user.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        user.setMargin(new java.awt.Insets(14, 14, 14, 14));
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 160, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/logo_dashboard.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 100));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 46, 67));
        jLabel1.setText("UV ALERT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 480));

        jPanel2.setBackground(new java.awt.Color(1, 46, 67));

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Temperatura");

        uvRays.setBackground(new java.awt.Color(204, 204, 204));
        uvRays.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        uvRays.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Indice de radiacion");

        temperature.setBackground(new java.awt.Color(204, 204, 204));
        temperature.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        temperature.setForeground(new java.awt.Color(255, 255, 255));

        turnOnSensor.setBackground(new java.awt.Color(141, 251, 211));
        turnOnSensor.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        turnOnSensor.setForeground(new java.awt.Color(1, 46, 67));
        turnOnSensor.setText("Encender sensor");
        turnOnSensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnOnSensorActionPerformed(evt);
            }
        });

        turnOffSensor.setBackground(new java.awt.Color(141, 251, 211));
        turnOffSensor.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        turnOffSensor.setForeground(new java.awt.Color(1, 46, 67));
        turnOffSensor.setText("Apagar sensor");
        turnOffSensor.setEnabled(false);
        turnOffSensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnOffSensorActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/rango_uv.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(uvRays, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(temperature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addGap(111, 111, 111)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(turnOnSensor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(turnOffSensor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(uvRays, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addComponent(temperature, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(turnOnSensor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(turnOffSensor)
                        .addContainerGap(16, Short.MAX_VALUE))))
        );

        bg.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 34, 570, 80));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        bg.add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 570, 370));
        bg.add(welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 150, 20));

        dateDash.setFont(new java.awt.Font("Gill Sans MT", 2, 18)); // NOI18N
        dateDash.setForeground(new java.awt.Color(51, 51, 51));
        bg.add(dateDash, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 330, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void notificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationMouseClicked

    }//GEN-LAST:event_notificationMouseClicked

    private void notificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificationActionPerformed
        ShowJPanel(new NotificationVIew(this.userId));
    }//GEN-LAST:event_notificationActionPerformed

    private void reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportActionPerformed
        
        ShowJPanel(reportView);
    }//GEN-LAST:event_reportActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.stopSensor();
        this.stopApi();
        this.dispose();
        LoginView login = new LoginView(); // Crea una instancia de la ventana de login
        login.setVisible(true);
    }//GEN-LAST:event_exitActionPerformed

    private void senttingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senttingActionPerformed
        ShowJPanel(new ConfigurationView(this.userId));
    }//GEN-LAST:event_senttingActionPerformed

    private void home1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home1ActionPerformed
        ShowJPanel(new HomepageVIew(this.userId));
    }//GEN-LAST:event_home1ActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        ShowJPanel(new UserView(userId));
    }//GEN-LAST:event_userActionPerformed

    private void turnOnSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnOnSensorActionPerformed
        this.turnOnSensor.setEnabled(false);
        this.turnOffSensor.setEnabled(true);
        this.runSensor();
    }//GEN-LAST:event_turnOnSensorActionPerformed

    private void turnOffSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnOffSensorActionPerformed
        this.turnOnSensor.setEnabled(true);
        this.turnOffSensor.setEnabled(false);
        this.stopSensor();
    }//GEN-LAST:event_turnOffSensorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel dateDash;
    private javax.swing.JButton exit;
    private javax.swing.JButton home1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton notification;
    private javax.swing.JButton report;
    private javax.swing.JButton sentting;
    private javax.swing.JLabel temperature;
    private javax.swing.JButton turnOffSensor;
    private javax.swing.JButton turnOnSensor;
    private javax.swing.JButton user;
    private javax.swing.JLabel uvRays;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
