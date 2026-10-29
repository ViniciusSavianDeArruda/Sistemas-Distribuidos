# Sistemas Distribuídos — Resumo das Aulas

> **Professor:** Alexandre Zamberlan — `Alexz@ufn.edu.br`

## Informações da disciplina

### Estrutura dos projetos

- `Controller`
- `Model`
- `Service`
- `Communication` (quando usar socket)

### Avaliação

- **20%** — Participação
- **20%** — Notas de aula no GitHub
- **60%** — Provas e trabalhos práticos

---

## Aula 1 — Sistemas Distribuídos

## 1. O que são Sistemas Distribuídos?

Conjunto de **computadores independentes** que trabalham juntos através de uma rede, apresentando-se como um **sistema único**.

### Objetivos

- **Transparência** → usuário não precisa saber como/onde funciona
- **Confiabilidade** → sistema continua funcionando mesmo com falhas
- **Escalabilidade** → sistema consegue crescer
- **Compartilhamento de recursos** → vários usuários/processos utilizam recursos

### Exemplos

Netflix, Google Drive, WhatsApp, Blockchain.

---

## 2. Comunicação

| Tipo | Para quem envia |
|---|---|
| **Unicast** | Um destinatário |
| **Multicast** | Um grupo |
| **Broadcast** | Todos |

### Síncrona × Assíncrona

- **Síncrona:** envia e espera resposta (bloqueante).
- **Assíncrona:** envia e continua execução das tarefas (não bloqueante).

### Conceitos de rede

- **Socket:** ponto de comunicação entre aplicações.
- **Porta:** identifica o serviço/aplicação.
- **TCP/IP:** conjunto de protocolos para comunicação em rede.
- **Máscara de rede:** define a divisão entre rede e dispositivos.

---

## 3. Arquitetura

- **Cliente-Servidor:** servidor atende vários clientes. Ex.: Gmail.
- **P2P:** nós podem atuar como cliente e servidor. Ex.: BitTorrent.

---

## 4. Sistemas Paralelos

Utilizam múltiplos recursos de processamento para executar tarefas.

### Homogêneos

- Hardware, sistema operacional e linguagens de programação iguais ou semelhantes.

### Fortemente acoplados

- Processadores/máquinas trabalham de forma próxima.
- Utilizam comunicação por rede e protocolos TCP/IP.
- Envolve endereço de rede, porta lógica, máscara e protocolos de transporte.

### Cluster

Conjunto de computadores trabalhando juntos para realizar processamento.

### Cluster × Grid

- **Cluster:** computação paralela.
- **Grid:** computação distribuída/concomitante.

### Programação

- **Concomitante:** Threads.
- **Paralela:** CUDA, OpenMP, MPI.

---

## Aula 2 — Threads e Processos

## 1. Processo

Um **processo** é um programa em execução, com seu próprio espaço de memória.

- Possui memória própria/isolada.
- É mais pesado para criar e gerenciar.
- Processos diferentes precisam de mecanismos de comunicação para trocar dados.

---

## 2. Threads

Uma **thread** é uma unidade de execução dentro de um processo.

- Executa tarefas de forma concorrente/concomitante.
- É mais leve que um processo.
- Threads do mesmo processo podem compartilhar memória.
- Não são exclusivas de Sistemas Distribuídos.
- Podem receber uma rotina e parâmetros.

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

### Com memória compartilhada

É quando duas ou mais threads/processos podem acessar os mesmos dados na memória.

- Threads acessam os mesmos dados.
- Pode ocorrer **condição de corrida**.
- Pode existir **seção crítica**.
- Necessita de sincronização.

### Sem memória compartilhada

É quando cada processo/thread trabalha com dados separados, sem acessar diretamente a memória do outro.

- Dados não são compartilhados diretamente.
- Comunicação pode ser feita por **mensagens**.
- Menor risco de conflito em dados compartilhados.

---

## 5. Sincronização

Utilizada para controlar o acesso concorrente a recursos compartilhados.

### Exemplos

- **Monitor:** controla o acesso a uma seção crítica.
- **Semáforo:** controla o acesso a recursos através de permissões/contadores.

