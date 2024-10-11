package Telas;

import Main.login;
import conexao.conexao;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;

public class cadastro extends javax.swing.JFrame {
    conexao con_cliente;
    
    public cadastro() {
        initComponents();
        
        con_cliente = new conexao();
        con_cliente.conecta();
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagens/IconeK-Bom.png"));
        setIconImage(icon.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bCriar1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        senha = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        confsenha = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        data = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        button1 = new javaswingdev.Button();
        button2 = new javaswingdev.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(826, 620));
        setMinimumSize(new java.awt.Dimension(826, 620));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(826, 620));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/LogoK-bom.png"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(120, 30));
        jLabel3.setMinimumSize(new java.awt.Dimension(120, 30));
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 30));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(350, 70, 120, 30);

        jPanel2.setBackground(new java.awt.Color(0, 96, 177));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 550, 830, 81);

        jPanel3.setBackground(new java.awt.Color(204, 102, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 520, 830, 32);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 96, 177));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cadastro");
        jLabel4.setMaximumSize(new java.awt.Dimension(96, 41));
        jLabel4.setMinimumSize(new java.awt.Dimension(96, 41));
        jLabel4.setPreferredSize(new java.awt.Dimension(96, 41));
        jPanel1.add(jLabel4);
        jLabel4.setBounds(410, 100, 160, 41);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel5.setText("Faça seu");
        jLabel5.setMaximumSize(new java.awt.Dimension(154, 41));
        jLabel5.setMinimumSize(new java.awt.Dimension(154, 41));
        jLabel5.setPreferredSize(new java.awt.Dimension(154, 41));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(250, 100, 154, 41);

        bCriar1.setBackground(new java.awt.Color(0, 96, 177));
        bCriar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bCriar1.setForeground(new java.awt.Color(255, 255, 255));
        bCriar1.setText("Criar");
        bCriar1.setActionCommand("Entrar");
        bCriar1.setBorder(null);
        bCriar1.setBorderPainted(false);
        bCriar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCriar1.setMaximumSize(new java.awt.Dimension(276, 44));
        bCriar1.setMinimumSize(new java.awt.Dimension(276, 44));
        bCriar1.setPreferredSize(new java.awt.Dimension(276, 44));
        bCriar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCriar1ActionPerformed(evt);
            }
        });
        jPanel1.add(bCriar1);
        bCriar1.setBounds(270, 430, 276, 44);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel14.setText("Já tem uma conta?");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel14);
        jLabel14.setBounds(325, 480, 118, 20);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 102, 255));
        jLabel12.setText("Entre");
        jLabel12.setAlignmentY(0.0F);
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12);
        jLabel12.setBounds(450, 480, 32, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Ellipse 2.png"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(573, 116, 15, 15);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Usuário");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(100, 160, 54, 19);

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
        jPanel1.add(usuario);
        usuario.setBounds(100, 190, 236, 36);

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Email");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(100, 240, 37, 19);

        email.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        email.setMaximumSize(new java.awt.Dimension(276, 44));
        email.setMinimumSize(new java.awt.Dimension(276, 44));
        email.setPreferredSize(new java.awt.Dimension(276, 44));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email);
        email.setBounds(100, 270, 236, 36);

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("CPF");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(100, 320, 28, 19);

        cpf.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cpf.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cpf.setMaximumSize(new java.awt.Dimension(276, 44));
        cpf.setMinimumSize(new java.awt.Dimension(276, 44));
        cpf.setPreferredSize(new java.awt.Dimension(276, 44));
        jPanel1.add(cpf);
        cpf.setBounds(100, 350, 236, 36);

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setText("Senha");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(480, 160, 44, 19);

        senha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        senha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        senha.setMaximumSize(new java.awt.Dimension(276, 44));
        senha.setMinimumSize(new java.awt.Dimension(276, 44));
        senha.setPreferredSize(new java.awt.Dimension(276, 44));
        senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaActionPerformed(evt);
            }
        });
        jPanel1.add(senha);
        senha.setBounds(480, 190, 236, 36);

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setText("Confirma Senha");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(480, 240, 111, 19);

        confsenha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        confsenha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        confsenha.setMaximumSize(new java.awt.Dimension(276, 44));
        confsenha.setMinimumSize(new java.awt.Dimension(276, 44));
        confsenha.setPreferredSize(new java.awt.Dimension(276, 44));
        confsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confsenhaActionPerformed(evt);
            }
        });
        jPanel1.add(confsenha);
        confsenha.setBounds(480, 270, 236, 36);

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setText("Data de Nascimento");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(480, 320, 139, 19);

        data.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        data.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        data.setMaximumSize(new java.awt.Dimension(276, 44));
        data.setMinimumSize(new java.awt.Dimension(276, 44));
        data.setPreferredSize(new java.awt.Dimension(276, 44));
        jPanel1.add(data);
        data.setBounds(480, 350, 236, 36);

        jLabel10.setForeground(new java.awt.Color(51, 153, 255));
        jLabel10.setText("_____");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(448, 483, 220, 14);

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Close black.png"))); // NOI18N
        button1.setFocusPainted(false);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1);
        button1.setBounds(790, 0, 34, 34);

        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/minus black.png"))); // NOI18N
        button2.setFocusPainted(false);
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jPanel1.add(button2);
        button2.setBounds(760, 0, 34, 34);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCriar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCriar1ActionPerformed
        if(con_cliente.conecta()) {
            String cadastro = "INSERT INTO cliente (Nome_Cli, Senha, Email, CPF, Data_Nasc, Token) VALUES (?, ?, ?, ?, ?, ?)";

            try(PreparedStatement stmt = con_cliente.getConnection().prepareStatement(cadastro)) {
                // Preencher os parâmetros da consulta
                stmt.setString(1, usuario.getText());
                stmt.setString(2, senha.getText());
                stmt.setString(3, email.getText());
                stmt.setString(4, cpf.getText());
                stmt.setString(5, data.getText());
                stmt.setString(6, "gerar-token-aqui");  // Substitua pelo valor correto do Token

                // Executar a consulta
                int linhasAfetadas = stmt.executeUpdate();

                // Verificar se a inserção foi bem-sucedida
                if(linhasAfetadas > 0) {
                    JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

                    login mostra = new login();
                    mostra.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Email ou CPF já estão cadastrados!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch(SQLException errosql) {
                JOptionPane.showMessageDialog(null, "Não foi possível registrar seu cadastro, tente novamente mais tarde! :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            } finally {
                con_cliente.desconecta(); // Certifique-se de desconectar após a operação
            }
        }
    }//GEN-LAST:event_bCriar1ActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaActionPerformed

    private void confsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confsenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confsenhaActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        login mostra2 = new login();
        mostra2.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_button2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCriar1;
    private javaswingdev.Button button1;
    private javaswingdev.Button button2;
    private javax.swing.JTextField confsenha;
    private javax.swing.JTextField cpf;
    private javax.swing.JTextField data;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField senha;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}