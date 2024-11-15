package Main;

import static Telas.ManageAccount.URL;
import Telas.Menu;
import Telas.cadastro;
import conexao.TokenGenerator;
import conexao.conexao;
import conexao.FileUploader;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.SwingWorker;

public class login extends javax.swing.JFrame {
    conexao con_cliente;
    public static int clienteID;
    public static int admID;

    public login() {
        initComponents();
        
        setTitle("K-Bom");
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagens/IconeK-Bom.png"));
        setIconImage(icon.getImage());
        
        con_cliente = new conexao();
        con_cliente.conecta();
        
        sVGImage2.setSvgImage("Imagens/mail.svg", 18, 18);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        blogar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        email = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        sVGImage2 = new javaswingdev.SVGImage();
        button1 = new javaswingdev.Button();
        button2 = new javaswingdev.Button();
        button3 = new javaswingdev.Button();
        button4 = new javaswingdev.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(444, 600));
        setMinimumSize(new java.awt.Dimension(444, 600));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setMaximumSize(new java.awt.Dimension(444, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(444, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(444, 600));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Faça seu");
        jLabel1.setMaximumSize(new java.awt.Dimension(154, 41));
        jLabel1.setMinimumSize(new java.awt.Dimension(154, 41));
        jLabel1.setPreferredSize(new java.awt.Dimension(154, 41));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(84, 75, 180, 41);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 51));
        jLabel2.setText("Login");
        jLabel2.setMaximumSize(new java.awt.Dimension(96, 41));
        jLabel2.setMinimumSize(new java.awt.Dimension(96, 41));
        jLabel2.setPreferredSize(new java.awt.Dimension(96, 41));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(244, 75, 120, 41);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Email");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(84, 153, 70, 19);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Senha");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(84, 240, 70, 19);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 255));
        jLabel5.setText("Esqueceu minha senha");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(149, 323, 142, 20);

        blogar.setBackground(new java.awt.Color(51, 102, 255));
        blogar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        blogar.setForeground(new java.awt.Color(255, 255, 255));
        blogar.setText("Entre");
        blogar.setActionCommand("Entrar");
        blogar.setBorder(null);
        blogar.setBorderPainted(false);
        blogar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        blogar.setMaximumSize(new java.awt.Dimension(276, 44));
        blogar.setMinimumSize(new java.awt.Dimension(276, 44));
        blogar.setPreferredSize(new java.awt.Dimension(276, 44));
        blogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blogarActionPerformed(evt);
            }
        });
        jPanel1.add(blogar);
        blogar.setBounds(84, 390, 276, 44);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 102, 255));
        jLabel12.setText("Crie-a!");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12);
        jLabel12.setBounds(290, 448, 50, 20);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Ainda não tem uma conta?");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel14);
        jLabel14.setBounds(113, 448, 171, 20);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Ellipse 1.png"))); // NOI18N
        jPanel1.add(jLabel13);
        jLabel13.setBounds(346, 93, 15, 15);

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
        senha.setBounds(84, 265, 276, 44);

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
        email.setBounds(84, 178, 276, 44);

        jPanel2.setBackground(new java.awt.Color(0, 96, 177));
        jPanel2.setMaximumSize(new java.awt.Dimension(444, 113));
        jPanel2.setMinimumSize(new java.awt.Dimension(444, 113));
        jPanel2.setPreferredSize(new java.awt.Dimension(444, 113));

        jPanel3.setBackground(new java.awt.Color(255, 101, 0));
        jPanel3.setMaximumSize(new java.awt.Dimension(444, 32));
        jPanel3.setMinimumSize(new java.awt.Dimension(444, 32));
        jPanel3.setPreferredSize(new java.awt.Dimension(444, 32));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 81, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 495, 444, 113);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/LogoK-bom.png"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(120, 30));
        jLabel3.setMinimumSize(new java.awt.Dimension(120, 30));
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 30));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(160, 50, 120, 30);

        sVGImage2.setMaximumSize(new java.awt.Dimension(18, 18));
        sVGImage2.setMinimumSize(new java.awt.Dimension(18, 18));
        sVGImage2.setPreferredSize(new java.awt.Dimension(18, 18));
        jPanel1.add(sVGImage2);
        sVGImage2.setBounds(366, 189, 18, 18);

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Close black.png"))); // NOI18N
        button1.setFocusable(false);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1);
        button1.setBounds(410, 0, 34, 34);

        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/minus black.png"))); // NOI18N
        button2.setFocusPainted(false);
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jPanel1.add(button2);
        button2.setBounds(380, 0, 34, 34);

        button3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/eye-off.png"))); // NOI18N
        button3.setAlignmentY(0.0F);
        button3.setFocusable(false);
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        jPanel1.add(button3);
        button3.setBounds(360, 273, 28, 28);

        button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/eye.png"))); // NOI18N
        button4.setAlignmentY(0.0F);
        button4.setFocusable(false);
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        jPanel1.add(button4);
        button4.setBounds(360, 273, 28, 28);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void salvarDados(String usuarioID) {
        String path = "src/conexao/Token.txt"; // Caminho do arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(usuarioID); // Escreve o ID no arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String lerDados() {
        String linha = null; // Variável para armazenar a primeira linha
        String path = "src/conexao/Token.txt"; // Caminho do arquivo

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            linha = reader.readLine(); // Lê apenas a primeira linha
        } catch (IOException e) {
            e.printStackTrace(); // Imprime a pilha de exceções se ocorrer um erro
        }

        return linha; // Retorna a primeira linha lida
    }
    
    public static void executeWithDelay(int milliseconds, Runnable task) {
        // Criando um SwingWorker para executar a tarefa após o delay
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Pausa a execução por um tempo especificado
                Thread.sleep(milliseconds);
                return null;
            }

            @Override
            protected void done() {
                // Executa a tarefa após o delay
                task.run();
            }
        };

        // Executa o worker
        worker.execute();
    }
    
    private void blogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blogarActionPerformed
        String usuario = email.getText();
        String pass = senha.getText();
        String sql = "SELECT ID_cliente FROM cliente WHERE Email = ? AND Senha = ?";
        String sqlBackup = "SELECT ID_adm FROM administrador WHERE Email = ? AND Senha = ?";
        
        try {
            // Use o método getConnection para obter a conexão
            Connection conexao = con_cliente.getConnection();

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            
            // Gera um token
            String token = TokenGenerator.generateToken();
            Timestamp expireDate = new Timestamp(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000); // 30 dias a partir de agora
            
            salvarDados(token);

            if (rs.next()) {
                // Atualiza o token e a data de expiração no banco de dados
                clienteID = rs.getInt("ID_cliente");
                System.out.println("Id CLIENTE - "+clienteID);
                String updateSql = "UPDATE cliente SET Token = ?, Token_expira_em = ? WHERE ID_cliente = "+clienteID;
                
                PreparedStatement updatePst = conexao.prepareStatement(updateSql);
                updatePst.setString(1, token);
                updatePst.setTimestamp(2, expireDate);
                updatePst.executeUpdate();

                AbrirTelaLogar();
            } else {
                // Tenta buscar na tabela de backup se não encontrado na tabela principal
                PreparedStatement pstBackup = conexao.prepareStatement(sqlBackup);
                pstBackup.setString(1, usuario);
                pstBackup.setString(2, pass);
                ResultSet rsBackup = pstBackup.executeQuery();
                
                if (rsBackup.next()) {
                    
                    admID = rsBackup.getInt("ID_adm");
                    System.out.println("Id ADM - "+admID);
                    String updateSql2 = "UPDATE administrador SET Token = ?, Token_expira_em = ? WHERE ID_adm = "+admID;

                    PreparedStatement updatePst2 = conexao.prepareStatement(updateSql2);
                    updatePst2.setString(1, token);
                    updatePst2.setTimestamp(2, expireDate);
                    updatePst2.executeUpdate();
                    AbrirTelaLogar();
                } else {
                    // Se não encontrar em nenhuma das tabelas
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + e.getMessage());
        }
    }//GEN-LAST:event_blogarActionPerformed

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        AbrirTelaCadastro();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void AbrirTelaCadastro() {
        // Gradualmente reduz a opacidade da janela
        new Thread(() -> {
            try {
                for (float i = 1.0f; i > 0.0f; i -= 0.05f) {
                    setOpacity(i);  // Reduz a opacidade da janela
                    Thread.sleep(2); // Aguarda 50ms para criar o efeito de transição suave
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cadastro mostra2 = new cadastro();
            mostra2.setVisible(true);
            dispose();
        }).start();
    }
    
    private void AbrirTelaLogar() {
        // Gradualmente reduz a opacidade da janela
        new Thread(() -> {
            try {
                for (float i = 1.0f; i > 0.0f; i -= 0.05f) {
                    setOpacity(i);  // Reduz a opacidade da janela
                    Thread.sleep(2); // Aguarda 50ms para criar o efeito de transição suave
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Menu mostra = new Menu();
            mostra.setVisible(true);
            dispose();
        }).start();
    }
    
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        senha.setEchoChar((char)0);
        button3.setVisible(false);
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        senha.setEchoChar('•');
        button3.setVisible(true);
    }//GEN-LAST:event_button4ActionPerformed

    public static void main(String args[]) {
        new splashscreen.SplashScreen(null,true).setVisible(true);
        
        conexao con_cliente = new conexao();
        con_cliente.conecta();
        
        login armazenarDados = new login();
        
        String Token = armazenarDados.lerDados();

        try {
            Connection conexao = con_cliente.getConnection();
            String sql = "SELECT ID_cliente FROM cliente WHERE Token = '"+Token+"'";
            String sqlBackup = "SELECT ID_adm FROM administrador WHERE Token = '"+Token+"'";
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            // Cria a tela de login
            login loginScreen = new login();

            if (rs.next()) {
                
                clienteID = rs.getInt("ID_cliente");
                
                // Token válido encontrado, redireciona para o Menu
                Menu mostra = new Menu();
                mostra.setVisible(true);
                // Fecha a tela de login
                loginScreen.dispose(); // Fecha a janela de login
            } else {
                PreparedStatement pstBackup = conexao.prepareStatement(sqlBackup);
                ResultSet rsBackup = pstBackup.executeQuery();
                if(rsBackup.next()) {
                    
                    admID = rsBackup.getInt("ID_adm");
                    
                    Menu mostra = new Menu();
                    mostra.setVisible(true);
                    // Fecha a tela de login
                    loginScreen.dispose();
                } else {
                    // Nenhum token válido, abre a tela de login
                    java.awt.EventQueue.invokeLater(() -> loginScreen.setVisible(true));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + e.getMessage());
        } finally {
            con_cliente.desconecta();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blogar;
    private javaswingdev.Button button1;
    private javaswingdev.Button button2;
    private javaswingdev.Button button3;
    private javaswingdev.Button button4;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javaswingdev.SVGImage sVGImage2;
    private javax.swing.JPasswordField senha;
    // End of variables declaration//GEN-END:variables
}