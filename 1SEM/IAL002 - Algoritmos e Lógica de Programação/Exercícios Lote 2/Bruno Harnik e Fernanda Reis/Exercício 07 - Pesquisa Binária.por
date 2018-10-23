programa
{
	const inteiro qtd = 20

	inteiro i, j, meio

	real vetor[qtd], aux, key

	funcao inicio(){

		meio = 0

		escreva("Exercício 07 - Lote 2\n\nCriar e coletar em um vetor [", qtd, "] com números aleatórios.\nClassificar este vetor em ordem crescente e mostrar os dados.\n\nBruno Bega Harnik | RA 1110481823052\nProf. Ricardo Satoshi Oyakawa\n\n------------------------------------------------------------\n\n")
		
		escreva("Insira ", qtd, " valores reais:\n")
	
		aux = 0.0
		
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
		
		escreva("\nDigite um valor, verifique se ele está na lista e em qual posição se encontra: ")
		leia(key)
		
		PesquisaBinaria(vetor, key, qtd )

		se(meio == -1){
			escreva("\nO valor que você solicitou não foi encontrado no vetor.\n")
		}
		senao{
			escreva("\nO valor que você solicitou foi encontrado na ", meio + 1, "ª posição.\n")
		}
	}
	
	funcao PesquisaBinaria(real vet[], real chave, inteiro tam){
	
			inteiro zero = 0
	
			enquanto (zero < tam - 1){
	
				meio = (zero + tam) / 2

				se (chave == vet[meio]){
					
					retorne
					
				}
				se (chave < vet[meio]){
					
					tam = meio
					
				}
				senao{
					zero = meio
				}
					
			}		

		meio = -1
		retorne
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 34; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */