# Sistemas Distribuídos

## Aula 1

### Professor
- Alexandre Zamberlan
- E-mail: Alexz@ufn.edu.br

### Organização dos projetos
- Utilizar a seguinte estrutura nas atividades em código:
  - Controller
  - Model
  - Service
  - Communication

---

## Processo de Avaliação

- 20% da nota: participação efetiva.
- 20% da nota: notas de aula (GitHub pessoal).
  - Criar um arquivo chamado `notas_aula.md`.
- 60% da nota: provas e trabalhos práticos.

---

## Conteúdo da Aula

### Conceitos básicos de Sistemas Distribuídos (SD)

- Comunicação
- Arquitetura
- Processamento concomitante × processamento paralelo
- Cluster × Grid

---

## Comunicação

- Tipos de comunicação:
  - Broadcast
  - Multicast
  - Unicast

- Comunicação bloqueante:
  - Escrever (**Writer** ou **Sender**)
  - Ler (**Reader** ou **Receiver**)

- Modelo TCP/IP
  - Aplicação
  - Transporte
  - Interface
  - Rede

- Máscara ou classe de rede e domínio.
- Socket.
- Porta lógica.

---

## Arquitetura

- Cliente-Servidor
- Ponto a Ponto (Peer-to-Peer)

---

## Threads

### Conceitos

- Thread é um subprocesso (ou mini processo) pertencente a um processo.
- É criada em tempo de programação/execução.
- Sua finalidade é garantir processamento concomitante/paralelo.

### Estados da Thread

- Execução
- Finalizado/Pronto
- Espera/Aguardando
- Parado
- Dormindo
- Cancelado

### Sincronismo

Há comandos que garantem o **SINCRONISMO** do processamento.

### Compartilhamento de memória

#### Com compartilhamento

- O processamento é bloqueante.
- O **PROGRAMADOR** é responsável por garantir o sincronismo.

#### Sem compartilhamento

- Não compartilha memória/recurso.

### Threads em Java

- A JVM permite processamento concomitante.
- Com compartilhamento de memória:
  - Interface `Runnable`
- Sem compartilhamento de memória:
  - Classe `Thread`

---

## Programação Multitarefa (Thread)

- Thread é um mini processo dentro de um processo.
- Pode ser com memória compartilhada.
  - Sincronismo
    - Monitor
    - Semáforo
- Pode ser sem memória compartilhada.

### Importância

- Executar processos concomitantemente.
- Em Sistemas Distribuídos, liberar comunicação bloqueante.

---

# Processamento Concomitante × Processamento Paralelo

## Processamento Concomitante (Concorrente)

- Um Sistema Operacional gerencia várias tarefas.
- Normalmente utiliza apenas uma CPU.
- Alterna rapidamente entre as tarefas.
- Dá a impressão de que tudo acontece ao mesmo tempo.

**Palavra-chave:** Alternância.

**Exemplo:** ouvir música enquanto navega na internet.

---

## Processamento Paralelo

- Várias tarefas são executadas simultaneamente.
- Utiliza várias unidades de processamento.

### Fortemente acoplado

- Mesmo computador.
- Compartilha memória.

**Exemplos**
- CPU Multicore
- GPU

**Palavra-chave:** Mesmo computador.

### Fracamente acoplado

- Vários computadores conectados em rede.
- Cada computador possui CPU e memória próprias.

**Exemplo**
- Cluster computacional.

**Palavra-chave:** Vários computadores.

---

## Resumo

- **Concomitante** = Sistema Operacional + alternância de tarefas + CPU.
- **Paralelo** = execução simultânea.
- **Fortemente acoplado** = CPU Multicore + GPU.
- **Fracamente acoplado** = Cluster computacional.

---

# Diferença entre Processo e Thread

## Processo

- Instância independente de um programa em execução.
- Possui espaço de memória próprio.
- Possui recursos próprios.
- Comunicação entre processos (IPC) é mais complexa.
- Se um processo falhar, normalmente não afeta os demais.

### Exemplo

Um servidor web pode executar vários processos para atender clientes simultaneamente.

---

## Thread

- Unidade de execução dentro de um processo.
- Compartilha memória e recursos do processo.
- Comunicação entre threads é rápida.
- Se uma thread falhar, pode comprometer todo o processo.

### Exemplo

Um servidor web pode utilizar várias threads para atender diversas requisições simultaneamente.

---

## Comparativo

| Característica | Processo | Thread |
|---------------|-----------|---------|
| Isolamento | Sim | Não |
| Comunicação | IPC | Compartilhamento direto |
| Custo de criação | Alto | Baixo |
| Robustez | Maior | Menor |
| Uso comum | Isolar aplicações | Paralelizar tarefas |

---

## Em Sistemas Distribuídos

- **Processos** podem estar em máquinas diferentes, executando partes da aplicação.
- **Threads** normalmente são utilizadas dentro de um processo para aproveitar melhor os recursos da máquina local.
