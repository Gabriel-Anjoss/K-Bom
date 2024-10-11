package javaswingdev;

import java.awt.event.ActionListener;

public class Header extends javax.swing.JPanel {
    private ActionListener event;
    
    public Header() {
        initComponents();
        
        cmdMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMenuActionPerformed(evt);
            }
        });
        
        sVGImage1.setSvgImage("Imagens/k.png", 115, 35);
    }
    public void addMenuEvent(ActionListener event) {
        this.event = event; // Armazena o evento para uso posterior
        cmdMenu.addActionListener(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sVGImage1 = new javaswingdev.SVGImage();
        pesqBar1 = new javaswingdev.PesqBar();
        jLabel1 = new javax.swing.JLabel();
        cmdMenu = new javaswingdev.Button();

        sVGImage1.setBackground(new java.awt.Color(255, 255, 255));
        sVGImage1.setForeground(new java.awt.Color(255, 255, 255));
        sVGImage1.setAlignmentY(0.0F);
        sVGImage1.setMaximumSize(new java.awt.Dimension(115, 40));
        sVGImage1.setMinimumSize(new java.awt.Dimension(115, 40));
        sVGImage1.setPreferredSize(new java.awt.Dimension(115, 40));

	cmdMenu.setBackground(new java.awt.Color(0, 96, 177));
        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/menu.png"))); // NOI18N
        cmdMenu.setEffectColor(new java.awt.Color(255, 255, 255));
        cmdMenu.setFocusPainted(false);
        cmdMenu.setFocusable(false);
        cmdMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMenuActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(0, 96, 177));
        setMaximumSize(new java.awt.Dimension(1303, 81));
        setMinimumSize(new java.awt.Dimension(1303, 81));
        setPreferredSize(new java.awt.Dimension(1303, 81));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/k.png"))); // NOI18N
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setMaximumSize(new java.awt.Dimension(115, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(115, 40));
        jLabel1.setPreferredSize(new java.awt.Dimension(115, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220)
                .addComponent(pesqBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pesqBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMenuActionPerformed
        // Chama o evento que foi registrado
        if (event != null) {
            event.actionPerformed(evt);
        }
    }//GEN-LAST:event_cmdMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.Button cmdMenu;
    private javax.swing.JLabel jLabel1;
    private javaswingdev.PesqBar pesqBar1;
    private javaswingdev.SVGImage sVGImage1;
    // End of variables declaration//GEN-END:variables
}