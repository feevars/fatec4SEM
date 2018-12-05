programa{

	funcao inicio(){

		inteiro numero_binario, x = 1, potencia = 1, vetor_binario[10], i, soma = 0, decimal

		escreva("Insira um número binário maior que 1 e menor que 1000000000: ")
		leia(numero_binario)

		//Validação do intervalo do enunciado
		se(numero_binario < 1 ou numero_binario > 1000000000){

			limpa()
			escreva("Você digitou um valor inválido. Refaça...\n")

			inicio()
			
		}senao{
			//Separa os algarismos e popula o vetor
			para(i = 0; i < 10; i++){
	
				vetor_binario[i] = numero_binario / x % 10 
				
				x = x * 10

				se(vetor_binario[i] < 0 ou vetor_binario[i] > 1){
	
					limpa()
					escreva("O número que você digitou não é binário. Refaça...\n")
	
					inicio()
					
				}
			}
			
			para(i = 0; i < 10; i++){
	
				se(i == 0){
	
					soma = vetor_binario[i]
					
				}senao{
	
					potencia = potencia * 2
					soma = soma + (vetor_binario[i] * potencia)
					
				}
				
			}
	
			decimal = soma

			limpa()
			escreva("O número binário ", numero_binario, " em decimal é ", decimal)

			escreva("\n\nVerifique outro número binário :-)\n")
			inicio()

		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1106; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */