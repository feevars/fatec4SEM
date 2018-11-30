algoritmo "7.	A partir do exercício 6 (vetor classificado) solicitar um valor qualquer e verificar a sua existência no vetor (utilizar pesquisa binária)."
// Função :
// Autor :
// Data : 27/11/2018
// Seção de Declarações
var
valor:vetor [1..5] de inteiro
i, j, aux, k, num, inicial, final, x : inteiro
meio : inteiro
inicio
escreval ("Vamos procurar um número específico e sua posição em um vetor.")
escreval("(Lembre-se de que os números informados serão armazenados em ordem crescente.)")
escreval()
para i <- 1 ate 5 faca
   escreval("Informe o ", i,"º valor: ")
   leia(valor[i])
fimpara


aux <- 0

para i <- 1 ate 5 faca
   para j <- 1 ate 5 faca
      se valor[i] < valor[j] entao
         aux <- valor[i]
         valor[i] <- valor[j]
         valor[j] <- aux
      fimse
   fimpara
fimpara
//até aqui é igual ao 6, mas não exibe a ordem

escreval()
escreval("Digite um número aleatório para ser localizado no vetor: ")
leia(num)

//precisa fazer pesquisa binária aqui


inicial <- 1
final <- 5

x <- 0

   enquanto (inicial <= final) e (x = 0) faca
      meio <- (inicial + final) DIV 2
      i <- meio
      se (valor[i] = num) entao
         x <- 1
      senao
         se valor[i] > num entao
            final <- meio - 1
         senao
            inicial <- meio + 1
         fimse
      fimse
      fimenquanto

      //Exibir Resultados da busca
      se x = 1 entao
         escreva ("O número foi encontrado na posição ", meio, " do vetor.")
      senao
         escreva ("O número informado não foi encontrado no vetor.")
      fimse




FimAlgoritmo
