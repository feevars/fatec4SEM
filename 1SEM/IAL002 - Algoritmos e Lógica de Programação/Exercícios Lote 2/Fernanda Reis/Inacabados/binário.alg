algoritmo "semnome"
// Função :
// Autor :
// Data : 30/11/2018
// Seção de Declarações
var
numero_binario, potencia : inteiro
binario: vetor[0..9] de inteiro
i, soma, decimal, x : inteiro
inicio
potencia <- 1
x <- 1
soma <- 0

escreva("Insira um número binário maior que 1 e menor que 1000000000: ")
leia(numero_binario)

//Validação do intervalo do enunciado
se(numero_binario < 1) ou (numero_binario > 1000000000)entao
   escreval("Você digitou um valor inválido. Refaça...")
senao
   //Separa os algarismos e popula o vetor
   para i <- 0 ate 9 faca

      binario[i] <- numero_binario / x
      binario[i] <- binario[i] % 10

      x <- x * 10

      se(binario[i] < 0 ou binario[i] > 1)entao

         escreval("O número que você digitou não é binário. Refaça...")
      senao
      fimse
      i<-i+1
   fimpara

   para i <- 0 ate 9 faca
      se(i = 0)entao
         soma <- binario[i]
      senao
         potencia <- potencia * 2
         soma <- soma + (binario[i] * potencia)
      fimse
      i <- i + 1
   fimpara
fimpara

decimal = soma

limpa()
escreva("O número binário ", numero_binario, " em decimal é ", decimal)

fimse// Seção de Comandos
fimalgoritmo
