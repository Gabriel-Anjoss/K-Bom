package javaswingdev;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyboardFocusManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Timer;

public class PesqBar extends javax.swing.JPanel {
    private int cornerRadius = 20;
    private String placeholderText = "Buscar...";
    
    private Color defaultColor = new Color(255, 255, 255);
    private Color hoverColor = new Color(217,217,217); // Cor para o efeito hover
    private int animationDuration = 200; // Duração da animação em milissegundos
    private Timer hoverTimer;
    
    public PesqBar() {
        initComponents();
        
        email2.setText(placeholderText);
        email2.setForeground(Color.GRAY);
        
        email2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(email2.getText().equals(placeholderText)) {
                    email2.setText(""); // Limpa o campo quando o foco é obtido
                    email2.setForeground(Color.BLACK); // Define a cor do texto normal
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(email2.getText().isEmpty()) {
                    email2.setText(placeholderText); // Reinsere o placeholder se estiver vazio
                    email2.setForeground(Color.GRAY); // Define a cor do placeholder novamente
                }
            }
        });
        
        setFocusable(true);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
        
        // Remover foco ao clicar fora do JTextField
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(!email2.getBounds().contains(e.getPoint())) {
                    email2.getParent().requestFocusInWindow(); // Remove foco do JTextField
                }
            }
        });
    }
    
    private void animateColorChange(javaswingdev.RoundedPanel panel, Color startColor, Color endColor) {
        hoverTimer = new Timer(10, null); // Timer com delay de 10ms para uma animação suave
        long startTime = System.currentTimeMillis();

        hoverTimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long elapsed = System.currentTimeMillis() - startTime;
                float progress = Math.min(1.0f, (float) elapsed / animationDuration);

                int red = (int) (startColor.getRed() + progress * (endColor.getRed() - startColor.getRed()));
                int green = (int) (startColor.getGreen() + progress * (endColor.getGreen() - startColor.getGreen()));
                int blue = (int) (startColor.getBlue() + progress * (endColor.getBlue() - startColor.getBlue()));

                Color newColor = new Color(red, green, blue);
                panel.setBackground(newColor);

                if (progress >= 1.0f) {
                    hoverTimer.stop(); // Para o timer quando a animação termina
                }
            }
        });

        hoverTimer.start(); // Inicia a animação
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Desenha um retângulo com bordas arredondadas
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

        g2d.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        email2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        button1 = new javaswingdev.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(715, 40));
        setMinimumSize(new java.awt.Dimension(715, 40));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(715, 40));
        setRequestFocusEnabled(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        email2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        email2.setToolTipText("");
        email2.setBorder(null);
        email2.setMargin(null);
        email2.setMaximumSize(new java.awt.Dimension(660, 40));
        email2.setMinimumSize(new java.awt.Dimension(660, 40));
        email2.setPreferredSize(new java.awt.Dimension(660, 40));
        email2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email2ActionPerformed(evt);
            }
        });
        add(email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(18, 40));
        jPanel1.setMinimumSize(new java.awt.Dimension(18, 40));
        jPanel1.setPreferredSize(new java.awt.Dimension(18, 40));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/search.png"))); // NOI18N
        button1.setFocusable(false);
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 28, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void email2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.Button button1;
    private javax.swing.JTextField email2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}