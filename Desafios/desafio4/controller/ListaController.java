package Desafios.desafio4.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Desafios.desafio4.model.Utilidades;
import Desafios.desafio4.view.ExibicaoView;

/**
 * Controller responsável por controlar a execução do programa.
 */
public class ListaController {

    /**
     * Executa o processamento do exercício.
     */
    public void executarProcessamento() {

        List<Integer> numeros = new ArrayList<>();

        /*
         * Thread responsável por ler o primeiro arquivo.
         */
        Thread threadNumeros1 = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    Utilidades.lerNumeros(
                        "Desafios/desafio4/data/numeros1.txt",numeros);
                } catch (IOException e) {
                    System.out.println("Erro ao ler o arquivo numeros1.txt.");
                }
            }
        });

        /*
         * Thread responsável por ler o segundo arquivo.
         */
        Thread threadNumeros2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Utilidades.lerNumeros(
                            "Desafios/desafio4/data/numeros2.txt",numeros);
                } catch (IOException e) {
                    System.out.println("Erro ao ler o arquivo numeros2.txt.");
                }
            }
        });

        // Inicia as Threads de leitura.
        threadNumeros1.start();
        threadNumeros2.start();

        /*
         * Aguarda as duas Threads terminarem.
         */
        try {

            threadNumeros1.join();
            threadNumeros2.join();

        } catch (InterruptedException e) {

            System.out.println("Thread interrompida.");
        }

        /*
         * Exibe a lista que recebeu os números
         * dos dois arquivos.
         */
        ExibicaoView.exibirLista(numeros, "Lista de números:");
    }
}
