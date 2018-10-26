programa
{
	const inteiro qtd = 6
	
	inteiro vetor[qtd], i, maior, menor
	
	real md
		
	funcao inicio(){

		escreva("Exercício 02 - Lote 2\n\nCriar e coletar um vetor [", qtd ,"] inteiro e exibir:\na)O maior e o menor valor;\nb)A média dos valores.\n\nBruno Bega Harnik | RA 1110481823052\nProf. Ricardo Satoshi Oyakawa\n\n------------------------------------------------------------\n\n")

		i = 0
		maior = 0
		menor = 0
		md = 0
		
		para(i = 0; i <= qtd - 1; i++){

			escreva("Insira o ", i + 1, "º número: ")
			leia(vetor[i])

			se (i == 0){
				maior = vetor[i]
				menor = vetor[i]
			}

			se (vetor[i] > maior){
	
				maior = vetor[i]
				
			}
	
			se (vetor[i] < menor){
	
				menor = vetor[i]
				
			}

			md = md + vetor[i]

		}

		md = md / qtd

		escreva("\nO maior número inseirido foi ", maior, ", o menor foi ", menor, ".\n\n")

		escreva("A média dos números inseridos é ", md, "\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 32; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */