programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		inteiro a, b, maior, menor
		
		escreva("Digite dois números inteiros: ")
		leia(a,b)
		
		maior = mat.maior_numero(a, b)
		menor = mat.menor_numero(a, b)

		se (maior % menor == 0){
			escreva(maior, " é divisível por ", menor, ".\n", maior, " / ", menor, " = ", maior / menor)
		}
		senao{
			escreva(maior, " não é divisível por ", menor, ".")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 423; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */