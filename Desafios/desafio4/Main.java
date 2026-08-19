package Desafios.desafio4;

import Desafios.desafio4.controller.ListaController;

/**
 * Classe principal da aplicação.
 */
public class Main {

    /**
     * Método principal responsável por iniciar o programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {

        ListaController controller = new ListaController();

        controller.executarProcessamento();
    }
}
