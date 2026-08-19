package controller;

import model.CaixaCentral;
import view.CaixaView;

/**
 * Controller responsável por coordenar a execução das threads
 * que representam os caixas do evento.
 *
 * O Controller cria as threads, inicia as vendas,
 * aguarda todas terminarem e envia o resultado para a View.
 */
public class CaixaController {

    /**
     * Executa o processamento das vendas dos cinco caixas.
     *
     * Cada caixa realiza 1.000 vendas de R$ 10,00.
     * Todas as threads utilizam o mesmo saldo centralizado.
     */
    public void executarProcessamento() {

        /**
         * Runnable representa a tarefa que será executada
         * por cada caixa.
         */
        Runnable caixa = new Runnable() {

            @Override
            public void run() {

                // Cada caixa realiza 1.000 vendas
                for (int i = 0; i < 1000; i++) {

                    // Cada venda adiciona R$ 10,00 ao saldo
                    CaixaCentral.registrarVenda(10.00);
                }
            }
        };

        // Cria as cinco threads que representam os caixas
        Thread caixa1 = new Thread(caixa);
        Thread caixa2 = new Thread(caixa);
        Thread caixa3 = new Thread(caixa);
        Thread caixa4 = new Thread(caixa);
        Thread caixa5 = new Thread(caixa);

        // Inicia as cinco threads
        caixa1.start();
        caixa2.start();
        caixa3.start();
        caixa4.start();
        caixa5.start();

        /**
         * Aguarda todas as threads terminarem
         * antes de consultar o saldo final.
         */
        try {

            caixa1.join();
            caixa2.join();
            caixa3.join();
            caixa4.join();
            caixa5.join();

        } catch (InterruptedException e) {

            // Trata uma possível interrupção durante o join
            System.out.println("Erro ao aguardar as threads.");
        }

        // Saldo esperado após todas as vendas
        double saldoEsperado = 50000.00;

        // Obtém o saldo realmente registrado
        double saldoFinal = CaixaCentral.getSaldoCentral();

        // Envia os resultados para a View
        CaixaView.exibirResultado(5,1000,saldoEsperado,saldoFinal);
    }
}
