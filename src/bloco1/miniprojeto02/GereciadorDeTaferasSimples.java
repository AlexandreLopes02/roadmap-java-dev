package bloco1.miniprojeto02;

import java.util.*;

public class GereciadorDeTaferasSimples {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Tarefas> tarefas = new ArrayList<>();
        int opcao = 0;

        while (opcao != 7){
            System.out.println("""
                    ====== ↓MENU DE OPÇÕES↓ ======
                    1 - Adicionar tarefa
                    2 - Listar tarefas
                    3 - Atualizar tarefa
                    4 - Remover tarefa
                    5 - Buscar tarefa
                    6 - Ordenar por prioridade
                    7 - Sair
                    """);
            System.out.print("Escolha um opção: ");
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao){
                    case 1->{
                        System.out.println("\n↓ADICIONE UMA TAFERA A SUA LISTA↓");
                        System.out.print("Digite o nome da tarefa que deseja adicionar: ");
                        String descricao = scanner.nextLine();
                        System.out.print("Digite a prioridade(1 a 3) dessa tarefa:");
                        int prioridade = scanner.nextInt();
                        scanner.nextLine();
                        tarefas.add(new Tarefas(descricao,prioridade));
                        System.out.println("Tarefa adiconada com sucesso\n");
                    }
                    case 2->{
                        if (tarefas.isEmpty()){
                            System.out.println("\nLista de taferas vazia!\n");
                        } else {
                            System.out.println("\n↓LISTA DE TAFERA(S)↓");
                            for (int i = 0; i < tarefas.size(); i++) {
                                System.out.println(i + 1 + " -> " + tarefas.get(i) + ".");
                            }
                            System.out.println();
                        }
                    }
                    // ...
                    case 3 -> {
                        if (tarefas.isEmpty()) {
                            System.out.println("\nLista de tarefas vazia!\n");
                        } else {
                            System.out.println("\n↓TAREFA(S) EM SUA LISTA↓");
                            for (int i = 0; i < tarefas.size(); i++) {
                                System.out.println(i + 1 + " -> " + tarefas.get(i) + ".");
                            }
                            int indice = -1;
                            try {
                                System.out.print("\nDigite o NÚMERO da tarefa que deseja atualizar: ");
                                indice = scanner.nextInt();
                                scanner.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("\n[!] Entrada inválida. Por favor, digite um número.\n");
                                scanner.nextLine();
                                break;
                            }

                            if (indice < 1 || indice > tarefas.size()) {
                                System.out.println("\n[!] Índice inválido! Por favor digite um número existente na lista de tarefas.\n");
                            } else {
                                Tarefas tarefaParaAtualizar = tarefas.get(indice - 1);
                                System.out.println("\n--- ATUALIZANDO TAREFA: " + tarefaParaAtualizar.toString() + " ---");
                                System.out.print("Nova descrição (deixe em branco para manter: '" + tarefaParaAtualizar.getDescricao() + "'): ");
                                String novaDescricao = scanner.nextLine().trim();
                                System.out.print("Nova prioridade (1-Alta, 2-Media, 3-Baixa, ou 0 para manter: " + tarefaParaAtualizar.getPrioridade() + "): ");
                                int novaPrioridade = 0;
                                try {
                                    novaPrioridade = scanner.nextInt();
                                    scanner.nextLine();
                                } catch (InputMismatchException e) {
                                    System.out.println("[!] Prioridade inválida. Mantendo a prioridade atual.");
                                    scanner.nextLine();
                                    novaPrioridade = 0;
                                }
                                if (!novaDescricao.isEmpty()) {
                                    tarefaParaAtualizar.setDescricao(novaDescricao);
                                }
                                if (novaPrioridade >= 1 && novaPrioridade <= 3) {
                                    tarefaParaAtualizar.setPrioridade(novaPrioridade);
                                } else if (novaPrioridade != 0) {
                                    System.out.println("[!] Valor de prioridade inválido (apenas 1, 2 ou 3). Prioridade não foi alterada.");
                                }
                                System.out.println("\n[SUCESSO] Tarefa atualizada com sucesso para: " + tarefaParaAtualizar.toString() + "\n");
                            }
                        }
                    }
                    case 4 ->{
                        if (tarefas.isEmpty()){
                            System.out.println("\nLista de taferas vazia!\n");
                        } else {
                            System.out.println("\n↓TAREFA(S) EM SUA LISTA↓");
                            for (int i = 0; i < tarefas.size(); i++) {
                                System.out.println(i + 1 + " -> " + tarefas.get(i) + ".");
                            }
                            int indice = -1;
                            try {
                                System.out.print("\nDigite o NÚMERO da tarefa que deseja remover: ");
                                indice = scanner.nextInt();
                                scanner.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("\n[!] Entrada inválida. Por favor, digite um número.\n");
                                scanner.nextLine();
                                break;
                            }

                            if (indice < 1 || indice > tarefas.size()) {
                                System.out.println("\n[!] Índice inválido! Por favor digite um número existente na lista de tarefas.\n");
                            } else {
                                tarefas.remove(indice - 1);
                                System.out.println("Tarefa removida com sucesso da sua lista!");
                            }
                        }
                    }
                    case 5 ->{
                        if (tarefas.isEmpty()){
                            System.out.println("\nLista de taferas vazia!\n");
                        } else {
                            System.out.println("Digite o termo pelo qual deseja procurar: ");
                            String termo = scanner.nextLine();
                            List<Tarefas> resultado = tarefas.stream()
                                    .filter(t -> t.getDescricao().toLowerCase().contains(termo.toLowerCase()))
                                    .toList();
                            if (resultado.isEmpty()){
                                System.out.println("Nenhuma tarefa encontrada.");
                            } else {
                                System.out.println("\n=== RESULTADOS ===");
                                resultado.forEach(System.out::println);
                                System.out.println();
                            }
                        }
                    }
                    case 6 ->{
                        if (tarefas.isEmpty()){
                            System.out.println("\nLista de taferas vazia!\n");
                        } else {
                            tarefas.sort(Comparator.comparingInt(Tarefas::getPrioridade));
                            System.out.println("Tarefas ordenadas por prioridade (Alta → Baixa)");
                            for (Tarefas tarefa : tarefas){
                                System.out.println(tarefa);
                            }
                            System.out.println();
                        }
                    }
                    case 7 ->{
                        System.out.println("Finalizando a aplicação...");
                    }
                    default -> System.out.println("\nOpção invalida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: digite um valor numérico válidos!\n");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
