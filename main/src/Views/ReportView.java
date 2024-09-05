package Views;

import controllers.ExpositionDetailController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ReportView extends javax.swing.JPanel {
    
    private int userId;
    
    public ReportView() {
        initComponents();
    }
    
    public void setUser(int userId) {
        this.userId = userId;
    }
    
    public void setData(String humidity, String pressure, String description, String date, String cityName, String feelsLike, String tempMin, String tempMax, String cloudCover) {
        ExpositionDetailController expositionDetail = new ExpositionDetailController();
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "ES");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", spanishLocale);
        String formattedDate = now.format(formatter);
        
        String text = "Condiciones climáticas de hoy en ";
        String textTimeExposition = "Tiempo total de exposicion: ";
        String textUvRays = "Radiacion recibida: ";
        int timeExposition = expositionDetail.getTotalTimeExposition(userId, formattedDate);
        double uvRays = expositionDetail.getTotalExposition(userId, formattedDate);
        
        textTimeExposition = textTimeExposition.concat(String.valueOf(timeExposition).concat(" minutos"));
        textUvRays = textUvRays.concat(String.valueOf(uvRays));
        
        text = text.concat(cityName);
        reportDate.setText(text);
        this.tempMax.setText(tempMax + "°C\n");
        this.tempMin.setText(tempMin + "°C\n");
        this.expositionTime.setText(textTimeExposition);
        this.totalUv.setText(textUvRays);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reportDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tempMin = new javax.swing.JLabel();
        totalUv = new javax.swing.JLabel();
        tempMax = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        expositionTime = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reportDate.setBackground(new java.awt.Color(255, 255, 255));
        reportDate.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        reportDate.setForeground(new java.awt.Color(0, 0, 51));
        reportDate.setText("Condiciones climáticas de hoy en:  ");
        add(reportDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 6, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Gadugi", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setText("Temp máxima prevista");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 170, -1));

        tempMin.setFont(new java.awt.Font("Gadugi", 3, 14)); // NOI18N
        tempMin.setForeground(new java.awt.Color(0, 0, 0));
        add(tempMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 80, 40));

        totalUv.setBackground(new java.awt.Color(255, 255, 255));
        totalUv.setFont(new java.awt.Font("Gadugi", 2, 14)); // NOI18N
        totalUv.setForeground(new java.awt.Color(0, 0, 51));
        totalUv.setText("Radiacion recibida");
        add(totalUv, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 290, -1));

        tempMax.setFont(new java.awt.Font("Gadugi", 3, 14)); // NOI18N
        tempMax.setForeground(new java.awt.Color(0, 0, 0));
        add(tempMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/tempMax.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 20, 60));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/tempMin.png"))); // NOI18N
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 20, 60));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Gadugi", 2, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 51));
        jLabel8.setText("Temp mínima prevista");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 170, -1));

        expositionTime.setBackground(new java.awt.Color(255, 255, 255));
        expositionTime.setFont(new java.awt.Font("Gadugi", 2, 14)); // NOI18N
        expositionTime.setForeground(new java.awt.Color(0, 0, 51));
        expositionTime.setText("Tiempo total de exposicion");
        add(expositionTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 300, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel expositionTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel reportDate;
    private javax.swing.JLabel tempMax;
    private javax.swing.JLabel tempMin;
    private javax.swing.JLabel totalUv;
    // End of variables declaration//GEN-END:variables
}
