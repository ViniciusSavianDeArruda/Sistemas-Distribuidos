# Aula 2 — Sistemas Distribuídos

## Para que usar Sistemas Distribuídos?

- Para compartilhar recursos, sejam eles de alta ou de baixa complexidade.

## Como Sistemas Distribuídos operam?

- Através de comunicação de dados (troca de **bytes**).

---

## Threads

### O que são?

- Mini processos dentro de processos, criados para realizar tarefas ou rotinas de forma **concomitante**.
- Existem apenas em Sistemas Distribuídos.

### Para que servem?

- Circundam rotinas ou tarefas para que essas possam ser executadas de forma concomitante.

### Em quais tarefas as threads são mais adequadas?

- Mineração
- Tratamento de dados
- Análise de dados
- Rotinas que não possuam seção crítica

### Tipos de threads

- **Sem memória compartilhada:** não possuem seção crítica e são mais simples de gerenciar.
- **Com memória compartilhada:** possuem seção crítica, necessitam de sincronização e são mais complexas, pois podem ocorrer conflitos no acesso aos dados.

---

## Processo

Um processo pode criar threads de diferentes formas:

- **Thread (classe):** geralmente associada a exemplos **sem** memória compartilhada.
- **Runnable (interface):** geralmente utilizada quando há memória compartilhada entre as threads.
