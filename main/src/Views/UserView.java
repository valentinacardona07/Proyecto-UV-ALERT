package Views;

import utils.Constants;
import controllers.UserController;
import utils.EmailValidator;
import java.awt.Dialog;
import java.util.HashMap;
import java.util.Map;

public class UserView extends javax.swing.JPanel {

    InfoView alert = new InfoView();
    private int user_id;

    public UserView(int user_id) {
        this.user_id = user_id;
        initComponents();
        loadData(user_id);
    }

    private void loadData(int user_id) {
        Map<String, Object> userData = new HashMap<>();
        UserController user = new UserController();
        userData = user.getUser(user_id);
        this.new_name.setText(String.valueOf(userData.get("name")));
        this.new_last_name.setText(String.valueOf(userData.get("last_name")));
        this.new_email.setText(String.valueOf(userData.get("email")));
        this.new_confirm_email.setText(String.valueOf(userData.get("email")));
        this.new_password.setText(String.valueOf(userData.get("password")));
        this.new_confirm_password.setText(String.valueOf(userData.get("password")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        new_name = new javax.swing.JTextField();
        update_user = new javax.swing.JButton();
        new_email = new javax.swing.JTextField();
        new_last_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        new_confirm_email = new javax.swing.JTextField();
        new_confirm_password = new javax.swing.JPasswordField();
        new_password = new javax.swing.JPasswordField();
        edit_user = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        new_name.setBackground(new java.awt.Color(255, 255, 255));
        new_name.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        new_name.setForeground(new java.awt.Color(102, 102, 102));
        new_name.setEnabled(false);
        new_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_nameActionPerformed(evt);
            }
        });

