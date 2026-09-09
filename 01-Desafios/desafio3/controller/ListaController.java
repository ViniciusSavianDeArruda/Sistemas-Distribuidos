package Desafios.desafio3.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Desafios.desafio3.model.Utilidades;
import Desafios.desafio3.view.ExibicaoView;

/**
 * Controller responsável por controlar a execução do programa.
 */
public class ListaController {

    /**
     * Executa o processamento do exercício.
     */
    public void executarProcessamento() {

        List<Integer> numeros = new ArrayList<>();
        List<String> nomes = new ArrayList<>();

        /*
         * Thread responsável por ler os números.
         */
      Thread threadNumeros = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    Utilidades.lerNumeros("Desafios/desafio3/data/numeros.txt", numeros);

                } catch (IOException e) {
                    System.out.println("Erro ao ler o arquivo de números.");
                }
            }
        });

        /*
         * Thread responsável por ler os nomes.
         */
        Thread threadNomes = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                   Utilidades.lerNomes("Desafios/desafio3/data/nomes.txt", nomes);

                } catch (IOException e) {
                    System.out.println("Erro ao ler o arquivo de nomes.");
                }
            }
        });

        // Inicia as Threads de leitura.
        threadNumeros.start();
        threadNomes.start();

        /*
         * Aguarda as Threads de leitura terminarem.
         */
        try {

            threadNumeros.join();
            threadNomes.join();

        } catch (InterruptedException e) {

            System.out.println("Thread interrompida.");
        }

        /*
         * Thread responsável por exibir os números.
         */
        Thread threadExibirNumeros = new Thread(new Runnable() {

            @Override
            public void run() {

                ExibicaoView.exibirListaInteiros(numeros, "Lista de números:");
            }
        });

        /*
         * Thread responsável por exibir os nomes.
         */
        Thread threadExibirNomes = new Thread(new Runnable() {

            @Override
            public void run() {

                ExibicaoView.exibirListaNomes(nomes, "Lista de nomes:");
            }
        });

        // Inicia as Threads de exibição.
        threadExibirNumeros.start();
        threadExibirNomes.start();

        /*
         * Aguarda as Threads de exibição terminarem.
         */
        try {

            threadExibirNumeros.join();
            threadExibirNomes.join();

        } catch (InterruptedException e) {

            System.out.println("Thread de exibição interrompida.");
        }
    }
}