### Seção crítica

Parte do código que acessa um **recurso compartilhado** e precisa ser protegida.

### Exclusão mútua

Garante que **apenas uma thread/processo por vez** acesse uma seção crítica ou recurso compartilhado.

---

## 6. Condição de corrida

Acontece quando duas ou mais threads acessam/modificam o mesmo recurso ao mesmo tempo, podendo gerar um resultado incorreto ou inesperado.

---

## 7. Deadlock

Acontece quando duas ou mais threads/processos ficam **esperando uns pelos outros** e nenhum consegue continuar.

Exemplo:

- Thread A → espera recurso B
- Thread B → espera recurso A

---

## 8. Relógios

### Relógio físico

- Baseado no **tempo real**.
- Busca sincronizar os relógios das máquinas.
- Exemplo: **NTP**.

### Relógio lógico

- Não representa a hora real.
- Determina a **ordem dos eventos**.
- Exemplo: **Lamport**.

> **Físico = que horas são?**
> **Lógico = qual evento aconteceu primeiro?**

---

## 9. Lamport

Cada processo possui um **contador lógico**.

- Evento local → incrementa contador.
- Envio → incrementa e envia o contador.
- Recebimento → `max(local, recebido) + 1`.

**Objetivo:** determinar a **ordem causal dos eventos**.

---

## Aula 3 — Identificação de Threads

Uma thread pode ser identificada por:

- **ID**
- **Nome**
- **Thread atual**

### Java

```java
Thread.currentThread();
String nome = Thread.currentThread().getName();
long id = Thread.currentThread().getId();
```

### C#

```csharp
Thread t = Thread.CurrentThread;
string nome = t.Name;
int id = t.ManagedThreadId;
```

### Python

```python
import threading

t = threading.current_thread()
nome = t.name
id_thread = threading.get_ident()
```

---

## Aula 4 — Threads, MVC e Sincronização

Trabalho avaliativo sobre:

- Threads
- Memória compartilhada e não compartilhada
- Concorrência
- Sincronização
- `join()`
- MVC

### join()

Faz uma thread esperar outra terminar.

```java
thread.join();
```

### MVC

- **Model:** dados e regras de negócio.
- **View:** interface.
- **Controller:** recebe ações e coordena o sistema.

**Objetivo:** separar responsabilidades e organizar o código.

---

## Aula 5 — Pool de Threads

## Pool de Threads

Conjunto de threads utilizado para executar várias tarefas de forma controlada.

### Vantagens

- Controla a quantidade de threads.
- Evita criação excessiva.
- Reutiliza threads.
- Melhora o gerenciamento dos recursos.

### Java

- `ExecutorService`
- `FixedThreadPool`

### Python

- `ThreadPoolExecutor`

---

## Conteúdos adicionais

## 1. Tolerância a Falhas

Capacidade do sistema de continuar funcionando mesmo quando ocorre uma falha.

### Tipos de falha

- **Comunicação:** perda de pacotes/conexão.
- **Processo:** servidor/processo para de funcionar.
- **Hardware:** falha física, energia, disco etc.

---

## 2. Escalabilidade

Capacidade de suportar o crescimento de:

- Usuários
- Dados
- Processos
- Processamento

### Técnicas

- Replicação
- Balanceamento de carga
- Particionamento de dados

---

## 3. Segurança

Proteção dos dados, recursos e comunicação contra acessos ou ações não autorizadas.

---

## 4. Manutenção/Atualização

Permite corrigir, atualizar ou modificar componentes do sistema sem comprometer seu funcionamento.

---

## 5. Eleição

Processo utilizado para escolher um coordenador/líder entre os processos.

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

## Dicas rápidas

- **Processo** = programa em execução
- **Thread** = unidade de execução dentro do processo
- **Compartilhada** = mesmos dados
- **Seção crítica** = recurso compartilhado
- **Semáforo/Monitor** = sincronização
- **Corrida** = conflito
- **Deadlock** = travamento por espera
- **Síncrono** = espera
- **Assíncrono** = continua
- **Cluster** = paralelo
- **Grid** = distribuído
- **Físico** = tempo
- **Lamport** = ordem
- **Eleição** = líder
- **Escalabilidade** = crescer
- **Tolerância a falhas** = resistir a falhas

