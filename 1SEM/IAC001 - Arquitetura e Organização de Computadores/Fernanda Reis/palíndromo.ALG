Algoritmo "semnome"
// Disciplina  :  Algoritmos e Lógica de Programação 
// RICARDO SATOSHI OYAKAWA 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 17/11/2018
Var
// Seção de Declarações das variáveis 
numero, invertido : inteiro
aux, digito : inteiro
Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 
 escreval ("Vamos descobrir se um número é palíndromo!")
 ESCREVAL("Informe um número: ")
 LEIA(numero)
 
 aux <- numero
 invertido <-0
 
 enquanto aux <> 0 faca
   digito <- int(aux % 10)
   invertido <- (invertido *10) + digito
   aux <- int(aux / 10)
 fimenquanto
 
 se numero = invertido entao
    escreval ("Número digitado: ", numero, " | Número inverso: ", invertido)
   ESCREVAL("O número digitado é um Palíndromo!")
 senao
 //colocar para encontrar o numero palindromo mais próximo
      escreval ("Número digitado: ", numero, " | Número inverso: ", invertido)
   ESCREVAL("Err.. O número digitado não é um palíndromo :( mas...")
   //até aqui ta certinho <<<<<<<<<<<<<<<<<<<<<<<<<<<<
                   funcao <decresce> : //funcao para descrescer o numero
                          numero <- numero - 1
                          aux <- numero
                          invertido <-0
                          enquanto aux <> 0 faca
                                   digito <- int(aux % 10)
                                   invertido <- (invertido *10) + digito
                                   aux <- int(aux / 10)
                          fimenquanto
                          se numero = invertido entao
                             ESCREVAL("O palíndromo mais próximo é o ", numero)
                          senao
                               //volta para o começo da funcao
                               decresce <- decresce + 1
                          fimse

                   funcao <acresce> : //funcao para acrescer o número
                          numero <- numero + 1
                          aux <- numero
                          invertido <-0
                          enquanto aux <> invertido faca
                                   digito <- int(aux % 10)
                                   invertido <- (invertido *10) + digito
                                   aux <- int(aux / 10)
                          fimenquanto
                          se numero <> invertido entao
                             acresce <- acresce + 1

                          senao
                               //volta para o começo da funcao

                          fimse
                          // escreval ("O palíndromo mais próximo é: ", acresce)


 // se acresce > decresce entao
 //   exibe acresce
 fimse

Fimalgoritmo
