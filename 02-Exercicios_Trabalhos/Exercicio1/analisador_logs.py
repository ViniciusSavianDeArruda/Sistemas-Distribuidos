from concurrent.futures import ThreadPoolExecutor
from pathlib import Path


def processar_pedaco(linhas):
    erros_nivel_1 = 0
    erros_nivel_2 = 0
    erros_nivel_3 = 0

    for linha in linhas:
        partes = linha.strip().split(",")

        if len(partes) < 3:
            continue

        nivel = partes[2].replace("*", "").strip()

        if nivel == "1":
            erros_nivel_1 += 1

        elif nivel == "2":
            erros_nivel_2 += 1

        elif nivel == "3":
            erros_nivel_3 += 1

    return {
        "linhas": len(linhas),
        "nivel_1": erros_nivel_1,
        "nivel_2": erros_nivel_2,
        "nivel_3": erros_nivel_3
    }


def criar_pedacos(caminho, tamanho_pedaco):
    pedaco = []

    with open(caminho, "r", encoding="utf-8") as arquivo:
        for linha in arquivo:
            if linha.strip():
                pedaco.append(linha)

            if len(pedaco) == tamanho_pedaco:
                yield pedaco
                pedaco = []

        if pedaco:
            yield pedaco


def main():
    num_threads = 4
    tamanho_pedaco = 20
    arquivo_log = "erro.log"

    caminho = Path(arquivo_log)

    if not caminho.exists():
        print(f"Arquivo não encontrado: {arquivo_log}")
        return

    total_linhas = 0
    total_nivel_1 = 0
    total_nivel_2 = 0
    total_nivel_3 = 0
    total_pedacos = 0

    with ThreadPoolExecutor(max_workers=num_threads) as pool:

        resultados = pool.map(
            processar_pedaco,
            criar_pedacos(caminho, tamanho_pedaco)
        )

        for resultado in resultados:
            total_linhas += resultado["linhas"]
            total_nivel_1 += resultado["nivel_1"]
            total_nivel_2 += resultado["nivel_2"]
            total_nivel_3 += resultado["nivel_3"]
            total_pedacos += 1

    total_erros = (
        total_nivel_1 +
        total_nivel_2 +
        total_nivel_3
    )

    print("\nRESULTADO FINAL")
    print(f"Total de pedaços: {total_pedacos}")
    print(f"Total de linhas: {total_linhas}")
    print(f"Erros nível 1: {total_nivel_1}")
    print(f"Erros nível 2: {total_nivel_2}")
    print(f"Erros nível 3: {total_nivel_3}")
    print(f"Total de erros: {total_erros}")


if __name__ == "__main__":
    main()
