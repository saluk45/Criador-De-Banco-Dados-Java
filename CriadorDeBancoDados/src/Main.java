import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Criar Banco de Dados");
            System.out.println("2. Criar Tabela");
            System.out.println("3. Criar Coluna na Tabela");
            System.out.println("4. Adicionar Item na Coluna");
            System.out.println("5. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine();  

            switch (escolha) {
                case 1:
                    CriarBancoDados criarBancoDados = new CriarBancoDados();
                    criarBancoDados.executar();
                    break;
                case 2:
                    CriarTabela criarTabela = new CriarTabela();
                    criarTabela.executar();
                    break;
                case 3:
                    CriarColunaTabela criarColunaTabela = new CriarColunaTabela();
                    criarColunaTabela.executar();
                    break;
                case 4:
                    AdicionarItemColuna adicionarItemColuna = new AdicionarItemColuna();
                    adicionarItemColuna.executar();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }

        scanner.close();
    }
}
