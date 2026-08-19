package Desafios.desafio4.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Classe responsável pela manipulação dos dados dos arquivos.
 */
public class Utilidades {

    /**
     * Lê um arquivo contendo números inteiros,um número por linha, e adiciona os valores
     * encontrados em uma lista.
     */
    public static void lerNumeros(String caminhoArquivo, List<Integer> lista)
            throws IOException {

        BufferedReader leitor = new BufferedReader(
                new FileReader(caminhoArquivo));

        String linha;

        while ((linha = leitor.readLine()) != null) {

            if (!linha.trim().isEmpty()) {
                lista.add(Integer.parseInt(linha.trim()));
            }
        }

        leitor.close();
    }
}