---


# Aula 6 — Comunicação entre Máquinas

## 1. Comunicação entre máquinas

É um dos principais focos de **Sistemas Distribuídos**.

Permite que diferentes máquinas troquem informações e compartilhem recursos.

### Compartilhamento de recursos

- Memória
- Processador (CPU)
- GPU

---

## 2. Modelo TCP/IP

Modelo utilizado para organizar o funcionamento da comunicação em redes de computadores.

### Camadas

- **Enlace**
- **Rede**
- **Transporte**
- **Sessão**
- **Apresentação**
- **Aplicação**
- **Middleware**

> **Foco da aula:** camada de **Transporte**.

### Pacote

Um pacote contém, de forma simplificada:

- **Remetente** → quem envia
- **Destinatário** → quem recebe
- **Conteúdo** → informação enviada

### Endereçamento

- **IP** → identifica a máquina na rede.
- **Porta lógica** → identifica o serviço/aplicação.
- **Cliente** → solicita um serviço.
- **Servidor** → fornece um serviço.

---

## 3. Middleware

Camada que facilita o desenvolvimento de aplicações distribuídas.

Fornece **APIs e abstrações** para facilitar a comunicação entre sistemas.

> O middleware facilita a programação, evitando que o programador precise implementar toda a comunicação de baixo nível.

---

## 4. Formas de Comunicação

### Comunicação orientada a mensagem

A comunicação ocorre através do **envio e recebimento de mensagens**.

- **Socket** → permite a comunicação entre aplicações.
- O programador pode controlar explicitamente conexão, envio e recebimento.

### Chamada de Procedimento Remoto (RPC)

Permite executar um procedimento que está em **outra máquina**, como se fosse uma chamada local.

### Exemplos

- **RPC** → Python
- **RMI** → Java
- **SOAP** → XML

---

## 5. Serialização

**Serialização** é transformar um **objeto em dados/bytes** para que ele possa ser enviado pela rede ou armazenado.

```text
Objeto
   ↓
Serialização
   ↓
Dados/Bytes
   ↓
Rede
   ↓
Dados/Bytes
   ↓
Desserialização
   ↓
Objeto
```

### Desserialização

É o processo contrário da serialização.

Transforma os dados/bytes recebidos novamente em um objeto.

### Serialização × Desserialização

| Serialização | Desserialização |
|---|---|
| Objeto → dados/bytes | Dados/bytes → objeto |
| Prepara para enviar | Reconstrói o objeto |
| Antes do envio | Depois do recebimento |

### Para decorar

**Serializar** = empacotar o objeto para enviar.

**Desserializar** = desempacotar e reconstruir o objeto.

---

## 6. Tipos de Comunicação

A comunicação pode ser classificada quanto ao:

- Sincronismo
- Persistência

### 6.1 Quanto ao Sincronismo

#### Síncrona

O remetente espera uma resposta do destinatário.

- Bloqueante
- Possui retorno/resposta
- Geralmente associada ao TCP
- Pode utilizar buffer

```text
Cliente → requisição → Servidor
Cliente ← resposta   ← Servidor
```

#### Assíncrona

O remetente não precisa esperar uma resposta para continuar sua execução.

- Não bloqueante
- Geralmente associada ao UDP
- Útil para áudio, vídeo e streaming

```text
Cliente → mensagem → Servidor
    ↓
continua execução
```

#### Síncrona × Assíncrona

| Síncrona | Assíncrona |
|---|---|
| Espera resposta | Não espera resposta |
| Bloqueante | Não bloqueante |
| TCP | UDP |
| Possui retorno | Não espera retorno imediato |

### 6.2 Quanto à Persistência

#### Transiente

A mensagem só é enviada se o destinatário estiver disponível/online.

```text
Remetente → Mensagem → Destinatário
                       online
```

Se o destinatário não estiver disponível, a mensagem pode ser perdida.