        update_user.setBackground(new java.awt.Color(151, 233, 255));
        update_user.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        update_user.setForeground(new java.awt.Color(51, 51, 51));
        update_user.setText("GUARDAR");
        update_user.setEnabled(false);
        update_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_userActionPerformed(evt);
            }
        });

        new_email.setBackground(new java.awt.Color(255, 255, 255));
        new_email.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        new_email.setForeground(new java.awt.Color(102, 102, 102));
        new_email.setEnabled(false);
        new_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_emailActionPerformed(evt);
            }
        });

        new_last_name.setBackground(new java.awt.Color(255, 255, 255));
        new_last_name.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        new_last_name.setForeground(new java.awt.Color(102, 102, 102));
        new_last_name.setEnabled(false);
        new_last_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_last_nameActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre *");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Contraseña *");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Correo *");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Confirmar contraseña *");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Confirmar correo *");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Apellido *");

        new_confirm_email.setBackground(new java.awt.Color(255, 255, 255));
        new_confirm_email.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        new_confirm_email.setForeground(new java.awt.Color(102, 102, 102));
        new_confirm_email.setEnabled(false);
        new_confirm_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_confirm_emailActionPerformed(evt);
            }
        });

        new_confirm_password.setBackground(new java.awt.Color(255, 255, 255));
        new_confirm_password.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        new_confirm_password.setEnabled(false);

        new_password.setBackground(new java.awt.Color(255, 255, 255));
        new_password.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        new_password.setEnabled(false);

        edit_user.setBackground(new java.awt.Color(151, 233, 255));
        edit_user.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        edit_user.setForeground(new java.awt.Color(51, 51, 51));
        edit_user.setText("EDITAR");
        edit_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_userActionPerformed(evt);
            }
        });

        cancel.setBackground(new java.awt.Color(151, 233, 255));
        cancel.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        cancel.setForeground(new java.awt.Color(51, 51, 51));
        cancel.setText("CANCELAR");
        cancel.setEnabled(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Actualizar Datos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addGap(168, 168, 168)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(new_name, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(new_last_name, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addGap(144, 144, 144)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(new_password, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(new_confirm_password, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(edit_user, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(update_user, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(new_email, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(new_confirm_email, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(new_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(new_last_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(new_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(new_confirm_password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(new_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(new_confirm_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit_user)
                    .addComponent(update_user)
                    .addComponent(cancel))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void new_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_nameActionPerformed

    }//GEN-LAST:event_new_nameActionPerformed

    private void new_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_new_emailActionPerformed

    private void new_last_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_last_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_new_last_nameActionPerformed

    private void new_confirm_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_confirm_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_new_confirm_emailActionPerformed

    private void disableInputs() {
        new_name.setEnabled(false);
        new_last_name.setEnabled(false);
        new_password.setEnabled(false);
        new_confirm_password.setEnabled(false);
        new_email.setEnabled(false);
        new_confirm_email.setEnabled(false);
    }

    public boolean validateUpdate() {
        Map<String, String> update_data = new HashMap<>();
        UserController user = new UserController();
        Constants constants = new Constants();
        String key = "";
        String text = "";

        char[] password_char = new_password.getPassword();
        char[] new_confirm_password_char = new_confirm_password.getPassword();

        String new_email = this.new_email.getText();
        String new_confirm_email = this.new_confirm_email.getText();
        String new_password = String.valueOf(password_char);
        String new_confirm_password = String.valueOf(new_confirm_password_char);
        String new_first_name = this.new_name.getText();
        String new_last_name = this.new_last_name.getText();

        if (new_email.isEmpty() || new_confirm_email.isEmpty()
                || new_password.isEmpty() || new_confirm_password.isEmpty()
                || new_first_name.isEmpty() || new_last_name.isEmpty()) {
            key = "empty_imputs";
        } else {
            if (!new_email.equals(new_confirm_email)) {
                key = "different_emails";
            } else if (!new_password.equals(new_confirm_password)) {
                key = "different_password";
            } else if (!EmailValidator.isValidEmail(new_email)) {
                key = "email_format_invalid";
            } else {
                update_data.put("user_id", String.valueOf(user_id));
                update_data.put("email", new_email);
                update_data.put("password", new_password);
                update_data.put("name", new_first_name);
                update_data.put("last_name", new_last_name);
                update_data.put("age", "20");
                key = user.updateUser(update_data);
                loadData(this.user_id);
                disableInputs();
            }

        }

        text = constants.get_message(key);
        if (!key.isEmpty()) {
            printMessage(text);
            if (key == "success_update") {
                return true;
            }
        }
        return false;
    }

    public void printMessage(String message) {
        alert.setMessage(message);
        alert.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE); // Evita que la alerta sea modal respecto a la ventana modal
        alert.setAlwaysOnTop(true); // Asegura que la alerta esté siempre en primer plano
        alert.setVisible(true);
        alert.setLocationRelativeTo(this);
    }

    private void update_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_userActionPerformed
        boolean updateUser = validateUpdate();
        if (updateUser) {
            updateDom();
        }
    }//GEN-LAST:event_update_userActionPerformed

    private void edit_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_userActionPerformed
        new_name.setEnabled(true);
        new_last_name.setEnabled(true);
        new_password.setEnabled(true);
        new_confirm_password.setEnabled(true);
        new_email.setEnabled(true);
        new_confirm_email.setEnabled(true);
        this.edit_user.setEnabled(false);
        this.cancel.setEnabled(true);
        this.update_user.setEnabled(true);
    }//GEN-LAST:event_edit_userActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        updateDom();
    }//GEN-LAST:event_cancelActionPerformed

    public void updateDom() {
        new_name.setEnabled(false);
        new_last_name.setEnabled(false);
        new_password.setEnabled(false);
        new_confirm_password.setEnabled(false);
        new_email.setEnabled(false);
        new_confirm_email.setEnabled(false);
        loadData(user_id);
        this.edit_user.setEnabled(true);
        this.cancel.setEnabled(false);
        this.update_user.setEnabled(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton edit_user;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField new_confirm_email;
    private javax.swing.JPasswordField new_confirm_password;
    private javax.swing.JTextField new_email;
    private javax.swing.JTextField new_last_name;
    private javax.swing.JTextField new_name;
    private javax.swing.JPasswordField new_password;
    private javax.swing.JButton update_user;
    // End of variables declaration//GEN-END:variables
}
