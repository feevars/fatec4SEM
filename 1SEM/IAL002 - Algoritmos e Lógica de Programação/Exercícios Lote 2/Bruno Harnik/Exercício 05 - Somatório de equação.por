programa{

	const inteiro qtd = 20

	inteiro vetor[qtd], i, soma, x
	
	funcao inicio(){

		escreva("Exercício 05 - Lote 2\n\nCriar e coletar em um vetor [", qtd, "] inteiro.\nCalcule e exiba o somatório das posições de 1 a 10 para vetor[i] - vetor[20 - i]\n\nBruno Bega Harnik | RA 1110481823052\nProf. Ricardo Satoshi Oyakawa\n\n------------------------------------------------------------\n\n")

		escreva("Digite 20 valores inteiros...\n\n")
		
		para(i = 0; i < qtd; i++){

			escreva(i + 1 ,"º valor: ")
			leia(vetor[i])
			
		}

		i = 0
		soma = 0
		para(i = 0; i < 10; i++){

			x = qtd - 1 - i
			
			soma = soma + (vetor[i] - vetor[x])
			
		}

		escreva("\nSe eu entendi direito, o somatório da equação proposta é ", soma, "\n")

	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 724; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */