/* Exercício 5: Equação com duas raízes */
programa
{

	inclua biblioteca Matematica --> mat  // Inclui a biblioteca Matemática

	funcao inicio()
	{
		real A, B, C, X1, X2, raiz_quadrada, delta

		leia(A, B, C)

		delta = B * B - 4 * A * C

		raiz_quadrada = mat.raiz(delta, 2.0)

		X1 = (-B + (raiz_quadrada)) / 2 * A

		X2 = (-B - (raiz_quadrada)) / 2 * A

		escreva("X1 = ", X1, " e X2 = ", X2)
	}
}


/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 0; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */