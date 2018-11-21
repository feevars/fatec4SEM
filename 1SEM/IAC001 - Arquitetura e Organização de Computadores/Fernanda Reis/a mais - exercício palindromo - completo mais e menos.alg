Algoritmo "palindromo"

Var
// Seção de Declarações das variáveis
informado, inv1, inv2 : inteiro
num1, num2, dig1, dig2, p, num_decresc, decresce, acresce : inteiro

funcao ver_palindromo1: inteiro

inicio

num1 <- informado
inv1 <-0

enquanto num1 <> 0 faca
   dig1 <- int(num1 % 10)
   inv1 <- (inv1 *10) + dig1
   num1 <- int(num1 / 10)
fimenquanto
retorne inv1
FimFuncao

funcao ver_palindromo2: inteiro

inicio
num2 <- num_decresc
inv2 <- 0

enquanto num2 <> 0 faca
   dig2 <- int(num2 % 10)
   inv2 <- (inv2 *10) + dig2
   num2 <- int(num2 / 10)
   retorne inv2
fimenquanto


fimfuncao

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc...
escreval ("Vamos descobrir se um número é palíndromo!")
ESCREVA("Digite um número: ")
LEIA(informado)
num_decresc <- informado
acresce <- 0
decresce <- 0

inv1 <- ver_palindromo1
se (informado = inv1) entao
   escreval("Número digitado: ", informado, " |  Número inverso: ", inv1)
   escreval("O número digitado é um palíndromo!")
senao
   escreval ("O número informado não é palíndromo :( mas...")
   p <- 1
   enquanto p = 1 faca
      inv1 <- ver_palindromo1
      //função é definida pelo invertido pois é com ele que vamos comparar
      se informado = inv1  entao

         p <- 0
      senao

         inv2 <- ver_palindromo2

         se num_decresc = inv2 entao

            p <- 0
         senao
            informado <- informado + 1
            num_decresc <- num_decresc - 1
            inv2 <- ver_palindromo2
            decresce <- decresce +1
            acresce <- acresce + 1

         fimse


      fimse

   fimenquanto

   se (acresce > decresce) e (num_decresc = inv2) ou (acresce = decresce) e (num_decresc = inv2) e (informado <> inv1) entao
      escreval ("O palindromo mais próximo é: ", num_decresc) //o menor numero de numeros será o exibido
   senao
      se (acresce = decresce) e (num_decresc = inv2) e (informado = inv1) entao
         escreval ("Os palíndromos mais próximos encontram-se na mesma posição: ", num_decresc, " e ", informado)
      senao
         escreval ("O palíndromo mais próximo é: ", informado)

      fimse

   fimse
fimse
Fimalgoritmo

