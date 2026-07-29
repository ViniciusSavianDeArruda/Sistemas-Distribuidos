AULA 1
  - Alexandre Zamberlan - Alexz@ufn.edu.br
    - vai precisar ter controller, model, service, comunication para atividades em codigos essas a organizacao dos componentes que tem que seguir

  - Processo de Avalicacao
      - 20% nota a participacao efetiva
      - 20% nota sao as npotas de aula (no github pessaol)
      - criar um arquivo chamado notas_aula.md
      - 60% nota entre porva e trabalhos praticoas

  - Apresentacao e deiscussao do plano de ensino

  - conecietos biasicos de Sd: comunicacao, arquitetura, processaemento concomitante versus pararlelo, clustert versus grid.

  - Comunicacao
      - broadcast, multcast, unicast
      - é bloqueante: escrever(writw ou sender) e ler (reader ou receiver)
      - respeito ou segue o modelo TCP/IP (aplicacao, transporte, interface, rede)
      - mascara ou classe de rede e dominio
      - socket
      - porta logica
  - ARQUITETURA
    - cliente servidor
    - ponto a ponto





  Processamento Concomitante × Processamento Paralelo
1. Processamento Concomitante (Concorrente)
Um Sistema Operacional gerencia várias tarefas.
Normalmente usa uma CPU, alternando rapidamente entre as tarefas.
Dá a impressão de que tudo acontece ao mesmo tempo, mas apenas uma tarefa é executada por vez.

Palavra-chave: Alternância.

Exemplo: ouvir música enquanto navega na internet.

2. Processamento Paralelo
Várias tarefas são executadas ao mesmo tempo.
Utiliza várias unidades de processamento.

Existem dois tipos:

Fortemente acoplado
Mesmo computador.
Compartilha memória.
Exemplos:
CPU multicore (vários núcleos).
GPU.

Palavra-chave: Mesmo computador.

Fracamente acoplado
Vários computadores conectados em rede.
Cada computador possui sua própria CPU e memória.
Exemplo:
Cluster computacional.

Palavra-chave: Vários computadores.

Resumo final (para decorar)
Concomitante = Sistema Operacional + alternância de tarefas + CPU.
Paralelo = execução simultânea.
Fortemente acoplado = GPU + CPU multicore (mesmo computador).
Fracamente acoplado = Cluster computacional (vários computadores).

