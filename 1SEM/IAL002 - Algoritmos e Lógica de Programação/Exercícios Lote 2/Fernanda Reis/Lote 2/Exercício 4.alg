algoritmo "Criar e coletar em um vetor [30] real, calcular e exibir:"
                 "a) A média do grupo."
                 "b) A quantidade de notas acima da média."
                 "c) As posições dos valores abaixo da média do grupo."

var
 i, j, k : inteiro
 soma, media : real
 nota: vetor[1..4] de real
 acima: vetor[1..4] de real
 abaixo: vetor[1..4] de real
 posicao: vetor[1..4] de real
inicio
      i <- 1
      j <- 1
      k <- 1
      para i <- 1 ate 4 faca
           escreval ("Digite a ",i,"ª nota: ")
           leia (nota[i])
                soma <- soma + nota[i]
                media <- soma/i
                se (nota[i] > 6) entao
                   acima[i] <- nota[i]
                   j <- j+1

                senao
                     se (nota[i] < 6) entao
                        abaixo[k] <- nota[i]
                        k <- k+1

                     senao
                     fimse
                fimse

      fimpara
      escreval ("A média das notas foi ", media,".")
      escreval ("O número de notas acima da média foi ",j-1,".")
      escreval ("As notas abaixo da média se encontram nas seguintes posições: ",posicao[i],".")
          //falta colocar a posição das notas abaixo da média
fimalgoritmo
