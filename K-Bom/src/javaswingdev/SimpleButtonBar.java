package javaswingdev;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SimpleButtonBar extends javax.swing.JPanel {

    public SimpleButtonBar() {
        initComponents();
        setOpaque(false);
        cmdMinimize.setFont(cmdMinimize.getFont().deriveFont(0, 3));
    }

    public void initEvent(JFrame fram) {
        cmdClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        cmdMinimize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fram.setState(JFrame.ICONIFIED);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdClose = new javaswingdev.Buttont();
        cmdMinimize = new javaswingdev.Buttont();

        cmdClose.setBackground(new java.awt.Color(0, 96, 177));
        cmdClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Close.png"))); // NOI18N
        cmdClose.setHoverColor(new java.awt.Color(255, 48, 48));
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        cmdMinimize.setBackground(new java.awt.Color(0, 96, 177));
        cmdMinimize.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 1, 1, 1));
        cmdMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/minus.png"))); // NOI18N
        cmdMinimize.setHoverColor(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(cmdMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmdMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cmdClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdCloseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.Buttont cmdClose;
    private javaswingdev.Buttont cmdMinimize;
    // End of variables declaration//GEN-END:variables
}