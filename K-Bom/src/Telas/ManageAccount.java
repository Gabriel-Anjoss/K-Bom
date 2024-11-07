package Telas;

import static Main.login.clienteID;
import ShadowBox.PanelShadow;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javaswingdev.PanelRound;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;
import conexao.conexao;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javaswingdev.LinhaTable;
import jnafilechooser.api.JnaFileChooser;
import conexao.FileUploader;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;

public class ManageAccount extends javax.swing.JPanel {
    conexao con_cliente;
    private Color startColor = new Color(255, 101, 0);  // Cor inicial
    private Color hoverColor = new Color(245, 160, 1); // Cor ao passar o mouse
    private float colorStep = 0.1f; // Quantidade de mudança por frame
    
    public static File URL;
    public int w;
    
    LinhaTable linha = new LinhaTable();
    
    public ManageAccount() {
        initComponents();

        con_cliente = new conexao();
        con_cliente.conecta();
        
        jPanel1.setVisible(false);
        bReloadADM.setVisible(false);
        bReloadCli.setVisible(false);
        scrollPaneWin111.getVerticalScrollBar().setUnitIncrement(25);
        
        MatteBorder customBorder = new MatteBorder(0, 0, 0, 1, Color.BLACK);
        
        jPanel6.setBorder(customBorder);
        jPanel7.setBorder(customBorder);
        jPanel8.setBorder(customBorder);
        
        sVGImage1.setSvgImage("Imagens/shield_person.svg", 52, 52);
        sVGImage2.setSvgImage("Imagens/account_circle.svg", 52, 52);
        sVGImage3.setSvgImage("Imagens/sentiment_dissatisfied.svg", 50, 50);
        sVGImage4.setSvgImage("Imagens/Close.svg", 24, 24);
        bOK.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sVGImage4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jDialog1.setLocationRelativeTo(null);
        
        applyHoverAnimation(bADM);
        applyHoverAnimation(bCliente);
        
        bADM.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        bADM.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String sql = "SELECT ID_adm, URL_FotoPefil, Nome_adm, Data_Nasc FROM administrador";

                try {
                    Connection conexao = con_cliente.getConnection(); // Conexão com o banco
                    PreparedStatement pst = conexao.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery(); // Executa o SELECT e obtém os resultados

                    // Limpa o JPanel antes de adicionar novas linhas
                    jPanel4.removeAll();
                    bReloadADM.setVisible(true);
                    bReloadCli.setVisible(false);
                    w = 0;
                    w = 64;

                    while (rs.next()) {
                        // Pega os valores das colunas
                        int idAdmin = rs.getInt("ID_adm");
                        String perfil = rs.getString("URL_FotoPefil");
                        String usuario = rs.getString("Nome_adm");
                        String data = rs.getString("Data_Nasc");

                        try {
                            URL url = new URL(perfil);
                            Image image = ImageIO.read(url);
                            ImageIcon icon = new ImageIcon(image);

                            // Cria uma nova linha (um novo painel LinhaTable)
                            LinhaTable linha = new LinhaTable();
                            jPanel4.setPreferredSize(new java.awt.Dimension(938, w));
                            w = w + 64;

                            // Preenche as labels com os dados do banco
                            linha.ID.setText("" + idAdmin);
                            linha.Perfil.setIcon(icon);
                            linha.Usuario.setText(usuario);
                            linha.Data.setText(data);

                            linha.bEdit.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    // Query para atualizar na primeira tabela (cliente)
                                    String sqlUpdateCliente = "SELECT Nome_Cli, CPF, Data_Nasc, URL_FotoPefil FROM cliente WHERE ID_cliente = ? AND Nome_Cli = ? AND Data_Nasc = ?";

                                    // Query para atualizar na segunda tabela (administrador)
                                    String sqlUpdateAdm = "SELECT Nome_adm, CPF, Data_Nasc, URL_FotoPefil FROM administrador WHERE ID_adm = ? AND Nome_adm = ? AND Data_Nasc = ?";

                                    int id = Integer.parseInt(linha.ID.getText());
                                    String usuario = linha.Usuario.getText();
                                    String data = linha.Data.getText();

                                    try {
                                        // Abre a conexão com o banco de dados
                                        Connection conexao = con_cliente.getConnection();

                                        // Prepara a consulta de atualização para a tabela cliente
                                        PreparedStatement pst = conexao.prepareStatement(sqlUpdateCliente);
                                        pst.setInt(1, id); // ID do cliente
                                        pst.setString(2, usuario); // Nome atual (para garantir que o cliente certo seja atualizado)
                                        pst.setString(3, data); // Data atual
                                        ResultSet rs = pst.executeQuery();

                                        if (rs.next()) { // Se atualizou na tabela cliente
                                            linha.usuario.setText(rs.getString("Nome_Cli"));
                                            linha.cpf.setText(rs.getString("CPF"));
                                            linha.data.setText(rs.getString("Data_Nasc"));

                                            try {
                                                URL url = new URL(rs.getString("URL_FotoPefil"));
                                                Image image = ImageIO.read(url);
                                                ImageIcon icon = new ImageIcon(image);
                                                linha.imageAvatar1.setIcon(icon);
                                            } catch (IOException ex) {
                                                Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        } else {
                                            // Se não atualizou na tabela cliente, tenta na tabela administrador
                                            PreparedStatement pstBackup = conexao.prepareStatement(sqlUpdateAdm);
                                            pstBackup.setInt(1, id); // ID do administrador
                                            pstBackup.setString(2, usuario); // Nome atual
                                            pstBackup.setString(3, data); // Data atual
                                            ResultSet rsBackup = pstBackup.executeQuery();

                                            if (rsBackup.next()) {
                                                linha.usuario.setText(rsBackup.getString("Nome_adm"));
                                                linha.cpf.setText(rsBackup.getString("CPF"));
                                                linha.data.setText(rsBackup.getString("Data_Nasc"));

                                                try {
                                                    URL url = new URL(rsBackup.getString("URL_FotoPefil"));
                                                    Image image = ImageIO.read(url);
                                                    ImageIcon icon = new ImageIcon(image);
                                                    linha.imageAvatar1.setIcon(icon);
                                                } catch (IOException ex) {
                                                    Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            } else {
                                                // Se não encontrou nem na tabela cliente nem na tabela administrador
                                                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para atualizar.");
                                            }
                                        }
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage());
                                    }
                                    linha.TelaAlt.setVisible(true);
                                    
                                }
                            });
                            
                            linha.imageAvatar1.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    JnaFileChooser ch = new JnaFileChooser();
                                    boolean action;
                                    action = ch.showOpenDialog(SwingUtilities.getWindowAncestor(linha));
                                    if(action) {
                                        URL = ch.getSelectedFile();
                                        linha.TelaAlt.toFront();
                                        linha.TelaAlt.requestFocus();
                                        ImageIcon iconPreview = new ImageIcon(URL.toString());
                                        linha.imageAvatar1.setIcon(iconPreview);
                                        linha.imageAvatar1.revalidate();
                                        linha.imageAvatar1.repaint();
                                    }
                                }
                            });
                            
                            int dID = Integer.parseInt(linha.ID.getText());
                            String dName = linha.Usuario.getText();
                            String dDate = linha.Data.getText();
                            
                            System.out.println(dID+" "+dName+" "+dDate);
                            
                            linha.bAlt.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    String usuario = linha.usuario.getText();
                                    String cpf = linha.cpf.getText();
                                    String data = linha.data.getText();
                                    
                                    String sql = "SELECT ID_adm, URL_FotoPefil FROM administrador WHERE ID_adm = '"+dID+"' AND Nome_adm = '"+dName+"' AND Data_Nasc = '"+dDate+"'";
                                    
                                    try {
                                        // Abre a conexão com o banco de dados
                                        Connection conexao = con_cliente.getConnection();

                                        // Prepara a consulta de atualização para a tabela cliente
                                        PreparedStatement pst = conexao.prepareStatement(sql);
                                        ResultSet rs = pst.executeQuery();
                                        
                                        if(rs.next()) {
                                            String sqlUpdate = "UPDATE administrador SET Nome_adm = ?, CPF = ?, Data_Nasc = ?, URL_FotoPefil = ? WHERE ID_adm = ?";
                                            
                                            PreparedStatement pstADM = conexao.prepareStatement(sqlUpdate);
                                            pstADM.setString(1, usuario); // Nome                                            
                                            pstADM.setString(2, cpf);  // CPF
                                            pstADM.setString(3, data); // Data Nascimento
                                            
                                            String FileADM = String.valueOf(URL);
                                            
                                            if(FileADM != "null") {
                                                FileUploader upCliente = new FileUploader("http://tentreosbrothers.shop/Guilherme/KBom/uploadPerfil.php", FileADM);
                                                
                                                pstADM.setString(4, "http://tentreosbrothers.shop/Guilherme/KBom/FotoPerfil/"+upCliente.nomeFile);
                                            } else {
                                                pstADM.setString(4, rs.getString("URL_FotoPefil"));
                                            }
                                            
                                            pstADM.setInt(5, rs.getInt("ID_adm")); // Data Nascimento
                                            
                                            pstADM.executeUpdate();
                                            
                                            URL = null;
                                            linha.TelaAlt.setVisible(false);
                                            carregarAdministradores();
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para alterar.");
                                        }
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage());
                                    }
                                }
                            });
                            
                            linha.bExc.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    String sqlToken = "SELECT Token FROM administrador WHERE ID_adm = "+dID;
                                    String sql = "DELETE FROM administrador WHERE ID_adm = "+dID;
                                    
                                    try {
                                        // Abre a conexão com o banco de dados
                                        Connection conexao = con_cliente.getConnection();
                                        
                                        PreparedStatement pstToken = conexao.prepareStatement(sqlToken);
                                        ResultSet rs = pstToken.executeQuery();
                                        
                                        if(rs.next()) {
                                            String Token = rs.getString("Token");
                                            String TokenLocal = lerDados();
                                            
                                            if(TokenLocal.equals(Token)) {
                                                jDialog1.setVisible(true);
                                            } else {
                                                // Prepara a consulta de atualização para a tabela administrador
                                                PreparedStatement pst = conexao.prepareStatement(sql);
                                                pst.executeUpdate();
                                            }
                                        }
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null, "Erro ao apagar Registro " + ex.getMessage());
                                    }
                                }
                            });

                            // Adiciona o painel (linha) no seu JPanel principal
                            jPanel4.add(linha);
                        } catch (IOException ex) {
                            Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    // Atualiza o JPanel após adicionar todos os componentes
                    jPanel4.revalidate();
                    jPanel4.repaint();
                    jPanel1.setVisible(true);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage());
                } catch (Exception ex) {
                    Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        bCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String sql = "SELECT ID_cliente, URL_FotoPefil, Nome_Cli, Data_Nasc FROM cliente";

                try {
                    Connection conexao = con_cliente.getConnection(); // Conexão com o banco
                    PreparedStatement pst = conexao.prepareStatement(sql);
                    ResultSet rs = pst.executeQuery(); // Executa o SELECT e obtém os resultados

                    // Limpa o JPanel antes de adicionar novas linhas
                    jPanel4.removeAll();
                    bReloadADM.setVisible(false);
                    bReloadCli.setVisible(true);
                    w = 0;
                    w = 64;

                    while (rs.next()) {
                        // Pega os valores das colunas
                        int idCliente = rs.getInt("ID_cliente");
                        String perfil = rs.getString("URL_FotoPefil");
                        String usuario = rs.getString("Nome_Cli");
                        String data = rs.getString("Data_Nasc");

                        try {
                            URL url = new URL(perfil);
                            Image image = ImageIO.read(url);
                            ImageIcon icon = new ImageIcon(image);

                            // Cria uma nova linha (um novo painel LinhaTable)
                            LinhaTable linha = new LinhaTable();
                            jPanel4.setPreferredSize(new java.awt.Dimension(938, w));
                            w = w + 64;

                            // Preenche as labels com os dados do banco
                            linha.ID.setText("" + idCliente);
                            linha.Perfil.setIcon(icon);
                            linha.Usuario.setText(usuario);
                            linha.Data.setText(data);

                            linha.bEdit.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    // Query para atualizar na primeira tabela (cliente)
                                    String sqlUpdateCliente = "SELECT Nome_Cli, CPF, Data_Nasc, URL_FotoPefil FROM cliente WHERE ID_cliente = ? AND Nome_Cli = ? AND Data_Nasc = ?";

                                    // Query para atualizar na segunda tabela (administrador)
                                    String sqlUpdateAdm = "SELECT Nome_adm, CPF, Data_Nasc, URL_FotoPefil FROM administrador WHERE ID_adm = ? AND Nome_adm = ? AND Data_Nasc = ?";

                                    int id = Integer.parseInt(linha.ID.getText());
                                    String usuario = linha.Usuario.getText();
                                    String data = linha.Data.getText();

                                    try {
                                        // Abre a conexão com o banco de dados
                                        Connection conexao = con_cliente.getConnection();

                                        // Prepara a consulta de atualização para a tabela cliente
                                        PreparedStatement pst = conexao.prepareStatement(sqlUpdateCliente);
                                        pst.setInt(1, id); // ID do cliente
                                        pst.setString(2, usuario); // Nome atual (para garantir que o cliente certo seja atualizado)
                                        pst.setString(3, data); // Data atual
                                        ResultSet rs = pst.executeQuery();

                                        if (rs.next()) { // Se atualizou na tabela cliente
                                            linha.usuario.setText(rs.getString("Nome_Cli"));
                                            linha.cpf.setText(rs.getString("CPF"));
                                            linha.data.setText(rs.getString("Data_Nasc"));

                                            try {
                                                URL url = new URL(rs.getString("URL_FotoPefil"));
                                                Image image = ImageIO.read(url);
                                                ImageIcon icon = new ImageIcon(image);
                                                linha.imageAvatar1.setIcon(icon);
                                            } catch (IOException ex) {
                                                Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        } else {
                                            // Se não atualizou na tabela cliente, tenta na tabela administrador
                                            PreparedStatement pstBackup = conexao.prepareStatement(sqlUpdateAdm);
                                            pstBackup.setInt(1, id); // ID do administrador
                                            pstBackup.setString(2, usuario); // Nome atual
                                            pstBackup.setString(3, data); // Data atual
                                            ResultSet rsBackup = pstBackup.executeQuery();

                                            if (rsBackup.next()) {
                                                linha.usuario.setText(rsBackup.getString("Nome_adm"));
                                                linha.cpf.setText(rsBackup.getString("CPF"));
                                                linha.data.setText(rsBackup.getString("Data_Nasc"));

                                                try {
                                                    URL url = new URL(rsBackup.getString("URL_FotoPefil"));
                                                    Image image = ImageIO.read(url);
                                                    ImageIcon icon = new ImageIcon(image);
                                                    linha.imageAvatar1.setIcon(icon);
                                                } catch (IOException ex) {
                                                    Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            } else {
                                                // Se não encontrou nem na tabela cliente nem na tabela administrador
                                                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para atualizar.");
                                            }
                                        }
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage());
                                    }
                                    linha.TelaAlt.setVisible(true);
                                }
                            });
                            
                            linha.imageAvatar1.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    JnaFileChooser ch = new JnaFileChooser();
                                    boolean action;
                                    action = ch.showOpenDialog(SwingUtilities.getWindowAncestor(linha));
                                    if(action) {
                                        URL = ch.getSelectedFile();
                                        linha.TelaAlt.toFront();
                                        linha.TelaAlt.requestFocus();
                                        ImageIcon iconPreview = new ImageIcon(URL.toString());
                                        linha.imageAvatar1.setIcon(iconPreview);
                                        linha.imageAvatar1.revalidate();
                                        linha.imageAvatar1.repaint();
                                    }
                                }
                            });
                            
                            int dID = Integer.parseInt(linha.ID.getText());
                            String dName = linha.Usuario.getText();
                            String dDate = linha.Data.getText();
                            
                            linha.bAlt.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    String usuario = linha.usuario.getText();
                                    String cpf = linha.cpf.getText();
                                    String data = linha.data.getText();
                                    
                                    String sql = "SELECT ID_cliente, URL_FotoPefil FROM cliente WHERE ID_cliente = '"+dID+"' AND Nome_Cli = '"+dName+"' AND Data_Nasc = '"+dDate+"'";
                                    
                                    try {
                                        // Abre a conexão com o banco de dados
                                        Connection conexao = con_cliente.getConnection();

                                        // Prepara a consulta de atualização para a tabela cliente
                                        PreparedStatement pst = conexao.prepareStatement(sql);
                                        ResultSet rs = pst.executeQuery();
                                        
                                        if(rs.next()) {
                                            int clienteID = rs.getInt("ID_cliente");
                                            String sqlUpdateCliente = "UPDATE cliente SET Nome_Cli = ?, CPF = ?, Data_Nasc = ?, URL_FotoPefil = ? WHERE ID_cliente = ?";
                                            
                                            PreparedStatement pstCliente = conexao.prepareStatement(sqlUpdateCliente);
                                            pstCliente.setString(1, usuario); // Nome 
                                            pstCliente.setString(2, cpf);  // CPF 
                                            pstCliente.setString(3, data); // Data Nascimento
                                            
                                            String FileCliente = String.valueOf(URL);
                                            
                                            if(FileCliente != "null") {
                                                FileUploader upCliente = new FileUploader("http://tentreosbrothers.shop/Guilherme/KBom/uploadPerfil.php", FileCliente);
                                                
                                                pstCliente.setString(4, "http://tentreosbrothers.shop/Guilherme/KBom/FotoPerfil/"+upCliente.nomeFile);
                                            } else {
                                                pstCliente.setString(4, rs.getString("URL_FotoPefil"));
                                            }
                                            
                                            pstCliente.setInt(5, rs.getInt("ID_cliente")); // Data Nascimento
                                            
                                            pstCliente.executeUpdate();
                                            
                                            URL = null;
                                            
                                            linha.TelaAlt.setVisible(false);
                                            carregarClientes();
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para alterar.");
                                        }
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage());
                                    }
                                }
                            });

                            // Adiciona o painel (linha) no seu JPanel principal
                            jPanel4.add(linha);
                        } catch (IOException ex) {
                            Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    // Atualiza o JPanel após adicionar todos os componentes
                    jPanel4.revalidate();
                    jPanel4.repaint();
                    jPanel1.setVisible(true);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage());
                } catch (Exception ex) {
                    Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
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
    
    private void applyHoverAnimation(PanelRound label) {
        label.setBackground(startColor);
        label.setForeground(Color.WHITE);
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
    
    private void carregarDados(String sql, String tabela) {
        try {
            Connection conexao = con_cliente.getConnection(); // Conexão com o banco
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(); // Executa o SELECT e obtém os resultados

            // Limpa o JPanel antes de adicionar novas linhas

                // Pega os valores das colunas
                if(tabela == "administrador") {
                    try {
                        jPanel4.removeAll();
                        bReloadADM.setVisible(true);
                        bReloadCli.setVisible(false);

                        while (rs.next()) {
                            // Pega os valores das colunas
                            int idAdmin = rs.getInt("ID_adm");
                            String perfil = rs.getString("URL_FotoPefil");
                            String usuario = rs.getString("Nome_adm");
                            String data = rs.getString("Data_Nasc");

                            try {
                                URL url = new URL(perfil);
                                Image image = ImageIO.read(url);
                                ImageIcon icon = new ImageIcon(image);

                                // Cria uma nova linha (um novo painel LinhaTable)
                                LinhaTable linha = new LinhaTable();

                                // Preenche as labels com os dados do banco
                                linha.ID.setText("" + idAdmin);
                                linha.Perfil.setIcon(icon);
                                linha.Usuario.setText(usuario);
                                linha.Data.setText(data);

                                linha.bEdit.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        // Query para atualizar na primeira tabela (cliente)
                                        String sqlUpdateCliente = "SELECT Nome_Cli, CPF, Data_Nasc, URL_FotoPefil FROM cliente WHERE ID_cliente = ? AND Nome_Cli = ? AND Data_Nasc = ?";

                                        // Query para atualizar na segunda tabela (administrador)
                                        String sqlUpdateAdm = "SELECT Nome_adm, CPF, Data_Nasc, URL_FotoPefil FROM administrador WHERE ID_adm = ? AND Nome_adm = ? AND Data_Nasc = ?";

                                        int id = Integer.parseInt(linha.ID.getText());
                                        String usuario = linha.Usuario.getText();
                                        String data = linha.Data.getText();

                                        try {
                                            // Abre a conexão com o banco de dados
                                            Connection conexao = con_cliente.getConnection();

                                            // Prepara a consulta de atualização para a tabela cliente
                                            PreparedStatement pst = conexao.prepareStatement(sqlUpdateCliente);
                                            pst.setInt(1, id); // ID do cliente
                                            pst.setString(2, usuario); // Nome atual (para garantir que o cliente certo seja atualizado)
                                            pst.setString(3, data); // Data atual
                                            ResultSet rs = pst.executeQuery();

                                            if (rs.next()) { // Se atualizou na tabela cliente
                                                linha.usuario.setText(rs.getString("Nome_Cli"));
                                                linha.cpf.setText(rs.getString("CPF"));
                                                linha.data.setText(rs.getString("Data_Nasc"));

                                                try {
                                                    URL url = new URL(rs.getString("URL_FotoPefil"));
                                                    Image image = ImageIO.read(url);
                                                    ImageIcon icon = new ImageIcon(image);
                                                    linha.imageAvatar1.setIcon(icon);
                                                } catch (IOException ex) {
                                                    Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            } else {
                                                // Se não atualizou na tabela cliente, tenta na tabela administrador
                                                PreparedStatement pstBackup = conexao.prepareStatement(sqlUpdateAdm);
                                                pstBackup.setInt(1, id); // ID do administrador
                                                pstBackup.setString(2, usuario); // Nome atual
                                                pstBackup.setString(3, data); // Data atual
                                                ResultSet rsBackup = pstBackup.executeQuery();

                                                if (rsBackup.next()) {
                                                    linha.usuario.setText(rsBackup.getString("Nome_adm"));
                                                    linha.cpf.setText(rsBackup.getString("CPF"));
                                                    linha.data.setText(rsBackup.getString("Data_Nasc"));

                                                    try {
                                                        URL url = new URL(rsBackup.getString("URL_FotoPefil"));
                                                        Image image = ImageIO.read(url);
                                                        ImageIcon icon = new ImageIcon(image);
                                                        linha.imageAvatar1.setIcon(icon);
                                                    } catch (IOException ex) {
                                                        Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                                                    }
                                                } else {
                                                    // Se não encontrou nem na tabela cliente nem na tabela administrador
                                                    JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para atualizar.");
                                                }
                                            }
                                        } catch (SQLException ex) {
                                            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage());
                                        }
                                        linha.TelaAlt.setVisible(true);
                                    }
                                });

                                linha.imageAvatar1.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        JnaFileChooser ch = new JnaFileChooser();
                                        boolean action;
                                        action = ch.showOpenDialog(SwingUtilities.getWindowAncestor(linha));
                                        if(action) {
                                            URL = ch.getSelectedFile();
                                            linha.TelaAlt.toFront();
                                            linha.TelaAlt.requestFocus();
                                            ImageIcon iconPreview = new ImageIcon(URL.toString());
                                            linha.imageAvatar1.setIcon(iconPreview);
                                            linha.imageAvatar1.revalidate();
                                            linha.imageAvatar1.repaint();
                                        }
                                    }
                                });

                                int dID = Integer.parseInt(linha.ID.getText());
                                String dName = linha.Usuario.getText();
                                String dDate = linha.Data.getText();

                                System.out.println("CASSIO "+dID+" "+dName+" "+dDate);

                                linha.bAlt.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        String usuario = linha.usuario.getText();
                                        String cpf = linha.cpf.getText();
                                        String data = linha.data.getText();

                                        String sql = "SELECT ID_adm, URL_FotoPefil FROM administrador WHERE ID_adm = '"+dID+"' AND Nome_adm = '"+dName+"' AND Data_Nasc = '"+dDate+"'";

                                        try {
                                            // Abre a conexão com o banco de dados
                                            Connection conexao = con_cliente.getConnection();

                                            // Prepara a consulta de atualização para a tabela cliente
                                            PreparedStatement pst = conexao.prepareStatement(sql);
                                            ResultSet rs = pst.executeQuery();

                                            if(rs.next()) {
                                                String sqlUpdate = "UPDATE administrador SET Nome_adm = ?, CPF = ?, Data_Nasc = ?, URL_FotoPefil = ? WHERE ID_adm = ?";

                                                PreparedStatement pstADM = conexao.prepareStatement(sqlUpdate);
                                                pstADM.setString(1, usuario); // Nome                                            
                                                pstADM.setString(2, cpf);  // CPF
                                                pstADM.setString(3, data); // Data Nascimento

                                                String FileADM = String.valueOf(URL);

                                                if(FileADM != "null") {
                                                    FileUploader upCliente = new FileUploader("http://tentreosbrothers.shop/Guilherme/KBom/uploadPerfil.php", FileADM);

                                                    pstADM.setString(4, "http://tentreosbrothers.shop/Guilherme/KBom/FotoPerfil/"+upCliente.nomeFile);
                                                } else {
                                                    pstADM.setString(4, rs.getString("URL_FotoPefil"));
                                                }

                                                pstADM.setInt(5, rs.getInt("ID_adm")); // Data Nascimento

                                                pstADM.executeUpdate();

                                                URL = null;
                                                
                                                linha.TelaAlt.setVisible(false);
                                                carregarAdministradores();
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para alterar.");
                                            }
                                        } catch (SQLException ex) {
                                            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage());
                                        }
                                    }
                                });

                                // Adiciona o painel (linha) no seu JPanel principal
                                jPanel4.add(linha);
                            } catch (IOException ex) {
                                Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        // Atualiza o JPanel após adicionar todos os componentes
                        jPanel4.revalidate();
                        jPanel4.repaint();
                        jPanel1.setVisible(true);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage());
                    } catch (Exception ex) {
                        Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(tabela == "cliente") {
                    try {
                        // Limpa o JPanel antes de adicionar novas linhas
                        jPanel4.removeAll();
                        bReloadADM.setVisible(false);
                        bReloadCli.setVisible(true);

                        while (rs.next()) {
                            // Pega os valores das colunas
                            int idCliente = rs.getInt("ID_cliente");
                            String perfil = rs.getString("URL_FotoPefil");
                            String usuario = rs.getString("Nome_Cli");
                            String data = rs.getString("Data_Nasc");

                            try {
                                URL url = new URL(perfil);
                                Image image = ImageIO.read(url);
                                ImageIcon icon = new ImageIcon(image);

                                // Cria uma nova linha (um novo painel LinhaTable)
                                LinhaTable linha = new LinhaTable();

                                // Preenche as labels com os dados do banco
                                linha.ID.setText("" + idCliente);
                                linha.Perfil.setIcon(icon);
                                linha.Usuario.setText(usuario);
                                linha.Data.setText(data);

                                linha.bEdit.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        // Query para atualizar na primeira tabela (cliente)
                                        String sqlUpdateCliente = "SELECT Nome_Cli, CPF, Data_Nasc, URL_FotoPefil FROM cliente WHERE ID_cliente = ? AND Nome_Cli = ? AND Data_Nasc = ?";

                                        // Query para atualizar na segunda tabela (administrador)
                                        String sqlUpdateAdm = "SELECT Nome_adm, CPF, Data_Nasc, URL_FotoPefil FROM administrador WHERE ID_adm = ? AND Nome_adm = ? AND Data_Nasc = ?";

                                        int id = Integer.parseInt(linha.ID.getText());
                                        String usuario = linha.Usuario.getText();
                                        String data = linha.Data.getText();

                                        try {
                                            // Abre a conexão com o banco de dados
                                            Connection conexao = con_cliente.getConnection();

                                            // Prepara a consulta de atualização para a tabela cliente
                                            PreparedStatement pst = conexao.prepareStatement(sqlUpdateCliente);
                                            pst.setInt(1, id); // ID do cliente
                                            pst.setString(2, usuario); // Nome atual (para garantir que o cliente certo seja atualizado)
                                            pst.setString(3, data); // Data atual
                                            ResultSet rs = pst.executeQuery();

                                            if (rs.next()) { // Se atualizou na tabela cliente
                                                linha.usuario.setText(rs.getString("Nome_Cli"));
                                                linha.cpf.setText(rs.getString("CPF"));
                                                linha.data.setText(rs.getString("Data_Nasc"));

                                                try {
                                                    URL url = new URL(rs.getString("URL_FotoPefil"));
                                                    Image image = ImageIO.read(url);
                                                    ImageIcon icon = new ImageIcon(image);
                                                    linha.imageAvatar1.setIcon(icon);
                                                } catch (IOException ex) {
                                                    Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            } else {
                                                // Se não atualizou na tabela cliente, tenta na tabela administrador
                                                PreparedStatement pstBackup = conexao.prepareStatement(sqlUpdateAdm);
                                                pstBackup.setInt(1, id); // ID do administrador
                                                pstBackup.setString(2, usuario); // Nome atual
                                                pstBackup.setString(3, data); // Data atual
                                                ResultSet rsBackup = pstBackup.executeQuery();

                                                if (rsBackup.next()) {
                                                    linha.usuario.setText(rsBackup.getString("Nome_adm"));
                                                    linha.cpf.setText(rsBackup.getString("CPF"));
                                                    linha.data.setText(rsBackup.getString("Data_Nasc"));

                                                    try {
                                                        URL url = new URL(rsBackup.getString("URL_FotoPefil"));
                                                        Image image = ImageIO.read(url);
                                                        ImageIcon icon = new ImageIcon(image);
                                                        linha.imageAvatar1.setIcon(icon);
                                                    } catch (IOException ex) {
                                                        Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                                                    }
                                                } else {
                                                    // Se não encontrou nem na tabela cliente nem na tabela administrador
                                                    JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para atualizar.");
                                                }
                                            }
                                        } catch (SQLException ex) {
                                            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage());
                                        }
                                        linha.TelaAlt.setVisible(true);
                                    }
                                });

                                linha.imageAvatar1.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        JnaFileChooser ch = new JnaFileChooser();
                                        boolean action;
                                        action = ch.showOpenDialog(SwingUtilities.getWindowAncestor(linha));
                                        if(action) {
                                            URL = ch.getSelectedFile();
                                            linha.TelaAlt.toFront();
                                            linha.TelaAlt.requestFocus();
                                            ImageIcon iconPreview = new ImageIcon(URL.toString());
                                            linha.imageAvatar1.setIcon(iconPreview);
                                            linha.imageAvatar1.revalidate();
                                            linha.imageAvatar1.repaint();
                                        }
                                    }
                                });

                                int dID = Integer.parseInt(linha.ID.getText());
                                String dName = linha.Usuario.getText();
                                String dDate = linha.Data.getText();

                                linha.bAlt.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        String usuario = linha.usuario.getText();
                                        String cpf = linha.cpf.getText();
                                        String data = linha.data.getText();

                                        String sql = "SELECT ID_cliente, URL_FotoPefil FROM cliente WHERE ID_cliente = '"+dID+"' AND Nome_Cli = '"+dName+"' AND Data_Nasc = '"+dDate+"'";

                                        try {
                                            // Abre a conexão com o banco de dados
                                            Connection conexao = con_cliente.getConnection();

                                            // Prepara a consulta de atualização para a tabela cliente
                                            PreparedStatement pst = conexao.prepareStatement(sql);
                                            ResultSet rs = pst.executeQuery();

                                            if(rs.next()) {
                                                int clienteID = rs.getInt("ID_cliente");
                                                String sqlUpdateCliente = "UPDATE cliente SET Nome_Cli = ?, CPF = ?, Data_Nasc = ?, URL_FotoPefil = ? WHERE ID_cliente = ?";

                                                PreparedStatement pstCliente = conexao.prepareStatement(sqlUpdateCliente);
                                                pstCliente.setString(1, usuario); // Nome 
                                                pstCliente.setString(2, cpf);  // CPF 
                                                pstCliente.setString(3, data); // Data Nascimento

                                                String FileCliente = String.valueOf(URL);

                                                if(FileCliente != "null") {
                                                    FileUploader upCliente = new FileUploader("http://tentreosbrothers.shop/Guilherme/KBom/uploadPerfil.php", FileCliente);
                                                    

                                                    pstCliente.setString(4, "http://tentreosbrothers.shop/Guilherme/KBom/FotoPerfil/"+upCliente.nomeFile);
                                                } else {
                                                    pstCliente.setString(4, rs.getString("URL_FotoPefil"));
                                                }

                                                pstCliente.setInt(5, rs.getInt("ID_cliente")); // Data Nascimento

                                                pstCliente.executeUpdate();

                                                URL = null;
                                                
                                                linha.TelaAlt.setVisible(false);
                                                carregarClientes();
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para alterar.");
                                            }
                                        } catch (SQLException ex) {
                                            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage());
                                        }
                                        
                                    }
                                });

                                // Adiciona o painel (linha) no seu JPanel principal
                                jPanel4.add(linha);
                            } catch (IOException ex) {
                                Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        // Atualiza o JPanel após adicionar todos os componentes
                        jPanel4.revalidate();
                        jPanel4.repaint();
                        jPanel1.setVisible(true);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage());
                    } catch (Exception ex) {
                        Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }   
            

            // Atualiza o JPanel após adicionar todos os componentes
            jPanel4.revalidate();
            jPanel4.repaint();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void carregarClientes() {
        String sql = "SELECT ID_cliente, URL_FotoPefil, Nome_cli, Data_Nasc FROM cliente";
        carregarDados(sql, "cliente"); // Chama o método genérico com SQL e tipo "cliente"
    }

    // Método para carregar administradores
    private void carregarAdministradores() {
        String sql = "SELECT ID_adm, URL_FotoPefil, Nome_adm, Data_Nasc FROM administrador";
        carregarDados(sql, "administrador"); // Chama o método genérico com SQL e tipo "administrador"
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        sVGImage4 = new javaswingdev.SVGImage();
        jLabel10 = new javax.swing.JLabel();
        sVGImage3 = new javaswingdev.SVGImage();
        bOK = new javaswingdev.PanelRound();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        scrollPaneWin111 = new Scroll.ScrollPaneWin11();
        jPanel4 = new javax.swing.JPanel();
        bReloadADM = new javaswingdev.Button();
        bReloadCli = new javaswingdev.Button();
        bReturn = new javaswingdev.Button();
        jLabel1 = new javax.swing.JLabel();
        bADM = new javaswingdev.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        sVGImage1 = new javaswingdev.SVGImage();
        bCliente = new javaswingdev.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        sVGImage2 = new javaswingdev.SVGImage();

        jDialog1.setMaximumSize(new java.awt.Dimension(444, 240));
        jDialog1.setMinimumSize(new java.awt.Dimension(444, 240));
        jDialog1.setModal(true);
        jDialog1.setUndecorated(true);
        jDialog1.setPreferredSize(new java.awt.Dimension(444, 240));
        jDialog1.setResizable(false);
        jDialog1.getContentPane().setLayout(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel5.setLayout(null);

        sVGImage4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage4.setMaximumSize(new java.awt.Dimension(24, 24));
        sVGImage4.setMinimumSize(new java.awt.Dimension(24, 24));
        sVGImage4.setPreferredSize(new java.awt.Dimension(24, 24));
        sVGImage4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sVGImage4MouseClicked(evt);
            }
        });
        jPanel5.add(sVGImage4);
        sVGImage4.setBounds(416, 4, 24, 24);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("<html><center>Erro, você não pode excluir a conta que você está logado!</center></html>\n");
        jLabel10.setMaximumSize(new java.awt.Dimension(330, 33));
        jLabel10.setMinimumSize(new java.awt.Dimension(330, 33));
        jLabel10.setPreferredSize(new java.awt.Dimension(330, 33));
        jPanel5.add(jLabel10);
        jLabel10.setBounds(57, 20, 330, 50);

        sVGImage3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage3.setMaximumSize(new java.awt.Dimension(50, 50));
        sVGImage3.setMinimumSize(new java.awt.Dimension(50, 50));
        sVGImage3.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel5.add(sVGImage3);
        sVGImage3.setBounds(197, 79, 50, 50);

        bOK.setBackground(new java.awt.Color(0, 96, 177));
        bOK.setForeground(new java.awt.Color(255, 255, 255));
        bOK.setMaximumSize(new java.awt.Dimension(120, 44));
        bOK.setRoundBottomLeft(15);
        bOK.setRoundBottomRight(15);
        bOK.setRoundTopLeft(15);
        bOK.setRoundTopRight(15);
        bOK.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("OK\n");
        jLabel8.setMaximumSize(new java.awt.Dimension(120, 44));
        jLabel8.setMinimumSize(new java.awt.Dimension(120, 44));
        jLabel8.setPreferredSize(new java.awt.Dimension(120, 44));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        bOK.add(jLabel8);
        jLabel8.setBounds(0, 0, 120, 44);

        jPanel5.add(bOK);
        bOK.setBounds(162, 148, 120, 44);

        jPanel10.setBackground(new java.awt.Color(0, 96, 177));
        jPanel10.setMaximumSize(new java.awt.Dimension(444, 32));
        jPanel10.setMinimumSize(new java.awt.Dimension(444, 32));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel10);
        jPanel10.setBounds(0, 208, 444, 32);

        jDialog1.getContentPane().add(jPanel5);
        jPanel5.setBounds(0, 0, 444, 240);

        setBackground(new java.awt.Color(255, 255, 255));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);
        setMaximumSize(new java.awt.Dimension(1303, 655));
        setMinimumSize(new java.awt.Dimension(1303, 655));
        setPreferredSize(new java.awt.Dimension(1303, 655));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setMaximumSize(new java.awt.Dimension(1303, 655));
        jPanel1.setMinimumSize(new java.awt.Dimension(1303, 655));
        jPanel1.setPreferredSize(new java.awt.Dimension(1303, 655));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);
        jPanel2.setMaximumSize(new java.awt.Dimension(940, 631));
        jPanel2.setMinimumSize(new java.awt.Dimension(940, 631));
        jPanel2.setPreferredSize(new java.awt.Dimension(940, 631));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(0, 96, 177));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setMaximumSize(new java.awt.Dimension(940, 45));
        jPanel3.setLayout(null);

        jPanel6.setToolTipText("");
        jPanel6.setMaximumSize(new java.awt.Dimension(44, 43));
        jPanel6.setMinimumSize(new java.awt.Dimension(44, 43));
        jPanel6.setName(""); // NOI18N
        jPanel6.setOpaque(false);
        jPanel6.setPreferredSize(new java.awt.Dimension(44, 43));
        jPanel6.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ID");
        jLabel4.setAlignmentY(0.0F);
        jLabel4.setMaximumSize(new java.awt.Dimension(44, 43));
        jLabel4.setMinimumSize(new java.awt.Dimension(44, 43));
        jLabel4.setPreferredSize(new java.awt.Dimension(44, 43));
        jPanel6.add(jLabel4);
        jLabel4.setBounds(0, 0, 44, 43);

        jPanel3.add(jPanel6);
        jPanel6.setBounds(1, 1, 44, 43);

        jPanel7.setOpaque(false);
        jPanel7.setPreferredSize(new java.awt.Dimension(89, 43));
        jPanel7.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PERFIL");
        jLabel5.setAlignmentY(0.0F);
        jLabel5.setMaximumSize(new java.awt.Dimension(44, 43));
        jLabel5.setMinimumSize(new java.awt.Dimension(44, 43));
        jLabel5.setPreferredSize(new java.awt.Dimension(44, 43));
        jPanel7.add(jLabel5);
        jLabel5.setBounds(0, 0, 89, 43);

        jPanel3.add(jPanel7);
        jPanel7.setBounds(45, 1, 89, 43);

        jPanel8.setAlignmentX(0.0F);
        jPanel8.setAlignmentY(0.0F);
        jPanel8.setOpaque(false);
        jPanel8.setPreferredSize(new java.awt.Dimension(337, 43));
        jPanel8.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("USUÁRIO");
        jLabel6.setAlignmentY(0.0F);
        jLabel6.setMaximumSize(new java.awt.Dimension(44, 43));
        jLabel6.setMinimumSize(new java.awt.Dimension(44, 43));
        jLabel6.setPreferredSize(new java.awt.Dimension(44, 43));
        jPanel8.add(jLabel6);
        jLabel6.setBounds(0, 0, 337, 43);

        jPanel3.add(jPanel8);
        jPanel8.setBounds(134, 1, 337, 43);

        jPanel9.setOpaque(false);
        jPanel9.setPreferredSize(new java.awt.Dimension(468, 43));
        jPanel9.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("DATA DE NASCIMENTO");
        jLabel7.setAlignmentY(0.0F);
        jLabel7.setMaximumSize(new java.awt.Dimension(44, 43));
        jLabel7.setMinimumSize(new java.awt.Dimension(44, 43));
        jLabel7.setPreferredSize(new java.awt.Dimension(44, 43));
        jPanel9.add(jLabel7);
        jLabel7.setBounds(0, 0, 468, 43);

        jPanel3.add(jPanel9);
        jPanel9.setBounds(471, 1, 468, 43);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 940, 45);

        scrollPaneWin111.setBorder(null);
        scrollPaneWin111.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneWin111.setFocusable(false);
        scrollPaneWin111.setMaximumSize(new java.awt.Dimension(938, 32767));
        scrollPaneWin111.setMinimumSize(new java.awt.Dimension(938, 584));
        scrollPaneWin111.setOpaque(false);
        scrollPaneWin111.setPreferredSize(new java.awt.Dimension(938, 584));
        scrollPaneWin111.setRequestFocusEnabled(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setAlignmentX(0.0F);
        jPanel4.setAlignmentY(0.0F);
        jPanel4.setMaximumSize(new java.awt.Dimension(938, 32767));
        jPanel4.setMinimumSize(new java.awt.Dimension(938, 584));
        jPanel4.setPreferredSize(new java.awt.Dimension(938, 584));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 20);
        flowLayout1.setAlignOnBaseline(true);
        jPanel4.setLayout(flowLayout1);
        scrollPaneWin111.setViewportView(jPanel4);

        jPanel2.add(scrollPaneWin111);
        scrollPaneWin111.setBounds(1, 46, 938, 584);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(182, 12, 940, 631);

        bReloadADM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sync.png"))); // NOI18N
        bReloadADM.setAlignmentY(0.0F);
        bReloadADM.setFocusable(false);
        bReloadADM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReloadADMActionPerformed(evt);
            }
        });
        jPanel1.add(bReloadADM);
        bReloadADM.setBounds(72, 12, 40, 40);

        bReloadCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sync.png"))); // NOI18N
        bReloadCli.setAlignmentY(0.0F);
        bReloadCli.setFocusable(false);
        bReloadCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReloadCliActionPerformed(evt);
            }
        });
        jPanel1.add(bReloadCli);
        bReloadCli.setBounds(72, 12, 40, 40);

        bReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/arrow_circle_left.png"))); // NOI18N
        bReturn.setAlignmentY(0.0F);
        bReturn.setFocusable(false);
        bReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReturnActionPerformed(evt);
            }
        });
        jPanel1.add(bReturn);
        bReturn.setBounds(12, 12, 40, 40);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1303, 655);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quem você vai gerenciar?");
        jLabel1.setAlignmentY(0.0F);
        add(jLabel1);
        jLabel1.setBounds(80, 40, 490, 60);

        bADM.setBackground(new java.awt.Color(255, 101, 0));
        bADM.setAlignmentX(0.0F);
        bADM.setAlignmentY(0.0F);
        bADM.setMaximumSize(new java.awt.Dimension(220, 100));
        bADM.setMinimumSize(new java.awt.Dimension(220, 100));
        bADM.setPreferredSize(new java.awt.Dimension(220, 100));
        bADM.setRoundBottomLeft(15);
        bADM.setRoundBottomRight(15);
        bADM.setRoundTopLeft(15);
        bADM.setRoundTopRight(15);
        bADM.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ADMINISTRADOR");
        bADM.add(jLabel2);
        jLabel2.setBounds(70, 39, 134, 22);

        sVGImage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage1.setAlignmentY(0.0F);
        sVGImage1.setMaximumSize(new java.awt.Dimension(52, 52));
        sVGImage1.setMinimumSize(new java.awt.Dimension(52, 52));
        sVGImage1.setPreferredSize(new java.awt.Dimension(52, 52));
        bADM.add(sVGImage1);
        sVGImage1.setBounds(10, 24, 52, 52);

        add(bADM);
        bADM.setBounds(394, 279, 220, 100);

        bCliente.setBackground(new java.awt.Color(255, 101, 0));
        bCliente.setAlignmentX(0.0F);
        bCliente.setAlignmentY(0.0F);
        bCliente.setMaximumSize(new java.awt.Dimension(220, 100));
        bCliente.setMinimumSize(new java.awt.Dimension(220, 100));
        bCliente.setPreferredSize(new java.awt.Dimension(220, 100));
        bCliente.setRoundBottomLeft(15);
        bCliente.setRoundBottomRight(15);
        bCliente.setRoundTopLeft(15);
        bCliente.setRoundTopRight(15);
        bCliente.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CLIENTE");
        bCliente.add(jLabel3);
        jLabel3.setBounds(100, 40, 70, 22);

        sVGImage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sVGImage2.setAlignmentY(0.0F);
        sVGImage2.setMaximumSize(new java.awt.Dimension(52, 52));
        sVGImage2.setMinimumSize(new java.awt.Dimension(52, 52));
        sVGImage2.setPreferredSize(new java.awt.Dimension(52, 52));
        bCliente.add(sVGImage2);
        sVGImage2.setBounds(10, 24, 52, 52);

        add(bCliente);
        bCliente.setBounds(689, 279, 220, 100);
    }// </editor-fold>//GEN-END:initComponents

    private void bReloadADMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReloadADMActionPerformed
        carregarAdministradores();
    }//GEN-LAST:event_bReloadADMActionPerformed

    private void bReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReturnActionPerformed
        jPanel1.setVisible(false);
    }//GEN-LAST:event_bReturnActionPerformed

    private void bReloadCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReloadCliActionPerformed
        carregarClientes();
    }//GEN-LAST:event_bReloadCliActionPerformed

    private void sVGImage4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sVGImage4MouseClicked
        jDialog1.setVisible(false);
    }//GEN-LAST:event_sVGImage4MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        jDialog1.setVisible(false);
    }//GEN-LAST:event_jLabel8MouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javaswingdev.PanelRound bADM;
    private javaswingdev.PanelRound bCliente;
    public javaswingdev.PanelRound bOK;
    private javaswingdev.Button bReloadADM;
    private javaswingdev.Button bReloadCli;
    private javaswingdev.Button bReturn;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javaswingdev.SVGImage sVGImage1;
    private javaswingdev.SVGImage sVGImage2;
    private javaswingdev.SVGImage sVGImage3;
    private javaswingdev.SVGImage sVGImage4;
    private Scroll.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables
}