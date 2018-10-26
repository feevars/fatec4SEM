programa
{
	inclua biblioteca Matematica --> mat
	//33.	Receba um número. Calcule e mostre a série 1 + 1/2 + 1/3 + ... + 1/N.
	funcao inicio()
	{
		real numero, cont, result

		cont=0
		result=0

		escreva("Calcularemos o resultado de 1/1+1/2+1/3+...+1/N")
		escreva("\nDigite o número N:")
		leia(numero)

		 enquanto (numero >= 1) {
		 	
			result = mat.potencia(numero, -1.0)
			cont = cont + result
			numero = (numero -1)
			escreva(cont, ",") 
		 }
		
			escreva("\nO resultado da soma é:", cont)
		}
		
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 492; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */