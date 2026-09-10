from concurrent.futures import ThreadPoolExecutor
import random


tamanho_lista = 20


def processar_lista(id_tarefa):
    # Cada tarefa tem sua própria lista isolada

    # 1. Popular a lista de forma aleatória
    lista = [random.randint(1, 100) for _ in range(tamanho_lista)]

    # 2. Exibir lista original
    print(f"Tarefa {id_tarefa} (Original): {lista}")

    # 3. Ordenar a lista
    lista.sort()

    # 4. Exibir lista ordenada
    print(f"Tarefa {id_tarefa} (Ordenada): {lista}")


# Criamos o pool limitando o máximo de trabalhadores em 5
N = 5

with ThreadPoolExecutor(max_workers=N) as pool:

    for i in range(1, N + 1):
        pool.submit(processar_lista, i)