Algoritmo "5.	Criar e coletar em um vetor [10] inteiro. Calcule e exiba, segundo:""

Var
i, num, soma, total_soma : inteiro
nota: vetor [1..10] de inteiro
Inicio

i <- 1
para i <- 1 ate 10 faca
   escreval ("Digite o ",i,"º valor: ")
   leia (nota[i])

   i <- i + 1
fimpara
i <- 1
soma <- 0
total_soma <- 0
   para i <- 1 ate 5 faca
      soma <- soma + (nota[i] - nota[11-i])
      escreval ("A operação (subtração) dos números na ", i, "ª e na ", 11-i, "ª posições é: ", soma)
      i <- i+1
      total_soma <- total_soma + soma
   fimpara
   escreval ("A somatória total dos valores contidos no vetor é: ", total_soma)

Fimalgoritmo
