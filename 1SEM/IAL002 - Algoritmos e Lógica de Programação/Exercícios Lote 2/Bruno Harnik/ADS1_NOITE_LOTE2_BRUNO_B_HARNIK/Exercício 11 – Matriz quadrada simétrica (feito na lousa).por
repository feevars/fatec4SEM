programa{

	inteiro m[8][8], x, y, z
	
	funcao inicio()
	{
		para (z = 0; z <= 3; z++){

			para (x = z; x <= (7 - z); x++){

				para (y = z; y <= (7 - z); y++){

					m[x][y] = z + 1
					
				}	
				
			}

		}

		para (x = 0; x <= 7; x++){
			
			para (y = 0; y <= 7; y++){

					escreva(" | ", m[x][y], " | ")

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
 * @POSICAO-CURSOR = 311; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */