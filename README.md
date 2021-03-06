<h2>Escopo:</h2>

<p>O trabalho consiste em implementar um sistema de navegação automática de um agente utilizando o algoritmo de busca em largura, profundidade, gulosa e A*. </p>

<p>O  agente  deve  ser  capaz  de  calcular  automaticamente  a  melhor  rota  para  chegar  a  qualquer ponto de um ambiente representado através de um grafo que conecta com seus vértices  as  áreas,  locais  ou  partes  do  caminho  onde  o  agente  pode  navegar.  O  grafo  representa então um cenário fictício que você deve criar, onde o agente irá tentar encontrar um prêmio (estado objetivo) que se encontra em algum local diferente de onde o agente inicia  no  ambiente  (nó  inicial),  o  grafo  deve  ter  pelo  menos  30  vértices.  Além  do  prêmio  final durante o percurso o agente também deve coletar recompensas que estão espalhadas no mapa. Os algoritmos de busca cega devem pegar as recompensas que aparecerem nos vértices  visitados  durante  a  verificação  do  caminho  que  leva  ao prêmio  final.  Já  os  algoritmos  com  heurística  devem  ter  em  sua  heurística  uma  forma  de  avaliar  se  é  compensador deslocar da rota que leva para o prêmio final para pegar recompensas que estejam em vértices próximos durante esse caminho.</p>

<p>O ambiente por onde o agente irá navegar é formado por diversos tipos de terrenos e em cada  tipo  de  terreno  o  agente  tem  um  grau  de  dificuldade  diferente  para  andar.  Por exemplo, o agente consegue passar facilmente por um terreno solido e plano, porem terá dificuldade para andar em um terreno rochoso ou um pântano.</p>

Os tipos de terrenos que compõem o ambiente são:<br/>
  -Solido e plano – Custo: +1<br/>
  -Rochoso – Custo: +10<br/>
  -Arenosos– Custo: +4<br/>
  -Pântano – Custo: +20<br/>

<p>A melhor rota para chegar a um determinado ponto do ambiente é a rota que tem o menor custo. </p>

<h2>Requisitos do Trabalho:</h2>
  •As    figuras    de  exemplo  mostram  ideias  para  o mapa  do  ambiente  que  deve  ser  desenvolvido. O símbolo “▓” representaparedes (por onde o agente não pode passar de  nenhuma maneira),  os  espaços  em  branco  em  diferentes  cores  representam  os  locais onde o agente pode andar (cada cor representa um tipo de terreno), o símbolo “☺” representa o agente e as recompensas são representadas pelo símbolo “$”. É permitido utilizar outros símbolos de sua preferência para representar os elementos. A quantidade de recompensas no ambiente deve ser de no mínimo 5.<br/>
  •Após  calcular  a  melhor  rota,  o  programa  deve  mostrar  a  movimentação  do  agente seguindo a rota calcula. <br/>
  •O Agente durante sua rota deve tentar pegar o máximo de recompensas possíveis.<br/>
  •O  algoritmo  deve  ser  capaz  de  perceber  quando  não  existe  nenhum  caminho  parachegar ao destino ou se existem paredes, becos ou pontos sem saída. Exemplo: uma sala  que  não  possui  nenhuma  entrada ou  uma  parede  que  impede  que  o  caminho  continue.<br/>
  •Além  de  encontrar  a  melhor  rota,  faça  um  comparativo  entre  os  resultados  dos  algoritmos  em  relação  a  tempo  de  execução  e  quantidade  de  nós  expandidos  na  memória.<br/>
  •A  melhor  maneira  de  começar  o  trabalho  é  pensando  a  função  heurística  que será utilizada  pelos algoritmos  Guloso  e  A*.  Os  algoritmos  devem  ser  implementados  de  forma correta e o código organizado.<br/>
