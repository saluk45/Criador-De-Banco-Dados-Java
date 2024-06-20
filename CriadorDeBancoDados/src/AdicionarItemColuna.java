import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class AdicionarItemColuna {
    public void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do banco de dados:");
        String BancoNome = scanner.nextLine();

        System.out.println("Digite o nome da tabela:");
        String nomeTabela = scanner.nextLine();

        System.out.println("Digite o nome da coluna onde deseja adicionar o item:");
        String nomeColuna = scanner.nextLine();

        System.out.println("Digite o valor a ser adicionado na coluna:");
        String value = scanner.nextLine();

        String url = "jdbc:mysql://localhost/" + BancoNome;
        String usuario = "root";
        String senha = "123456";

        try {
            // Carregar o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conectar ao banco de dados
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            Statement stmt = conexao.createStatement();

            // Inserir o valor na coluna especificada
            String sql = "INSERT INTO " + nomeTabela + " (" + nomeColuna + ") VALUES ('" + value + "')";
            stmt.executeUpdate(sql);

            System.out.println("Valor '" + value + "' adicionado com sucesso na coluna '" + nomeColuna + "' da tabela '" + nomeTabela + "' no banco de dados '" + BancoNome + "'!");

            stmt.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao adicionar o item na coluna.");
        }
    }
}
