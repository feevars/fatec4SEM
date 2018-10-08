programa
{

	inteiro vetor[5], i, qti, soma
	real md
	
	funcao inicio()
	{

		MediaIntervalo()
		SomaImpares()
		

		escreva(md)
		
		
	}
	funcao MediaIntervalo(){
		
		qti = 0
		md = 0.0

		para (i = 0; i <= 4; i++){
			leia(vetor[i])
			
			se (vetor[i] >= 10 e vetor[i] <= 200){

				qti = qti + 1
				md = md + vetor[i]
				
			}

		}

		md = md / qti
	}
	funcao SomaImpares(){
		se (vetor[i] % 2 != 0){
			
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 411; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */