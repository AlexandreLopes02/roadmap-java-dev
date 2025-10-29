package bloco1.miniprojeto03;

public class ContaPoupanca extends ContaBancaria {

    private double taxaRendimento;

    public ContaPoupanca(int numeroConta, Pessoa titular, double taxaRendimento) {
        super(numeroConta, titular);
        this.taxaRendimento = taxaRendimento;
    }

    public void aplicarRendimento() {
        double ganho = saldo * taxaRendimento;
        saldo += ganho;
        System.out.printf("Rendimento de R$%.2f aplicado! Novo saldo: R$%.2f%n", ganho, saldo);
    }

}
