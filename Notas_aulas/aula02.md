## Aula 2

# Para que usar Sistemas distribuidos ?
 - Para compartilhar recursos seja de alta complexidade ou de baixa complexidade

# Como Sistemas Distribuidos opera ?
 - Comunicacao de dados = Bytes

# Therads 
**O que sao**?
- Mini processos dentro de processos para realizar tarefas ou rotinas de forma concomitante 
- Existe so em Sistemas Distribuidos 

**para que servem**?
- circundam rotinas ou tarefas para essas possam executar concomitantemente

**Em quais tarefas as threads são mais adequadas**?
    - mineração
    - tratamento de dados
    - análise de dados
    - rotinas que não possuam seção crítica 

**ipos de threads**
    - **Sem memória compartilhada:** não possuem seção crítica e são mais simples de gerenciar.
    - **Com memória compartilhada:** possuem seção crítica, necessitam de sincronização e são mais complexas, pois podem ocorrer conflitos no acesso aos dados.

## Processo
Um processo pode criar threads de diferentes formas:

- **Thread (classe):** geralmente associada a exemplos sem memória compartilhada.
- **Runnable (interface):** geralmente utilizada quando há memória compartilhada entre as threads.
