programa
{	
	inteiro i, vetor[7], x = 2, soma = 0, resto = 0
	
	funcao inicio()
	{
		escreva("Exercício 4 da P2\n\nSequência de 7 dígitos.\nVocê deve digitar 7 números inteiros de 0 a 9.\n\n")

		//Looping para receber o vetor
		para(i = 0; i < 7; i++){

			escreva(i + 1, "º dígito: ")
			
			leia(vetor[i])
			
			se(vetor[i] < 0 ou vetor[i] > 9){

				escreva("O valor deve ser maior ou igual a 0 e menor ou igual a 9.\nDigite novamente o ")
				
				i--
				
			}
		}
		
		//Este looping eu fiz apenas para exibir o vetor, não precisa
		escreva("\n")
		para (i = 0; i < 7; i++){

			se(i == 6){
				escreva("-")
			}

			escreva(vetor[i])

			
		}
		escreva("\n")

		
		para (i = 5; i >= 0; i--){

			//a)
			vetor[i] = vetor[i] * x
			x++
			//b)
			soma = soma + vetor[i]
			
		}

		//c)
		resto = soma % 11
		//d)
		resto = 11 - resto
		//e)
		se(resto == 10 ou resto == 11){
			resto = 0
		}
		//f)
		se(resto == vetor[6]){

			//Exemplos de corretos:
			//422613-5
			//254321-4
			escreva("\nCorreto\n")
			
		}senao{
			escreva("\nIncorreto\n")
		}

	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 987; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */