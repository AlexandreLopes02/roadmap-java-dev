package bloco1.exercicio04;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClienteRepository repo = new ClienteRepository();
        RelatorioClientes relatorio = new RelatorioClientes(repo);
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao !=6){
            System.out.println("""
                    \n====== MENU CLIENTES ======
                    1 - Cadastrar cliente
                    2 - Listar todos os clientes
                    3 - Buscar cliente por CPF
                    4 - Relatório por letra inicial
                    5 - Relatório de e-mails
                    6 - Sair
                    ============================
                    """);
            System.out.print("Escolha uma opção: ");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao){
                    case 1 ->{
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("E-mail: ");
                        String email = scanner.nextLine();
                        repo.salvarCliente(new Pessoa(nome, cpf, email));
                    }
                    case 2 -> repo.lerClientes().forEach(System.out::println);
                    case 3 -> {
                        System.out.print("Digite o CPF para buscar: ");
                        String cpf = scanner.nextLine();
                        Optional<Pessoa> cliente = repo.buscarClientePorCpf(cpf);
                        cliente.ifPresentOrElse(
                                c -> System.out.println("Cliente encontrado: " + c),
                                () -> System.out.println("❌ Cliente não encontrado."));
                    }
                    case 4 -> {
                        System.out.print("Digite a letra inicial: ");
                        String letra = scanner.nextLine();
                        relatorio.gerarRelatorioPorLetra(letra);
                    }
                    case 5 -> relatorio.gerarRelatorioPorEmail();
                    case 6 -> System.out.println("\nFinalizando programa...");
                    default -> System.out.println("\nOpção invalida! Por favor digite um operação valida.\n");
                }
            }catch (InputMismatchException e) {
                System.out.println("\nErro: Digite um valor numerico valido!\n");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
