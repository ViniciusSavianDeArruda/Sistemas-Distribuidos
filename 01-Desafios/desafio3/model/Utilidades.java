package Desafios.desafio3.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Classe responsável pelas operações relacionadas à manipulação
 * e carregamento dos dados dos arquivos.
 */
public class Utilidades {

    /**
     * Lê um arquivo contendo números inteiros, um número por linha,
     * e adiciona os valores encontrados em uma lista de inteiros.
     */
    public static void lerNumeros(
            String caminhoArquivo, List<Integer> lista) throws IOException {

        try (BufferedReader leitor = new BufferedReader(
                new FileReader(caminhoArquivo))) {

            String linha;

            while ((linha = leitor.readLine()) != null) {

                if (!linha.trim().isEmpty()) {
                    lista.add(Integer.parseInt(linha.trim()));
                }
            }
        }
    }

    /**
     * Lê um arquivo contendo nomes, um nome por linha,
     * e adiciona os valores encontrados em uma lista de Strings.
     */
    public static void lerNomes(
            String caminhoArquivo,
            List<String> lista) throws IOException {

        try (BufferedReader leitor = new BufferedReader(
                new FileReader(caminhoArquivo))) {

            String linha;

            while ((linha = leitor.readLine()) != null) {

                if (!linha.trim().isEmpty()) {
                    lista.add(linha.trim());
                }
            }
        }
    }
}
