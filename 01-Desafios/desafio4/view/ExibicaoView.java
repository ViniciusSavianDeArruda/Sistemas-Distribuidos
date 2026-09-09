package Desafios.desafio4.view;

import java.util.List;

/**
 * Classe responsável pela exibição dos dados.
 */
public class ExibicaoView {

    /**
     * Exibe uma lista de números inteiros.
     */
    public static void exibirLista(List<Integer> lista, String frase) {

        System.out.println(frase);

        for (Integer numero : lista) {
            System.out.println(numero);
        }

        System.out.println("Total de registros: " + lista.size());
    }
}
