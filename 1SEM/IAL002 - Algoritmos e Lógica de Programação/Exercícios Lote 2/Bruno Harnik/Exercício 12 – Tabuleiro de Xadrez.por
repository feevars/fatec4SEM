programa{

	inteiro tabuleiro[8][8], l, c, soma

	const inteiro peao = 1, torre = 2, cavalo = 4, bispo = 3, rainha = 5, rei = 6, casa_vazia = 7
	
	funcao inicio(){

		tabuleiro[0][0] = 2
		tabuleiro[0][1] = 4
		tabuleiro[0][2] = 3
		tabuleiro[0][3] = 5
		tabuleiro[0][4] = 6
		tabuleiro[0][5] = 3
		tabuleiro[0][6] = 4
		tabuleiro[0][7] = 2

		tabuleiro[7][0] = 2
		tabuleiro[7][1] = 4
		tabuleiro[7][2] = 3
		tabuleiro[7][3] = 5
		tabuleiro[7][4] = 6
		tabuleiro[7][5] = 3
		tabuleiro[7][6] = 4
		tabuleiro[7][7] = 2
		
		para(c = 0; c < 8; c++){
			
			l = 1
			tabuleiro[l][c] = peao
			
			l = 6
			tabuleiro[l][c] = peao

			para(l = 2; l < 6; l++){

				tabuleiro[l][c] = casa_vazia

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

		escreva("\nA soma dos valores das casas é: ", soma)
			
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 877; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */