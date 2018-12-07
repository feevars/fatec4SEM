programa
{

	inteiro numero, f, fatorial = 1
	
	funcao inicio()
	{
	
		escreva("Digite um número inteiro positivo: ")
		leia(numero)

		se(numero == 0 ou numero == 1){

			escreva("O fatorial de ", numero, " é igual a 1.")
		}senao{

			para(f = numero; f > 1; f--){

				fatorial = fatorial * f
				
			}

			escreva("O fatorial de ", numero, " é igual a ", fatorial)
			
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 305; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */