package bloco1.exercicio03;

public class ContaBancaria {

    private int numeroConta;
    protected double saldo;
    Pessoa titular;

    public ContaBancaria(int numeroConta, Pessoa titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor){
        if (valor <= 0){
            System.out.println("Valor invalido! Por favor digite um valor maior quer R$0");
        } else {
            valor += saldo;
        }
    }

    public void sacar(double valor){
        if (valor <= 0){
            System.out.println("Valor invalido! Por favor digite um valor maior quer R$0");
        } else if (valor > saldo){
            System.out.println("Saldo insuficiente para sacar valor solicitado!");
        } else {
            valor -= saldo;
            System.out.println("Saque realizado com sucessor! Saldo atualizado R$" + saldo);
        }
    }

    public void exibirSaldo(){
        System.out.printf("%s seu saldo atual é de R$%.2f%n", titular.getNome() , saldo);
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


}
