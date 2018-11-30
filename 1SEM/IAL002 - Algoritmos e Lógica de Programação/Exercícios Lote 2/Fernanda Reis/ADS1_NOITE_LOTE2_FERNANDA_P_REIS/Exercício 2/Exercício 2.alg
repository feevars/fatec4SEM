algoritmo "Criar e coletar um vetor [100] inteiro e exibir:"
"a) Maior e menor valor. "
"b) A média dos valores."

var
val: vetor[1..5] de inteiro
maior, menor, i, soma : inteiro
media : real
inicio
i <- 1
media <- 0
soma <- 0
para i <- 1 ate 5 faca
   escreval ("Digite o ", i, "º valor: ")
   leia (val[i])
   se (i <- 1) entao
      maior <- val[i]
      menor <- val[i]
   senao
      se (val[i] < menor) entao
         menor <- val[i]
      senao
         se (val[i] > maior) entao
            maior <- val[i]
         senao
         fimse
      fimse
   fimse
   soma <- soma + val[i]
fimpara
media <- soma/5
escreval ("O maior valor digitado foi o número ", maior, ", enquanto o menor foi o número ",menor,".")
escreval ("A média de todos os valores digitados é ",media,".")
fimalgoritmo
