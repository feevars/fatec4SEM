Algoritmo "semnome"
// Disciplina  :  Algoritmos e Lógica de Programação 
// RICARDO SATOSHI OYAKAWA 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 17/11/2018

Var
// Seção de Declarações das variáveis 
numero, invertido, num_acresc, num_decresc : inteiro
aux, digito, acresce, decresce, p : inteiro

funcao ver_palindromo: inteiro

inicio

 aux <- numero
 invertido <-0

 enquanto aux <> 0 faca
   digito <- int(aux % 10)
   invertido <- (invertido *10) + digito
   aux <- int(aux / 10)
 fimenquanto

retorne invertido
fimfuncao

Inicio


// Seção de Comandos, procedimento, funções, operadores, etc... 
 escreval ("Vamos descobrir se um número é palíndromo!")
 ESCREVAL("Informe um número: ")
 LEIA(numero)
 
 decresce <- 0
 acresce <- 0

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
                   //precisa fazer um loopcrescente e um loop decrescente

                   num_decresc <- numero - 1 //um numero acima e abaixo para começar o loop
                   numero <- numero + 1
                   
    //Acréscimo
               p <- 1
               enquanto p = 1 faca
                        aux <- ver_palindromo

                        se aux = invertido entao
                           //ESCREVAL(informado, " é PALINDROMO!")
                           escreval ("O número palíndromo crescente mais próximo é o ", num_acresc)
                           p <- 0
                        senao
                        num_acresc <- num_acresc + 1
                        acresce <- acresce + 1
                        fimse
               fimenquanto
               
    //Decréscimo
                p <- 1
               enquanto p = 1 faca
                        num_decresc <- ver_palindromo
                        se num_decresc = invertido entao
                           //ESCREVAL(informado, " é PALINDROMO!")
                           escreval ("O número palíndromo decrescente mais próximo é o ", num_decresc)
                           p <- 0
                        senao
                        num_decresc <- num_decresc - 1
                        decresce <- decresce + 1
                        fimse
               fimenquanto


                   se (acresce > decresce) entao
                      //o menor número representa o palíndromo mais próximo
                      escreval ("O número palíndromo mais próximo é: ", num_decresc)
                   senao
                      se (acresce = decresce) entao
                         escreval ("Os palíndromos mais próximos encontram-se na mesma posição: ", num_decresc, " e ", num_acresc)
                      senao
                         escreval ("O número palíndromo mais próximo é: ", num_acresc)
                      fimse
                   fimse



 fimse

FimAlgoritmo
