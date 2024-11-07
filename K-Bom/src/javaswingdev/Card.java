package javaswingdev;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Card extends javax.swing.JPanel {
    private float colorStep = 0.1f; // Quantidade de mudança por frame

    public Card() {
        initComponents();
        
        applyHoverAnimation(panelRound1, new Color(245,246,247), new Color(255,255,255));
    }
    
    private void animateColor(JPanel label, Color from, Color to, Timer[] hoverTimer) {
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
    
    private void applyHoverAnimation(JPanel label, Color colorStart, Color hoverColor ) {
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

        panelRound1 = new javaswingdev.PanelRound();
        capa = new javaswingdev.ImageReajust();
        Titulo = new javax.swing.JLabel();
        Preco = new javax.swing.JLabel();
        infos = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(150, 206));
        setMinimumSize(new java.awt.Dimension(150, 206));
        setOpaque(false);
        setLayout(null);

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setMaximumSize(new java.awt.Dimension(150, 206));
        panelRound1.setMinimumSize(new java.awt.Dimension(150, 206));
        panelRound1.setPreferredSize(new java.awt.Dimension(150, 206));
        panelRound1.setRoundBottomLeft(15);
        panelRound1.setRoundBottomRight(15);
        panelRound1.setRoundTopLeft(15);
        panelRound1.setRoundTopRight(15);
        panelRound1.setLayout(null);

        capa.setForeground(new java.awt.Color(0, 0, 0));
        capa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Motherboard.jpg"))); // NOI18N
        capa.setMaximumSize(new java.awt.Dimension(100, 100));
        capa.setMinimumSize(new java.awt.Dimension(100, 100));
        capa.setPreferredSize(new java.awt.Dimension(100, 100));
        panelRound1.add(capa);
        capa.setBounds(25, 15, 100, 100);

        Titulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Titulo.setForeground(new java.awt.Color(0, 0, 0));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Titulo.setText("NOME");
        Titulo.setMaximumSize(new java.awt.Dimension(120, 15));
        Titulo.setMinimumSize(new java.awt.Dimension(120, 15));
        Titulo.setPreferredSize(new java.awt.Dimension(120, 15));
        panelRound1.add(Titulo);
        Titulo.setBounds(15, 125, 140, 15);

        Preco.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        Preco.setForeground(new java.awt.Color(102, 102, 102));
        Preco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Preco.setText("<html><span style=\"text-decoration: line-through;\">R$ 0,00</span> <span style=\"color: #FF6500; font-size: 12px;\">R$ 0,00</span></html>");
        Preco.setToolTipText("");
        Preco.setAlignmentY(0.0F);
        Preco.setMaximumSize(new java.awt.Dimension(120, 20));
        Preco.setMinimumSize(new java.awt.Dimension(120, 20));
        Preco.setPreferredSize(new java.awt.Dimension(120, 20));
        panelRound1.add(Preco);
        Preco.setBounds(15, 140, 140, 20);

        infos.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        infos.setForeground(new java.awt.Color(102, 102, 102));
        infos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        infos.setText("<html><span style=\"color: #000000\">À vista no PIX</span><br><span style=\"color: #000000\">ou até 10x de R$ 0,00</span><br><span style=\"color: #0060B1;\">Restam 0</span></html>");
        infos.setToolTipText("");
        infos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        infos.setAlignmentY(0.0F);
        infos.setMaximumSize(new java.awt.Dimension(120, 20));
        infos.setMinimumSize(new java.awt.Dimension(120, 20));
        infos.setPreferredSize(new java.awt.Dimension(120, 20));
        panelRound1.add(infos);
        infos.setBounds(15, 162, 140, 40);

        add(panelRound1);
        panelRound1.setBounds(0, 0, 150, 206);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Preco;
    public javax.swing.JLabel Titulo;
    public javaswingdev.ImageReajust capa;
    public javax.swing.JLabel infos;
    public javaswingdev.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}