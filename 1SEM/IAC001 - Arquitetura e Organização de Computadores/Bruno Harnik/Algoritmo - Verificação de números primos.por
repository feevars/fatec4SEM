programa{
	
	funcao inicio(){

		inteiro numero

		escreva("Digite um número natural maior que 0 e menor que 100000: ")
		leia(numero)

		se (numero < 1 ou numero > 100000){
			
			limpa()
			escreva("O número que você digitou não atende à regra deste algoritmo. \n\n")

			inicio()
		}
		senao{
			limpa()

			Primos(numero)
		}limpa()

		Primos(numero)
	}
	
	funcao Primos(inteiro n){

		inteiro i, quadrado

		escreva("Os números primos de 1 a ", n, " são:\n")

		i = 1

		enquanto(i <= n){

			quadrado = i * i
			
			se((quadrado % 2 != 0 e quadrado % 3 != 0 e quadrado % 5 != 0 e quadrado % 7 != 0) ou i == 1 ou i == 2 ou i == 3 ou i == 5 ou i == 7){

				escreva(i, "\n")

			}

			i++
			
		}			
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 354; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */