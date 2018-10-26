programa{

	const inteiro qtd = 10

	inteiro menor, maior, valor, i
	
	funcao inicio(){

		escreva("Digite ", qtd, " números inteiros.\n")
		
		para(i = 0; i < qtd; i++){

			escreva(i + 1,"º: ")
			leia(valor)

			se(i == 0){
				menor = valor
				maior = valor
			}
			
			se(valor < menor){

				menor = valor
				
			}
			se(valor > maior){

				maior = valor
				
			}
		}

		escreva("\nMaior número: ", maior, "\nMenor número: ", menor, "\n")

	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 431; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */