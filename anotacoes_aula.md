# Aula 1 — Sistemas Distribuídos

> **Professor:** Alexandre Zamberlan — `Alexz@ufn.edu.br`

## Informações da disciplina

**Estrutura dos projetos:**

* `Controller`
* `Model`
* `Service`
* `Communication`

**Avaliação:**

* 20% — Participação
* 20% — Notas de aula no GitHub
* 60% — Provas e trabalhos práticos

---

## 1. O que são Sistemas Distribuídos?

Conjunto de **computadores independentes** que trabalham juntos através de uma rede, apresentando-se como um **sistema único**.

**Objetivos:**

* Transparência --> **Usuário não precisa saber como/onde funciona**
* Confiabilidade --> **Sistema continua funcionando mesmo com falhas**
* Escalabilidade --> **Sistema consegue crescer**
* Compartilhamento de recursos --> **Vários usuários/processos utilizam recursos**

**Exemplos:** Netflix, Google Drive, WhatsApp, Blockchain.

---

## 2. Comunicação

| Tipo          | Para quem envia |
| ------------- | --------------- |
| **Unicast**   | Um destinatário |
| **Multicast** | Um grupo        |
| **Broadcast** | Todos           |

### Síncrona × Assíncrona

* **Síncrona:** envia e espera resposta → bloqueante.
* **Assíncrona:** envia e continua execução das terefas → não bloqueante.

### Conceitos de rede

* **Socket:** ponto de comunicação entre aplicações.
* **Porta:** identifica o serviço/aplicação.
* **TCP/IP:** conjunto de protocolos para comunicação em rede.

---

## 3. Arquitetura

* **Cliente-Servidor:** servidor atende vários clientes. Ex: Gmail.
* **P2P:** nós podem atuar como cliente e servidor. Ex: BitTorrent.

---

# Aula 2 — Threads e Processos

## 1. Threads

Uma **thread** é uma unidade de execução dentro de um processo, utilizada para executar tarefas de forma concorrente/concomitante.

### Para que servem?

* Executar tarefas concorrentemente.
* Tratamento e análise de dados.
* Processamento de várias tarefas.

> Threads não são exclusivas de Sistemas Distribuídos.

---

## 2. Memória compartilhada

### Com memória compartilhada

* Threads acessam os mesmos dados.
* Pode ocorrer conflito/condição de corrida.
* Pode existir **seção crítica**.
* Necessita de sincronização.

### Sem memória compartilhada

* Dados não são compartilhados diretamente.
* Comunicação pode ser feita por **mensagens**.
* Menor risco de conflito em dados compartilhados.

---

## 3. Sincronização

Utilizada para controlar o acesso concorrente a recursos compartilhados.

**Exemplos:**

* Monitor = 
* Semáforo

### Seção crítica

Parte do código que acessa um recurso compartilhado e precisa ser protegida por monitor ou semafo.

---

## 4. Processo × Thread

| Processo                  | Thread                          |
| ------------------------- | ------------------------------- |
| Maior isolamento          | Menor isolamento                |
| Memória própria           | Compartilha memória do processo |
| Mais pesado               | Mais leve                       |
| Comunicação mais complexa | Comunicação mais simples        |

---

# Aula 3 — Identificação de Threads

Uma thread pode ser identificada por:

* **ID**
* **Nome**
* **Thread atual**

### Java

```java
Thread.currentThread()
```

* Nome: `.getName()`
* ID: `.getId()`

### C#

```csharp
Thread.CurrentThread
```

* Nome: `.Name`
* ID: `.ManagedThreadId`

### Python

```python
threading.current_thread()
```

* Nome: `.name`
* ID: `threading.get_ident()`

---

# Aula 4 — Threads, MVC e Sincronização

Trabalho avaliativo sobre:

* Threads
* Memória compartilhada e não compartilhada
* Concorrência
* Sincronização
* `join()`
* MVC

### `join()`

Faz uma thread esperar outra terminar.

```java
thread.join();
```

### MVC

* **Model:** dados/regras.
* **View:** interface.
* **Controller:** recebe ações e coordena o sistema.

Objetivo: **separar responsabilidades e organizar o código.**

---

# Aula 5 — Pool de Threads

## Pool de Threads

Conjunto de threads utilizado para executar várias tarefas de forma controlada.

### Vantagens

* Controla a quantidade de threads.
* Evita criação excessiva.
* Reutiliza threads.
* Melhora o gerenciamento dos recursos.

### Java

* `ExecutorService`
* `FixedThreadPool`

### Python

* `ThreadPoolExecutor`

---

# Conteúdo adicional 

## 1. Concorrência × Paralelismo

### Concorrência

Tarefas progridem de forma **intercalada**.

### Paralelismo

Tarefas são executadas **realmente ao mesmo tempo**, utilizando múltiplas unidades de processamento.

> **Concorrência = intercalado**
> **Paralelismo = simultâneo**

---

## 2. Relógios Físicos × Lógicos

### Relógio físico

* Baseado no **tempo real**.
* Busca sincronizar os relógios das máquinas.
* Exemplo: **NTP**.

### Relógio lógico

* Não representa a hora real.
* Determina a **ordem dos eventos**.
* Exemplo: **Lamport**.

> **Físico = que horas são?**
> **Lógico = qual evento aconteceu primeiro?**

---

## 3. Lamport

Cada processo possui um **contador lógico**.

* Evento local → incrementa contador.
* Envio → incrementa e envia o contador.
* Recebimento → `max(local, recebido) + 1`.

**Objetivo:** determinar a **ordem causal dos eventos**.

---

## 4. Exclusão Mútua

Garante que **apenas um processo/thread por vez** acesse uma seção crítica ou recurso compartilhado.

**Objetivo:** evitar conflitos no acesso aos recursos.

```text
P1 → entra → usa → sai
P2 → entra → usa → sai
```

---

## 5. Eleição

Processo utilizado para escolher um **coordenador/líder** entre os processos.

Se o coordenador falhar:

```text
Coordenador → ❌
       ↓
Eleição
       ↓
Novo coordenador
```

**Objetivo:** escolher um novo processo para coordenar o sistema.

---

## 6. Falhas

* **Comunicação:** perda de pacotes/conexão.
* **Processo:** servidor/processo para de funcionar.
* **Hardware:** falha física, energia, disco etc.

---

## 7. Escalabilidade

Capacidade de suportar o crescimento de usuários, dados ou processos.

**Técnicas:**

* Replicação
* Balanceamento de carga
* Particionamento de dados

---
