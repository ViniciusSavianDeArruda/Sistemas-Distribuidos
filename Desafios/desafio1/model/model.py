import threading


def somar(lista, resultados, indice):
    resultados[indice] = sum(lista)


def processar(lista):
    partes = [
        lista[0:2500],
        lista[2500:5000],
        lista[5000:7500],
        lista[7500:10000]
    ]

    resultados = [0, 0, 0, 0]
    threads = []

    for i in range(4):
        thread = threading.Thread(
            target=somar,
            args=(partes[i], resultados, i)
        )

        threads.append(thread)
        thread.start()

    for thread in threads:
        thread.join()

    return resultados
