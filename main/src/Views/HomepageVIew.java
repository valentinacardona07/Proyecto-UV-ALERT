package Views;

public class HomepageVIew extends javax.swing.JPanel {

    private int userId;

    public HomepageVIew(int userId) {
        this.userId = userId;
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        introduction = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(570, 380));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        introduction.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        introduction.setForeground(new java.awt.Color(51, 51, 51));
        introduction.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        introduction.setText("<html><div style='text-align: justify;'>¡Bienvenido a UVAlert, la aplicación que protege tu salud bajo el sol! <br><br>Nuestra app está diseñada para brindarte información precisa y personalizada sobre la radiación ultravioleta (UV) en tu área. <br><br>Con UVAlert, podrás recibir alertas en tiempo real sobre los niveles de rayos UV y obtener recomendaciones específicas para mantener tu piel segura. <br><br>La app te permite personalizar tu perfil, ajustando la información según tu tipo de piel y cualquier enfermedad relacionada que puedas tener. Ya sea que tengas una piel sensible, una condición de salud específica, o simplemente desees disfrutar del sol de manera segura, UVAlert está aquí para ayudarte a tomar decisiones informadas y proteger tu salud. <br><br>¡Descubre cómo UVAlert puede convertirse en tu compañero esencial para una exposición solar segura y saludable!");
        introduction.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        introduction.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(introduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 530, 340));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel introduction;
    // End of variables declaration//GEN-END:variables
}
