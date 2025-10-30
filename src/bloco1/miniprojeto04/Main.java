package bloco1.miniprojeto04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PessoaRepository repo = new PessoaRepository();
        Validador validador = new Validador();
        CadastroService service = new CadastroService(repo, validador);
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("""
                    \n====== MENU DE CADASTRO ======
                    1 - Cadastrar pessoa
                    2 - Listar pessoas
                    3 - Buscar por e-mail
                    4 - Atualizar pessoa
                    5 - Remover pessoa
                    6 - Exportar para TXT
                    7 - Sair
                    ==============================
                    """);
            System.out.print("Escolha uma opção: ");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Telefone (somente números): ");
                        String telefone = scanner.nextLine();
                        System.out.print("Senha: ");
                        String senha = scanner.nextLine();
                        service.criarPessoa(nome, email, telefone, senha);
                    }
                    case 2 -> service.listarPessoas();
                    case 3 -> {
                        System.out.print("Digite o e-mail para busca: ");
                        String emailBusca = scanner.nextLine();
                        service.buscarPorEmail(emailBusca);
                    }
                    case 4 -> {
                        System.out.print("Digite o e-mail antigo: ");
                        String emailAntigo = scanner.nextLine();
                        System.out.println("Digite os novos dados:");
                        System.out.print("Nome: ");
                        String nomeNovo = scanner.nextLine();
                        System.out.print("Email: ");
                        String emailNovo = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String telefoneNovo = scanner.nextLine();
                        System.out.print("Senha: ");
                        String senhaNova = scanner.nextLine();

                        Pessoa novaPessoa = new Pessoa(nomeNovo, emailNovo, telefoneNovo, senhaNova);
                        service.atualizarPessoa(emailAntigo, novaPessoa);
                    }
                    case 5 -> {
                        System.out.print("Digite o e-mail a remover: ");
                        String emailRemover = scanner.nextLine();
                        service.removerPessoa(emailRemover);
                    }
                    case 6 -> service.exportarParaTxt();
                    case 7 -> System.out.println("Finalizando programa...");
                    default -> System.out.println("Opção invalida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite um opção valida! " + e.getMessage());
            }
        }
        scanner.close();
    }
}
