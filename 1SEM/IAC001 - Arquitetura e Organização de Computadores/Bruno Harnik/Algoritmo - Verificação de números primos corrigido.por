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
		}
	}
	
	funcao Primos(inteiro n){


		inteiro i, p, quadrado, primos[n]

		primos[0] = 1
		primos[1] = 2
		primos[2] = 3
		primos[3] = 5
		primos[4] = 7

		escreva("Os números primos de 1 a ", n, " são:\n")

		i = 1
		
		p = 0
		
		enquanto(i < n - 1 e i < 10){

			se((i < 10) e (primos[p] == 1 ou primos[p] == 2 ou primos[p] == 3 ou primos[p] == 5 ou primos[p] == 7)){
				escreva(primos[p], "\n")
				p++
			}

			i++
			
		}

		i = 10

		enquanto(i <= n){

			p = 1

			enquanto(p <= i){

				se(primos[p] == 0){

					
					primos[p] = i
					escreva(primos[p], "\n")
					p = i + 1
					
				}
				senao se(i % primos[p] == 0){
					
					p = i + 1
					
				}
				senao se(i % primos[p] != 0){
					
					p++
				
				}
				
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
 * @POSICAO-CURSOR = 329; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */