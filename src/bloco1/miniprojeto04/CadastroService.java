package bloco1.miniprojeto04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CadastroService {

    private final PessoaRepository repo;
    private final Validador validador;

    public CadastroService(PessoaRepository repo, Validador validar) {
        this.repo = repo;
        this.validador = validar;
    }

    public void criarPessoa(String nome, String email,String telefone, String senha){
        if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty() || senha.isEmpty()) {
            System.out.println("⚠️ Todos os campos são obrigatórios!");
            return;
        }

        if (!validador.validarEmail(email)) {
            System.out.println("❌ Email inválido!");
            return;
        }
        if (!validador.validarTelefone(telefone)) {
            System.out.println("❌ Telefone inválido!");
            return;
        }
        if (!validador.validarSenha(senha)) {
            System.out.println("❌ Senha fraca! Deve ter 6+ caracteres, 1 maiúscula e 1 número.");
            return;
        }

        Pessoa pessoa = new Pessoa(nome, email, telefone, senha);
        repo.salvarPessoa(pessoa);
    }

    public void listarPessoas(){
        List<Pessoa> pessoas = repo.lerPessoa();
        if (pessoas.isEmpty()){
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            pessoas.forEach(System.out::println);
        }
    }

    public void buscarPorEmail(String email){
        List<Pessoa> pessoas = repo.lerPessoa();
        Optional<Pessoa> encontrada = pessoas.stream()
                .filter(p -> p.getEmail().equals(email))
                .findFirst();

        encontrada.ifPresentOrElse(
                p -> System.out.println("Pessoa encontrada" + p),
                () -> System.out.println("Nenhuma cadastrado com esse email.")
        );
    }

    public void atualizarPessoa(String emailAntigo, Pessoa novaPessoa){
        repo.atualizarPessoa(emailAntigo, novaPessoa);
    }

    public void removerPessoa(String email){
        repo.removerPessoa(email);

    }

    public void exportarParaTxt(){
        List<Pessoa> pessoas = repo.lerPessoa();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("export_pessoas.txt"))){
            for (Pessoa p : pessoas){
                bw.write(p.toString());
                bw.newLine();
            }System.out.println("📄 Exportação concluída com sucesso!");
        } catch (IOException e) {
            System.out.println("❌ Erro ao exportar: " + e.getMessage());
        }
    }
}
