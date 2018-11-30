algoritmo "8.	Criar e carregar uma matriz [4][3] inteiro com quantidade de produtos vendidos em 4 semanas. Calcular e exibir:
"a.	A quantidade de cada produto vendido no mês;
"b.	A quantidade de produtos vendidos por semana;
"c.	O total de produtos vendidos no mês.
// Função :
// Autor :
// Data : 26/11/2018
// Seção de Declarações
var
produtos: vetor [1..4, 1..3] de inteiro
i, j, soma_um, soma_dois, soma_tres, soma_quatro, total : inteiro
semana_um, semana_dois, semana_tres, semana_quatro : inteiro
//  i<- número de semanas  ||   j <- numero do produto
inicio
soma_um <- 0
soma_dois <- 0
soma_tres <- 0
soma_quatro <- 0
total <- 0
semana_um <- 0
semana_dois <- 0
semana_tres <- 0
semana_quatro <- 0
escreval("Vamos verificar quantos produtos foram vendidos no mês!")
escreval()
//loop para receber os produtos do ítem 1 em todas as semanas
para i <- 1 ate 4 faca
   j <- 1
   escreval("Insira o número de produtos vendidos do ítem", j, " na ", i, "ª semana: ")
   leia(produtos[i,j])
   soma_um <- soma_um + produtos[i,j]
   se (i = 1) entao
      semana_um <- semana_um + produtos[i,j]
   senao
      se (i = 2) entao
         semana_dois <- semana_dois + produtos[i,j]
      senao
         se (i = 3) entao
            semana_tres <- semana_tres + produtos[i,j]
         senao
            semana_quatro <- semana_quatro + produtos[i,j]
         fimse
      fimse
   fimse
   i <- i + 1
fimpara

//loop para receber os produtos do ítem 2 em todas as semanas
para i <- 1 ate 4 faca
   j <- 2
   escreval("Insira o número de produtos vendidos do ítem", j, " na ", i, "ª semana: ")
   leia(produtos[i,j])
   soma_dois <- soma_dois + produtos[i,j]
   se (i = 1) entao
      semana_um <- semana_um + produtos[i,j]
   senao
      se (i = 2) entao
         semana_dois <- semana_dois + produtos[i,j]
      senao
         se (i = 3) entao
            semana_tres <- semana_tres + produtos[i,j]
         senao
            semana_quatro <- semana_quatro + produtos[i,j]
         fimse
      fimse
   fimse
   i <- i + 1
fimpara

// loop para receber os produtos do ítem 3 em todas as semanas
para i <- 1 ate 4 faca
   j <- 3
   escreval("Insira o número de produtos vendidos do ítem", j, " na ", i, "ª semana: ")
   leia(produtos[i,j])
   soma_tres <- soma_tres + produtos[i,j]
   se (i = 1) entao
      semana_um <- semana_um + produtos[i,j]
   senao
      se (i = 2) entao
         semana_dois <- semana_dois + produtos[i,j]
      senao
         se (i = 3) entao
            semana_tres <- semana_tres + produtos[i,j]
         senao
            semana_quatro <- semana_quatro + produtos[i,j]
         fimse
      fimse
   fimse
   i <- i + 1
fimpara

//total de produtos
total <- soma_um + soma_dois + soma_tres


//exibir
escreval ()
escreval ()
escreval ("O número de produtos vendidos foi de: ")
escreval ("ítem 1: ", soma_um)
escreval ("ítem 2: ", soma_dois)
escreval ("ítem 3: ", soma_tres)
escreval ()
escreval ("O número TOTAL de produtos vendidos foi de: ", total)
escreval ()
escreval ("O número de produtos vendidos por semana foi de: ")
escreval ("Semana 1: ", semana_um)
escreval ("Semana 2: ", semana_dois)
escreval ("Semana 3: ", semana_tres)
escreval ("Semana 4: ", semana_quatro)
fimalgoritmo



