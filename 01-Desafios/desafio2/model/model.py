import threading


def limpar(lista):
    resultado = []

    for nome in lista:
        resultado.append(nome.strip().upper())

    return resultado


def processar(lista):
    metade = len(lista) // 2

    parte_a = lista[:metade]
    parte_b = lista[metade:]

    resultado_a = []
    resultado_b = []

    thread_a = threading.Thread(
        target=lambda: resultado_a.extend(limpar(parte_a))
    )

    thread_b = threading.Thread(
        target=lambda: resultado_b.extend(limpar(parte_b))
    )

    thread_a.start()
    thread_b.start()

    thread_a.join()
    thread_b.join()

    return resultado_a + resultado_b
