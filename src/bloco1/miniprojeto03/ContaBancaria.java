package bloco1.miniprojeto03;

public class ContaBancaria {

    private int numeroDaConta;
    protected double saldo;
    Pessoa titular;

    public ContaBancaria(int numeroDaConta, Pessoa titular) {
        this.numeroDaConta = numeroDaConta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor){
        if (valor <= 0){
            System.out.printf("Não é possivel depositar: R$%.2f! Por favor tente um valor valido.", valor);
        } else {
            System.out.printf("Valor de R$%.2f depositado com sucesso!", valor);
            saldo += valor;
        }
    }

    public void sacar(double valor){
        if (valor <= 0){
            System.out.printf("Não é possivel depositar: R$%.2f! Por favor tente um valor valido.", valor);
        } else if (valor > saldo){
            System.out.println("Saldo insufienciete para sacar esse valor. Seu saldo é de R$" + saldo);
        } else {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso! Saldo atulizado R$" + saldo);
        }
    }

    public void exibirInformacao(){
        System.out.printf("👤 Titular: %s%n💰 Saldo atual: R$%.2f%n", titular.getNome(), saldo);
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Pessoa getTitular() {
        return titular;
    }
}
