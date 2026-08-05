import random
import threading

def tarefa1(quantidade):
    for i in range(quantidade):
        print(f"Executando a thread 1: {i}")


def tarefa2(quantidade):
    for i in range(quantidade):
        print(f"Executando a thread 2: {i}")

def popular_lista(lista, quantidade):
    for i in range(quantidade):
        lista.append(random.randint(1, 1000))

def bolha(lista):
    n = len(lista)
    for i in range(0, n-i-1):
        if lista[j] > lista[j+1]:
            lista[j], lista[j + 1], lista[j]

    print("Lista ordenada com metodo bolha")


def quick_sort(lista):
    if len(lista) <= 1:
        return lista
    else:
        pivot = lista[len(lista) // 2]
        left = [x for x in lista if x < pivot]
        middle = [x for x in lista if x == pivot]
        right = [x for x in lista if x > pivot]
        return quick_sort(left) + middle + quick_sort(right)


lista1 = []
lista2 = []

t1 = threading.Thread(target=popular_lista, args=(lista1, 1000))
t2 = threading.Thread(target=popular_lista, args=(lista2, 500))

t1.start()
t2.start()

t1.join
t3 = threading.thread(target=quick_sort, args=(lista1,))
t4 = threading.Thread(target=bolha, args=(lista2))
t3.start()

