package bloco1.exercicio03;

public class ContaPoupanca extends ContaBancaria{

    private double rendimento;

    public ContaPoupanca(int numeroConta, Pessoa titular, double rendimento) {
        super(numeroConta, titular);
        this.rendimento = rendimento;
    }

    public void aplicarRendimento(){
        double ganho = saldo * rendimento;
        saldo += ganho;
        System.out.printf("Rendimento de R$%.2f aplicado! Novo saldo: R$%.2f%n", ganho, saldo);
    }
}
