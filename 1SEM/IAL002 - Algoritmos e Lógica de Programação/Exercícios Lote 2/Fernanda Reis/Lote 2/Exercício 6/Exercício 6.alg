algoritmo "Exercício 6 -	Criar e coletar em um vetor [20] com números aleatórios. \nClassificar este vetor em ordem crescente e mostre os dados."
// Função :
// Autor :
// Data : 23/11/2018
// Seção de Declarações
var
valor:vetor [1..5] de inteiro
i, j, aux : inteiro

inicio
escreval ("Vamos ordenar uma sequência de números em ordem crescente!")
escreval()
para i <- 1 ate 5 faca
   escreval("Informe o ", i,"º valor: ")
   leia(valor[i])
fimpara


aux <- 0

para i <- 1 ate 5 faca
   para j <- 1 ate 5 faca
      se valor[i] < valor[j] entao
         aux <- valor[i]
         valor[i] <- valor[j]
         valor[j] <- aux
      fimse
   fimpara
fimpara

escreval ()
escreval("Aqui estão os valores informados em ordem crescente: ")
para i <- 1 ate 5 faca
   escreval(valor[i])
fimpara

Fimalgoritmo
