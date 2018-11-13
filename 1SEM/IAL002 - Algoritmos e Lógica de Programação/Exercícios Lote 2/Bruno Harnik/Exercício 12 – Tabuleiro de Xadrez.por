programa{

	const real peao = 1.0, torre = 6.4, cavalo = 2.4, bispo = 4.0, rainha = 10.4, rei = 3.0, casa_vazia = 0.0

	real tabuleiro[8][8], somas[2][7], pecas[7] = {peao, torre, cavalo, bispo, rainha, rei, casa_vazia}

	inteiro l, c, i, soma
	
	cadeia nomes[7] = {" Peões", " Torres", " Cavalos", " Bispos", " Rainhas", " Reis", " Casas vazias"}
	
	funcao inicio(){

		escreva("Valores sugeridos por Evgeny Gik.\n\n")
		
		DistribuirPecas()

		para(l = 0; l < 8; l++){
			
			para(c = 0; c < 8; c++){

				para(i = 0; i < 7; i++){

					se(pecas[i] == tabuleiro[l][c]){
					
					somas[0][i] = somas[0][i] + 1 //Quantidade de peças
					somas[1][i] = somas[1][i] + tabuleiro[l][c] //Soma dos valores atribuidos
					}
				}
				
			}
			
		}

		escreva("\nO tabuleiro possui: ")

		para(i = 0; i < 7; i++){

			escreva("\n", somas[0][i], nomes[i], ", cuja soma dos valores informados é ", somas[1][i], ".")
			escreva("\nCada lado possui inicialmente ", somas[0][i] / 2, nomes[i] , ", com força total ", somas[1][i] / 2, ".\n")

		}
	}

	funcao DistribuirPecas(){

		escreva("\nDistribuição das peças no tabuleiro: \n")
		
		tabuleiro[0][0] = pecas[1]
		tabuleiro[0][1] = pecas[2]
		tabuleiro[0][2] = pecas[3]
		tabuleiro[0][3] = pecas[4]
		tabuleiro[0][4] = pecas[5]
		tabuleiro[0][5] = pecas[3]
		tabuleiro[0][6] = pecas[2]
		tabuleiro[0][7] = pecas[1]

		tabuleiro[7][0] = pecas[1]
		tabuleiro[7][1] = pecas[2]
		tabuleiro[7][2] = pecas[3]
		tabuleiro[7][3] = pecas[4]
		tabuleiro[7][4] = pecas[5]
		tabuleiro[7][5] = pecas[3]
		tabuleiro[7][6] = pecas[2]
		tabuleiro[7][7] = pecas[1]
		
		para(c = 0; c < 8; c++){
			
			l = 1
			tabuleiro[l][c] = pecas[0]
			
			l = 6
			tabuleiro[l][c] = pecas[0]

			para(l = 2; l < 6; l++){

				tabuleiro[l][c] = pecas[6]

			}
			
		}

		soma = 0
		
		para(l = 0; l < 8; l++){

			para(c = 0; c < 8; c++){

				soma = soma + tabuleiro[l][c]
				escreva("[ ", tabuleiro[l][c], " ]")
				
			}

			escreva("\n")

		}

		escreva("\nA soma dos valores de todas as casas é: ", soma, "\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 569; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */