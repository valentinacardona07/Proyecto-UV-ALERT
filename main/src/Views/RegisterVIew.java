package Views;

import utils.Constants;
import java.util.HashMap;
import java.util.Map;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import utils.EmailValidator;
import controllers.UserController;
import java.awt.Dialog;

public class RegisterVIew extends javax.swing.JPanel {

    InfoView alert = new InfoView();

    public RegisterVIew() {
        initComponents();
        loadUtils();
    }

    public void loadUtils() {
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    validateRegistry(); // Método que realiza la validación de login
                }
            }
        });
        last_name.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    validateRegistry(); // Método que realiza la validación de login
                }
            }
        });
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    validateRegistry(); // Método que realiza la validación de login
                }
            }
        });
        confirm_email.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    validateRegistry(); // Método que realiza la validación de login
                }
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    validateRegistry(); // Método que realiza la validación de login
                }
            }
        });
        confirm_password.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    validateRegistry(); // Método que realiza la validación de login
                }
            }
        });
        age.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    validateRegistry(); // Método que realiza la validación de login
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        confirm_password = new javax.swing.JTextField();
        done = new javax.swing.JButton();
        email = new javax.swing.JTextField();
        last_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        confirm_email = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setForeground(new java.awt.Color(19, 127, 217));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(0, 105, 192));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Registro");
        title.setPreferredSize(new java.awt.Dimension(40, 20));
        background.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 198, 35));

        confirm_password.setBackground(new java.awt.Color(255, 255, 255));
        confirm_password.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        confirm_password.setForeground(new java.awt.Color(102, 102, 102));
        confirm_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_passwordActionPerformed(evt);
            }
        });
        background.add(confirm_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 182, -1));

        done.setBackground(new java.awt.Color(0, 105, 192));
        done.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        done.setForeground(new java.awt.Color(255, 255, 255));
        done.setText("GUARDAR");
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });
        background.add(done, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 190, -1));

        email.setBackground(new java.awt.Color(255, 255, 255));
        email.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        email.setForeground(new java.awt.Color(102, 102, 102));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        background.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 182, -1));

        last_name.setBackground(new java.awt.Color(255, 255, 255));
        last_name.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        last_name.setForeground(new java.awt.Color(102, 102, 102));
        last_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last_nameActionPerformed(evt);
            }
        });
        background.add(last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 182, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre *");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Contraseña *");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Correo *");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Confirmar contraseña *");
        background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Confirmar correo *");
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Apellido *");
        background.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        confirm_email.setBackground(new java.awt.Color(255, 255, 255));
        confirm_email.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        confirm_email.setForeground(new java.awt.Color(102, 102, 102));
        confirm_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_emailActionPerformed(evt);
            }
        });
        background.add(confirm_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 182, -1));

        name.setBackground(new java.awt.Color(255, 255, 255));
        name.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        name.setForeground(new java.awt.Color(102, 102, 102));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        background.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 182, -1));

        password.setBackground(new java.awt.Color(255, 255, 255));
        password.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        password.setForeground(new java.awt.Color(102, 102, 102));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        background.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 180, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Edad");
        background.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        age.setBackground(new java.awt.Color(255, 255, 255));
        age.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        age.setForeground(new java.awt.Color(102, 102, 102));
        age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageActionPerformed(evt);
            }
        });
        background.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 182, -1));

        jButton1.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 105, 192));
        jButton1.setText("< Acceder");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        background.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/logo_alert.png"))); // NOI18N
        background.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void last_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_last_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_last_nameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    public void validateRegistry() {
        UserController user = new UserController();
        Map<String, String> data = new HashMap<>();
        Constants constants = new Constants();
        String key = "";
        String text = "";

        try {
            String age = this.age.getText();
            Integer.valueOf(age);
            String email = this.email.getText();
            String confirm_email = this.confirm_email.getText();
            String password = this.password.getText();
            String confirm_password = this.confirm_password.getText();
            String name = this.name.getText();
            String last_name = this.last_name.getText();

            if (email.isEmpty() || confirm_email.isEmpty()
                    || password.isEmpty() || confirm_password.isEmpty()
                    || name.isEmpty() || last_name.isEmpty() || age.isEmpty()) {
                key = "empty_imputs";
            } else {
                if (!email.equals(confirm_email)) {
                    key = "different_emails";
                } else if (!password.equals(confirm_password)) {
                    key = "different_password";
                } else if (!EmailValidator.isValidEmail(email)) {
                    key = "email_format_invalid";
                } else {
                    data.put("age", age);
                    data.put("email", email);
                    data.put("password", password);
                    data.put("name", name);
                    data.put("last_name", last_name);

                    key = user.createUser(data);
                }
            }
        } catch (NumberFormatException e) {
            key = "number_format";
        }
        text = Constants.get_message(key);
        printAlert(text, key);
    }
    private void doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneActionPerformed
        validateRegistry();
    }//GEN-LAST:event_doneActionPerformed

    public void cleanInputs() {
        this.age.setText("");
        this.email.setText("");
        this.confirm_email.setText("");
        this.password.setText("");
        this.confirm_password.setText("");
        this.name.setText("");
        this.last_name.setText("");
    }

    public void printAlert(String message, String key) {

        alert.setMessage(message);
        alert.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE); // Evita que la alerta sea modal respecto a la ventana modal
        alert.setAlwaysOnTop(true); // Asegura que la alerta esté siempre en primer plano
        alert.setVisible(true);
        alert.setLocationRelativeTo(this);
        if (key == "success_registry") {
            cleanInputs();
        }
    }

    private void confirm_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_passwordActionPerformed

    }//GEN-LAST:event_confirm_passwordActionPerformed

    private void confirm_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirm_emailActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.closeModal(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void closeModal(RegisterVIew register) {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof JDialog) {
            JDialog dialog = (JDialog) window;
            dialog.dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age;
    private javax.swing.JPanel background;
    private javax.swing.JTextField confirm_email;
    private javax.swing.JTextField confirm_password;
    private javax.swing.JButton done;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField last_name;
    private javax.swing.JTextField name;
    private javax.swing.JTextField password;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
