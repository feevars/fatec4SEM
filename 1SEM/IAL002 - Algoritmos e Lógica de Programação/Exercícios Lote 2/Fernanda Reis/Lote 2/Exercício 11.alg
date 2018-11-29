algoritmo "11.	Criar uma matriz [8][8] inteiro e o programa irá carregar segundo:"

// Função :
// Autor :
// Data : 29/11/2018
// Seção de Declarações
var
matriz: vetor[0..7,0..7] de inteiro
x, y, z : inteiro
inicio
para z <- 0 ate 3 faca
   para x <- z ate (7-z) faca
      para y <- z ate (7 - z) faca
         matriz[x,y] <- z + 1
         y <- y+1
      fimpara
      x <- x+1
   fimpara
   z<-z+1
fimpara


para x <- 0 ate 7 faca
   para y <- 0 ate 7 faca
      escreva(" | ", matriz[x,y], " | ")
      y <- y+1
   fimpara
   escreval()
   x <- x+1
fimpara

fimalgoritmo
