package bloco1.exercicio04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository {

    private static final String CAMINHO_ARQUIVO = "clientes.txt";
    List<Pessoa> clientes = new ArrayList<>();

    public void salvarCliente(Pessoa pessoa) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) {
            bw.write(pessoa.getNome() + ";" + pessoa.getCpf() + ";" + pessoa.getEmail());
            bw.newLine();
            System.out.println("✅ Cliente salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar cliente: " + e.getMessage());
        }
    }

    public List<Pessoa> lerClientes() {
        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    Pessoa p = new Pessoa(partes[0], partes[1], partes[2]);
                    clientes.add(p);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("📂 Nenhum arquivo encontrado ainda. Ele será criado automaticamente.");
        } catch (IOException e) {
            System.out.println("❌ Erro ao ler o arquivo: " + e.getMessage());
        }

        return clientes;
    }

    public Optional<Pessoa> buscarClientePorCpf(String cpf){
        List<Pessoa> cliente = lerClientes();

        return cliente.stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst();
    }
}
