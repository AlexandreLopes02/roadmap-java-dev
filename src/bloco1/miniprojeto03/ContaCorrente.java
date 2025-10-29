package bloco1.miniprojeto03;

public class ContaCorrente extends ContaBancaria {

    private double taxaManutencao;

    public ContaCorrente(int numeroConta, Pessoa titular, double taxaManutencao) {
        super(numeroConta, titular);
        this.taxaManutencao = taxaManutencao;
    }

    @Override
    public void sacar(double valor) {
        double total = valor + taxaManutencao;
        if (valor <= 0) {
            System.out.println("Valor inválido para saque!");
        } else if (total > saldo) {
            System.out.println("Saldo insuficiente para saque + taxa! Seu saldo é R$" + saldo);
        } else {
            saldo -= total;
            System.out.printf("Saque de R$%.2f realizado (taxa R$%.2f).%n", valor, taxaManutencao);
        }
    }
}
