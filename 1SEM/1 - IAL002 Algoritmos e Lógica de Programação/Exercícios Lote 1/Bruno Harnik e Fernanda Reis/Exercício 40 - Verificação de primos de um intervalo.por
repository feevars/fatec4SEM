programa
{
	inteiro a, b, n1, n2, posicoes
	
	funcao inicio()
	{


		leia(a)

		leia(b)

		se (a < b){
			n1 = a
			n2 = b
		}
		senao {
			n1 = b
			n2 = a
		}

	}

	funcao intervalo(){

		posicoes = n1 - n2
		
		se(posicoes >= 1){

			ni = n1 + 1

			para(ni == n1 + 1; ni < n2; ni++)
			
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 248; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */