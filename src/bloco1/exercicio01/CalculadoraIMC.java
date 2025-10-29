package bloco1.exercicio01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {


        //possivel melhora a implementar: imprimir o IMC e imprimir tambem em que grupo se encaixa, ex: peso ideal ou acima do peso
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 2){
            System.out.println("""
                    ====== MENU ======
                    1 - Calcular IMC;
                    2 - Sair.
                    """);
            System.out.print("Digite a opção que deseja: ");
            try {
                opcao = scanner.nextInt();

                switch (opcao){

                    case 1 -> {
                        try {
                            System.out.print("Digite seu peso (kg): ");
                            double peso = scanner.nextDouble();

                            System.out.print("Digite sua altura (m): ");
                            double altura = scanner.nextDouble();

                            double imc = peso / (altura * altura);
                            System.out.printf("Seu IMC é: %.2f%n", imc);
                        }catch (InputMismatchException e) {
                            System.out.println("Erro: digite valores numéricos válidos!");
                            scanner.nextLine(); // limpa buffer
                        }
                        break;
                    }
                    case 2 -> {
                        System.out.println("Finalizando o programa...");
                        break;
                    }
                    default -> {
                        System.out.println("Opção invalida.");
                        break;
                    }

                }
            }catch (InputMismatchException e) {
                System.out.println("Erro: digite apenas números!");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
