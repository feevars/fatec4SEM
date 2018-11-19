algoritmo "13. Faça um algoritmo que leia um número (1 < número < 10000) e,
"caso ele não seja um número palíndromo, apontar qual o número palíndromo
"mais próximo antes dele."

Var
// Seção de Declarações das variáveis
informado, inv : inteiro
num, dig, p : inteiro


funcao ver_palindromo: inteiro

inicio

num <- informado
inv <-0

enquanto num <> 0 faca
   dig <- int(num % 10)
   inv <- (inv *10) + dig
   num <- int(num / 10)
fimenquanto
retorne inv
FimFuncao


Inicio
// Seção de Comandos, procedimento, funções, operadores, etc...
escreval ("Vamos descobrir se um número é palíndromo!")
ESCREVA("Digite um número: ")
LEIA(informado)

se (informado >= 1) e (informado < 10000) entao
   inv <- ver_palindromo
   se (informado = inv) entao
      escreval("Número digitado: ", informado, " |  Número inverso: ", inv)
      escreval("O número digitado é um palíndromo!")
   senao
      escreval ("O número informado não é palíndromo :( mas...")
      p <- 1
      enquanto p = 1 faca
         inv <- ver_palindromo
         //função é definida pelo invertido pois é com ele que vamos comparar
         se informado = inv  entao
            p <- 0
            escreval ("O palíndromo mais próximo abaixo é: ", informado)
         senao
            informado <- informado - 1
         fimse

      fimenquanto
   fimse
senao
   escreva("O número informado não atende aos requisitos do programa.")
fimse
Fimalgoritmo

