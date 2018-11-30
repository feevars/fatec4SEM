algoritmo "10.	Criar uma matriz [8][8] onde o programa irá carregar segundo:
"casa | 1 | 2 | 3 | 4 | ... | exibir a
"valor | 1 | 2 | 4 | 8 |... | soma dos valores
// Função :
// Autor :
// Data : 27/11/2018
// Seção de Declarações
var
matriz: vetor[1..4,1..4] de inteiro
i, j, mul : inteiro

inicio
escreva ("Criaremos uma matriz[8][8] com múltiplos de dois. Observe: ")
escreval()
i <- 1
j <- 1
mul <- 1
para i <- 1 ate 4 faca
   para j <- 1 ate 4 faca
      matriz[i,j] <- mul
      mul <- matriz[i,j] * 2
      escreva (matriz[i,j], "  ||  ")
   fimpara
   escreval()
fimpara
fimalgoritmo
