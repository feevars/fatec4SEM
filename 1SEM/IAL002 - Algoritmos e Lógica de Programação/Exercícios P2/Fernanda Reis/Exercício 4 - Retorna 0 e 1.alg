Algoritmo "Criar uma função que receba um vetor com uma sequencia de 7 números"
// Disciplina  :  [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 05/12/2018
Var
   // Seção de DeclaraçõesCria das variáveis


Inicio
   cont <- 2
   soma <- 1
   escreval("Digite um número de 7 algarismos: ")
   //se o primeiro algarismo for 0, nao pode ser
   para i <- 1 ate 7 faca
      vet_num[i] = num / x % 10
      x = x * 10
   fimpara

   para i <- 2 ate 7 faca
      soma <- soma + vet_num[i] * cont
      cont <- cont + 1
   fimpara
   
   soma <- soma mod 11
   
Fimalgoritmo