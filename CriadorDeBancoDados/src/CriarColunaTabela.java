import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class CriarColunaTabela {
    public void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do banco de dados:");
        String BancoNome = scanner.nextLine();

        System.out.println("Digite o nome da tabela:");
        String nomeTabela = scanner.nextLine();

        System.out.println("Digite o nome da nova coluna a ser adicionada:");
        String nomeColuna = scanner.nextLine();

        System.out.println("Digite o tipo de dados da nova coluna (ex: VARCHAR(100), INT):");
        String tipoColuna = scanner.nextLine();

        String url = "jdbc:mysql://localhost/" + BancoNome;
        String usuario = "root";
        String senha = "123456";

        try {
            // Carregar o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conectar ao banco de dados
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            Statement stmt = conexao.createStatement();

            // Adicionar a coluna na tabela
            String sql = "ALTER TABLE " + nomeTabela + " ADD COLUMN " + nomeColuna + " " + tipoColuna;
            stmt.executeUpdate(sql);

            System.out.println("Coluna '" + nomeColuna + "' do tipo " + tipoColuna + " adicionada com sucesso na tabela " + nomeTabela + " no banco de dados " + BancoNome + "!");

            stmt.close();
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao adicionar a coluna na tabela.");
        }
    }
}
