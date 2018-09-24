programa
{
	funcao inicio()
	{
		//35.	Receba 2 números inteiros, verifique qual o maior entre eles. Calcule e mostre o resultado da 
		//		somatória dos números ímpares entre esses valores.

		inteiro num, ndois, cont, soma


		escreva("/n Digite dois números: ")
		leia(num)
		leia(ndois)

		
		cont = num + 1
		soma = 0

		se (num < ndois) {
			enquanto (cont > num)
			para (cont = num + 1; cont < ndois; cont++) {
				se (cont % 2 == 1) {
					soma = soma + cont
				}
				senao
					soma = soma
			}
		}
		senao
			enquanto (cont > ndois)
			para (cont = ndois + 1; cont < num; cont++) {
				se (cont % 2 == 1) {
					soma = soma + cont
				}
				senao
					soma = soma			
			}
		escreva("A soma dos ímpares entre os números é: ", soma)

					
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 262; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */