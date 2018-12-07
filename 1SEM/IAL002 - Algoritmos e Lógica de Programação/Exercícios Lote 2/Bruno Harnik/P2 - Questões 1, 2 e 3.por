programa{

	inclua biblioteca Util --> util
	
	const inteiro qtd = 10, total = 100
	
	inteiro MAT[qtd][qtd], i, j
	
	funcao inicio(){

		inteiro opcao
		
		escreva("P2 do Satoshi\n\nExercício 3\nMenu de opções das questões 1 e 2.\n\n")
		escreva("[1] Carregar matriz\n[2]Ordenar matriz\n[9]Finalizar programa\n\nDigite a opção desejada: ")
		leia(opcao)

		escolha(opcao){
			caso 1 :	limpa()
					CarregaMat()
					inicio()
					pare
					
			caso 2 :	OrdenaMat(MAT)

					//Escrevo com a Matriz retornada
					para(i = 0; i < qtd; i++){
			
						para(j = 0; j < qtd; j++){
			
							escreva(MAT[i][j], "	")
			
						}
						escreva("\n")
					}

					inicio()

					
					pare

			caso 9 : 	escreva("Fim")
					pare

			caso contrario : 	escreva("Você digitou uma opção inválida. Refaça...\n\n")
							inicio()
		}

	}

	//Procedimento Carrega Matriz e soma os dividíveis por 3 e 5
	funcao CarregaMat(){

		MAT[0][0] = 1
		
		inteiro soma_div = 0

		//Enunciado
		escreva("Exercício 1\nCarregue a matriz como exibida no enunciado, com diagonal principal\nque o valor seguinte tem dobro do valor anterior e o primeiro valor é 1,\nmostre a soma dos divisíveis por 3 e 5.\n\n")
		escreva("Não pode movimentar conteúdo na matriz, tipo \"chumbar campo\".\n\n\n")

		//Looping de carregamento da Matriz
		para(i = 0; i < qtd; i++){

			para(j = 0; j < qtd; j++){

				//se os índices i e j são iguais executa a regra
				se(i == j){
					//mas só a partir da segunda posição da diagonal
					se(i > 0){
						MAT[i][j] = MAT[i - 1][j - 1] * 2
					}
				//senão, coloca um número aleatório
				}senao{
					MAT[i][j] = util.sorteia(-99, 999)
				}
				//Aí escreve a matriz para vermos bonitinha.
				escreva(MAT[i][j], "	")

				se(MAT[i][j] % 3 == 0 e MAT[i][j] % 5 == 0){

					soma_div = soma_div + MAT[i][j]
					
				}
			}
			
			//Pula linha na tabela
			escreva("\n")
		}
		//Escreve a soma dos divisíveis por 3 e 5
		escreva("\nA soma dos números divisíveis por 3 e 5 desta matriz é: ", soma_div, "\n\n\n")
	}

	funcao OrdenaMat(inteiro ORD[][]){

		inteiro ordenador[total], k = 0, aux

		//Enunciado
		escreva("Exercício 2\nCriar uma função que receba a matriz e\nretorne-a classificada em ordem crescente.\n\n\n")

		//O primeiro looping passa a matriz inteira para um vetor de índice único
		para(i = 0; i < qtd; i++){

			para(j = 0; j < qtd; j++){

				ordenador[k] =  MAT[i][j]
				k++

			}
		}

		//Bubble sort no vetor
		para(i = 0; i < total; i++){
			//O segundo índice deve ir até um antes do índice em questão no looping
			para(j = 0; j < i; j++){
				//e então avaliar se o valor do novo índice é maior que o índice "travado", se for...
				se(ordenador[j] > ordenador[i]){

					//faz a troca de ordenador[i] com ordenador[j]
					aux = ordenador[j]
					ordenador[j] = ordenador[i]
					ordenador[i] = aux
				
				}
				
			}	

		}

		//Remonto a matriz ordenada
		k = 0
		para(i = 0; i < qtd; i++){

			para(j = 0; j < qtd; j++){

				ORD[i][j] = ordenador[k]
				k++

			}
		}

	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 2028; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */