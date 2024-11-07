package javaswingdev;

import Telas.ManageAccount;
import conexao.conexao;
import java.sql.Connection;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;

public class LinhaTable extends javax.swing.JPanel {
    conexao con_cliente;
    private float colorStep = 0.1f; // Quantidade de mudança por frame
    
    public LinhaTable() {
        initComponents();
        
        con_cliente = new conexao();
        con_cliente.conecta();
        
        TelaAlt.setVisible(false);
        TelaAlt.setLocationRelativeTo(null);
        
        MatteBorder customBorder= new MatteBorder(0, 1, 0, 0, new Color(217,217,217));
        
        jPanel1.setBorder(customBorder);
        jPanel2.setBorder(customBorder);
        jPanel3.setBorder(customBorder);
        
        sVGImage1.setSvgImage("Imagens/lock.svg", 24, 24);
        sVGImage2.setSvgImage("Imagens/edit.svg", 24, 24);
        sVGImage3.setSvgImage("Imagens/delete_forever.svg", 24, 24);
        
        applyHoverAnimation(bLock, new Color(28,27,31), new Color(55,58,60));
        applyHoverAnimation(bEdit, new Color(0,96,177), new Color(0,76,145));
        applyHoverAnimation(bExc, new Color(198,47,47), new Color(122,18,18));
        applyHoverAnimation(bAlt, new Color(255,101,0), new Color(245,160,1));
        
        bLock.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bExc.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bAlt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageAvatar1.setCursor(new Cursor(Cursor.HAND_CURSOR));
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

        dateChooser1 = new com.raven.datechooser.DateChooser();
        TelaAlt = new javax.swing.JDialog();
        JPanel4 = new javax.swing.JPanel();
        button1 = new javaswingdev.Button();
        imageAvatar1 = new javaswingdev.ImageAvatar();
        jLabel4 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        data = new javax.swing.JTextField();
        bAlt = new javaswingdev.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        panelRound1 = new javaswingdev.PanelRound();
        ID = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Perfil = new javaswingdev.ImageAvatar();
        jPanel2 = new javax.swing.JPanel();
        Usuario = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Data = new javax.swing.JLabel();
        bLock = new javaswingdev.PanelRound();
        sVGImage1 = new javaswingdev.SVGImage();
        bEdit = new javaswingdev.PanelRound();
        sVGImage2 = new javaswingdev.SVGImage();
        bExc = new javaswingdev.PanelRound();
        sVGImage3 = new javaswingdev.SVGImage();

        dateChooser1.setForeground(new java.awt.Color(0, 96, 177));

        TelaAlt.setMaximumSize(new java.awt.Dimension(650, 400));
        TelaAlt.setMinimumSize(new java.awt.Dimension(650, 400));
        TelaAlt.setModal(true);
        TelaAlt.setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        TelaAlt.setModalityType(java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
        TelaAlt.setUndecorated(true);
        TelaAlt.setPreferredSize(new java.awt.Dimension(650, 400));
        TelaAlt.setResizable(false);
        TelaAlt.getContentPane().setLayout(null);

        JPanel4.setBackground(new java.awt.Color(255, 255, 255));
        JPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217, 217, 217)));
        JPanel4.setMaximumSize(new java.awt.Dimension(650, 400));
        JPanel4.setMinimumSize(new java.awt.Dimension(650, 400));
        JPanel4.setPreferredSize(new java.awt.Dimension(650, 400));
        JPanel4.setLayout(null);

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Close black.png"))); // NOI18N
        button1.setFocusable(false);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        JPanel4.add(button1);
        button1.setBounds(616, 0, 34, 34);

        imageAvatar1.setAlignmentX(0.0F);
        imageAvatar1.setAlignmentY(0.0F);
        imageAvatar1.setMaximumSize(new java.awt.Dimension(120, 120));
        imageAvatar1.setMinimumSize(new java.awt.Dimension(120, 120));
        JPanel4.add(imageAvatar1);
        imageAvatar1.setBounds(71, 100, 120, 120);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setLabelFor(usuario);
        jLabel4.setText("Usuário");
        JPanel4.add(jLabel4);
        jLabel4.setBounds(302, 45, 210, 19);

        usuario.setBackground(new java.awt.Color(255, 255, 255));
        usuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        usuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        usuario.setMaximumSize(new java.awt.Dimension(276, 44));
        usuario.setMinimumSize(new java.awt.Dimension(276, 44));
        usuario.setPreferredSize(new java.awt.Dimension(276, 44));
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        JPanel4.add(usuario);
        usuario.setBounds(302, 70, 276, 44);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setLabelFor(usuario);
        jLabel5.setText("CPF");
        JPanel4.add(jLabel5);
        jLabel5.setBounds(302, 126, 210, 19);

        cpf.setBackground(new java.awt.Color(255, 255, 255));
        cpf.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cpf.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cpf.setMaximumSize(new java.awt.Dimension(276, 44));
        cpf.setMinimumSize(new java.awt.Dimension(276, 44));
        cpf.setPreferredSize(new java.awt.Dimension(276, 44));
        cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfActionPerformed(evt);
            }
        });
        JPanel4.add(cpf);
        cpf.setBounds(302, 151, 276, 44);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setLabelFor(usuario);
        jLabel6.setText("Data de Nascimento");
        JPanel4.add(jLabel6);
        jLabel6.setBounds(302, 207, 210, 19);

        data.setBackground(new java.awt.Color(255, 255, 255));
        data.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        data.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        data.setMaximumSize(new java.awt.Dimension(276, 44));
        data.setMinimumSize(new java.awt.Dimension(276, 44));
        data.setPreferredSize(new java.awt.Dimension(276, 44));
        data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataActionPerformed(evt);
            }
        });
        JPanel4.add(data);
        data.setBounds(302, 232, 276, 44);

        bAlt.setBackground(new java.awt.Color(255, 101, 0));
        bAlt.setMaximumSize(new java.awt.Dimension(276, 44));
        bAlt.setMinimumSize(new java.awt.Dimension(276, 44));
        bAlt.setPreferredSize(new java.awt.Dimension(276, 44));
        bAlt.setRoundBottomLeft(15);
        bAlt.setRoundBottomRight(15);
        bAlt.setRoundTopLeft(15);
        bAlt.setRoundTopRight(15);
        bAlt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bAltMouseClicked(evt);
            }
        });
        bAlt.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alterar");
        jLabel1.setMaximumSize(new java.awt.Dimension(62, 28));
        jLabel1.setMinimumSize(new java.awt.Dimension(62, 28));
        jLabel1.setPreferredSize(new java.awt.Dimension(62, 28));
        bAlt.add(jLabel1);
        jLabel1.setBounds(107, 8, 62, 28);

        JPanel4.add(bAlt);
        bAlt.setBounds(187, 312, 276, 44);

        jPanel5.setBackground(new java.awt.Color(0, 96, 177));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        JPanel4.add(jPanel5);
        jPanel5.setBounds(0, 368, 650, 32);

        TelaAlt.getContentPane().add(JPanel4);
        JPanel4.setBounds(0, 0, 650, 400);

        setMaximumSize(new java.awt.Dimension(900, 44));
        setMinimumSize(new java.awt.Dimension(900, 44));
        setName(""); // NOI18N
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(900, 44));
        setLayout(null);

        panelRound1.setBackground(new java.awt.Color(245, 246, 247));
        panelRound1.setAlignmentX(0.0F);
        panelRound1.setAlignmentY(0.0F);
        panelRound1.setMaximumSize(new java.awt.Dimension(900, 44));
        panelRound1.setMinimumSize(new java.awt.Dimension(900, 44));
        panelRound1.setPreferredSize(new java.awt.Dimension(900, 44));
        panelRound1.setRoundBottomLeft(15);
        panelRound1.setRoundBottomRight(15);
        panelRound1.setRoundTopLeft(15);
        panelRound1.setRoundTopRight(15);
        panelRound1.setLayout(null);

        ID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ID.setForeground(new java.awt.Color(0, 0, 0));
        ID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ID.setText("#");
        ID.setMaximumSize(new java.awt.Dimension(56, 42));
        ID.setMinimumSize(new java.awt.Dimension(56, 42));
        ID.setPreferredSize(new java.awt.Dimension(44, 43));
        panelRound1.add(ID);
        ID.setBounds(1, 0, 44, 43);

        jPanel1.setBackground(new java.awt.Color(204, 0, 51));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(56, 42));
        jPanel1.setLayout(null);

        Perfil.setMaximumSize(new java.awt.Dimension(56, 42));
        Perfil.setMinimumSize(new java.awt.Dimension(56, 42));
        jPanel1.add(Perfil);
        Perfil.setBounds(0, 0, 56, 42);

        panelRound1.add(jPanel1);
        jPanel1.setBounds(45, 1, 56, 42);

        jPanel2.setBackground(new java.awt.Color(204, 0, 51));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(348, 42));
        jPanel2.setLayout(null);

        Usuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Usuario.setForeground(new java.awt.Color(0, 0, 0));
        Usuario.setText("NOME");
        Usuario.setAlignmentY(0.0F);
        Usuario.setMaximumSize(new java.awt.Dimension(348, 42));
        Usuario.setMinimumSize(new java.awt.Dimension(348, 42));
        Usuario.setPreferredSize(new java.awt.Dimension(348, 42));
        jPanel2.add(Usuario);
        Usuario.setBounds(18, 0, 330, 42);

        panelRound1.add(jPanel2);
        jPanel2.setBounds(101, 1, 348, 42);

        jPanel3.setBackground(new java.awt.Color(204, 0, 51));
        jPanel3.setMaximumSize(new java.awt.Dimension(450, 42));
        jPanel3.setMinimumSize(new java.awt.Dimension(450, 42));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(450, 42));
        jPanel3.setLayout(null);

        Data.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Data.setForeground(new java.awt.Color(0, 0, 0));
        Data.setText("2000-00-00");
        Data.setAlignmentY(0.0F);
        Data.setMaximumSize(new java.awt.Dimension(348, 42));
        Data.setMinimumSize(new java.awt.Dimension(348, 42));
        Data.setPreferredSize(new java.awt.Dimension(348, 42));
        jPanel3.add(Data);
        Data.setBounds(18, 0, 100, 42);

        bLock.setBackground(new java.awt.Color(28, 27, 31));
        bLock.setMaximumSize(new java.awt.Dimension(34, 34));
        bLock.setMinimumSize(new java.awt.Dimension(34, 34));
        bLock.setPreferredSize(new java.awt.Dimension(34, 34));
        bLock.setRoundBottomLeft(12);
        bLock.setRoundBottomRight(12);
        bLock.setRoundTopLeft(12);
        bLock.setRoundTopRight(12);
        bLock.setLayout(null);

        sVGImage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage1.setMaximumSize(new java.awt.Dimension(34, 34));
        sVGImage1.setMinimumSize(new java.awt.Dimension(34, 34));
        sVGImage1.setPreferredSize(new java.awt.Dimension(34, 34));
        bLock.add(sVGImage1);
        sVGImage1.setBounds(0, 0, 34, 34);

        jPanel3.add(bLock);
        bLock.setBounds(323, 4, 34, 34);

        bEdit.setBackground(new java.awt.Color(0, 96, 177));
        bEdit.setMaximumSize(new java.awt.Dimension(34, 34));
        bEdit.setMinimumSize(new java.awt.Dimension(34, 34));
        bEdit.setRoundBottomLeft(12);
        bEdit.setRoundBottomRight(12);
        bEdit.setRoundTopLeft(12);
        bEdit.setRoundTopRight(12);
        bEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEditMouseClicked(evt);
            }
        });
        bEdit.setLayout(null);

        sVGImage2.setBackground(new java.awt.Color(0, 96, 177));
        sVGImage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage2.setMaximumSize(new java.awt.Dimension(34, 34));
        sVGImage2.setMinimumSize(new java.awt.Dimension(34, 34));
        sVGImage2.setPreferredSize(new java.awt.Dimension(34, 34));
        bEdit.add(sVGImage2);
        sVGImage2.setBounds(0, 0, 34, 34);

        jPanel3.add(bEdit);
        bEdit.setBounds(367, 4, 34, 34);

        bExc.setBackground(new java.awt.Color(198, 47, 47));
        bExc.setMaximumSize(new java.awt.Dimension(34, 34));
        bExc.setMinimumSize(new java.awt.Dimension(34, 34));
        bExc.setRoundBottomLeft(12);
        bExc.setRoundBottomRight(12);
        bExc.setRoundTopLeft(12);
        bExc.setRoundTopRight(12);
        bExc.setLayout(null);

        sVGImage3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage3.setMaximumSize(new java.awt.Dimension(34, 34));
        sVGImage3.setMinimumSize(new java.awt.Dimension(34, 34));
        sVGImage3.setPreferredSize(new java.awt.Dimension(34, 34));
        bExc.add(sVGImage3);
        sVGImage3.setBounds(0, 0, 34, 34);

        jPanel3.add(bExc);
        bExc.setBounds(411, 4, 34, 34);

        panelRound1.add(jPanel3);
        jPanel3.setBounds(449, 1, 450, 42);

        add(panelRound1);
        panelRound1.setBounds(0, 0, 900, 44);
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    private void cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfActionPerformed

    private void dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        TelaAlt.setVisible(false);
    }//GEN-LAST:event_button1ActionPerformed
    
    private void bEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEditMouseClicked
        
    }//GEN-LAST:event_bEditMouseClicked

    private void bAltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAltMouseClicked
        String newName = usuario.getText();
        String newCPF = cpf.getText();
        String newDate = data.getText();
    }//GEN-LAST:event_bAltMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Data;
    public javax.swing.JLabel ID;
    private javax.swing.JPanel JPanel4;
    public javaswingdev.ImageAvatar Perfil;
    public javax.swing.JDialog TelaAlt;
    public javax.swing.JLabel Usuario;
    public javaswingdev.PanelRound bAlt;
    public javaswingdev.PanelRound bEdit;
    public javaswingdev.PanelRound bExc;
    public javaswingdev.PanelRound bLock;
    private javaswingdev.Button button1;
    public javax.swing.JTextField cpf;
    public javax.swing.JTextField data;
    private com.raven.datechooser.DateChooser dateChooser1;
    public javaswingdev.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javaswingdev.PanelRound panelRound1;
    private javaswingdev.SVGImage sVGImage1;
    public javaswingdev.SVGImage sVGImage2;
    private javaswingdev.SVGImage sVGImage3;
    public javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}