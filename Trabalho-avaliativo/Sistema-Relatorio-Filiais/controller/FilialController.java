package controller;

import model.Filial;
import view.FilialView;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller responsável por coordenar o processamento
 * das vendas das quatro filiais.
 */
public class FilialController {

    /**
     * Executa o processamento das quatro filiais.
     *
     * Cada filial recebe sua própria lista de vendas
     * e possui uma Thread para calcular sua soma.
     */
    public void executarProcessamento() {

        // Cria as quatro listas independentes
        List<Double> vendasFilial1 = criarVendas();
        List<Double> vendasFilial2 = criarVendas();
        List<Double> vendasFilial3 = criarVendas();
        List<Double> vendasFilial4 = criarVendas();

        // Cria uma Thread para cada filial
        Filial filial1 = new Filial(vendasFilial1);
        Filial filial2 = new Filial(vendasFilial2);
        Filial filial3 = new Filial(vendasFilial3);
        Filial filial4 = new Filial(vendasFilial4);

        // Inicia as quatro Threads
        filial1.start();
        filial2.start();
        filial3.start();
        filial4.start();

        // Aguarda todas as Threads terminarem
        try {

            filial1.join();
            filial2.join();
            filial3.join();
            filial4.join();

        } catch (InterruptedException e) {

            System.out.println("Erro ao aguardar as threads.");
        }

        // Obtém o resultado de cada filial
        double resultado1 = filial1.getResultado();
        double resultado2 = filial2.getResultado();
        double resultado3 = filial3.getResultado();
        double resultado4 = filial4.getResultado();

        // Junta os resultados das quatro filiais
        double faturamentoTotal = resultado1 + resultado2 + resultado3 + resultado4;

        // Envia os resultados para a View
        FilialView.exibirResultado(resultado1,resultado2,resultado3,resultado4,faturamentoTotal
        );
    }

    /**
     * Cria uma lista com 10.000 registros de vendas.
     *
     * Cada registro possui o valor de R$ 10,00.
     */
    private List<Double> criarVendas() {

        List<Double> vendas = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            vendas.add(10.00);
        }

        return vendas;
    }
}
