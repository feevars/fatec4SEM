programa{

	inteiro tabuleiro[8][8], l, c

	const inteiro peao = 1, torre = 2, cavalo = 4, bispo = 3, rainha = 5, rei = 6, casa_vazia = 7
	
	funcao inicio(){

		para(c = 0; c < 8; c++){
			
			para
			
			l = 1
			tabuleiro[l][c] = peao
			
			l = 6
			tabuleiro[l][c] = peao

			para(l = 2; l < 6; l++){

				tabuleiro[l][c] = casa_vazia

			}
			
		}
			
		

		

		para(l = 0; l < 8; l++){

			para(c = 0; c < 8; c++){

				escreva("[ ", tabuleiro[l][c], " ]")
				
			}

			escreva("\n")

			
		}
			
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 197; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */