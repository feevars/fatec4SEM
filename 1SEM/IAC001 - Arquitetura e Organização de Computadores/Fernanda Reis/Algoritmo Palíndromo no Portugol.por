programa{

	inclua biblioteca Tipos --> tp

	inteiro valor

	cadeia valor_c, metade_1, metade_2, metade_espelhada

	funcao inicio(){
		
		escreva("Insira um número inteiro:")
		leia(valor)

		valor_c = tp.inteiro_para_cadeia(valor, 10)

		escreva(valor_c)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 113; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */