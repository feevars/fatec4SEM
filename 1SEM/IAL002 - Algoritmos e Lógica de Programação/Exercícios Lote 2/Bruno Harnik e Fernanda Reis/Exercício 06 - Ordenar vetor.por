programa
{
	const inteiro qtd = 5

	inteiro i, j

	real vetor[qtd], aux
	
	funcao inicio(){

		escreva("Exercício 06 - Lote 2\n\nCriar e coletar em um vetor [", qtd, "] com números aleatórios.\nClassificar este vetor em ordem crescente e mostrar os dados.\n\nBruno Bega Harnik | RA 1110481823052\nProf. Ricardo Satoshi Oyakawa\n\n------------------------------------------------------------\n\n")

		escreva("Insira ", qtd, " valores reais:\n")

		aux = 0
		
		para(i = 0; i < qtd; i++){
				
			leia(vetor[i])

			para(j = 0; j < qtd; j++){	

				se(vetor[i] < vetor[j]){

					aux = vetor[i]
					vetor[i] = vetor[j]
					vetor[j] = aux
					
				}
			}
		}
		escreva("\nValores ordenados:\n")
		para(i = 0; i < qtd; i++){
			
			escreva(vetor[i], "\n")
			
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 33; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */