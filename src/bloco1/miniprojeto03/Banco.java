package bloco1.miniprojeto03;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private List<Pessoa> clientes = new ArrayList<>();
    private List<ContaBancaria> contas = new ArrayList<>();
    private int contadorContas = 1000;

    public void cadastrarCliente(Pessoa pessoa){
        clientes.add(pessoa);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public Pessoa buscarCliente(String cpf){
        for (Pessoa p: clientes){
            if (p.getCpf().equals(cpf)){
                return p;
            }
        }
        return null;
    }

    public void criarConta(Pessoa titular, int tipo){
        contadorContas++;
        ContaBancaria conta;
        if (tipo == 1) {
            conta = new ContaCorrente(contadorContas, titular, 1.50);
        } else {
            conta = new ContaPoupanca(contadorContas, titular, 0.005);
        }
        contas.add(conta);
        System.out.printf("Conta criada com sucesso! Número: %d%n", conta.getNumeroDaConta());
    }

    public ContaBancaria buscarConta(int numero) {
        for (ContaBancaria c : contas) {
            if (c.getNumeroDaConta() == numero) return c;
        }
        return null;
    }

    public void depositar(int numero, double valor) {
        ContaBancaria conta = buscarConta(numero);
        if (conta != null) conta.depositar(valor);
        else System.out.println(" Conta não encontrada!");
    }

    public void sacar(int numero, double valor) {
        ContaBancaria conta = buscarConta(numero);
        if (conta != null) conta.sacar(valor);
        else System.out.println("❌ Conta não encontrada!");
    }

    public void exibirSaldo(int numero) {
        ContaBancaria conta = buscarConta(numero);
        if (conta != null) conta.exibirInformacao();
        else System.out.println("❌ Conta não encontrada!");
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada ainda.");
        } else {
            System.out.println("\n=== CONTAS CADASTRADAS ===");
            for (ContaBancaria c : contas) {
                System.out.printf("Conta %d - Titular: %s - Saldo: R$%.2f%n",
                        c.getNumeroDaConta(), c.getTitular().getNome(), c.getSaldo());
            }
        }
    }
}
