programa
{
	funcao inicio()
	{
		inteiro opcao, valor, nvalor
		escreva ("1)Poupança \n2)Renda fixa \n \n Escolha uma opção: ")
		leia(opcao)
		escreva("\nInsira valor de investimento: ")
		leia(valor)


		se (opcao == 1) {
			nvalor=valor* 1.03
			escreva("\nValor de investimento após 1 mês: R$",nvalor)
		}
		senao {
			se(opcao == 2) {
				nvalor=valor * 1.05
				escreva("\nValor de investimento após 1 mês: R$",nvalor)
			}
			senao {
				escreva("\n Opção inválida!")
				inicio()
			}
		}
	
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 323; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */