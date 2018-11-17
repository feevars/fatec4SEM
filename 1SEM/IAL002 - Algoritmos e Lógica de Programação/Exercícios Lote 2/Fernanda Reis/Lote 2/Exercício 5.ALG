Algoritmo "5.	Criar e coletar em um vetor [20] inteiro. Calcule e exiba, segundo:""

Var
i,k, sub : inteiro
num: vetor [1..6] de inteiro
Inicio
      i <- 1
      sub <- 0
      para k <- 1 ate 6 faca
          enquanto i < 5 faca
               sub <- num[i] - num[i+5]
               k <- k - 2
               escreval (sub)
          fimenquanto
      fimpara
Fimalgoritmo