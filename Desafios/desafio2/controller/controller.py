from model import processar
from view import mostrar_resultado


def executar():
    with open("usuarios.txt", "r", encoding="utf-8") as arquivo:
        lista = arquivo.readlines()

    resultado = processar(lista)

    mostrar_resultado(resultado)
