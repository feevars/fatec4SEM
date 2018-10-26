programa
{
	funcao inicio()
	{
		inteiro A, B, C
		
		escreva("Valor A: ")
		leia(A)
		escreva("Valor B: ")
		leia(B)

		se ( A > B ){
			
			C = A - B

		}
		senao {
			
			C = B - A
			
		}

		escreva("O resultado da diferença do maior pelo menor valor é: ", C)
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 128; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */