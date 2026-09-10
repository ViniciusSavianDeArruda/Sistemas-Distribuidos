import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExemploPool {

    public static void main(String[] args) {

        // Criamos um pool de threads com capacidade para N tarefas ao mesmo tempo
        int N = 5;
        int tamanhoLista = 20;

        ExecutorService pool = Executors.newFixedThreadPool(N);

        for (int i = 1; i <= N; i++) {

            final int idTarefa = i;

            pool.execute(() -> {

                // Cada thread cria sua própria lista
                // Não existe memória compartilhada entre as tarefas
                List<Integer> lista = new ArrayList<>();

                Random random = new Random();

                // 1. Popular a lista de forma aleatória
                for (int j = 0; j < tamanhoLista; j++) {
                    lista.add(random.nextInt(100));
                }

                // 2. Exibir lista original
                System.out.println(
                    "Tarefa " + idTarefa + " (Original): " + lista
                );

                // 3. Ordenar a lista
                Collections.sort(lista);

                // 4. Exibir lista ordenada
                System.out.println(
                    "Tarefa " + idTarefa + " (Ordenada): " + lista
                );
            });
        }

        // Fecha o pool após enviar todas as tarefas
        pool.shutdown();
    }
}