# Aula 1 — Sistemas Distribuídos

> **Professor:** Alexandre Zamberlan — `Alexz@ufn.edu.br`

## Informações da disciplina

**Estrutura dos projetos:**

* `Controller`
* `Model`
* `Service`
* `Communication` --> Quando usar Socket

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

## 1. Processo

Um **processo** é um programa em execução, com seu próprio espaço de memória.

* Possui memória própria/isolada.
* É mais pesado para criar e gerenciar.
* Processos diferentes precisam de mecanismos de comunicação para trocar dados.

---

## 2. Threads

Uma **thread** é uma unidade de execução dentro de um processo.

* Executa tarefas de forma concorrente/concomitante.
* É mais leve que um processo.
* Threads do mesmo processo podem compartilhar memória.
* Não são exclusivas de Sistemas Distribuídos.

---

## 3. Processo × Thread

| Processo | Thread |
|---|---|
| Programa em execução | Unidade de execução dentro do processo |
| Memória própria | Compartilha memória do processo |
| Mais pesado | Mais leve |
| Maior isolamento | Menor isolamento |
| Comunicação mais complexa | Comunicação mais simples |

---

## 4. Memória compartilhada

### Com memória compartilhad

É quando duas ou mais threads/processos podem acessar os mesmos dados na memória.

* Threads acessam os mesmos dados.
* Pode ocorrer **condição de corrida**.
* Pode existir **seção crítica**.
* Necessita de sincronização.

### Sem memória compartilhada

É quando cada processo/thread trabalha com dados separados, sem acessar diretamente a memória do outro.

* Dados não são compartilhados diretamente.
* Comunicação pode ser feita por **mensagens**.
* Menor risco de conflito em dados compartilhados.

---

## 5. Sincronização

Utilizada para controlar o acesso concorrente a recursos compartilhados.

**Exemplos:**
* **Monitor** = controla o acesso a uma seção crítica.
* **Semáforo** = controla o acesso a recursos através de permissões/contadores.

### Seção crítica

Parte do código que acessa um **recurso compartilhado** e precisa ser protegida.

---

## 6. Condição de corrida

Acontece quando duas ou mais threads acessam/modificam o mesmo recurso ao mesmo tempo, podendo gerar um resultado incorreto ou inesperado.

---

## 7. Deadlock

Acontece quando duas ou mais threads/processos ficam **esperando uns pelos outros** e nenhum consegue continuar.

Exemplo:

* Thread A → espera recurso B
* Thread B → espera recurso A

---
## Dicas

**Processo = programa em execução**  
**Thread = unidade de execução dentro do processo**  
**Memória compartilhada = mesmos dados**  
**Seção crítica = trecho que acessa recurso compartilhado**  
**Semáforo/Monitor = sincronização**  
**Condição de corrida = conflito**  
**Deadlock = travamento por espera**

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