#### Persistente

A mensagem pode ser enviada mesmo que o destinatário esteja offline.

```text
Cliente → Servidor
             ↓
     mensagem armazenada
             ↓
     Destinatário conecta
             ↓
       recebe mensagem
```

É comum em arquiteturas cliente-servidor.

#### Transiente × Persistente

| Transiente | Persistente |
|---|---|
| Destinatário precisa estar online | Destinatário pode estar offline |
| Mensagem pode ser perdida | Mensagem pode ser armazenada |
| Não depende de armazenamento intermediário | Pode utilizar armazenamento intermediário |

---

## 7. Sockets

Socket é um ponto de comunicação utilizado para permitir a troca de dados entre aplicações.

É baseado principalmente na arquitetura cliente-servidor.

### Características

- Surgiu na década de 1980.
- Atua principalmente na camada de Transporte.
- Pode utilizar TCP ou UDP.
- Permite comunicação explícita entre máquinas.

---

## 8. Sockets em Java

Em Java, o programador precisa controlar explicitamente vários aspectos da comunicação:

- Endereço IP
- Porta lógica
- Conexão
- Envio de dados
- Recebimento de dados
- Sincronização
- Threads
- Fechamento da conexão

### Principais métodos

| Método | Função |
|---|---|
| `bind()` | Associa o socket a um IP + porta |
| `listen()` | Coloca o socket aguardando conexões |
| `accept()` | Aceita uma conexão de um cliente |
| `connect()` | Inicia uma conexão com o servidor |
| `read()` / INPUT | Lê/recebe dados |
| `write()` / OUTPUT | Escreve/envia dados |
| `close()` | Fecha a conexão |

---

## 9. Funcionamento do Socket

### Servidor

```text
Criar Socket
     ↓
   bind()
     ↓
  listen()
     ↓
  accept()
     ↓
read() / write()
     ↓
  close()
```

### Cliente

```text
Criar Socket
     ↓
 connect()
     ↓
write() / read()
     ↓
  close()
```

## Aula 7 — Sockets na Prática

## 1. O que cada lado precisa ter?

A comunicação via Socket (TCP) divide as tarefas entre o Servidor e o Cliente utilizando objetos específicos.

### Lado do Servidor (Server)
* **ServerSocket:** Contém o endereço IP e a porta de requisição. Ele serve para ficar ouvindo a rede e esperando os clientes chegarem.
* **Socket do Cliente (criado no Servidor):** É criado assim que o servidor aceita a conexão. É o canal para falar com o cliente que entrou.
    * **InputStream:** Canal de entrada (serve para o servidor LER o que o cliente mandou).
    * **OutputStream:** Canal de saída (serve para o servidor ENVIAR a resposta para o cliente).

### Lado do Cliente (Client)
* **Socket (Apontamento):** É o socket criado no cliente que aponta para o IP e a porta do servidor para abrir a conexão.
    * **OutputStream:** Canal de saída (serve para o cliente ENVIAR dados para o servidor).
    * **InputStream:** Canal de entrada (serve para o cliente LER a resposta do servidor).

---

## 2. Resumo do Fluxo (Como eles conversam)

1. O Servidor liga o `ServerSocket` e fica escutando a porta.
2. O Cliente cria o `Socket` apontando para o IP e porta do servidor.
3. O Servidor aceita a conexão e cria o `Socket do Cliente` local.
4. Os dois trocam dados usando seus canais de `InputStream` (Ler) e `OutputStream` (Escrever).

---

## Aula 8 - UPD - Trabalho Prático: Sistemas Distribuídos (Cliente-Servidor via UDP)


---

## Aula 9 - # RPC - Remote Procedure Call

RPC é um protocolo de comunicação entre processos que permite que um programa execute uma função ou procedimento em outro programa, possivelmente em outro computador na rede, como se fosse uma chamada local. Ele abstrai a complexidade da comunicação entre sistemas distribuídos, permitindo que os desenvolvedores chamem funções remotas de maneira semelhante às chamadas de funções locais.

