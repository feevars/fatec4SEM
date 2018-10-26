programa
{
	funcao inicio()
	{
		inteiro a, b, c

		escreva("Digite um número inteiro: ")
		leia(a)

		b = a % 2
		c = a % 3

		se (b != 0 ou c != 0){
			escreva("O número não é divisível por 2 e 3")
		}
		senao{
			escreva("O número é divisível por 2 e 3.\n")
			escreva("\n", a, " / 2 = ", a / 2, "\n", a, " / 3 = ", a / 3)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 150; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */