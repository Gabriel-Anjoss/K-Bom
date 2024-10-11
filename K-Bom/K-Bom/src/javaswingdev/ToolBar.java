package javaswingdev;

import javax.swing.BorderFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import javax.swing.Timer;

public class ToolBar extends javax.swing.JPanel {

    private Timer hoverTimer;
    private Color startColor = new Color(255, 101, 0);  // Cor inicial
    private Color hoverColor = new Color(245, 160, 1); // Cor ao passar o mouse
    private float[] currentColor;
    private float[] targetColor;
    private float colorStep = 0.1f; // Quantidade de mudança por frame
    
    public ToolBar() {
        initComponents();
        
        MatteBorder customBorder = new MatteBorder(0, 1, 0, 1, Color.WHITE);
        MatteBorder customBorderRight = new MatteBorder(0, 2, 0, 1, Color.WHITE);
        MatteBorder customBorderLeft = new MatteBorder(0, 1, 0, 2, Color.WHITE);
        
        jLabel1.setBorder(customBorderRight);
        jLabel2.setBorder(customBorder);
        jLabel3.setBorder(customBorder);
        jLabel4.setBorder(customBorder);
        jLabel5.setBorder(customBorder);
        jLabel6.setBorder(customBorderLeft);

        // Aplica a animação de hover em cada botão
        applyHoverAnimation(jLabel1);
        applyHoverAnimation(jLabel2);
        applyHoverAnimation(jLabel3);
        applyHoverAnimation(jLabel4);
        applyHoverAnimation(jLabel5);
        applyHoverAnimation(jLabel6);

        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jLabel4);
        this.add(jLabel5);
        this.add(jLabel6);
    }
    
    private void animateColor(JLabel label, Color from, Color to, Timer[] hoverTimer) {
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
    
    private void applyHoverAnimation(JLabel label) {
        label.setBackground(startColor);
        label.setForeground(Color.WHITE);
        label.setOpaque(true);

        // Cria um timer que será usado para animar cada botão de forma independente
        Timer[] hoverTimer = new Timer[1]; // Usamos um array para o Timer para poder modificá-lo dentro do listener.

        // Adiciona eventos de mouse ao botão
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                animateColor(label, startColor, hoverColor, hoverTimer);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                animateColor(label, hoverColor, startColor, hoverTimer);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 101, 0));
        setMaximumSize(new java.awt.Dimension(819, 40));
        setMinimumSize(new java.awt.Dimension(819, 40));
        setPreferredSize(new java.awt.Dimension(819, 40));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setBackground(new java.awt.Color(255, 101, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PLACA MÃE");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setMaximumSize(new java.awt.Dimension(139, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(139, 40));
        jLabel1.setPreferredSize(new java.awt.Dimension(139, 40));
        jLabel1.setRequestFocusEnabled(false);
        add(jLabel1);

        jLabel2.setBackground(new java.awt.Color(255, 101, 0));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PLACA VÍDEO");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.setMaximumSize(new java.awt.Dimension(139, 40));
        jLabel2.setMinimumSize(new java.awt.Dimension(139, 40));
        jLabel2.setPreferredSize(new java.awt.Dimension(139, 40));
        jLabel2.setRequestFocusEnabled(false);
        add(jLabel2);

        jLabel3.setBackground(new java.awt.Color(255, 101, 0));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PROCESSADOR");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setMaximumSize(new java.awt.Dimension(139, 40));
        jLabel3.setMinimumSize(new java.awt.Dimension(139, 40));
        jLabel3.setPreferredSize(new java.awt.Dimension(139, 40));
        jLabel3.setRequestFocusEnabled(false);
        add(jLabel3);

        jLabel4.setBackground(new java.awt.Color(255, 101, 0));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MEMÓRIA RAM");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setMaximumSize(new java.awt.Dimension(139, 40));
        jLabel4.setMinimumSize(new java.awt.Dimension(139, 40));
        jLabel4.setPreferredSize(new java.awt.Dimension(139, 40));
        jLabel4.setRequestFocusEnabled(false);
        add(jLabel4);

        jLabel5.setBackground(new java.awt.Color(255, 101, 0));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("FONTE");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.setMaximumSize(new java.awt.Dimension(100, 40));
        jLabel5.setMinimumSize(new java.awt.Dimension(100, 40));
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 40));
        jLabel5.setRequestFocusEnabled(false);
        add(jLabel5);

        jLabel6.setBackground(new java.awt.Color(255, 101, 0));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ARMAZENAMENTO");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.setMaximumSize(new java.awt.Dimension(163, 40));
        jLabel6.setMinimumSize(new java.awt.Dimension(163, 40));
        jLabel6.setPreferredSize(new java.awt.Dimension(163, 40));
        jLabel6.setRequestFocusEnabled(false);
        add(jLabel6);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}