Algoritmo "semnome"
// Disciplina  :  Algoritmos e Lógica de Programação 
// RICARDO SATOSHI OYAKAWA 
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 17/11/2018
Var
// Seção de Declarações das variáveis 
numero, invertido, inv_acresc, inv_decresc, num_acresc, num_decresc : inteiro
aux, aux_acresc, aux_decresc, digito, decresce, acresce : inteiro
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
                   num_acresc <- numero + 1
                   
                   enquanto (num_decresc <> invertido) faca

                            aux <- num_decresc
                            invertido <-0
                             //verifica se é palíndromo
                              enquanto aux <> 0 faca
                                 digito <- int(aux % 10)
                                 invertido <- (invertido *10) + digito
                                 aux <- int(aux / 10)
                              fimenquanto
                              
                              decresce <- decresce + 1

                              num_decresc <- num_decresc - 1//continua no loop do enquanto
                    fimenquanto
                              escreval ("O número palíndromo mais próximo é o ", num_decresc)


                   


                    enquanto (num_acresc <> invertido) faca
                            aux <- num_acresc
                            invertido <-0
                             //verifica se é palíndromo
                              enquanto aux <> 0 faca
                                 digito <- int(aux % 10)
                                 invertido <- (invertido *10) + digito
                                 aux <- int(aux / 10)
                              fimenquanto

                              acresce <- acresce + 1       //quantos numeros acresceu até que seja um palíndromo

                              num_acresc <- num_acresc + 1 //continua no loop do enquanto

                   fimenquanto
                              escreval ("O palíndromo acrescente mais próximo é o ", num_acresc)

                   
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
