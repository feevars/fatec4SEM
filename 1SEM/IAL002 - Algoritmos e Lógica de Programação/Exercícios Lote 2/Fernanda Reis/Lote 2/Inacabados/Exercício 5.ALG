Algoritmo "5.	Criar e coletar em um vetor [20] inteiro. Calcule e exiba, segundo:""

Var
i,k, sub, num : inteiro
nums: vetor [1..6] de inteiro
Inicio
      i <- 1
      sub <- 0
      k <- 6
      //entrada
      escreval ("Digite 6 números:")
      leia (num)
           se (num < 1) entao
              escreval ("Número inválido!")
              <inicio>  //volta para o começo da funcao entrada
           senao
                // calculo em si
                nums[i] <- num
                i <- i+1
                para k <- 1 ate 6 faca
                     enquanto i < 5 faca
                              enquanto k > i faca
                                       sub <- nums[i] - nums[k]
                                       k <- k - 1
                                       i <- i + 1
                                       escreval ("valor: ",sub)
                              fimenquanto
                     fimenquanto
                fimpara
           fimse

Fimalgoritmo