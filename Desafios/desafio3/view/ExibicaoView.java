package Desafios.desafio3.view;

import java.util.List;

/**
 * Classe responsável pela apresentação dos dados no console.
 */
public class ExibicaoView {

    /**
     * Exibe uma lista de inteiros no console.
     */
    public static void exibirListaInteiros(
            List<Integer> lista, String frase) {

        System.out.println(frase);

        for (Integer numero : lista) {
            System.out.println(numero);
        }

        System.out.println("Total de registros: " + lista.size());
    }

    /**
     * Exibe uma lista de nomes no console.
     *
     */
    public static void exibirListaNomes(
            List<String> lista, String frase) {

        System.out.println(frase);

        for (String nome : lista) {
          System.out.println(nome);
        }

        System.out.println("Total de registros: " + lista.size());
    }
}
