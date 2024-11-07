package conexao;

import javax.swing.JOptionPane;
import java.sql.*;
import Telas.ErroServe;

public class conexao {
    final private String driver = "com.mysql.cj.jdbc.Driver"; // Definição do Driver
    final private String url = "jdbc:mysql://tentreosbrothers.shop/k_bom"; // Acesso ao bd "k_bom" no servidor
    final private String usuario = "root";
    final private String senha = "df533a9d-4426-4417-a91e-fcc55df8159f"; // Adicione sua senha se houver
    private Connection conexao;
    private ErroServe erro = null; // Armazenar a instância da tela de erro

    public boolean conecta() {
        boolean result = true;
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Driver não localizado: " + Driver, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
            result = false;
        } catch (SQLException Fonte) {
            // Chama a janela de erro com Singleton
            ErroServe erro = ErroServe.getInstance(this); // Aqui a instância correta é passada
            erro.setVisible(true); // Mostra a tela se ela não estiver visível
            result = false;
        }
        return result;
    }

    public void desconecta() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar o banco: " + fecha, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public Connection getConnection() {
        return this.conexao; // Método para retornar a conexão
    }
}