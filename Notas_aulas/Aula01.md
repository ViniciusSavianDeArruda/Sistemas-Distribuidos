# Aula 1 — Sistemas Distribuídos

> **Professor:** Alexandre Zamberlan — `Alexz@ufn.edu.br`

---

## Informações da disciplina

**Estrutura dos projetos em código:**
- `Controller`
- `Model`
- `Service`
- `Communication`

**Avaliação:**
- 20% — Participação
- 20% — Notas de aula no GitHub (`notas_aula.md`)
- 60% — Provas e trabalhos práticos

---

## 1. O que são Sistemas Distribuídos?

São sistemas em que várias máquinas trabalham juntas trocando informações pela rede.
Para funcionar bem, precisamos entender **4 pilares**:

1. Comunicação
2. Arquitetura
3. Processamento (concorrente × paralelo)
4. Cluster × Grid

---

## 2. Comunicação

### Tipos
| Tipo | Para quem envia |
|------|-----------------|
| **Unicast** | Um destinatário |
| **Multicast** | Um grupo |
| **Broadcast** | Todos |

### Comunicação bloqueante
- **Writer / Sender** → escreve/envia
- **Reader / Receiver** → lê/recebe

### Conceitos de rede
- **Modelo TCP/IP:** Aplicação → Transporte → Interface → Rede
- **Socket:** ponto de conexão entre duas máquinas
- **Porta lógica:** identifica o serviço dentro da máquina
- **Máscara/classe de rede:** define o domínio

---

## 3. Arquitetura

- **Cliente-Servidor:** um serve, outros consomem.
- **Ponto a Ponto (P2P):** todos são iguais, podem servir e consumir.

---

## 4. Threads

### O que é?
Uma **thread** é um mini processo dentro de um processo, usado para executar tarefas **ao mesmo tempo**.

### Estados de uma thread
`Execução` · `Pronto/Finalizado` · `Espera` · `Parado` · `Dormindo` · `Cancelado`

### Compartilhamento de memória

| | Com compartilhamento | Sem compartilhamento |
|---|---|---|
| Memória | Compartilhada | Isolada |
| Sincronismo | Necessário (responsabilidade do programador) | Não precisa |
| Complexidade | Alta | Baixa |
| Em Java | Interface `Runnable` | Classe `Thread` |

### Sincronismo (quando há memória compartilhada)
Ferramentas: **Monitor** e **Semáforo**.

### Por que usar threads?
- Executar tarefas **concomitantemente**.
- Em Sistemas Distribuídos: **liberar a comunicação bloqueante**.

---

## 5. Processamento: Concorrente × Paralelo

### Concorrente (Concomitante)
- **1 CPU** alternando rapidamente entre tarefas.
- Dá a **impressão** de simultaneidade.

### Paralelo
- Várias tarefas executadas **realmente ao mesmo tempo**, usando várias unidades de processamento.

**Divisão do paralelo:**

| | Fortemente acoplado | Fracamente acoplado |
|---|---|---|
| Máquina | **Mesmo** computador | **Vários** computadores em rede |
| Memória | Compartilhada | Cada um tem a sua |
| Exemplo | CPU Multicore, GPU | Cluster computacional |

---

## 6. Processo × Thread

| Característica | Processo | Thread |
|----------------|----------|--------|
| Isolamento | Sim | Não |
| Memória | Própria | Compartilhada com o processo |
| Comunicação | IPC (mais complexa) | Direta (rápida) |
| Custo de criação | Alto | Baixo |
| Robustez | Maior (falha isolada) | Menor (falha derruba o processo) |
| Uso comum | Isolar aplicações | Paralelizar tarefas |

### Exemplo prático (servidor web)
- **Com processos:** vários processos independentes atendendo clientes.
- **Com threads:** um processo com várias threads atendendo requisições.

### Em Sistemas Distribuídos
- **Processos** → podem estar em **máquinas diferentes**.
- **Threads** → vivem **dentro de um processo**, aproveitando a máquina local.

---
