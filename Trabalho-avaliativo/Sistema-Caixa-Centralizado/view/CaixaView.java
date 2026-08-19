package view;

/**
 * View responsável por exibir os resultados
 * do sistema de caixa centralizado.

 * A View apenas apresenta as informações no console.
 * Ela não realiza o processamento das vendas.
 */
public class CaixaView {

    /**
     * Exibe as informações sobre os caixas e o resultado final.
     *
     */
    public static void exibirResultado(
            int quantidadeCaixas,
            int vendasPorCaixa,
            double saldoEsperado,
            double saldoFinal) {

        System.out.println("SISTEMA DE CAIXA CENTRALIZADO");

        // Exibe a quantidade de vendas de cada caixa
        for (int i = 1; i <= quantidadeCaixas; i++) {
            System.out.println(
                    "Caixa " + i + ": " + vendasPorCaixa + " vendas");
        }

        // Calcula a quantidade total de vendas
        int totalVendas = quantidadeCaixas * vendasPorCaixa;

        System.out.println("Total de vendas: " + totalVendas);
        System.out.println("Saldo esperado: R$ " + saldoEsperado);
        System.out.println("Saldo final: R$ " + saldoFinal);

        // Verifica se o saldo final está correto
        if (saldoFinal == saldoEsperado) {
            System.out.println("Resultado: Sucesso!");
        } else {
            System.out.println("Resultado: Erro!");
        }

    }
}
