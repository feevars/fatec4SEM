programa
{	
	funcao inicio(){

		escreva("Exercício 03 ? Criar e coletar valores inteiros nos vetores VT1[3] e VT2[3].\nConcatenar esses valores em um 3º vetor (VT3[6]) e mostrar os seus dados.\n\nBruno Bega Harnik | RA 1110481823052\nProf. Ricardo Satoshi Oyakawa\n\n------------------------------------------------------------\n\n")

		const inteiro qtd = 4
		//Não tem um jeito de multiplicar a constante por 2?
		inteiro VT1[qtd], VT2[qtd], VT3[8], i, par, impar
	
		escreva("Digite os valores do vetor 1\n")
		i = 0
		
		para (i = 0; i < qtd; i++){
	
			escreva("Insira o ", i + 1, "º valor: ")
			leia(VT1[i])
			
		}
	
		escreva("\nDigite os valores do vetor 2\n")
		i = 0
		
		para (i = 0; i < qtd; i++){
	
			escreva("Insira o ", i + 1, "º valor: ")
			leia(VT2[i])
			
		}
	
		i = 0	
		para (i = 0; i < qtd * 2; i = i + 2){
	
			par = i / 2
			VT3[i] = VT1[par]
	
		}

		i = 1
		para (i = 1; i < qtd * 2; i = i + 2){
	
			impar = (i + 1) / 2 - 1
			VT3[i] = VT2[impar]
	
		}

		escreva("\nConcatena vetor 1 e 2 no vetor 3\n")
		i = 0
		para (i = 0; i < qtd * 2; i++){

			escreva(i + 1, "º valor: ", VT3[i], "\n")
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1070; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */