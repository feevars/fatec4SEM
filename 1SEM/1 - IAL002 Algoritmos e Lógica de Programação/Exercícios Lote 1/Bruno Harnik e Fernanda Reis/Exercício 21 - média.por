programa
{
	funcao inicio()
	{
		real A1, A2, A3, A4, E 

		escreva("Nota da A1:")
		leia(A1)
		escreva("Nota da A2:")
		leia(A2)
		escreva("Nota da A3:")
		leia(A3)
		escreva("Nota da A4:")
		leia(A4)

		E=(A1+A2+A3+A4) / 4

		se(E>=6) {
			escreva("\n APROVADO")
		}
		senao{
			se(E>=3){
				escreva("EXAME")
			}
			senao {
				escreva("REPROVADO")
				
			}
		}
			
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 357; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */