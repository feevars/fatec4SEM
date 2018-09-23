programa
{
	funcao inicio()
	{
		inteiro hi, hf, mi, mf, mti, mtf, minutos, horas, mresult
		
			escreva("Digite a hora inicial da partida: ")
			leia(hi)
			escreva("Digite os minutos: ")
			leia(mi)
			escreva("\nDigite a hora final da partida: ")
			leia(hf)
			escreva("Digite os minutos: ")
			leia(mf)

		se (hi >= 24 ou hi < 0 ou hf >= 24 ou hf < 0 ou mi >= 60 ou mi < 0 ou mf >= 60 ou mf < 0 ){
			escreva("Você inseriu valores que não são válidos para horas e minutos. Por favor, tente novamente. \n\n")
			inicio() 
		}
		senao{
			mti = (hi * 60) + mi
			mtf = (hf * 60) + mf

			se (mtf < mti){
				minutos = mtf + 1440 - mti
			}
			senao{
				minutos = mtf - mti
			}
			horas = minutos / 60
			mresult = minutos % 60
			escreva("O tempo da partida foi de ", horas, " hora(s) e ", mresult, " minuto(s).")
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 815; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */