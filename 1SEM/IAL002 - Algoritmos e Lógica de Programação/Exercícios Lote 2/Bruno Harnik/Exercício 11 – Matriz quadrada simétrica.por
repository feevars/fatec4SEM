programa{

	const inteiro qtd = 8

	inteiro matriz[qtd][qtd], valor, i, l, c
	
	funcao inicio(){

		escreva("Exercício 11 - Lote 2\n\nCriar uma matriz [", qtd,"][", qtd, "] inteiro e o programa irá carregar como um alvo,\ncom ", qtd / 2 ,"dados: borda 1, borda 2, borda 3...\n\n\nBruno Bega Harnik | RA 1110481823052\nProf. Ricardo Satoshi Oyakawa\n\n------------------------------------------------------------\n\n")

		para(l = 0; l < qtd; l++){
			
			para(c = 0; c < qtd ; c++){
					
					se(l == c e l < qtd / 2){

						escreva("Digite o ", l + 1, "º valor: ")
						leia(valor)
						
						matriz[l][c] = valor
						matriz[qtd - 1 - l][c] = valor
						matriz[l][qtd - 1 - c] = valor
						matriz[qtd - 1 - l][qtd - 1 - c] = valor

						para(i = l + 1; i < qtd / 2; i++){

							matriz[i][c] = valor
							matriz[qtd - 1 - i][qtd - 1 - c] = valor
							matriz[qtd - 1 - i][c] = valor
							matriz[i][qtd - 1 - c] = valor
							
						}

						para(i = c + 1; i < qtd / 2; i++){

							matriz[l][i] = valor
							matriz[qtd - 1 - l][qtd - 1 - i] = valor
							matriz[qtd - 1 - l][i] = valor
							matriz[l][qtd - 1 - i] = valor
							
						}
						
					}

			}
			
		}

		escreva("\n")
		
		para(l = 0; l < qtd; l++){
			
			para(c = 0; c < qtd; c++){

				escreva(" | ", matriz[l][c], " | ")
				
			}

			escreva("\n")
			
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1207; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */