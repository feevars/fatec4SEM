programa{

	const inteiro peao = 1, torre = 2, cavalo = 4, bispo = 3, rainha = 5, rei = 6, casa_vazia = 7

	inteiro tabuleiro[8][8], l, c, i, soma, somas[2][7], pecas[7] = {peao, torre, cavalo, bispo, rainha, rei, casa_vazia}

	cadeia nomes[7] = {" Peões", " Torres", " Cavalos", " Bispos", " Rainhas", " Reis", " Casas vazias"}
	
	funcao inicio(){

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

		para(l = 0; l < 8; l++){
			
			para(c = 0; c < 8; c++){

				para(i = 0; i < 7; i++){

					se(pecas[i] == tabuleiro[l][c]){
					
					somas[0][i] = somas[0][i] + 1
					somas[1][i] = somas[1][i] + tabuleiro[l][c]
					}
				}
				
			}
			
		}

		escreva("\nO tabuleiro possui: ")

		para(i = 0; i < 7; i++){

			escreva("\n", somas[0][i], nomes[i], ", cuja soma dos valores informados é ", somas[1][i])

		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1353; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */