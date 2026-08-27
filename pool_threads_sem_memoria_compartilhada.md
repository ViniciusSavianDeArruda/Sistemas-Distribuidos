# Pool de Threads SEM MEMÓRIA COMPARTILHADA

Para exemplos, foi utilizado lista.

## Java (usando ExecutorService)
No Java, usamos o ExecutorService com um número fixo de trabalhadores para criar o nosso pool.

```java
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
                // Cada thread cria sua própria lista (sem memória compartilhada)
                List<Integer> lista = new ArrayList<>();
                Random random = new Random();

                // 1. Popular de forma aleatória
                for (int j = 0; j < tamanhoLista; j++) {
                    lista.add(random.nextInt(100));
                }

                // 2. Exibir lista original
                System.out.println("Tarefa " + idTarefa + " (Original): " + lista);

                // 3. Ordenar
                Collections.sort(lista);

                // 4. Exibir lista ordenada
                System.out.println("Tarefa " + idTarefa + " (Ordenada): " + lista);
            });
        }

        // Fecha o pool após terminar as tarefas
        pool.shutdown();
    }
}

```

## Python (usando ThreadPoolExecutor)
No Python, a biblioteca concurrent.futures é o mecanismo para gerenciar o pool.

```python
from concurrent.futures
import ThreadPoolExecutor
import random

def processar_lista(id_tarefa):
    # Cada tarefa tem sua própria lista isolada
    # 1. Popular de forma aleatória
    lista = [random.randint(1, 100) for _ in range(tamanho_lista)]

    # 2. Exibir lista original
    print(f"Tarefa {id_tarefa} (Original): {lista}")

    # 3. Ordenar
    lista.sort()

    # 4. Exibir lista ordenada
    print(f"Tarefa {id_tarefa} (Ordenada): {lista}")

# Criamos o pool limitando o máximo de trabalhadores em 5
N = 5
tamanho_lista = 20
with ThreadPoolExecutor(max_workers=N, tamanho=tamanho_lista) as pool:
    for i in range(1, N+1):
        pool.submit(processar_lista, i)
```
