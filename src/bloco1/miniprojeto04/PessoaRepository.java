package bloco1.miniprojeto04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {

    private static final String CAMINHO_ARQUIVO = "pessoa.txt";
    List<Pessoa> pessoas = new ArrayList<>();

    public void salvarPessoa(Pessoa pessoa){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) {
            bw.write(pessoa.getNome() + ";" + pessoa.getEmail() + ";" + pessoa.getTelefone() + ";" + pessoa.getSenha());
            bw.newLine();
            System.out.println("✅ Cliente salvo com sucesso!");
        } catch(IOException e) {
            System.out.println("❌ Erro ao salvar cliente: " + e.getMessage());
        }
    }

    public List<Pessoa> lerPessoa(){
        try(BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))){
            String linha;
            while ((linha = br.readLine()) != null){
                String[] partes = linha.split(";");
                if (partes.length == 4){
                    Pessoa p = new Pessoa(partes[0], partes[1], partes[2], partes[3]);
                    pessoas.add(p);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("📂 Nenhum arquivo encontrado ainda. Ele será criado automaticamente.");
        } catch (IOException e) {
            System.out.println("❌ Erro ao ler o arquivo: " + e.getMessage());
        }
        return pessoas;
    }

    public void atualizarPessoa(String emailAntigo, Pessoa novaPessoa){
        List<Pessoa> pessoas = lerPessoa();

        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getEmail().equals(emailAntigo)){
                pessoas.set(i, novaPessoa);
                break;
            }
        }
    }

    public void removerPessoa(String email){
        List<Pessoa> pessoas = lerPessoa();
        pessoas.removeIf(p -> p.getEmail().equals(email));
        sobrescreverArquivo(pessoas);
        System.out.println("Pessoa removida com sucesso!");
    }

    private void sobrescreverArquivo(List<Pessoa> pessoas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (Pessoa p : pessoas) {
                bw.write(p.getNome() + ";" + p.getEmail() + ";" +
                        p.getTelefone() + ";" + p.getSenha());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Erro ao sobrescrever arquivo: " + e.getMessage());
        }
    }
}
