import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class CriarBancoDados {
    public void executar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do banco de dados a ser criado:");
        String BancoNome = scanner.nextLine();

        String url = "jdbc:mysql://localhost/";
        String usuario = "root";
        String senha = "123456";

        try {
            // Carregar o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conecta ao servidor MySQL
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            Statement stmt = conexao.createStatement();

            // Cria o banco de dados
            String sql = "CREATE DATABASE " + BancoNome;
            stmt.executeUpdate(sql);

            System.out.println("Banco de dados " + BancoNome + " criado com sucesso!");

            stmt.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao criar o banco de dados.");
        }
    }
}
