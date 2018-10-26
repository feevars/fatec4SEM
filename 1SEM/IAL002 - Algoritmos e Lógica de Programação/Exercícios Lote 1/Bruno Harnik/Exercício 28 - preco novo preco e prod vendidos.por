programa
{
	funcao inicio()
	{
		real prec, vend, nprec

		escreva("\nDigite um valor (preço): ")
		leia(prec)
		escreva("\nDigite o número de produtos vendidos: ")
		leia(vend)

		se(prec<30 e vend<500) {
			nprec = 1.10 * prec
		}
		senao {
			se(vend>=500 e vend<1000 e prec>=30 e prec<80) {
				nprec = 1.15 * prec
			}
			senao {
				se(vend>=1000 e prec>=80) {
					nprec = 0.95 * prec
				}
				senao {
					nprec = prec
				}
		
			}
		}
		escreva("\nPreço final: R$", nprec)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 334; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */