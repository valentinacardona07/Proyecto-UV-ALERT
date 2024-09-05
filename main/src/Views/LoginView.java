package Views;

import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.Dialog;
import java.awt.Color;

import controllers.UserController;
import utils.EmailValidator;
import javax.swing.JDialog;
import utils.Constants;
import Views.AlertView;

public class LoginView extends javax.swing.JFrame {

    private final String emailPlacerholder = "Email";
    private final String passwordPlacerholder = "Password";

    public LoginView() {
        initComponents();
        loadUtils();
    }

    public void loadUtils() {
        background.requestFocusInWindow();
        email.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (email.getText().equals(emailPlacerholder)) {
                    email.setText("");
                    email.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (email.getText().isEmpty()) {
                    email.setText(emailPlacerholder);
                    email.setForeground(Color.GRAY);
                }
            }
        });
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (password.getText().equals(passwordPlacerholder)) {
                    password.setText("");
                    password.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (password.getText().isEmpty()) {
                    password.setText(passwordPlacerholder);
                    password.setForeground(Color.GRAY);
                }
            }
        });

        email.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    loginValidate(); // Método que realiza la validación de login
                }
            }
        });

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    loginValidate(); // Método que realiza la validación de login
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        slogan = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        password = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(800, 500));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        slogan.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        slogan.setForeground(new java.awt.Color(19, 127, 217));
        slogan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        slogan.setText("<html>BRIGHT SUN, CONSTANT PROTECTION");
        background.add(slogan, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 347, 230, 24));

        register.setBackground(new java.awt.Color(255, 255, 255));
        register.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        register.setForeground(new java.awt.Color(0, 105, 192));
        register.setText("Registrarse >");
        register.setBorder(null);
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
        });
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        background.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, -1, -1));

        password.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(51, 51, 51));
        password.setText("Password");
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        background.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 254, 31));

        login.setBackground(new java.awt.Color(19, 127, 217));
        login.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        login.setForeground(new java.awt.Color(51, 51, 51));
        login.setText("Ingresar");
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                loginKeyTyped(evt);
            }
        });
        background.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 275, 196, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/logo_dashboard.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 6, 116, -1));

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 46, 67));
        jLabel3.setText("<html>UV ALERT");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 122, 70, -1));

        email.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N
        email.setForeground(new java.awt.Color(51, 51, 51));
        email.setText("Email");
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        background.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 254, 31));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void loginValidate() {
        UserController user = new UserController();

        Constants constants = new Constants();
        String email_ = this.email.getText();
        String password_ = this.password.getText();
        String key = "";
        String text;

        if (email_.equals("Email") || password_.equals("Password")) {
            key = "empty_imputs";
        } else {
            if (!EmailValidator.isValidEmail(email_)) {
                key = "email_format_invalid";
            } else {
                String validateUser = user.validateLogin(email_, password_);

                if (validateUser != "no_info" && validateUser != "sql_query_error") {
                    int userId = Integer.valueOf(validateUser);
                    DashboardView dashboard = new DashboardView();
                    dashboard.setUser(userId);
                    dashboard.setTitle("UV ALERT");
                    dashboard.setVisible(true);
                    dispose();
                } else {
                    key = validateUser;
                }
            }
        }
        if (!key.isEmpty()) { // Solo muestra la alerta si hay un error
            text = constants.get_message(key);
            printAlert(text);
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

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed

        loginValidate();
    }//GEN-LAST:event_loginActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        //Configurar la ventana de registro (puedes utilizar
        //un JPanel o cualquier otro componente)
        JDialog registerDialog = new JDialog(this, "", true); // El tercer parámetro true hace que el diálogo sea modal
        registerDialog.setTitle("Registro");
        RegisterVIew registerPanel = new RegisterVIew();
        registerDialog.add(registerPanel);
        registerDialog.pack();
        registerDialog.setLocationRelativeTo(this);
        registerDialog.setVisible(true);
    }//GEN-LAST:event_registerActionPerformed

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_registerMouseClicked

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginKeyPressed

    }//GEN-LAST:event_loginKeyPressed

    private void loginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginKeyTyped

    }//GEN-LAST:event_loginKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton login;
    private javax.swing.JTextField password;
    private javax.swing.JButton register;
    private javax.swing.JLabel slogan;
    // End of variables declaration//GEN-END:variables
}