## Características
- Funciona como uma chamada de função local, mas executa o código em um servidor remoto.
- Permite a comunicação entre diferentes linguagens de programação.
- Pode ser usado para criar aplicações distribuídas e microserviços.
- Oferece uma interface simples para o desenvolvimento de aplicações distribuídas.

## Tipos de RPC
- **Síncrono**: O cliente envia uma solicitação e espera pela resposta do servidor antes de continuar a execução.
- **Assíncrono**: O cliente envia uma solicitação e continua a execução sem esperar pela resposta do servidor. A resposta é recebida posteriormente, geralmente através de um callback ou evento.
- **Baseado em Mensagens**: O cliente envia uma mensagem para o servidor, que processa a solicitação e envia uma resposta de volta. A comunicação é feita através de mensagens, e não de chamadas de função diretas.
- **Baseado em Streaming**: Permite a transmissão contínua de dados entre o cliente e o servidor, permitindo que ambos enviem e recebam dados em tempo real.
- **Baseado em Eventos**: O cliente se inscreve em eventos no servidor e recebe notificações quando esses eventos ocorrem, permitindo uma comunicação reativa entre os sistemas.

---

# Aula 10 - RMI (Remote Method Invocation)

## O que é RMI?

**RMI (Remote Method Invocation)** é uma tecnologia do Java que permite executar métodos de objetos localizados em outro computador através de uma rede.

É utilizada em **sistemas distribuídos**, permitindo que diferentes aplicações Java se comuniquem.

## Como funciona?

1. O servidor disponibiliza um objeto remoto.
2. O objeto é registrado no **RMI Registry**.
3. O cliente localiza o objeto remoto.
4. O cliente invoca um método desse objeto.
5. O servidor executa o método e retorna o resultado.

## Principais componentes

- **Remote:** interface que define os métodos disponíveis remotamente.
- **RemoteException:** trata possíveis erros de comunicação.
- **RMI Registry:** registra e permite localizar objetos remotos.
- **Stub:** representante local do objeto remoto, responsável por encaminhar chamadas ao servidor.
- **UnicastRemoteObject:** classe utilizada para exportar objetos remotos.

## Vantagens

- Facilita a comunicação entre aplicações Java.
- Permite executar métodos remotamente.
- Simplifica o desenvolvimento de sistemas distribuídos.
- Possibilita compartilhar serviços entre computadores.

## Desvantagens

- Depende de conexão de rede.
- Pode apresentar atrasos na comunicação.
- Exige tratamento de falhas remotas.
- É voltado principalmente para aplicações Java.

## Resumo

O **RMI** permite que um programa Java chame métodos de objetos que estão em outro computador, como se fossem locais. Ele facilita a comunicação entre aplicações distribuídas, utilizando interfaces remotas e um serviço de registro para localizar os objetos.


## O que é JGroups?

JGroups é uma biblioteca Java utilizada em sistemas distribuídos para permitir a comunicação entre várias aplicações ou servidores organizados em grupos (clusters).

## Para que serve?

- Enviar mensagens entre aplicações Java.
- Criar grupos de comunicação (clusters).
- Detectar quando um membro entra ou sai do grupo.
- Facilitar a comunicação entre vários servidores.
- Apoiar sistemas distribuídos e tolerantes a falhas.

## Como funciona?

1. Cada aplicação entra em um canal de comunicação.
2. As aplicações conectadas ao mesmo grupo podem trocar mensagens.
3. O JGroups gerencia a comunicação e informa mudanças nos membros do grupo.

## Exemplo prático

Em um sistema de chat distribuído, várias aplicações Java podem entrar no mesmo grupo e compartilhar mensagens. Quando uma aplicação envia uma mensagem, os outros membros podem recebê-la.

## JGroups x RMI

- **RMI:** permite chamar métodos de objetos Java remotamente.
- **JGroups:** permite trocar mensagens e gerenciar grupos de aplicações distribuídas.

## Resumo final

JGroups facilita a comunicação entre aplicações Java em sistemas distribuídos, permitindo enviar mensagens, organizar clusters e detectar alterações nos membros do grupo.


