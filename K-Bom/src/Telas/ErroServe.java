package Telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javaswingdev.PanelRound;
import javax.swing.Timer;
import conexao.conexao;
import javax.swing.ImageIcon;

public class ErroServe extends javax.swing.JFrame {
    private float colorStep = 0.1f; // Quantidade de mudança por frame
    private static ErroServe instance;
    private conexao con;
    
    public ErroServe(conexao con) {
        this.con = con;
        initComponents();
        
        setAlwaysOnTop(true);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagens/IconeK-Bom.png"));
        setIconImage(icon.getImage());
        
        sVGImage1.setSvgImage("Imagens/sentiment_dissatisfied.svg", 50, 50);
        sVGImage2.setSvgImage("Imagens/Close.svg", 24, 24);
        
        applyHoverAnimation(bTentar, new Color(0,96,177), new Color(0,76,145));
        applyHoverAnimation(bSair, new Color(198,47,47), new Color(122,18,18));
        
        bTentar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        bSair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        
        bTentar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose(); // Fecha a janela de erro atual
                con.conecta(); // Tenta conectar novamente
            }
        });
        
        sVGImage2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
    }
    
    public static ErroServe getInstance(conexao con) {
        if (instance == null || !instance.isVisible()) { // Garante que apenas uma instância seja criada
            instance = new ErroServe(con);
        }
        return instance;
    }
    
    private void animateColor(PanelRound label, Color from, Color to, Timer[] hoverTimer) {
        // Pegando os valores RGB da cor inicial e final
        float[] currentColor = from.getRGBComponents(null);
        float[] targetColor = to.getRGBComponents(null);

        if (hoverTimer[0] != null && hoverTimer[0].isRunning()) {
            hoverTimer[0].stop();
        }

        hoverTimer[0] = new Timer(30, e -> {
            boolean done = true;
            for (int i = 0; i < 3; i++) {
                if (Math.abs(currentColor[i] - targetColor[i]) > colorStep) {
                    done = false;
                    if (currentColor[i] < targetColor[i]) {
                        currentColor[i] += colorStep;
                    } else {
                        currentColor[i] -= colorStep;
                    }
                }
            }
            label.setBackground(new Color(currentColor[0], currentColor[1], currentColor[2]));

            if (done) {
                hoverTimer[0].stop();
            }
        });
        hoverTimer[0].start();
    }
    
    private void applyHoverAnimation(PanelRound label, Color colorStart, Color hoverColor ) {
        Timer[] hoverTimer = new Timer[1]; // Usamos um array para o Timer para poder modificá-lo dentro do listener.

        // Adiciona eventos de mouse ao botão
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                animateColor(label, colorStart, hoverColor, hoverTimer);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                animateColor(label, hoverColor, colorStart, hoverTimer);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bTentar = new javaswingdev.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        bSair = new javaswingdev.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        sVGImage1 = new javaswingdev.SVGImage();
        jLabel3 = new javax.swing.JLabel();
        sVGImage2 = new javaswingdev.SVGImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(444, 240));
        setMinimumSize(new java.awt.Dimension(444, 240));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(444, 240));
        setResizable(false);
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sair");
        jLabel2.setMaximumSize(new java.awt.Dimension(120, 44));
        jLabel2.setMinimumSize(new java.awt.Dimension(120, 44));
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 44));
        bSair.add(jLabel2);
        jLabel2.setBounds(0, 0, 120, 44);

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

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 444, 240);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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