# Sistema-de-ranqueado-automatizado
Este programa, aplicativo ou sistema foi desenvolvido em linguagem Java, utilizando o banco de dados MYSQL. O objetivo dele é gerenciar um sistema de rank específico, que foi idealizado por mim. Utilizando uma interface gráfica, é possivel fazer vários comandos nesse rank, como adicionar e remover "pessoas" do rank.

## O rank
O rank foi pensado por mim, tendo três divisões nele: a principal, que representa o "prêmio" máximo que a "pessoa" pode conseguir; a secundária, que seria um "prêmio" menor; a última divisão é a divisão de duplas, que seria uma combinação de duas "pessoas" para disputar "prêmio" de duplas. As três divisões são divididas entre o gênero, feminino e masculino, que utiliza um sistema de pontos. 

O campeão, ou seja, aquele que tem o "prêmio" :grey_exclamation:(esse prêmio pode ser um titulo de UFC por exemplo, mas vou chamar de prêmio para ficar mais fácil):grey_exclamation: não entra no rank em si, ele está acima de todos os outros, ele não ganha pontos e nem perde, se perder para outros, ele perde o posto de campeão. 

O sistema de pontos funciona da seguinte forma: aquele que está abaixo do rank, ou seja, tem poucos pontos, se ele ganhar de alguém que tem mais pontos que ele, ele ganha 3 pontos, já o que perdeu, perde só 2. Abaixo terá as regras de pontos:

Ganhador:
- Evento especial: :grey_exclamation:(um condição que faz as perdas e ganhos maiores):grey_exclamation: 4 pontos
- Acima dele: 3 pontos
- Mesma posição dele: 2 pontos
- Abaixo dele: 1 pontos

Perdedor:
- Evento especial: -3 pontos
- Abaixo dele: -2 pontos
- Acima ou na mesma posição dele: 1 pontos
