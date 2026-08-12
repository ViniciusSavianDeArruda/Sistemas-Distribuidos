import random
from model import processar
from view import mostrar_resultado


def executar():
    lista = [random.randint(1, 100) for _ in range(10000)]

    resultados = processar(lista)

    mostrar_resultado(resultados)
