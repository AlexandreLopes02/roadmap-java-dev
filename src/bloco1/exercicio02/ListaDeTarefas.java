package bloco1.exercicio02;

import java.util.*;

public class ListaDeTarefas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> listaDeTarefas = new ArrayList<>();
        int opcao = 0;

        while (opcao != 8){
            System.out.println("""
                    ========== MENU ==========
                    1 - Adicionar tarefa
                    2 - Listar tarefas
                    3 - Atualizar tarefa
                    4 - Remover tarefa
                    5 - Buscar tarefa
                    6 - Ordenar tarefas
                    7 - Converter List ↔ Set
                    8 - Sair
                    """);
            System.out.print("Escolha uma opção: ");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao){
                    case 1 -> {
                        System.out.println("\n====Adicionar tarefa====");
                        System.out.println("Digite o nome da tafera: ");
                        String tarefa = scanner.nextLine();
                        listaDeTarefas.add(tarefa);
                        System.out.println("Tarefa adicionada com sucesso!\n");
                    }
                    case 2 -> {
                        if (listaDeTarefas.isEmpty()){
                            System.out.println("\nA lista de tarefa está vazia!\n");
                        } else {
                            System.out.println("====Lista de Taferas====");
                            for (int i = 0; i < listaDeTarefas.size(); i++) {
                                System.out.println( i + 1  + " - " + listaDeTarefas.get(i) + ".");
                            }
                            System.out.println();
                        }
                    }
                    case 3 ->{
                        if (listaDeTarefas.isEmpty()){
                            System.out.println("\nA lista de tarefa está vazia!\n");
                        }else {
                            System.out.println("====Lista de Taferas====");
                            for (int i = 0; i < listaDeTarefas.size(); i++) {
                                System.out.println( i + 1  + " - " + listaDeTarefas.get(i) + ".");
                            }
                            System.out.println();
                            System.out.println("Digite o indice da tarefa que deseja atualizar.");
                            try {
                                int indice = scanner.nextInt();
                                scanner.nextLine();
                                if (indice <= 0 || indice > listaDeTarefas.size()){
                                    System.out.println("Indice invalido! Digite um indice existente.");
                                } else {
                                    System.out.println("Qual nova descrição do indice escolhido: ");
                                    String novaDescricao = scanner.nextLine();
                                    listaDeTarefas.set(indice - 1, novaDescricao);
                                    System.out.println("Tarefa atualizada com sucesso\n");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: digite um valor numérico válido!");
                                scanner.nextLine();
                            }
                        }
                    }
                    case 4 ->{
                        if (listaDeTarefas.isEmpty()){
                            System.out.println("\nA lista de tarefa está vazia!\n");
                        }else {
                            System.out.println("====Lista de Taferas====");
                            for (int i = 0; i < listaDeTarefas.size(); i++) {
                                System.out.println( i + 1  + " - " + listaDeTarefas.get(i) + ".");
                            }
                            System.out.println();
                            try {
                                System.out.println("Digite o índice da tarefa que deseja remover: ");
                                int indice = scanner.nextInt();
                                scanner.nextLine();
                                if (indice <= 0){
                                    System.out.println("Indice invalido! Digite um indice existente.");
                                } else {
                                    listaDeTarefas.remove(indice - 1);
                                    System.out.println("Tarefa deletada com sucesso\n");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: digite um valor numérico válido!");
                                scanner.nextLine();
                            }
                        }
                    }
                    case 5 ->{
                        if (listaDeTarefas.isEmpty()){
                            System.out.println("\nA lista de tarefa está vazia!\n");
                        }else {
                            System.out.println("Digite o nome da tarefa que deseja buscar: ");
                            String termo = scanner.nextLine();
                            int encontrado = 0;
                            for (String tarefa : listaDeTarefas) {
                                if (tarefa.toLowerCase().contains(termo.toLowerCase())){
                                    System.out.println(tarefa);
                                    encontrado++;
                                }
                            }
                            if (encontrado == 0) {
                                System.out.println("Nenhuma tarefa encontrada com o termo " + termo + ".\n");
                            }
                        }

                    }
                    case 6 ->{
                        if (listaDeTarefas.isEmpty()){
                            System.out.println("\nA lista de tarefa está vazia!\n");
                        }else {
                            Collections.sort(listaDeTarefas);
                            System.out.println("Tarefa ordenada com sucesso!\n");
                            System.out.println("↓↓↓↓LISTA ORDENADA↓↓↓↓");
                            for (String tarefa : listaDeTarefas){
                                System.out.println(tarefa);
                            }
                            System.out.println();
                        }
                    }
                    case 7 ->{
                        if (listaDeTarefas.isEmpty()){
                            System.out.println("\nA lista de tarefa está vazia!\n");
                        }else {
                            Set<String> conjunto = new HashSet<>(listaDeTarefas);
                            System.out.println("Conversão concluida e duplicadas removidas!\n");
                            System.out.println("↓↓↓↓LISTA -> SET↓↓↓↓");
                            for (String item : conjunto){
                                System.out.println(item);
                            }
                            listaDeTarefas = new ArrayList<>(conjunto);
                            System.out.println();
                        }
                    }
                    case 8 -> {
                        System.out.println("\nFinalizando programa...");
                    }

                    default -> System.out.println("Opção invalida! Tente novamente.");
                }
            }catch (InputMismatchException e) {
                System.out.println("Erro: digite um valor numérico válidos!\n");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}