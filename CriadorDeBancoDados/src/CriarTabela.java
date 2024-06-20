import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class CriarTabela {
    public void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do banco de dados onde deseja criar a tabela:");
        String BancoNome = scanner.nextLine();

        System.out.println("Digite o nome da tabela a ser criada:");
        String nomeTabela = scanner.nextLine();

        String url = "jdbc:mysql://localhost/" + BancoNome;
        String usuario = "root";
        String senha = "123456";

        try {
            // Carregar o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conectar ao banco de dados
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            Statement stmt = conexao.createStatement();

            // Criar a tabela com apenas a coluna id
            String sql = "CREATE TABLE IF NOT EXISTS " + nomeTabela + " (" +
                         "id INT AUTO_INCREMENT PRIMARY KEY)";
            stmt.executeUpdate(sql);

            System.out.println("Tabela " + nomeTabela + " criada com sucesso no banco de dados " + BancoNome + "!");

            stmt.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao criar a tabela.");
        }
    }
}
