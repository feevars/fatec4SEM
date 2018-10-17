programa
{
	funcao inicio()
	{
		//32.	Receba um número inteiro. Calcule e mostre o seu fatorial.

		inteiro numero, natual, cont

		natual = 1
		cont = 1
		
		escreva("Digite um numero: ")
		leia(numero)
		
		enquanto (natual <= numero) // Itera 'atual' até o valor informado
		{
			cont = cont * natual // Cálcula a próxima multipllicação do fatorial
			natual = natual + 1
		}
		
		escreva("O fatorial de ", numero, " é: ", cont, "\n")
}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 431; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */