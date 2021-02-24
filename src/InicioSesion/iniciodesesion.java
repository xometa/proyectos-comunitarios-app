/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InicioSesion;

import Alertas.ErrordeProcesos;
import Alertas.ProcesoExitoso;
import principal.principal;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import principal.menuempleado;
import usuarios.Encriptacion;
import usuarios.Usuario;
import usuarios.dao_usuarios;

/**
 *
 * @author Sony
 */
public class iniciodesesion extends javax.swing.JFrame {

    dao_usuarios du = new dao_usuarios();
    Usuario usuario = new Usuario();

    /**
     * Creates new form LoginUi
     */
    public iniciodesesion() {
        initComponents();
        this.setTitle("Sistema para el control de Proyectos Comunitarios por Alcaldía");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        j1 = new javax.swing.JLabel();
        j2 = new javax.swing.JLabel();
        j3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btniniciosesion = new rsbuttom.RSButtonMetro();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        password = new jpass.JRPasswordField();
        codigo = new jpass.JRPasswordField();
        user = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));
        jPanel2.setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesprincipal/icons8_Facebook_33px.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesprincipal/icons8_Facebook_36px.png"))); // NOI18N
        jPanel2.add(jButton1);
        jButton1.setBounds(590, 660, 51, 39);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesprincipal/icons8_Twitter_33px.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesprincipal/icons8_Twitter_36px.png"))); // NOI18N
        jPanel2.add(jButton2);
        jButton2.setBounds(640, 660, 45, 39);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesprincipal/icons8_Google_Plus_33px.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesprincipal/icons8_Google_Plus_36px.png"))); // NOI18N
        jPanel2.add(jButton3);
        jButton3.setBounds(680, 660, 51, 38);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesprincipal/icons8_Instagram_33px.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesprincipal/icons8_Instagram_36px.png"))); // NOI18N
        jPanel2.add(jButton4);
        jButton4.setBounds(740, 660, 46, 39);

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(115, 135, 156));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Inicio de Sesión ");

        j1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        j1.setForeground(new java.awt.Color(153, 153, 153));
        j1.setText("Usuario:");

        j2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        j2.setForeground(new java.awt.Color(153, 153, 153));
        j2.setText("Contraseña:");

        j3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        j3.setForeground(new java.awt.Color(153, 153, 153));
        j3.setText("Código:");

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("____________________");

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("____________________");

        btniniciosesion.setText("Ingresar");
        btniniciosesion.setColorHover(new java.awt.Color(22, 159, 133));
        btniniciosesion.setColorNormal(new java.awt.Color(38, 185, 154));
        btniniciosesion.setColorPressed(new java.awt.Color(22, 159, 133));
        btniniciosesion.setColorTextHover(new java.awt.Color(255, 255, 255));
        btniniciosesion.setDefaultCapable(false);
        btniniciosesion.setFocusable(false);
        btniniciosesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btniniciosesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btniniciosesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniniciosesionActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("___________________________________________________________________");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(115, 135, 156));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Interstellar");

        jLabel5.setForeground(new java.awt.Color(115, 135, 156));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Crear una nueva cuenta?");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(115, 135, 156));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sistema para el control de información de Proyectos Comunitarios");

        jLabel8.setForeground(new java.awt.Color(115, 135, 156));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("de cada Alcaldía de el país El Salvador");

        password.setBackground(new java.awt.Color(247, 247, 247));
        password.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        password.setForeground(new java.awt.Color(153, 153, 153));
        password.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        password.setPlaceholder("Contraseña");

        codigo.setBackground(new java.awt.Color(247, 247, 247));
        codigo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        codigo.setForeground(new java.awt.Color(153, 153, 153));
        codigo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        codigo.setPlaceholder("Còdigo de Sesiòn");

        user.setBackground(new java.awt.Color(247, 247, 247));
        user.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        user.setForeground(new java.awt.Color(153, 153, 153));
        user.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        user.setPlaceholder("Usuario");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesprincipal/logoinicio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btniniciosesion, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(61, 61, 61))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(j3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btniniciosesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(450, 20, 470, 640);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1256, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btniniciosesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniniciosesionActionPerformed
        // TODO add your handling code here:
        String user = this.user.getText();
        String pass = this.password.getText();
        String codigo = this.codigo.getText();
        usuario = validaruser(user, pass, codigo);
        if (!this.password.getText().isEmpty() && !this.user.getText().isEmpty() && !this.codigo.getText().isEmpty()) {
            if (usuario != null) {

                if (usuario.getTipouser().equals("Administrador")) {
                    principal pr = new principal(usuario);
                    pr.setVisible(true);
                    ProcesoExitoso pe = new ProcesoExitoso(new JFrame(), true);
                    pe.titulo.setText("BIENVENIDO");
                    pe.msj.setText(usuario.getNombre() + " " + usuario.getApellidos());
                    pe.msj1.setText("");
                    pe.setVisible(true);
//                principal.user1.setText(usuario.getUsuario());
//                principal.user2.setText(usuario.getUsuario());
                    limpiar();
                    this.dispose();
                } else if (usuario.getTipouser().equals("Empleado")) {
                    menuempleado pr = new menuempleado(usuario);
                    pr.setVisible(true);
                    ProcesoExitoso pe = new ProcesoExitoso(new JFrame(), true);
                    pe.titulo.setText("BIENVENIDO");
                    pe.msj.setText(usuario.getNombre() + " " + usuario.getApellidos());
                    pe.msj1.setText("");
                    pe.setVisible(true);
//                principal.user1.setText(usuario.getUsuario());
//                principal.user2.setText(usuario.getUsuario());
                    limpiar();
                    this.dispose();
                }
            } else {
                ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
                er.titulo.setText("ERROR AL INICIAR SESIÓN");
                er.msj.setText("LOS DATOS INGRESADOS");
                er.msj1.setText("SON ICORRECTOS");
                er.setVisible(true);
                limpiar();
            }
        } else {
            ErrordeProcesos er = new ErrordeProcesos(new JFrame(), true);
            er.titulo.setText("CAMPOS VACÍOS");
            er.msj.setText("LLENE LOS CAMPOS SOLICITADOS");
            er.msj1.setText("POR FAVOR, PARA INICIAR SESIÓN");
            er.setVisible(true);
        }
    }//GEN-LAST:event_btniniciosesionActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.dispose();
        crearcuenta cc = new crearcuenta();
        cc.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    void limpiar() {
        this.user.setText("");
        this.password.setText("");
        this.codigo.setText("");
    }

    /*Metodo para la validacion de los datos de inicio de sesion*/
    public Usuario validaruser(String user, String pass, String codigo) {
        String passencriptado = Encriptacion.getStringMessageDigest(pass, Encriptacion.MD5);
        for (Usuario u : du.llenaravl(du.datosusuarios())) {
            if (u.getUsuario().equals(user) && u.getContraseña().equals(passencriptado) && u.getCodigo().equals(codigo)) {
                return u;
            }
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(iniciodesesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(iniciodesesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(iniciodesesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(iniciodesesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new iniciodesesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro btniniciosesion;
    public static jpass.JRPasswordField codigo;
    private javax.swing.JLabel j1;
    private javax.swing.JLabel j2;
    private javax.swing.JLabel j3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static jpass.JRPasswordField password;
    public static app.bolivia.swing.JCTextField user;
    // End of variables declaration//GEN-END:variables
}
