def mostrar_resultado(resultados):
    for i in range(4):
        print(f"Thread {i + 1}: {resultados[i]}")

    print(f"Soma total: {sum(resultados)}")
