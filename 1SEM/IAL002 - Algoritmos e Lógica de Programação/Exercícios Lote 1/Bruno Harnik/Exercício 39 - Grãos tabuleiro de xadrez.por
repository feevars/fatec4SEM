programa{
	
	inteiro casa, qtd, total
	
	funcao inicio(){

		qtd = 1
		total = 0

		para(casa = 1; casa < 65; casa++){

			escreva(casa, "ª casa: ")


			se(casa < 65){

				qtd = qtd * 2
				total = total + qtd
				
				escreva(qtd, " grãos\n")
			}
			

		}

	escreva("Total de grãos: ", total)
	
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 57; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */