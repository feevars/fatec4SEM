programa
{
     inclua biblioteca Matematica --> mat

     funcao inicio()
     {
		escreva("Equação do 2º grau (Ax²+ Bx + C)\n\n")
     	
          real A, B, C, delta, X1, X2
          
          escreva("Valor de A: ")
          leia(A)
          escreva("Valor de B: ")
          leia(B)
          escreva("Valor de C: ")
          leia(C)


		//Equação de Segundo Grau

		delta = (B * B) - (4 * A * C)

		escreva("\nDelta: ", delta)

		se (delta > 0){
			
			X1 = ( -B + mat.raiz( delta, 2.0 ) ) / 2 * A
			X2 = ( -B - mat.raiz( delta, 2.0 ) ) / 2 * A
			escreva("\nX1 = ", X1)
			escreva("\nX2 = ", X2)
			
		}
		senao{
			se (delta==0) {
			
				X1 = -B  / 2 * A
				escreva("\nUma única raíz real: ", X1)
		
			}
			senao{
			
				escreva("\nDelta negativo ou menor que 0 não pode ser calculado")
			
			}
			
		}
		
     }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 815; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */