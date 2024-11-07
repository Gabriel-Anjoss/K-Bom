package Telas;

import conexao.conexao;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.Card;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JPanel {
    conexao con_cliente;
    public int w;
    public int pular;
    
    DecimalFormat df = new DecimalFormat("#.00");
    
    public Home() {
        initComponents();
        
        con_cliente = new conexao();
        con_cliente.conecta();
        
        CarregarProd();
        
        scrollPaneWin111.getVerticalScrollBar().setUnitIncrement(25);//rolagem rapida
    }

    public void CarregarProd() {
        String sql = "SELECT p.*, c.Descricao AS Categoria_Descricao FROM produto p INNER JOIN categoria c ON p.Categoria = c.ID_categoria";
        
        String sqlIMG = "SELECT * FROM imagens WHERE ID_Prod = ?";

        try {
            Connection conexao = con_cliente.getConnection(); // Conexão com o banco
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(); // Executa o SELECT e obtém os resultados
            
            PreparedStatement pstIMG = conexao.prepareStatement(sqlIMG);
            

            // Limpa o JPanel antes de adicionar novas linhas
            Produtos.removeAll();
            w = 0;
            w = 238;

            while(rs.next()) {
                // Pega os valores das colunas
                int idProd = rs.getInt("ID_produto");
                String titulo = rs.getString("Nome_Prod");
                int estoque = rs.getInt("Estq_produto");
                double preco = rs.getDouble("Preco_Produto");
                
                if (!rs.isBeforeFirst()) { // Verifica se o ResultSet está vazio
                    System.out.println("Nenhum produto encontrado.");
                } else {
                    System.out.println("Produtos encontrados.");
                }
                
                pstIMG.setInt(1, rs.getInt("ID_produto"));
                ResultSet rsIMG = pstIMG.executeQuery();
                
                if (!rsIMG.isBeforeFirst()) { // Verifica se o ResultSet está vazio
                    System.out.println("Nenhum imagem encontrado.");
                } else {
                    System.out.println("Imagens encontrados.");
                }

                while (rsIMG.next()) {
                    String imageURL = rsIMG.getString("URL");
                    int tipo = rsIMG.getInt("Tipo");

                    if (tipo == 1) {
                        URL url = new URL(imageURL);
                        Image image = ImageIO.read(url);
                        ImageIcon icon = new ImageIcon(image);

                        // Cria uma nova linha (um novo painel LinhaTable)
                        Card prod = new Card();
                        if(pular == 5) {
                            pular = 0;
                            w = w + 238;
                            background.setPreferredSize(new java.awt.Dimension(938, (w+32)));
                        }
                        
                        pular = pular + 1;
                        
                        prod.setPreferredSize(new Dimension(150, 206)); // Tamanho fixo ou preferido do Card
                        prod.panelRound1.setPreferredSize(new Dimension(150, 206)); // Tamanho fixo ou preferido do Card
                        
                        // Preenche as labels com os dados do banco
                        prod.capa.setIcon(icon);
                        prod.Titulo.setText(titulo);
                        prod.Preco.setText("<html><span style=\"text-decoration: line-through;\">R$ "+df.format((preco / 100) * 75)+"</span> <span style=\"color: #FF6500; font-size: 12px;\">R$ "+df.format(preco)+"</span></html>");
                        prod.infos.setText("<html><span style=\"color: #000000\">À vista no PIX</span><br><span style=\"color: #000000\">ou até 10x de R$ "+df.format((preco / 10))+"</span><br><span style=\"color: #0060B1;\">Restam "+estoque+"</span></html>");

                        Produtos.add(prod);
                    } else {
                        System.out.println("ERRO AO CARREGAR IMAGENS");
                    }
                }
            }

            // Atualiza o JPanel após adicionar todos os componentes
            Produtos.revalidate();
            Produtos.repaint();
            Produtos.setVisible(true);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(ManageAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneWin111 = new Scroll.ScrollPaneWin11();
        background = new javax.swing.JPanel();
        Produtos = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        scrollPaneWin111.setBackground(new java.awt.Color(255, 255, 255));
        scrollPaneWin111.setBorder(null);
        scrollPaneWin111.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPaneWin111.setMaximumSize(new java.awt.Dimension(939, 32767));
        scrollPaneWin111.setMinimumSize(new java.awt.Dimension(939, 655));
        scrollPaneWin111.setName(""); // NOI18N
        scrollPaneWin111.setPreferredSize(new java.awt.Dimension(939, 655));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setMaximumSize(new java.awt.Dimension(1303, 32767));
        background.setMinimumSize(new java.awt.Dimension(1303, 655));
        background.setPreferredSize(new java.awt.Dimension(1303, 655));
        background.setLayout(null);

        Produtos.setBackground(new java.awt.Color(217, 217, 217));
        Produtos.setMaximumSize(new java.awt.Dimension(939, 10000000));
        Produtos.setMinimumSize(new java.awt.Dimension(939, 10000000));
        Produtos.setPreferredSize(new java.awt.Dimension(939, 10000000));
        Produtos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 32, 32));
        background.add(Produtos);
        Produtos.setBounds(0, 0, 939, 10000000);

        scrollPaneWin111.setViewportView(background);

        add(scrollPaneWin111);
        scrollPaneWin111.setBounds(182, 0, 939, 655);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Produtos;
    private javax.swing.JPanel background;
    private Scroll.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables
}