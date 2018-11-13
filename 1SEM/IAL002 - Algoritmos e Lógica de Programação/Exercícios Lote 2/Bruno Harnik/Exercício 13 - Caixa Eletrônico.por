programa{

	inclua biblioteca Util --> u
	
	inteiro opcao, notas[3][6], qtd, saques_bancos[2][4], i, valor_total, total_saques = 0, valor_saque, saque_notas[2][6]

	cadeia bancos_nomes[4] = {"Banco do Brasil", "Santander", "Itaú", "Caixa Econômica"}
	
	funcao inicio() {
		
		notas[0][0] = 2 //2 reais
		notas[0][1] = 5 //5 reais
		notas[0][2] = 10 //10 reais
		notas[0][3] = 20 //20 reais
		notas[0][4] = 50 //50 reais
		notas[0][5] = 100 //100 reais
		//Na primeira linha deste vetor temos o valor da nota,
		//na seguda temos a quantidade e
		//na terceira temos o valor total da soma das notas de mesmo valor.

		escreva("-=$| Caixa Eletrônico |$=-\n")
		
		valor_total = 0
		
		para(i = 0; i < 6; i++){

			valor_total = (notas[0][i] * notas[1][i]) + valor_total
			//Calcula o valor total do caixa
			notas[2][i] = notas[0][i] * notas[1][i]
			//Calcula o valor total de cada nota.
		}
		
		escreva("Total em caixa: R$", valor_total, ",00 \n\n")
		
		escreva("Opções:\n[1] Carregar Notas     [2] Saque     [3] Estatística     [9] Fim\n")
		escreva("\nDigite a opção desejada: ")

		leia(opcao)
		//Lê a opção do menu inicial
		limpa()
		
		escolha (opcao) {
			caso 1: CarregarNotas()
				
				limpa()
				inicio()
			caso 2: Banco()
				
				total_saques = total_saques + 1
				inicio()
			caso 3:
				escreva("Opção 3 - Estatística")
				pare
			caso 9:
				escreva("Fim\n")
				pare
			caso contrario: escreva("Opção inválida...")
		 		u.aguarde(1500)
		 		limpa()
		 		inicio()
		}
		
	}

	funcao CarregarNotas(){

		escreva("Opção 1 - Carregar Notas\n\n")
		
		para(i = 0; i < 6; i++){

			escreva("\nQuantidade de notas de R$", notas[0][i],",00: ")
			
			leia(qtd)
			
			notas[1][i] = notas[1][i] + qtd
		}
	}

	funcao Banco(){

		escreva("Opção 2 - Saque\n\n")
		escreva("[1] ", bancos_nomes[0],"     [2] ", bancos_nomes[1],"     [3] ", bancos_nomes[2],"     [4] ", bancos_nomes[3],"\n")
		escreva("Selecione seu banco: ")
		leia(opcao)

		escolha (opcao) {

			caso 1: limpa()
					Saque(opcao - 1)

			caso 2: limpa()
					Saque(opcao - 1)

			caso 3: limpa()
					Saque(opcao - 1)

			caso 4: limpa()
					Saque(opcao - 1) 

			caso contrario: escreva("Opção inválida...")
		 		u.aguarde(2000)
		 		limpa()
			
		}
	}

	funcao Saque(inteiro banco){

		escreva(bancos_nomes[banco], "\n\n")
		
		escreva("Digite o valor que deseja sacar: R$")
		leia(valor_saque)

		Validacoes()
		
		OpcaoSaque1(valor_saque)

		OpcaoSaque2(valor_saque)

		leia(opcao)
		escolha (opcao) {
			caso 1:

			caso 2:
		
		}

		saques_bancos[0][banco] = saques_bancos[0][banco] + 1
		//Registra que ocorreu um novo saque ao banco selecionado
		
		saques_bancos[1][banco] = saques_bancos[1][banco] + valor_saque
		//Soma o valor do saque ao total de saques do banco selecionado
		
	}

	funcao Validacoes(){
		se(valor_saque > valor_total){
			escreva("\nO valor solicitado excede o valor que há no caixa.")
			u.aguarde(2000)
		 	limpa()
		 	escreva("\n	-=| Menu principal |=-.")
		 	u.aguarde(2000)
		 	limpa()
		 	inicio()
			
		}
		se(valor_saque < 2){
			escreva("\nNão é possível sacar menos que R$2,00.")
			u.aguarde(2000)
		 	limpa()
		 	escreva("\n	-=| Menu principal |=-.")
		 	u.aguarde(2000)
		 	limpa()
		 	inicio()
		}
		se(valor_saque == 3){
			escreva("\nNão é possível sacar R$3,00.")
			u.aguarde(2000)
		 	limpa()
		 	escreva("\n	-=| Menu principal |=-.")
		 	u.aguarde(2000)
		 	limpa()
		 	inicio()
		}
		se((valor_saque % 2 != 0) e (notas[1][1] == 0)){
			escreva("\nNão é possível sacar valor ímpar pois não há nota de R$5,00 no caixa.")
			u.aguarde(2000)
		 	limpa()
		 	escreva("\n	-=| Menu principal |=-")
		 	u.aguarde(2000)
		 	limpa()
		 	inicio()
		}
	}

	funcao OpcaoSaque1(inteiro aux_valor_saque){

		inteiro n2 = notas[1][0]
		
		para(i = 5; i >= 0; i--){//Começa o contador do maior para o menor índice
			
			se((notas[1][i] > 0)){//Se a quantidade de notas no caixa for maior que 0
	
				inteiro resto = aux_valor_saque / notas[0][i] //O resto inteiro é a quantidade de notas que se pode dividir o saque
				
				se(resto > notas[1][i]){ //para o resto maior que a quantidade de notas, atribuimos a quantidade de nota que o caixa tem
					
					saque_notas[0][i] = notas[1][i]
					
				}senao{
					
					saque_notas[0][i] = resto //se o caixa tem notas suficientes, dividimos pelo resto
				
				}
				
				aux_valor_saque = aux_valor_saque - (saque_notas[0][i] * notas[0][i])
				
			}

			se((aux_valor_saque < 100) e (aux_valor_saque % 5 != 0) e (n2 > 0)){
	
					aux_valor_saque = aux_valor_saque - notas[0][0]
					saque_notas[0][0] = saque_notas[0][0] + 1
					n2 = n2 - 1
				
				}
			se((aux_valor_saque == 1) ou (aux_valor_saque == 3) ou (aux_valor_saque == -1)){

				escreva("\nNão é possível sacar esse valor com as notas que estão no caixa.")
				u.aguarde(2000)
				limpa()
		 		inicio()
				
			}

			se(aux_valor_saque == 0){
				
				escreva("\nOpção de saque [1]\n")
				
				para(i = 5; i >= 0; i--){

				escreva(saque_notas[0][i], " notas de R$", notas[0][i], "\n")	
				
				}
				
				escreva("\n")
				
				retorne
			}		
		}
		
	}

	funcao OpcaoSaque2(inteiro aux_valor_saque){

		para(i = 5; i > 2; i--){

			se((notas[1][i - 1] * notas[0][i - 1]) - (saque_notas[0][i - 1] * notas[0][i - 1]) > (saque_notas[0][i] * notas[0][i])){
	
				saque_notas[1][i - 1] = (saque_notas[0][i] * notas[0][i]) / saque_notas[1][i - 1]
				 
			}

		
		}

		escreva("\nOpção de saque [2]\n")
				
				para(i = 5; i >= 0; i--){

				escreva(saque_notas[1][i], " notas de R$", notas[0][i], "\n")	
				
				}
				
				escreva("\n")
				
				retorne

	}
		
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 5156; 
 * @DOBRAMENTO-CODIGO = [8, 64, 78, 135];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */