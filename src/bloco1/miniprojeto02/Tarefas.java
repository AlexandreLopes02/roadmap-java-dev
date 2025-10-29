package bloco1.miniprojeto02;

public class Tarefas {

    private String descricao;
    private int prioridade;

    public Tarefas(String descricao, int prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public String getPrioridadeTexto(){
        if (prioridade == 1){
            return "Alta";
        } else if (prioridade == 2){
            return "Média";
        } else if (prioridade == 3){
            return "Baixa";
        } else {
            return "Prioridade desconhecida";
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "[" + getPrioridadeTexto() + "] - " + descricao;
    }
}
