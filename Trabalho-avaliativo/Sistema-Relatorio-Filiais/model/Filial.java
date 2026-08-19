package model;

import java.util.List;

/**
 * Model que representa uma filial.
 * Cada filial possui sua própria lista de vendas e calcula seu próprio faturamento.
 */
public class Filial extends Thread {

    /**
     * Lista de vendas pertencente à filial.
     */
    private List<Double> vendas;

    /**
     * Resultado da soma das vendas da filial.
     */
    private double resultado;

    /**
     * Construtor da filial.
     * Recebe a lista de vendas que pertence exclusivamente a esta filial.
     */
    public Filial(List<Double> vendas) {
        this.vendas = vendas;
        this.resultado = 0.0;
    }

    /**
     * Executa o processamento das vendas.
     * A Thread percorre a sua própria lista e calcula o faturamento da filial.
     */
    @Override
    public void run() {

        for (double venda : vendas) {
            resultado += venda;
        }
    }

    /**
     * Retorna o faturamento calculado da filial.
     */
    public double getResultado() {
        return resultado;
    }
}
