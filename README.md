# BEELabirinto
![ExemploLabirinto-sem-som-2x](https://user-images.githubusercontent.com/1190715/230742786-4d45325a-28ff-4ead-9c56-6d61c9e73eb0.gif)
## O que você vai estudar
Princípios da Programação Orientada a Objetos (POO) e conceitos relacionados a Buscar em Espaço de Estados (subárea da Inteligência Artificial).
## Resumo
Este código foi desenvolvido em 2012 como ponto de partida (cenário problema) para a disciplina de Sistemas de Inteligência Artificial (que hoje se chama Inteligência Artificial e Computacional) na Universidade Feevale. A ideia é apresentar um labirinto, com obstáculos, entrada e saída aleatórios. O desafio é identificar um conjunto de movimentos (estados do problema) que determinem o caminho até a saída, se houver um. 
  Com base nessa especificação podemos criar experimentos que implementem algoritmos de Busca em Espaço de Estados (BEE) clássicos com ou sem informação. Algoritmos *sem informação* utilizam métodos clássicos para busca em grafos, como por exemplo a Busca em Largura ou Busca em Profundidade. Algoritmos *com informação* empregam algum conhecimento a relacionado com o cenário problema, e modelam essa informação na forma de uma avaliação contínua dos estados. Mais informações sobre alternativas e pseudocódigos sobre algoritmos de BEE podem ser encontradas em Luger, Vieira e Tavares (2013)[^1], e Russel e Norvig (2013)[^2].
## Sugestão
Com base nesta especificação de problema, utilize os comportamentos disponíveis na classe Labirinto para testar algoritmos de busca. Então compare os resultados.
Arquivo / classe ExemploLabirinto é a demonstação de um labirinto com dimensão 10x10 e uma taxa de 30% de obstáculos (preenchimento). A aplicação imprime um labirinto aleatório, as coodenadas de uma instância de Posicao, da posição de entrada, do conjunto de posições possíveis a da posição atual (entrada) e da posição de saída, assim como a distância em linha reta (DLR) entre a posição atual e a de saída.
### Referências
[^1]:GEORGE F. LUGER; DANIEL VIEIRA; ANDRÉA IABRUDI TAVARES. Inteligência artificial. Editora Pearson, 2013. 616 p. ISBN 9788581435503.
[^2]:RUSSEL, Stuart; NORVIG, Peter. Inteligência artificial. Rio de Janeiro: GEN LTC, 2013. 1 recurso online. ISBN 9788595156104.
