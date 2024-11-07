package splashscreen;

import conexao.conexao;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class SplashScreen extends javax.swing.JDialog {

    public SplashScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getContentPane().setBackground(new Color(221, 221, 221));
        
        setTitle("Loading...");
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagens/IconeK-Bom.png"));
        setIconImage(icon.getImage());
        
        //  To disable key Alt+F4 to close dialog
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        curvesPanel1 = new splashscreen.CurvesPanel();
        jLabel1 = new javax.swing.JLabel();
        pro = new splashscreen.ProgressBarCustom();
        lbStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        curvesPanel1.setBackground(new java.awt.Color(255, 255, 255));
        curvesPanel1.setForeground(new java.awt.Color(0, 0, 204));
        curvesPanel1.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/KBOMmedio.png"))); // NOI18N
        curvesPanel1.add(jLabel1);
        jLabel1.setBounds(175, 100, 250, 125);

        pro.setBackground(new java.awt.Color(217, 217, 217));
        pro.setBorder(null);
        pro.setForeground(new java.awt.Color(0, 96, 177));
        curvesPanel1.add(pro);
        pro.setBounds(140, 283, 320, 5);

        lbStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(200, 200, 200));
        lbStatus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbStatus.setText("Status");
        curvesPanel1.add(lbStatus);
        lbStatus.setBounds(140, 260, 320, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(curvesPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(curvesPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    doTask("Conectando-se com o Banco de Dados ...", 1);
                    doTask("Conectando-se com o Banco de Dados ..", 2);
                    doTask("Conectando-se com o Banco de Dados .", 3);
                    doTask("Conectando-se com o Banco de Dados ...", 4);
                    doTask("Conectando-se com o Banco de Dados ..", 5);
                    doTask("Conectando-se com o Banco de Dados .", 6);
                    doTask("Conectando-se com o Banco de Dados ...", 7);
                    doTask("Conectando-se com o Banco de Dados ..", 8);
                    doTask("Conectando-se com o Banco de Dados .", 9);
                    doTask("Conectando-se com o Banco de Dados ...", 10);
                    doTask("Conectando-se com o Banco de Dados ..", 11);
                    doTask("Conectando-se com o Banco de Dados .", 12);
                    doTask("Conectando-se com o Banco de Dados ...", 13);
                    doTask("Conectando-se com o Banco de Dados ..", 14);
                    doTask("Conectando-se com o Banco de Dados .", 15);
                    doTask("Conectando-se com o Banco de Dados ...", 16);
                    doTask("Conectando-se com o Banco de Dados ..", 17);
                    doTask("Conectando-se com o Banco de Dados .", 18);
                    doTask("Conectando-se com o Banco de Dados ...", 19);
                    doTask("Conectando-se com o Banco de Dados ..", 20);
                    doTask("Conectando-se com o Banco de Dados .", 21);
                    doTask("Conectando-se com o Banco de Dados ...", 22);
                    doTask("Conectando-se com o Banco de Dados ..", 23);
                    doTask("Conectando-se com o Banco de Dados .", 24);
                    doTask("Conectando-se com o Banco de Dados ...", 25);
                    doTask("Conectando-se com o Banco de Dados ..", 26);
                    doTask("Conectando-se com o Banco de Dados .", 27);
                    doTask("Conectando-se com o Banco de Dados ...", 28);
                    doTask("Conectando-se com o Banco de Dados ..", 29);
                    doTask("Conectando-se com o Banco de Dados .", 30);
                    conexao con_cliente = new conexao();
                    con_cliente.conecta();
                    doTask("31% ..", 31);
                    doTask("32% ...", 32);
                    doTask("33% .", 33);
                    doTask("34% ..", 34);
                    doTask("35% ...", 35);
                    doTask("36% .", 36);
                    doTask("37% ..", 37);
                    doTask("38% ...", 38);
                    doTask("39% .", 39);
                    doTask("40% ..", 40);
                    doTask("41% ...", 41);
                    doTask("42% .", 42);
                    doTask("43% ..", 43);
                    doTask("44% ...", 44);
                    doTask("45% .", 45);
                    doTask("46% ..", 46);
                    doTask("47% ...", 47);
                    doTask("48% .", 48);
                    doTask("49% ..", 49);
                    doTask("50% ...", 50);
                    doTask("51% .", 51);
                    doTask("52% ..", 52);
                    doTask("53% ...", 53);
                    doTask("54% .", 54);
                    doTask("55% ..", 55);
                    doTask("56% ...", 56);
                    doTask("57% .", 57);
                    doTask("58% ..", 58);
                    doTask("59% ...", 59);
                    doTask("60% .", 60);
                    doTask("61% ..", 61);
                    doTask("62% ...", 62);
                    doTask("63% .", 63);
                    doTask("64% ..", 64);
                    doTask("65% ...", 65);
                    doTask("66% .", 66);
                    doTask("67% ..", 67);
                    doTask("68% ...", 68);
                    doTask("69% .", 69);
                    doTask("70% ..", 70);
                    doTask("71% ...", 71);
                    doTask("72% .", 72);
                    doTask("73% ..", 73);
                    doTask("74% ...", 74);
                    doTask("75% .", 75);
                    doTask("76% ..", 76);
                    doTask("77% ...", 77);
                    doTask("78% .", 78);
                    doTask("79% ..", 79);
                    doTask("80% ...", 80);
                    doTask("81% .", 81);
                    doTask("82% ..", 82);
                    doTask("83% ...", 83);
                    doTask("84% .", 84);
                    doTask("85% ..", 85);
                    doTask("86% ...", 86);
                    doTask("87% .", 87);
                    doTask("88% ..", 88);
                    doTask("89% ...", 89);
                    doTask("90% .", 90);
                    doTask("91% ..", 91);
                    doTask("92% ...", 92);
                    doTask("93% .", 93);
                    doTask("94% ..", 94);
                    doTask("95% ...", 95);
                    doTask("96% .", 96);
                    doTask("97% ..", 97);
                    doTask("98% ...", 98);
                    doTask("99% .", 99);
                    doTask("Feito", 100);
                    doTask("Feito", 100);
                    doTask("Feito", 100);
                    AbrirTela();
                    curvesPanel1.stop();    //  To Stop animation
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }//GEN-LAST:event_formWindowOpened

    private void AbrirTela() {
        // Gradualmente reduz a opacidade da janela
        new Thread(() -> {
            try {
                for (float i = 1.0f; i > 0.0f; i -= 0.05f) {
                    setOpacity(i);  // Reduz a opacidade da janela
                    Thread.sleep(2); // Aguarda 50ms para criar o efeito de transição suave
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dispose();
        }).start();
    }
    
    private void doTask(String taskName, int progress) throws Exception {
        lbStatus.setText(taskName);
        Thread.sleep(100); //  For Test
        pro.setValue(progress);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SplashScreen dialog = new SplashScreen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private splashscreen.CurvesPanel curvesPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbStatus;
    private splashscreen.ProgressBarCustom pro;
    // End of variables declaration//GEN-END:variables
}