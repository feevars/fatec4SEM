programa{
	
	const inteiro qtd = 4

	inteiro matriz[qtd][qtd], l, c, valor = 1

	funcao inicio(){

			escreva("Exercício 10 - Lote 2\n\nCriar uma matriz [", qtd,"][", qtd, "] onde o programa irá carregar a soma do valor na casa seguinte.\n\n\nBruno Bega Harnik | RA 1110481823052\nProf. Ricardo Satoshi Oyakawa\n\n------------------------------------------------------------\n\n")
		
		para(l = 0; l < qtd; l++){

			escreva(valor, "	")

			para(c = 0; c < qtd - 1; c++){
				
				valor = valor + valor
				escreva(valor, "	")
				
			}

			valor = valor + valor

			escreva("\n")
			
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 237; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */