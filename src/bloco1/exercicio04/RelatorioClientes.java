package bloco1.exercicio04;

import java.util.List;

public class RelatorioClientes {

    private ClienteRepository repo;

    public RelatorioClientes(ClienteRepository repo) {
        this.repo = repo;
    }

    public void gerarRelatorioPorLetra(String letra){
        List<Pessoa> clientes = repo.lerClientes();

        List<Pessoa> filtrados = clientes.stream()
                .filter(p -> p.getNome().toLowerCase().startsWith(letra.toLowerCase()))
                .toList();

        if (filtrados.isEmpty()) {
            System.out.println("⚠️ Nenhum cliente encontrado com a letra " + letra);
        } else {
            System.out.println("\n=== CLIENTES COM '" + letra.toUpperCase() + "' ===");
            filtrados.forEach(System.out::println);
        }
    }

    public void gerarRelatorioPorEmail(){
        List<Pessoa> clientes = repo.lerClientes();

        System.out.println("\n=== RELATÓRIO DE E-MAILS ===");
        clientes.stream()
                .map(Pessoa::getEmail)
                .forEach(System.out::println);

    }
}
