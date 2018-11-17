algoritmo "Criar e coletar em um vetor [30] real, calcular e exibir:"
                 "a) A média do grupo."
                 "b) A quantidade de notas acima da média."
                 "c) As posições dos valores abaixo da média do grupo."

var
 i, j, k, l : inteiro
 soma, media : real
 nota: vetor[1..4] de real
 acima: vetor[1..4] de real
 abaixo: vetor[1..4] de real
 posicao: vetor[1..4] de real
inicio
      i <- 1
      j <- 1
      k <- 1
      l <- 1
      
      funcao entrada ()
      funcao media ()
      funcao (acima)
      funcao (abaixo)
      
      
      funcao <entrada> [
             para i <- 1 ate 4 faca
                  escreval ("Digite a ",i,"ª nota: ")
                  leia (nota[i])
                  soma <- soma + nota[i]


      funcao <media>
                  media <- soma/i //colocar o i maximo
                  escreval (" A média das notas foi de: ",media)
                  
      funcao <acima>
             para (nota[i] > ) faca
                   acima[j] <- nota[i]
                   j <- j+1
             fimpara
             escreval ("O número de notas acima da média foi de: ", )
             
      funcao abaixo
             para nota[i] < 6 faca
                  abaixo[k] <- nota[i]
                  k <- k+1 //nao pede o numero de notas
                  posicao[l] <- i
                  l <- l+1
             fimpara
                  escreval (posicao[l],"ª posição")
      




fimalgoritmo
