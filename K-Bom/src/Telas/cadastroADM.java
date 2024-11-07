package Telas;

import Main.login;
import conexao.conexao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class cadastroADM extends javax.swing.JFrame {
    conexao con_cliente;
    
    public cadastroADM() {
        initComponents();
        
        panelRound1.setVisible(false);
        jLabel1.setOpaque(false);
        
        con_cliente = new conexao();
        con_cliente.conecta();
        
        setTitle("K-Bom");
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagens/IconeK-Bom.png"));
        setIconImage(icon.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bCriar1 = new javax.swing.JButton();
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
        button1 = new javaswingdev.Button();
        button2 = new javaswingdev.Button();
        panelRound1 = new javaswingdev.PanelRound();
        jLabel1 = new javax.swing.JLabel();

        dateChooser1.setForeground(new java.awt.Color(0, 96, 177));
        dateChooser1.setTextRefernce(data);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(826, 620));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(826, 620));
        jPanel1.setMinimumSize(new java.awt.Dimension(826, 620));
        jPanel1.setPreferredSize(new java.awt.Dimension(826, 620));
        jPanel1.setLayout(null);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/settings.png"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(645, 112, 24, 24);

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
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Administrador");
        jLabel4.setMaximumSize(new java.awt.Dimension(96, 41));
        jLabel4.setMinimumSize(new java.awt.Dimension(96, 41));
        jLabel4.setPreferredSize(new java.awt.Dimension(96, 41));
        jPanel1.add(jLabel4);
        jLabel4.setBounds(400, 100, 350, 41);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cadastre um");
        jLabel5.setMaximumSize(new java.awt.Dimension(154, 41));
        jLabel5.setMinimumSize(new java.awt.Dimension(154, 41));
        jLabel5.setPreferredSize(new java.awt.Dimension(154, 41));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(170, 100, 280, 41);

        bCriar1.setBackground(new java.awt.Color(0, 96, 177));
        bCriar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bCriar1.setForeground(new java.awt.Color(255, 255, 255));
        bCriar1.setText("Criar");
        bCriar1.setActionCommand("Entrar");
        bCriar1.setBorder(null);
        bCriar1.setBorderPainted(false);
        bCriar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCriar1.setFocusable(false);
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

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Usuário");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(100, 160, 80, 19);

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
        jPanel1.add(usuario);
        usuario.setBounds(100, 190, 236, 36);

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Email");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(100, 240, 70, 19);

        email.setBackground(new java.awt.Color(255, 255, 255));
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
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("CPF");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(100, 320, 60, 19);

        cpf.setBackground(new java.awt.Color(255, 255, 255));
        cpf.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cpf.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cpf.setMaximumSize(new java.awt.Dimension(276, 44));
        cpf.setMinimumSize(new java.awt.Dimension(276, 44));
        cpf.setPreferredSize(new java.awt.Dimension(276, 44));
        jPanel1.add(cpf);
        cpf.setBounds(100, 350, 236, 36);

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Senha");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(480, 160, 70, 19);

        senha.setBackground(new java.awt.Color(255, 255, 255));
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
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Confirma Senha");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(480, 240, 150, 19);

        confsenha.setBackground(new java.awt.Color(255, 255, 255));
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
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Data de Nascimento");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(480, 320, 180, 19);

        data.setBackground(new java.awt.Color(255, 255, 255));
        data.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        data.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        data.setMaximumSize(new java.awt.Dimension(276, 44));
        data.setMinimumSize(new java.awt.Dimension(276, 44));
        data.setPreferredSize(new java.awt.Dimension(276, 44));
        jPanel1.add(data);
        data.setBounds(480, 350, 236, 36);

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

        panelRound1.setBackground(new java.awt.Color(255, 0, 0));
        panelRound1.setForeground(new java.awt.Color(204, 204, 204));
        panelRound1.setAlignmentX(0.0F);
        panelRound1.setAlignmentY(0.0F);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(204, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Há algum erro no seus dados!");
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setOpaque(true);
        panelRound1.add(jLabel1);
        jLabel1.setBounds(5, 7, 280, 25);

        jPanel1.add(panelRound1);
        panelRound1.setBounds(270, 20, 290, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 
    public static boolean isCPFValido(String cpf) {
        // Remove caracteres especiais, como pontos e traços
        cpf = cpf.replaceAll("[^0-9]", ""); 

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (como "111.111.111-11"), que é inválido
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Cálculo do primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 >= 10) {
            digito1 = 0;
        }

        // Cálculo do segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 >= 10) {
            digito2 = 0;
        }

        // Verifica se os dígitos calculados são iguais aos dígitos do CPF fornecido
        return (cpf.charAt(9) - '0' == digito1) && (cpf.charAt(10) - '0' == digito2);
    }
    
    public static boolean validarData(String dataNascimento, int idademax) {
        try {
            // Parse da string para o formato de data (YYYY-MM-DD)
            LocalDate dataNasc = LocalDate.parse(dataNascimento);
            LocalDate dataAtual = LocalDate.now();

            // Calcula a idade
            int idade = Period.between(dataNasc, dataAtual).getYears();

            // Verifica se a idade é maior ou igual a 14 anos
            if (idade >= idademax) {
                return true; // Data válida para maiores de 14 anos
            } else {
                return false; // Menores de 14 anos
            }

        } catch (DateTimeParseException e) {
            // Se a data estiver em um formato inválido
            System.out.println("Formato de data inválido!");
            return false;
        }
    }
    
    public void mostrarMensagemErro(String mensagem) {
        jLabel1.setText(mensagem);
        panelRound1.setVisible(true);

        // Cria um Timer para fazer a mensagem desaparecer gradualmente após 5 segundos
        Timer timer = new Timer(50, new ActionListener() {
            int tempoTotal = 5000; // 5 segundos
            int tempoDecorrido = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                tempoDecorrido += 50;

                // Se passar de 5 segundos, começa a diminuir a opacidade
                if (tempoDecorrido >= tempoTotal) {
                    float opacidade = 1.0f - ((tempoDecorrido - tempoTotal) / 1000f);
                    panelRound1.setForeground(new Color(1.0f, 0.0f, 0.0f, opacidade)); // Cor vermelha com opacidade

                    if (opacidade <= 0) {
                        ((Timer) e.getSource()).stop();
                        panelRound1.setVisible(false);
                    }
                }
            }
        });

        // Timer para iniciar a remoção suave após 5 segundos
        timer.setInitialDelay(5000);
        timer.start();
    }

    private void bCriar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCriar1ActionPerformed
        String senconf = confsenha.getText();
        String sen = senha.getText();
        String CPF = cpf.getText();
        String date = data.getText();
        String user = usuario.getText();
        String emai = email.getText();
        
        if(user.equals("") || emai.equals("") || CPF.equals("") || sen.equals("") || date.equals("")) {
            mostrarMensagemErro("Insira todos os campos!");
        } else {
            if(sen.equals(senconf)) {
                if(isCPFValido(CPF)) {
                    if(validarData(date, 14)) {
                        if(con_cliente.conecta()) {
                            String cadastro = "INSERT INTO administrador (Nome_adm, Senha, Email, CPF, Data_Nasc, URL_FotoPefil, Token) VALUES (?, ?, ?, ?, ?, ?, ?)";

                            try(PreparedStatement stmt = con_cliente.getConnection().prepareStatement(cadastro)) {
                                // Preencher os parâmetros da consulta
                                stmt.setString(1, usuario.getText());
                                stmt.setString(2, senha.getText());
                                stmt.setString(3, email.getText());
                                stmt.setString(4, cpf.getText());
                                stmt.setString(5, data.getText());
                                stmt.setString(6, "http://tentreosbrothers.shop/Guilherme/KBom/FotoPerfil/Padrao.png");
                                stmt.setString(7, null);

                                // Executar a consulta
                                int linhasAfetadas = stmt.executeUpdate();

                                // Verificar se a inserção foi bem-sucedida
                                if(linhasAfetadas > 0) {
                                    JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                                    login log = new login();
                                    log.setVisible(true);
                                    dispose();
                                }
                            } catch(SQLException errosql) {
                                JOptionPane.showMessageDialog(null, "Não foi possível registrar seu cadastro, tente novamente mais tarde! :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                            } finally {
                                con_cliente.desconecta(); // Certifique-se de desconectar após a operação
                            }
                        }
                    } else {
                        jLabel23.setForeground(Color.red);
                        mostrarMensagemErro("Idade menor de 14 anos!");
                    }
                } else {
                    jLabel17.setForeground(Color.red);
                    mostrarMensagemErro("CPF inválido!");
                } 
            } else {
                jLabel22.setForeground(Color.red);
                mostrarMensagemErro("Confirmação de senha incorreta!");
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
        
    }//GEN-LAST:event_confsenhaActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_button2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroADM().setVisible(true);
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
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
    private javaswingdev.PanelRound panelRound1;
    private javax.swing.JTextField senha;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}