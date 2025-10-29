package bloco1.exercicio03;

public class PainelCaixa {
    public static void main(String[] args) {

        // Criando pessoa CPF exemplo, pois não fiz validação para esse teste.
        Pessoa p1 = new Pessoa("Alexandre Lopes", "123.456.789-00", "alexandre@email.com");

        // Criando contas
        ContaCorrente cc = new ContaCorrente(1001, p1, 1.50);
        ContaPoupanca cp = new ContaPoupanca(2001, p1, 0.005); // 0.5% de rendimento

        // Testando funcionalidades
        System.out.println("=== TESTE CONTA CORRENTE ===");
        cc.depositar(200);
        cc.exibirSaldo();
        cc.sacar(50);
        cc.exibirSaldo();

        System.out.println("\n=== TESTE CONTA POUPANÇA ===");
        cp.depositar(300);
        cp.aplicarRendimento();
        cp.exibirSaldo();
        cp.sacar(100);
        cp.exibirSaldo();
    }
}
