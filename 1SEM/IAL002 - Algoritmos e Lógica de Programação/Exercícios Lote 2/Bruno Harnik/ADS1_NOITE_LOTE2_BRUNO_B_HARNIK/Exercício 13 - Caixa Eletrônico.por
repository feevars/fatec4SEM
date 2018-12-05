programa{

	inclua biblioteca Util --> u

	inteiro opcao, notas[3][6], qtd, i, j, valor_total = 0, total_saques = 0, valor_saque, saque_notas[2][6], maior_saque = 0, menor_saque = 2147483647, total_sacado = 0

	real media_saques = 0.0 , media_bancos = 0.0, saques_bancos[2][4]
	
	cadeia bancos_nomes[4] = {"Banco Real", "Banespa", "Panamericano", "Bamerindus"}
	
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

		escreva("-=$| Caixa Eletrônico |$=-\n\n")
		
		escreva("Opções:\n[1] Carregar Notas     [2] Saque     [3] Estatística     [9] Fim\n")
		escreva("\nDigite a opção desejada: ")

		leia(opcao)
		//Lê a opção do menu inicial
		limpa()
		
		escolha (opcao) {
			
			caso 1: 	CarregarNotas()
					limpa()
					inicio()
					
			caso 2: 	Banco()
					inicio()
				
			caso 3: 	Estatistica()
					inicio()
				
			caso 9: 	escreva("Glória a Deuxxx\n")
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
			
			notas[1][i] = notas[1][i] + qtd //Soma quantidade a cada depósito, parte do 0
			notas[2][i] = notas[0][i] * notas[1][i] //Valor total que há daquela nota
			
		}

		
		valor_total = 0
		
		para(i = 0; i < 6; i++){

			valor_total = (notas[0][i] * notas[1][i]) + valor_total
			//Calcula o valor total do caixa
			notas[2][i] = notas[0][i] * notas[1][i]
			//Calcula o valor total de cada nota.
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
		 		Banco()
			
		}
	}

	funcao Saque(inteiro banco){

		escreva(bancos_nomes[banco], "\n\n")
		
		escreva("Digite o valor que deseja sacar: R$")
		leia(valor_saque)
		limpa()

		Validacoes()

		OpcaoSaque1(valor_saque)

		OpcaoSaque2(valor_saque)

		para(i = 0; i < 6; i++){

			se(saque_notas[0][i] != saque_notas[1][i]){

				escreva("Valor do saque: R$", valor_saque, ",00\n")
				
				escreva("\n[1] Opção de saque 1\n")
				
				para(i = 5; i >= 0; i--){

					escreva(saque_notas[0][i], " notas de R$", notas[0][i], "\n")	
				
				}

				escreva("\n[2] Opção de saque 2\n")
				
				para(i = 5; i >= 0; i--){

					escreva(saque_notas[1][i], " notas de R$", notas[0][i], "\n")	
				
				}
			
				escreva("\n[3] Cancelar saque\n\nDigite a opção desejada:\n")

				DoisSaquesOpcoes()

				i = 6
			}
			
		}

		
			se((saque_notas[0][0] == saque_notas[1][0]) e (saque_notas[0][1] == saque_notas[1][1]) e (saque_notas[0][2] == saque_notas[1][2]) e (saque_notas[0][3] == saque_notas[1][3]) e (saque_notas[0][4] == saque_notas[1][4]) e (saque_notas[0][5] == saque_notas[1][5])){
				
				escreva("Valor do saque: R$", valor_saque, ",00\n")
				
				escreva("\nVocê tem apenas uma opção de saque:\n")
						
				para(i = 5; i >= 0; i--){
		
					escreva(saque_notas[0][i], " notas de R$", notas[0][i], "\n")	
				
				}
		
				escreva("\nConfirma saque com as notas exibidas?\n[1] Sim		[2] Não\n")
		
				UmSaqueOpcoes()
				
			}

		valor_total = valor_total - valor_saque
		//Subtrai o valor total
		
		saques_bancos[0][banco] = saques_bancos[0][banco] + 1
		//Registra que ocorreu um novo saque ao banco selecionado
		
		saques_bancos[1][banco] = saques_bancos[1][banco] + valor_saque
		//Soma o valor do saque ao total de saques do banco selecionado

		total_saques = total_saques + 1
		//Registra a quantidade total de saques realizados

		total_sacado = total_sacado + valor_saque

		se(valor_saque > maior_saque){

			maior_saque = valor_saque
			
		}
		//Maior saque
		
		se(valor_saque < menor_saque){

			menor_saque = valor_saque
			
		}
		//Menor saque

		media_saques = total_sacado / total_saques
		//Média de todos os saques

		para(j = 0; j < 2; j++){

			para(i = 0; i < 6; i++){

				saque_notas[j][i] = 0
				
			}
		}
		//Zerei o vetor para o próximo saque

		limpa()
		inicio()
	}

	funcao Validacoes(){

		//Sacar mais que tem no caixa
		se(valor_saque > valor_total){
			
			escreva("\nO valor solicitado excede o valor que há no caixa.")
			u.aguarde(2000)
		 	limpa()
		 	escreva("\n	-=| Menu principal |=-")
		 	u.aguarde(2000)
		 	limpa()
		 	inicio()
		 	
		}

		//Saque menor que 2 reais
		se(valor_saque < 2){
			
			escreva("\nNão é possível sacar menos que R$2,00.")
			u.aguarde(2000)
		 	limpa()
		 	escreva("\n	-=| Menu principal |=-")
		 	u.aguarde(2000)
		 	limpa()
		 	inicio()
		 	
		}

		//3 reais
		se(valor_saque == 3){
			
			escreva("\nNão é possível sacar R$3,00.")
			u.aguarde(2000)
		 	limpa()
		 	escreva("\n	-=| Menu principal |=-")
		 	u.aguarde(2000)
		 	limpa()
		 	inicio()
		 	
		}

		//Valor ímpar sem nota de 5 no caixa
		se((valor_saque % 2 != 0) e (notas[1][1] == 0)){
			
			escreva("\nNão é possível sacar valor ímpar, pois não há nota de R$5,00 no caixa.")
			u.aguarde(2000)
		 	limpa()
		 	escreva("\n	-=| Menu principal |=-")
		 	u.aguarde(2000)
		 	limpa()
		 	inicio()
		 	
		}

		//Sem nota de 2 no caixa
		se(((valor_saque % 5 == 8) e (notas[1][0] < 4)) ou ((valor_saque % 5 == 1) e (notas[1][0] < 3)) ou ((valor_saque % 5 == 4) e (notas[1][0] < 2)) ou (notas[1][0] == 0)){
			
			escreva("\nNão há notas de 2 suficientes no caixa.")
			u.aguarde(2000)
		 	limpa()
		 	escreva("\n	-=| Menu principal |=-")
		 	u.aguarde(2000)
		 	limpa()
		 	inicio()
		 	
		}

		//Ocorreram mais de 100 saques
		se(total_saques > 100){

			escreva("\nO caixa já sacou 100 vezes e agora precisa descansar...\n\nAgora só sai cédula pintada de rosa daqui com explosivo.")
			u.aguarde(4000)
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

			se(aux_valor_saque < 100 e aux_valor_saque % 5 != 0 e aux_valor_saque % 10 != 0 e aux_valor_saque % 20 != 0 e aux_valor_saque % 50 != 0 e n2 > 0){
	
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
				
				retorne
			}		
		}
		
	}

	funcao OpcaoSaque2(inteiro aux_valor_saque){
	
		para(i = 5; i >= 0; i--){

			se((i > 1) e ((notas[2][i - 1] - (saque_notas[0][i - 1]) * notas[0][i - 1]) >= (saque_notas[0][i] * notas[0][i])) e (saque_notas[0][i] != 0)){
	
				saque_notas[1][i] = 0
				saque_notas[1][i - 1] = (saque_notas[0][i] * notas[0][i]) / notas[0][i - 1] + saque_notas[0][i - 1]

				para(j = i; j > 1; j--){

					saque_notas[1][j - 2] = saque_notas[0][j - 2]
					
				}
				
				i = i - 6
				 
			}
			
			senao{
				
				saque_notas[1][i] = saque_notas[0][i]
				
			}
			
		}
				
		retorne

	}

	funcao DoisSaquesOpcoes(){

		leia(opcao)
				
		escolha (opcao) {
			
			caso 1:	opcao = 0
					RegistraSaque(opcao)
					retorne

			caso 2:	opcao = 1
					RegistraSaque(opcao)
					retorne

			caso 3:	limpa()
					inicio()

			caso contrario: escreva("Opção inválida.\nDigite a opção desejada:")
	 					DoisSaquesOpcoes()
	 		
		}
		
	}
	
	funcao UmSaqueOpcoes(){

		leia(opcao)

		escolha (opcao) {
			
			caso 1:	opcao = 1
					RegistraSaque(opcao)
					retorne

			caso 2:	limpa()
					inicio()

			caso contrario: escreva("Opção inválida.\nDigite a opção desejada:")
		 				UmSaqueOpcoes()
		
		}		
	}

	funcao RegistraSaque(inteiro id){

		limpa()
		escreva("Retire o seu suado dinheirinho... \n\n")
		
		escreva("Caindo na sua mão: \n")

		para(i = 5; i >= 0; i--){

			notas[1][i] = notas[1][i] - saque_notas[id][i] //Subtraio o total daquela nota do caixa
			
			notas[2][i] = notas[1][i] * notas[0][i] //Recalculo o total daquela nota do caixa
			
			escreva(saque_notas[id][i], " notas de R$", notas[0][i], ",00\n")
			u.aguarde(250)

		}

		escreva("\nQuem dera fosse assim fácil... \n")
		u.aguarde(2000)

		
	}

	funcao Estatistica(){

		escreva("Opção 3 - Estatística\n")

		escreva("Total em caixa: R$", valor_total, ",00\n\n")
		//Total caixa
		
		escreva("Maior saque realizado: R$", maior_saque, ",00\n")
		//Maior saque

		escreva("Menor saque realizado: R$", menor_saque, ",00\n")
		//Menor saque

		escreva("\nForam realizados ", total_saques, " saques, que juntos já tiraram R$", total_sacado ,",00 deste pobre caixa.\n")
		//Total de saques e total sacado
		
		escreva("Média geral de R$", media_saques," por saque.")
		//Média total dos saques


		escreva("\nValores sacados por banco: ")

		para (i = 0; i < 4; i++){

			escreva("\n", bancos_nomes[i], "\n")

			escreva(saques_bancos[0][i], " saque(s) que totaliza(m) R$", saques_bancos[1][i], ",00\n")

			media_bancos = saques_bancos[1][i] / saques_bancos[0][i]
			
			escreva("Média: ", media_bancos, "\n")

		}

		escreva("\n---------------------------------------------------\n\n")
		inicio()
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 10317; 
 * @DOBRAMENTO-CODIGO = [10, 54, 81, 219, 300, 349, 380, 404, 423];
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */