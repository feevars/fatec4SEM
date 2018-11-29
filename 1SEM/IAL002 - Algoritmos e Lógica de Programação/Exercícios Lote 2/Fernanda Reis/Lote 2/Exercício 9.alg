algoritmo "9.	Criar e carregar uma matriz [4][4] com valores aleatórios, sendo que a diagonal principal terá seus dados carregados no programa segundo:
"1 - 4 - 16 - 64"
//precisa fazer com que a diagonal seja o matriz [2,2] ao quadrado, ou ao cubo
// matriz [1,1] = 1
var
matriz : vetor[1..4,1..4] de inteiro //matriz [i,j]
i, j, diagonal : inteiro//se i = j, numero naquela posição será matriz[2,2] elevado a i ou j - 1
// exemplo : se matriz[2,2] = 5, matriz[3,3] será matriz[2,2]^i-1, sendo i = 2

inicio
// Seção de Comandos
escreval("Verifique a matriz a seguir.")
escreval("Sua diagonal deve apresentar os valores 1, 4, 16 e 64.")
escreval("Preencha os outros endereços com números aleatórios.")
escreval()

diagonal <- 1
i <- 1
j <- 1

escreval("Insira 16 valores: ")
para i <- 1 ate 4 faca
   para j <- 1 ate 4 faca
      leia (matriz[i,j])
   fimpara
fimpara
para i <- 1 ate 4 faca
   para j <- 1 ate 4 faca
      se i=j entao
         matriz[i,j] <- diagonal
         diagonal <- diagonal * 4
      senao
      fimse
   fimpara
fimpara

escreval("Os valores que você digitou, nas posições x = y, serão ignorados hehe")
escreval("mas aqui está a matriz gerada: ")


para i <- 1 ate 4 faca
   para j <- 1 ate 4 faca
      escreva(" || ", matriz[i,j], " || ")
   fimpara
   escreval()
fimpara



fimalgoritmo

