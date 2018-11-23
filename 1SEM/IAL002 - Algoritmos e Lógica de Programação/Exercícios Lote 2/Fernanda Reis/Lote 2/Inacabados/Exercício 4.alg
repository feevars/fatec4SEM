algoritmo "Criar e coletar em um vetor [30] real, calcular e exibir:"
"a) A média do grupo."
"b) A quantidade de notas acima da média."
"c) As posições dos valores abaixo da média do grupo."

var
i, j, l : inteiro
soma, media : real
nota: vetor[1..10] de real



inicio

i <- 1
para i <- 1 ate 10 faca
   escreval ("Digite a ",i,"ª nota: ")
   leia (nota[i])
   soma <- soma + nota[i]
   i <- i + 1
fimpara

media <- soma/10 //colocar o i maximo
escreval (" A média das notas foi de: ",media)

i <- 1
j <- 1
l <- 1
escreval ("As notas abaixo da média encontram-se na(s) seguinte(s) posição(ões): ")
para i <- 1 ate 10 faca
   se (nota[i] > media) entao
      j <- j + 1
      i <- i + 1
   senao
      se (nota[i] < media) entao
         escreval (i,"ª posição")
      senao
      fimse
   fimse
fimpara
escreval ("O número de notas acima da média foi de: ", j, " notas.")
fimalgoritmo
