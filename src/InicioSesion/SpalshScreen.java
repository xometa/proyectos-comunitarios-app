/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InicioSesion;

/**
 *
 * @author RoXen
 */
public class SpalshScreen extends javax.swing.JFrame {

    /**
     * Creates new form SpalshScreen
     */
    public SpalshScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel_SoftZyd = new javax.swing.JLabel();
        loadingprogress = new javax.swing.JProgressBar();
        loadingnumber = new javax.swing.JLabel();
        jLabel_inven1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_SoftZyd.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel_SoftZyd.setForeground(new java.awt.Color(38, 185, 154));
        jLabel_SoftZyd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_SoftZyd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesprincipal/logosplash.png"))); // NOI18N
        jLabel_SoftZyd.setToolTipText("");
        jPanel1.add(jLabel_SoftZyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 390, 90));

        loadingprogress.setForeground(new java.awt.Color(38, 185, 154));
        loadingprogress.setBorderPainted(false);
        loadingprogress.setFocusable(false);
        loadingprogress.setRequestFocusEnabled(false);
        loadingprogress.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(loadingprogress, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 470, 820, 40));

        loadingnumber.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        loadingnumber.setForeground(new java.awt.Color(38, 185, 154));
        loadingnumber.setText("99%");
        jPanel1.add(loadingnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, -1, -1));

        jLabel_inven1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel_inven1.setForeground(new java.awt.Color(38, 185, 154));
        jLabel_inven1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_inven1.setText("Proyectos Comunitarios");
        jPanel1.add(jLabel_inven1, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 240, 490, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SpalshScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpalshScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpalshScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpalshScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SpalshScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_SoftZyd;
    private javax.swing.JLabel jLabel_inven1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    public javax.swing.JLabel loadingnumber;
    public javax.swing.JProgressBar loadingprogress;
    // End of variables declaration//GEN-END:variables
}
