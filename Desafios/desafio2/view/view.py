def mostrar_resultado(lista):
    print("=== USUÁRIOS LIMPOS ===")
    print(f"Total de usuários: {len(lista)}")
    print()

    for nome in lista:
        print(nome.strip())
