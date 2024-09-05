package Views;

import utils.Constants;
import controllers.UserConfigurationController;
import java.awt.Dialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigurationView extends javax.swing.JPanel {

    private int userId;

    public ConfigurationView(int UserId) {
        this.userId = UserId;
        initComponents();
        fillInfo();
    }

    public void fillInfo() {
        UserConfigurationController userConfig = new UserConfigurationController();
        List<Map<String, Object>> configData = new ArrayList<>();
        String validateConfig = userConfig.validateConfiguration(userId);

        if (!validateConfig.equals("no_info")) {
            configData = userConfig.getConfiguration(userId);
            if (configData != null) {
                for (Map<String, Object> config : configData) {
                    String exposureTime = String.valueOf(config.get("time_exposition"));
                    String skin = String.valueOf(config.get("skin"));
                    String disease = String.valueOf(config.get("disease"));
                    String apiNotification = String.valueOf(config.get("api_notification"));

                    if (apiNotification.equals("1")) {
                        this.apiNotification.setSelected(true);
                    }
                    if (!disease.isEmpty()) {
                        fillDiseaseSelector(disease);
                    }
                    if (!skin.isEmpty()) {
                        fillSkinSelector(skin);
                    }
                    if (!exposureTime.isEmpty()) {
                        this.exposureTime.setText(exposureTime);
                    }
                }
                this.saveButton.setEnabled(false);
            }
        }
    }

    public void printAlert(String message) {
        InfoView alert = new InfoView();
        alert.setMessage(message);
        alert.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE); // Evita que la alerta sea modal respecto a la ventana modal
        alert.setAlwaysOnTop(true); // Asegura que la alerta esté siempre en primer plano
        alert.setVisible(true);
        alert.setLocationRelativeTo(this);
    }

    public void fillSkinSelector(String skin) {
        System.out.println(skin);
        if (skin.equals("phototype_1")) {
            this.phototype_1.setSelected(true);
        } else if (skin.equals("phototype_2")) {
            this.phototype_2.setSelected(true);
        } else if (skin.equals("phototype_3")) {
            this.phototype_3.setSelected(true);
        } else if (skin.equals("phototype_4")) {
            this.phototype_4.setSelected(true);
        } else if (skin.equals("phototype_5")) {
            this.phototype_5.setSelected(true);
        } else if (skin.equals("phototype_6")) {
            this.phototype_6.setSelected(true);
        }
    }

    public void fillDiseaseSelector(String disease) {
        if (disease.equals("burn")) {
            this.burn.setSelected(true);
        } else if (disease.equals("cancer")) {
            this.cancer.setSelected(true);
        } else if (disease.equals("aging")) {
            this.aging.setSelected(true);
        } else if (disease.equals("dermatitis")) {
            this.dermatitis.setSelected(true);
        } else if (disease.equals("lupus")) {
            this.lupus.setSelected(true);
        } else if (disease.equals("dermatosis")) {
            this.dermatosis.setSelected(true);
        } else if (disease.equals("none")) {
            this.none.setSelected(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        phototype_skin = new javax.swing.ButtonGroup();
        skin_condition = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        burn = new javax.swing.JRadioButton();
        none = new javax.swing.JRadioButton();
        exposureTime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        aging = new javax.swing.JRadioButton();
        dermatitis = new javax.swing.JRadioButton();
        lupus = new javax.swing.JRadioButton();
        dermatosis = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        phototype_1 = new javax.swing.JRadioButton();
        phototype_2 = new javax.swing.JRadioButton();
        phototype_3 = new javax.swing.JRadioButton();
        saveButton = new javax.swing.JButton();
        phototype_4 = new javax.swing.JRadioButton();
        phototype_6 = new javax.swing.JRadioButton();
        phototype_5 = new javax.swing.JRadioButton();
        cancer = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        apiNotification = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(570, 360));

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Notificaciones");

        skin_condition.add(burn);
        burn.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        burn.setForeground(new java.awt.Color(51, 51, 51));
        burn.setText("Quemaduras");
        burn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                burnActionPerformed(evt);
            }
        });

        skin_condition.add(none);
        none.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        none.setForeground(new java.awt.Color(51, 51, 51));
        none.setText("Ninguna");
        none.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noneActionPerformed(evt);
            }
        });

        exposureTime.setBackground(new java.awt.Color(255, 255, 255));
        exposureTime.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        exposureTime.setForeground(new java.awt.Color(51, 51, 51));
        exposureTime.setActionCommand("<Not Set>");
        exposureTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exposureTimeActionPerformed(evt);
            }
        });
        exposureTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                exposureTimeKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Enfermedades o condiciones ");

        skin_condition.add(aging);
        aging.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        aging.setForeground(new java.awt.Color(51, 51, 51));
        aging.setText("Fotoenvejecimiento");
        aging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agingActionPerformed(evt);
            }
        });

        skin_condition.add(dermatitis);
        dermatitis.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        dermatitis.setForeground(new java.awt.Color(51, 51, 51));
        dermatitis.setText("Dermatitis actínica crónica");
        dermatitis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dermatitisActionPerformed(evt);
            }
        });

        skin_condition.add(lupus);
        lupus.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        lupus.setForeground(new java.awt.Color(51, 51, 51));
        lupus.setText("Lupus Eritematoso Cutáneo");
        lupus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lupusActionPerformed(evt);
            }
        });

        skin_condition.add(dermatosis);
        dermatosis.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        dermatosis.setForeground(new java.awt.Color(51, 51, 51));
        dermatosis.setText("Fotodermatosis");
        dermatosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dermatosisActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Fototipo de Piel");

        phototype_skin.add(phototype_1);
        phototype_1.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        phototype_1.setForeground(new java.awt.Color(51, 51, 51));
        phototype_1.setText("Fototipo I");
        phototype_1.setToolTipText("Piel muy clara, se quema fácilmente, no se broncea");
        phototype_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phototype_1ActionPerformed(evt);
            }
        });

        phototype_skin.add(phototype_2);
        phototype_2.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        phototype_2.setForeground(new java.awt.Color(51, 51, 51));
        phototype_2.setText("Fototipo II");
        phototype_2.setToolTipText("Piel clara, se quema fácilmente, se broncea mínimamente");
        phototype_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phototype_2ActionPerformed(evt);
            }
        });

        phototype_skin.add(phototype_3);
        phototype_3.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        phototype_3.setForeground(new java.awt.Color(51, 51, 51));
        phototype_3.setText("Fototipo III");
        phototype_3.setToolTipText("Piel intermedia, a veces se quema, se broncea moderadamente");
        phototype_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phototype_3ActionPerformed(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(151, 233, 255));
        saveButton.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        saveButton.setForeground(new java.awt.Color(51, 51, 51));
        saveButton.setText("GUARDAR");
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        phototype_skin.add(phototype_4);
        phototype_4.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        phototype_4.setForeground(new java.awt.Color(51, 51, 51));
        phototype_4.setText("Fototipo IV");
        phototype_4.setToolTipText("Piel más oscura, rara vez se quema, se broncea bien");
        phototype_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phototype_4ActionPerformed(evt);
            }
        });

        phototype_skin.add(phototype_6);
        phototype_6.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        phototype_6.setForeground(new java.awt.Color(51, 51, 51));
        phototype_6.setText("Fototipo VI");
        phototype_6.setToolTipText("Piel muy oscura, nunca se quema, se broncea intensamente");
        phototype_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phototype_6ActionPerformed(evt);
            }
        });

        phototype_skin.add(phototype_5);
        phototype_5.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        phototype_5.setForeground(new java.awt.Color(51, 51, 51));
        phototype_5.setText("Fototipo V");
        phototype_5.setToolTipText("Piel oscura, muy raramente se quema, se broncea intensamente");
        phototype_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phototype_5ActionPerformed(evt);
            }
        });

        skin_condition.add(cancer);
        cancer.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        cancer.setForeground(new java.awt.Color(51, 51, 51));
        cancer.setText("Cáncer de piel");
        cancer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancerActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Tiempo de exposición (min)");

        apiNotification.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        apiNotification.setForeground(new java.awt.Color(51, 51, 51));
        apiNotification.setText("Radiacion general");
        apiNotification.setToolTipText("Piel más oscura, rara vez se quema, se broncea bien");
        apiNotification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apiNotificationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(none)
                                            .addComponent(aging)
                                            .addComponent(cancer))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dermatitis)
                                            .addComponent(lupus)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(phototype_4, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                                    .addComponent(dermatosis)
                                                    .addComponent(phototype_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(phototype_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addGap(18, 18, 18)
                                .addComponent(burn))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(phototype_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(phototype_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(phototype_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveButton)))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exposureTime, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(apiNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(125, 125, 125))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exposureTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apiNotification)))
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aging))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dermatitis)
                            .addComponent(none)
                            .addComponent(burn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lupus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dermatosis)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phototype_1)
                            .addComponent(phototype_4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phototype_2))
                    .addComponent(phototype_5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phototype_3)
                            .addComponent(phototype_6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton)
                        .addGap(38, 38, 38))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        UserConfigurationController userConfig = new UserConfigurationController();
        Map<String, String> configData = new HashMap<>();
        Constants constants = new Constants();
        String disease = "";
        String api_notification = "";
        String phototype = "";
        String text;
        String key = "";
        int exposureTime = 0;

        try {

            if (!this.exposureTime.getText().isEmpty()) {
                exposureTime = Integer.valueOf(this.exposureTime.getText());
            }

            if (apiNotification.isSelected()) {
                api_notification = "1";
                Integer.valueOf(api_notification);
            } else {
                api_notification = "0";
                Integer.valueOf(api_notification);
            }
            // Verificar la enfermedad que está seleccionada
            if (burn.isSelected()) {
                disease = "burn";
            } else if (cancer.isSelected()) {
                disease = "cancer";
            } else if (aging.isSelected()) {
                disease = "aging";
            } else if (dermatitis.isSelected()) {
                disease = "dermatitis";
            } else if (lupus.isSelected()) {
                disease = "lupus";
            } else if (dermatosis.isSelected()) {
                disease = "dermatosis";
            } else if (none.isSelected()) {
                disease = "none";
            }
            // Verificar el tipo de piel seleccionado
            if (phototype_1.isSelected()) {
                phototype = "phototype_1";
            } else if (phototype_2.isSelected()) {
                phototype = "phototype_2";
            } else if (phototype_3.isSelected()) {
                phototype = "phototype_3";
            } else if (phototype_4.isSelected()) {
                phototype = "phototype_4";
            } else if (phototype_5.isSelected()) {
                phototype = "phototype_5";
            } else if (phototype_6.isSelected()) {
                phototype = "phototype_6";
            }

            configData.put("user_id", String.valueOf(this.userId));
            configData.put("skin", phototype);
            configData.put("disease", disease);
            configData.put("time_exposition", String.valueOf(exposureTime));
            configData.put("api_notification", String.valueOf(api_notification));
            String validateConfig = userConfig.validateConfiguration(userId);
            if (!validateConfig.equals("no_info")) {
                key = userConfig.updateConfiguration(configData);
            } else {
                key = userConfig.createConfiguration(configData);
            }

            text = Constants.get_message(key);

        } catch (NumberFormatException e) {
            text = "El tiempo de exposición debe ser un entero";
        }

        if (!key.isEmpty()) {
            printAlert(text);
            fillInfo();
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void exposureTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exposureTimeActionPerformed
        this.saveButton.setEnabled(true);
    }//GEN-LAST:event_exposureTimeActionPerformed

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonMouseClicked

    private void phototype_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phototype_1ActionPerformed
        this.saveButton.setEnabled(true);
    }//GEN-LAST:event_phototype_1ActionPerformed

    private void phototype_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phototype_4ActionPerformed
        this.saveButton.setEnabled(true);
    }//GEN-LAST:event_phototype_4ActionPerformed

    private void phototype_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phototype_6ActionPerformed
        this.saveButton.setEnabled(true);
    }//GEN-LAST:event_phototype_6ActionPerformed

    private void phototype_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phototype_5ActionPerformed
        this.saveButton.setEnabled(true);
    }//GEN-LAST:event_phototype_5ActionPerformed

    private void phototype_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phototype_2ActionPerformed
        this.saveButton.setEnabled(true);
    }//GEN-LAST:event_phototype_2ActionPerformed

    private void phototype_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phototype_3ActionPerformed
        this.saveButton.setEnabled(true);
    }//GEN-LAST:event_phototype_3ActionPerformed

    private void apiNotificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apiNotificationActionPerformed
        this.saveButton.setEnabled(true);
    }//GEN-LAST:event_apiNotificationActionPerformed

    private void noneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noneActionPerformed
        this.saveButton.setEnabled(true);
    }//GEN-LAST:event_noneActionPerformed

    private void cancerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancerActionPerformed
        this.saveButton.setEnabled(true);
    }//GEN-LAST:event_cancerActionPerformed

    private void agingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agingActionPerformed
        this.saveButton.setEnabled(true);
    }//GEN-LAST:event_agingActionPerformed

    private void dermatitisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dermatitisActionPerformed
        this.saveButton.setEnabled(true);
    }//GEN-LAST:event_dermatitisActionPerformed

    private void lupusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lupusActionPerformed
        this.saveButton.setEnabled(true);
    }//GEN-LAST:event_lupusActionPerformed

    private void dermatosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dermatosisActionPerformed
        this.saveButton.setEnabled(true);
    }//GEN-LAST:event_dermatosisActionPerformed

    private void burnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_burnActionPerformed
        this.saveButton.setEnabled(true);
    }//GEN-LAST:event_burnActionPerformed

    private void exposureTimeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_exposureTimeKeyTyped
        this.saveButton.setEnabled(true);
    }//GEN-LAST:event_exposureTimeKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton aging;
    private javax.swing.JRadioButton apiNotification;
    private javax.swing.JRadioButton burn;
    private javax.swing.JRadioButton cancer;
    private javax.swing.JRadioButton dermatitis;
    private javax.swing.JRadioButton dermatosis;
    private javax.swing.JTextField exposureTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton lupus;
    private javax.swing.JRadioButton none;
    private javax.swing.JRadioButton phototype_1;
    private javax.swing.JRadioButton phototype_2;
    private javax.swing.JRadioButton phototype_3;
    private javax.swing.JRadioButton phototype_4;
    private javax.swing.JRadioButton phototype_5;
    private javax.swing.JRadioButton phototype_6;
    private javax.swing.ButtonGroup phototype_skin;
    private javax.swing.JButton saveButton;
    private javax.swing.ButtonGroup skin_condition;
    // End of variables declaration//GEN-END:variables
}
