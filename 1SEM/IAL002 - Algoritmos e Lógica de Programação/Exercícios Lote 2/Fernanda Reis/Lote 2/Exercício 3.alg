algoritmo "Criar e coletar valores inteiros nos vetores VT1[3] e vt2[3]."
          "Concatenar esses valores em um 3º vetor VT[6] e mostrar seus dados."

var
   vt1: vetor [1..3] de inteiro
   vt2: vetor [1..3] de inteiro
   vt3: vetor [1..6] de inteiro
   i , j : inteiro
inicio
      j <- 1
      para i <- 1 ate 3 faca

           escreval ("Digite o ",i,"º valor do primeiro vetor: ")
           leia (vt1[i])
           se (j % 2 = 1) entao
           vt3[j] <- vt1[i]
           j <- j + 2
           senao
           fimse
      fimpara
      j <- 2
      para i <- 1 ate 3 faca
           escreval ("Digite o ",i,"º valor do segundo vetor: ")
           leia (vt2[i])
           se (j % 2 = 0) entao
           vt3[j] <- vt2[i]
           j <- j + 2
           senao
           fimse
      fimpara
      j<-1
             escreval ("Números concatenados: ")
             enquanto (j<7) faca
                  escreva (vt3[j])
                  j <- j+1
              fimenquanto
              


      // vt3[1] = vt1[1]  = vt1[1]
      // vt3[2] = vt2[4]  = vt2[1]
      // vt3[3] = vt1[2]  = vt1[2]
      // vt3[4] = vt2[5]  = vt2[2]
      // vt3[5] = vt1[3]  = vt1[3]
      // vt3[6] = vt2[6]  = vt2[3]

fimalgoritmo
