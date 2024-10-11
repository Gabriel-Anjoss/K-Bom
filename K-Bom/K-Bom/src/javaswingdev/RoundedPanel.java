package javaswingdev;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Dimension;
import javax.swing.JPanel;

public class RoundedPanel extends JPanel {

    public RoundedPanel() {
        setOpaque(false);
        setPreferredSize(new Dimension(50, 50));  // Tamanho padrão
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Ativar anti-aliasing para bordas suaves
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Desenhar o círculo preenchido
        g2.setColor(getBackground());
        g2.fillOval(0, 0, getWidth(), getHeight());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(50, 50);  // Tamanho fixo ou ajustável
    }

    @Override
    public boolean contains(int x, int y) {
        // Verifica se o ponto (x, y) está dentro do círculo
        int radius = getWidth() / 2;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        return Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2) <= Math.pow(radius, 2);
    }
}