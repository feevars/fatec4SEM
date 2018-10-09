programa
{
	funcao inicio()
	{
		inteiro x, y
		escreva("Ordenador de dois inteiros\n\n")
		escreva("Digite o primeiro número inteiro: ")
		leia(x)
		escreva("Digite outro número inteiro: ")
		leia(y)

		se(x < y){
			escreva("\nOrdem crescente: ", x,", ",y)
		}
		senao{
			escreva("\nOrdem crescente: ", y,", ",x)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 306; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */