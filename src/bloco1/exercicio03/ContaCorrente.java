package bloco1.exercicio03;

public class ContaCorrente extends ContaBancaria{

    private double taxaDeManutencao;

    public ContaCorrente(int numeroConta, Pessoa titular, double taxa) {
        super(numeroConta, titular);
        this.taxaDeManutencao = taxa;
    }

    @Override
    public void sacar(double valor){
        double totalSaque = valor + taxaDeManutencao;
        if (valor <= 0) {
            System.out.println("⚠ Valor inválido para saque!");
        } else if (totalSaque > saldo){
            System.out.println("Saldo insuficiente(incluindo taxa)!");
        } else {
            saldo -= totalSaque;
            System.out.println("Saque realizado! Taxa de R$" + taxaDeManutencao + " para manutenção aplicada!");
        }
    }
}
