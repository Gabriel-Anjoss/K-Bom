/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

/**
 *
 * @author Gui
 */
public class Sucess extends javax.swing.JFrame {

    /**
     * Creates new form Sucess
     */
    public Sucess() {
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

        jPanel1 = new javax.swing.JPanel();
        bTentar = new javaswingdev.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        bSair = new javaswingdev.PanelRound();
        jPanel2 = new javax.swing.JPanel();
        sVGImage1 = new javaswingdev.SVGImage();
        jLabel3 = new javax.swing.JLabel();
        sVGImage2 = new javaswingdev.SVGImage();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(null);

        bTentar.setBackground(new java.awt.Color(0, 96, 177));
        bTentar.setForeground(new java.awt.Color(255, 255, 255));
        bTentar.setRoundBottomLeft(15);
        bTentar.setRoundBottomRight(15);
        bTentar.setRoundTopLeft(15);
        bTentar.setRoundTopRight(15);
        bTentar.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><center>Tentar<br>Novamente</center></html>");
        jLabel1.setMaximumSize(new java.awt.Dimension(120, 44));
        jLabel1.setMinimumSize(new java.awt.Dimension(120, 44));
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 44));
        bTentar.add(jLabel1);
        jLabel1.setBounds(0, 0, 120, 44);

        jPanel1.add(bTentar);
        bTentar.setBounds(79, 148, 120, 44);

        bSair.setBackground(new java.awt.Color(198, 47, 47));
        bSair.setForeground(new java.awt.Color(255, 255, 255));
        bSair.setMaximumSize(new java.awt.Dimension(120, 44));
        bSair.setRoundBottomLeft(15);
        bSair.setRoundBottomRight(15);
        bSair.setRoundTopLeft(15);
        bSair.setRoundTopRight(15);
        bSair.setLayout(null);
        jPanel1.add(bSair);
        bSair.setBounds(246, 148, 120, 44);

        jPanel2.setBackground(new java.awt.Color(0, 96, 177));
        jPanel2.setMaximumSize(new java.awt.Dimension(444, 32));
        jPanel2.setMinimumSize(new java.awt.Dimension(444, 32));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 208, 444, 32);

        sVGImage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage1.setMaximumSize(new java.awt.Dimension(50, 50));
        sVGImage1.setMinimumSize(new java.awt.Dimension(50, 50));
        sVGImage1.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(sVGImage1);
        sVGImage1.setBounds(197, 79, 50, 50);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Erro ao se conectar ao servidor");
        jLabel3.setMaximumSize(new java.awt.Dimension(330, 33));
        jLabel3.setMinimumSize(new java.awt.Dimension(330, 33));
        jLabel3.setPreferredSize(new java.awt.Dimension(330, 33));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(57, 37, 330, 33);

        sVGImage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage2.setMaximumSize(new java.awt.Dimension(24, 24));
        sVGImage2.setMinimumSize(new java.awt.Dimension(24, 24));
        sVGImage2.setPreferredSize(new java.awt.Dimension(24, 24));
        jPanel1.add(sVGImage2);
        sVGImage2.setBounds(416, 4, 24, 24);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sair");
        jLabel2.setMaximumSize(new java.awt.Dimension(120, 44));
        jLabel2.setMinimumSize(new java.awt.Dimension(120, 44));
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 44));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(260, 90, 120, 44);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 444, 240);

        pack();
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
            java.util.logging.Logger.getLogger(Sucess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sucess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sucess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sucess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sucess().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.PanelRound bSair;
    public javaswingdev.PanelRound bTentar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javaswingdev.SVGImage sVGImage1;
    private javaswingdev.SVGImage sVGImage2;
    // End of variables declaration//GEN-END:variables
}
