package bloco1.miniprojeto04;

public class Validador {

    //Validações com Regex

    public static boolean validarNome(String nome) throws ValidacaoException {
        if (nome == null || nome.isBlank()){
            throw new ValidacaoException("O nome não pode estar vazio.");
        }
        String regex = "^[A-Za-zÀ-ÖØ-öø-ÿ]+\\s+[A-Za-zÀ-ÖØ-öø-ÿ]+$";
        if (!nome.matches(regex)){
            throw new ValidacaoException("Digite um nome e sobrenome valido.");
        }
        return true;
    }

    public static boolean validarEmail(String email) throws ValidacaoException {
        if (email == null || email.isBlank()){
            throw new ValidacaoException("O campo e-mail não pode estar vazio!");
        }
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        if (!email.matches(regex)){
            throw new ValidacaoException("Digite um email valido!(exemplo: nome@dominio.com)");
        }
        return true;
    }

    public static boolean validarTelefone(String telefone)throws ValidacaoException{
        if (telefone == null||telefone.isBlank()){
            throw new ValidacaoException("O telefone não pode está vazio.");
        }
        String regex = "^\\d{11}$";
        if (!telefone.matches(regex)){
            throw new ValidacaoException("O telefone dever conter 11 numeros");
        }
        return true;
    }

    public static boolean validarSenha(String senha) throws ValidacaoException{
        if (senha == null || senha.isBlank()){
            throw new ValidacaoException("Senha não pode está vazia");
        }
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$.!%*?&]{8,}$";
        if (!senha.matches(regex)){
            throw new ValidacaoException("Senha inválida! Deve ter 8+ caracteres, com letra maiúscula, minúscula, número e símbolo.");
        }
        return true;
    }
}
