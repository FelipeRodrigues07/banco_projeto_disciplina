package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgreSQL {
    public static void main(String[] args) {
        // Dados de conexão
        String url = "jdbc:postgresql://localhost:5432/banco_de_dados"; 
        String usuario = "user"; // Substitua pelo seu usuário do banco
        String senha = "si250350"; // Substitua pela sua senha

        // Tenta estabelecer a conexão
        try {
            // Carregar o driver PostgreSQL
            Class.forName("org.postgresql.Driver");

            // Conectar ao banco de dados
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado ao banco de dados com sucesso!");

            // Realize suas operações no banco aqui
            
            // Fechar a conexão
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro na conexão com o banco de dados.");
            e.printStackTrace();
        }
    }
}