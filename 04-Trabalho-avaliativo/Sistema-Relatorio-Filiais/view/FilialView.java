package view;

/**
 * View responsável por exibir os resultados do processamento das quatro filiais.
 */
public class FilialView {

    /**
     * Exibe o faturamento de cada filial e o faturamento total.
     */
    public static void exibirResultado(
            double resultado1,
            double resultado2,
            double resultado3,
            double resultado4,
            double faturamentoTotal) {

        System.out.println("RELATÓRIO DE VENDAS");

        System.out.println("Filial 1: R$ " + resultado1);
        System.out.println("Filial 2: R$ " + resultado2);
        System.out.println("Filial 3: R$ " + resultado3);
        System.out.println("Filial 4: R$ " + resultado4);

        System.out.println("Faturamento total: R$ " + faturamentoTotal);
    }
}
