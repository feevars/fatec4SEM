algoritmo "Criar um procedimento que:"
"-Carregue os dados da matriz e mostre a soma dos números divisíveis por 3 e 5 de todos os valores;"
"-Os valores da diagonal principal devem ser carregados pela aplicação ."

// Função :
// Autor :
// Data : 04/12/2018
// Seção de Declarações
var
matriz: vetor[1..4,1..4] de inteiro
i, j, num, soma, diag : inteiro
inicio
// Seção de Comandos
diag <- 1
soma <- 0
escreval("Carregaremos uma matriz [4,4] com valores aleatórios.")
para i <- 1 ate 4 faca
   para j <- 1 ate 4 faca
      escreval ("Digite um número randômico: ")
      leia(num)
      matriz[i,j] <- num
      se (num % 2 = 1) e (i <> j) entao
         soma <- soma + num
      senao
         se (i=j) entao
            matriz[i,j] <- diag
            diag <- diag * 2
         senao
         fimse
      fimse
   fimpara
fimpara

      escreval("A soma dos números ímpares é :", soma)

      escreval("Aqui está a matriz gerada, com diagonal com múltiplos de 2.")
      para i <- 1 ate 4 faca
         para j <- 1 ate 4 faca
            escreva(matriz[i,j])
         fimpara
         escreval()
      fimpara

   fimalgoritmo
