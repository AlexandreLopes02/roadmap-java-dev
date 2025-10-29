package bloco1.miniprojeto01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CalculadoraComHistorico {
    public static void main(String[] args) {
        List<String> historico = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        double resultado = 0.0;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");

        while (opcao != 6) {
            System.out.println("""
                    =====MENU=====
                    1 - Somar
                    2 - Subtrair
                    3 - Multiplicar
                    4 - Dividir
                    5 - Ver histórico
                    6 - Sair
                    """);
            System.out.print("Escolha uma opção: ");
            try {
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1 -> {
                        try {
                            System.out.println("*****SOMA*****");
                            System.out.print("Digite um número: ");
                            double num1 = scanner.nextDouble();
                            System.out.print("Digite outro número: ");
                            double num2 = scanner.nextDouble();

                            resultado = num1 + num2;
                            System.out.println("O resultado da sua soma é: " + resultado);

                            // data e hora do momento da operação
                            LocalDateTime agora = LocalDateTime.now();
                            String dataHoraFormatada = agora.format(formato);

                            String registro = "[" + dataHoraFormatada + "] ADIÇÃO -> " + num1 + " + " + num2 + " = " + resultado;
                            historico.add(registro);
                        } catch (InputMismatchException e) {
                            System.out.println("Erro: digite valores numéricos válidos!");
                            scanner.nextLine();
                        }
                    }
                    case 2 -> {
                        try {
                            System.out.println("*****SUBTRAÇÃO*****");
                            System.out.print("Digite um número: ");
                            double num1 = scanner.nextDouble();
                            System.out.print("Digite outro número: ");
                            double num2 = scanner.nextDouble();

                            resultado = num1 - num2;
                            System.out.println("O resultado da sua subtração é: " + resultado);

                            LocalDateTime agora = LocalDateTime.now();
                            String dataHoraFormatada = agora.format(formato);

                            String registro = "[" + dataHoraFormatada + "] SUBTRAÇÃO -> " + num1 + " - " + num2 + " = " + resultado;
                            historico.add(registro);
                        } catch (InputMismatchException e) {
                            System.out.println("Erro: digite valores numéricos válidos!");
                            scanner.nextLine();
                        }
                    }
                    case 3 -> {
                        try {
                            System.out.println("*****MULTIPLICAÇÃO*****");
                            System.out.print("Digite um número: ");
                            double num1 = scanner.nextDouble();
                            System.out.print("Digite outro número: ");
                            double num2 = scanner.nextDouble();

                            resultado = num1 * num2;
                            System.out.printf("O resultado da sua multiplicação é: %.2f%n", resultado);

                            LocalDateTime agora = LocalDateTime.now();
                            String dataHoraFormatada = agora.format(formato);

                            String registro = "[" + dataHoraFormatada + "] MULTIPLICAÇÃO -> " + num1 + " * " + num2 + " = " + resultado;
                            historico.add(registro);
                        } catch (InputMismatchException e) {
                            System.out.println("Erro: digite valores numéricos válidos!");
                            scanner.nextLine();
                        }
                    }
                    case 4 -> {
                        try {
                            System.out.println("*****DIVISÃO*****");
                            System.out.print("Digite o primeiro número (dividendo): ");
                            double num1 = scanner.nextDouble();
                            System.out.print("Digite o segundo número (divisor): ");
                            double num2 = scanner.nextDouble();

                            if (num2 == 0.0) {
                                System.out.println("Erro: Não é possível fazer divisão por 0.");
                            } else {
                                resultado = num1 / num2;
                                System.out.printf("O resultado da sua divisão é: %.2f%n", resultado);

                                LocalDateTime agora = LocalDateTime.now();
                                String dataHoraFormatada = agora.format(formato);

                                String registro = "[" + dataHoraFormatada + "] DIVISÃO -> " + num1 + " / " + num2 + " = " + resultado;
                                historico.add(registro);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Erro: digite valores numéricos válidos!");
                            scanner.nextLine();
                        }
                    }
                    case 5 -> {
                        if (historico.isEmpty()) {
                            System.out.println("Histórico vazio. Faça alguma operação primeiro.");
                        } else {
                            System.out.println("===== HISTÓRICO =====");
                            for (String item : historico) {
                                System.out.println(item);
                            }
                        }
                    }
                    case 6 -> {
                        System.out.println("Finalizando a aplicação...");
                        if (historico.isEmpty()) {
                            System.out.println("Histórico vazio. Nenhuma operação realizada.");
                        } else {
                            System.out.println("===== HISTÓRICO FINAL =====");
                            for (String item : historico) {
                                System.out.println(item);
                            }
                        }
                    }
                    default -> System.out.println("Opção inválida. Tente novamente!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: digite valores numéricos válidos!");
                scanner.nextLine(); // limpa buffer
            }
        }

        scanner.close();
    }
}
