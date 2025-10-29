package bloco1.miniprojeto03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 7){
            System.out.println("""
                    ====== MENU DO BANCO ======
                    1 - Cadastrar cliente
                    2 - Criar conta (corrente/poupança)
                    3 - Depositar
                    4 - Sacar
                    5 - Ver saldo
                    6 - Listar contas
                    7 - Sair
                    ============================
                    """);
            System.out.print("Escolha uma opção: ");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao){
                    case 1 -> {
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("E-mail: ");
                        String email = scanner.nextLine();
                        banco.cadastrarCliente(new Pessoa(nome, cpf, email));
                    }
                    case 2 -> {
                        System.out.print("Digite o CPF do cliente: ");
                        String cpf = scanner.nextLine();
                        Pessoa cliente = banco.buscarCliente(cpf);
                        if (cliente == null) {
                            System.out.println("Cliente não encontrado!");
                        } else {
                            System.out.print("Tipo de conta (1-Corrente / 2-Poupança): ");
                            int tipo = scanner.nextInt();
                            banco.criarConta(cliente, tipo);
                        }
                    }
                    case 3 -> {
                        System.out.print("Número da conta: ");
                        int num = scanner.nextInt();
                        System.out.print("Valor do depósito: ");
                        double val = scanner.nextDouble();
                        banco.depositar(num, val);
                    }
                    case 4 -> {
                        System.out.print("Número da conta: ");
                        int num = scanner.nextInt();
                        System.out.print("Valor do saque: ");
                        double val = scanner.nextDouble();
                        banco.sacar(num, val);
                    }
                    case 5 -> {
                        System.out.print("Número da conta: ");
                        int num = scanner.nextInt();
                        banco.exibirSaldo(num);
                    }
                    case 6 -> banco.listarContas();
                    case 7 ->{
                        System.out.println("\nFinalizando o programa...");
                    }
                    default -> System.out.println("\nOpção invalida! Digite uma opção que está descrita no menu.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nErro: Digite um valor numerico valido!\n");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
