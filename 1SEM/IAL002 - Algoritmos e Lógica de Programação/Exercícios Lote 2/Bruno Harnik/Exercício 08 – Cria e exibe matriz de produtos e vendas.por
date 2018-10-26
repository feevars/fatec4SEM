programa{

	const inteiro semanas = 4, produtos = 3

	inteiro tabela[semanas][produtos], linha, coluna, total_vendas, p, s, nome
	
	funcao inicio(){

		escreva("Exercício 08 - Lote 2\n\nCriar e carregar uma matriz [", semanas,"][", produtos, "] inteiro com quantidade\nde produtos vendidos em ", semanas," semanas. Calcular e exibir:\na)A quantidade de cada produto vendido no mês;\nb)A quantidade de produtos vendidos por semana;\nc)O total de produtos vendidos no mês.\n\nBruno Bega Harnik | RA 1110481823052\nProf. Ricardo Satoshi Oyakawa\n\n------------------------------------------------------------\n\n")
		
		escreva("Digite quantos produtos foram vendidos por semana.\n")
		
		total_vendas = 0

		para(linha = 0; linha < semanas; linha++){

			escreva("\n", linha  + 1, "ª semana\n")

			para(coluna = 0; coluna < produtos; coluna++){

				escreva("Produto ", coluna + 1, ": ")
				
				leia(tabela[linha][coluna])

				total_vendas = total_vendas + tabela[linha][coluna]
				
			}
		}

		escreva("\nVendas		")

		para(nome = 0; nome < produtos; nome++){

			escreva("Prod. ", nome + 1, "	")
		}

		escreva("\n")
		
		para(linha = 0; linha < semanas; linha++){
			
			escreva(linha + 1, "ª semana:	")
			
			para(coluna = 0; coluna < produtos; coluna++){

				escreva(tabela[linha][coluna],"	")

			}

			escreva("\n")
			
		}

		escreva("\nTotal de produtos vendidos: ", total_vendas)
		escreva("\n")
		
		para(p = 0; p < produtos; p++){

			escreva("\nTotal de vendas do ", p + 1, "º produto: ", SomaProduto(p))
			
		}

		escreva("\n")
		
		para(s = 0; s < semanas; s++){

			escreva("\nTotal de vendas na ", s + 1, "ª semana: ", SomaSemana(s))
			
		}

	}
	
	funcao inteiro SomaProduto(inteiro produto){

		inteiro total_produto = 0
		
		para(linha = 0; linha < semanas; linha++){

			total_produto = total_produto + tabela[linha][produto]
			
		}

		retorne total_produto
	}
	
	funcao inteiro SomaSemana(inteiro semana){

		inteiro total_semana = 0
		
		para(coluna = 0; coluna < produtos; coluna++){

			total_semana = total_semana + tabela[semana][coluna]
			
		}

		retorne total_semana
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 51; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */