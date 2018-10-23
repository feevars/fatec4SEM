programa{
	
	inclua biblioteca Util --> u
	
	const inteiro linhas = 6, colunas = 6

	inteiro linha, coluna, matriz[linhas][colunas]
	
	funcao inicio(){
	
	escreva("Exercício 09 - Lote 2\n\nCriar e carregar uma matriz [", linhas,"][", colunas, "] com valores aleatórios,\nsendo que a diagonal principal terá seus dados carregados no programa.\n\nBruno Bega Harnik | RA 1110481823052\nProf. Ricardo Satoshi Oyakawa\n\n------------------------------------------------------------\n\n")

	escreva("Fezinha da Megasena\n")
	
	para(linha = 0; linha < linhas; linha++){

		escreva("\n")
		para(coluna = 0; coluna < colunas; coluna++){
			
			matriz[linha][coluna] = u.sorteia(1, 60)
			
			se(coluna == linha){
	
				escreva("[", matriz[linha][coluna], "]	")
				
			}
			senao{

				escreva("", matriz[linha][coluna], "	")
				
			}
			
		}
		
	}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 494; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */