programa
{
	funcao inicio()
	{
		//32.	Receba um número inteiro. Calcule e mostre o seu fatorial.

		inteiro numero, cont

		cont = 1
		
		escreva("Digite um número inteiro: ")
		leia(numero)
		faca {
			cont = cont * (numero * (numero - 1))
			numero = numero -2
			escreva(cont, ",")
		}
		enquanto (numero > 1) 

		escreva("\nO fatorial desse número é:", cont)
}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 363; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */