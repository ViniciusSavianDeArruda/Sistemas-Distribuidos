
package model;
/**
 * Model responsável pelo saldo centralizado do evento.
 */
public class CaixaCentral {

    /**
     * Saldo compartilhado entre os caixas.
     */
    public static double saldo_central = 0.0;

    /**
     * Adiciona o valor da venda ao saldo.
     *
     */
    public static synchronized void registrarVenda(double valor) {
        saldo_central += valor;
    }

    /**
     * Retorna o saldo final.
     *
     */
    public static double getSaldoCentral() {
        return saldo_central;
    }
}
