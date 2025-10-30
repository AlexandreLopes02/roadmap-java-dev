package bloco1.miniprojeto04;

public class ValidacaoException extends RuntimeException {
    /* Exceção personalizada para erros de validação */
    public ValidacaoException(String message) {
        super(message);
    }
}
