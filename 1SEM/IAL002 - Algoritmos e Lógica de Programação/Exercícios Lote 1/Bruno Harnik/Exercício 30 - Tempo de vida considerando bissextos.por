programa
{
	
	inteiro ANOi, MESi, DIAi, ANOf, MESf, DIAf, total_dias, DIASMESi, total_mes, dias_resto, mes_intervalo, dias_intervalo, ANOi_dias, ANOf_dias, total_ano, ano_intervalo, ANOS_intervalo_dias
	
	funcao inicio(){
		
	escreva("<<<<< Data inicial >>>>>\n")
	escreva("Dia inicial:")
	leia(DIAi)

	escreva("Mês inicial:")
	leia(MESi)
		
	escreva("Ano inicial:")
	leia(ANOi)
	
	escreva("\n<<<<< Data final >>>>>\n")
	escreva("Dia final:")
	leia(DIAf)

	escreva("Mês final:")
	leia(MESf)
	
	escreva("Ano final:")
	leia(ANOf)

	validacoes()
	calculo()

	}
	
	funcao validacoes(){ //Dispositivos para checar se o usuário não insere nenhuma data impossível.
		
		se(ANOf < ANOi){
			escreva("O ano final não pode ser menor que o ano inicial. Refaça...\n")
			inicio()
		}
		
		se(ANOf == ANOi e MESf < MESi){
			escreva("O mês final não pode ser menor que o mês inicial do mesmo ano. Refaça...\n")
			inicio()
		}
		
		se(ANOf == ANOi e MESf == MESi e DIAf < DIAi){
			escreva("O dia final não pode ser menor que o dia inicial do mesmo mês no mesmo ano. Refaça...\n")
			inicio()
		}
		
		se (MESi <= 0 ou MESi > 12 ou MESf <= 0 ou MESf > 12){
			escreva("O ano tem 12 meses, insira um valor de 1 a 12 para o mês. Refaça...\n")
			inicio()
		}
		
		se (((MESi == 1 ou MESi == 3 ou MESi == 5 ou MESi == 8 ou MESi == 10 ou MESi == 12) e (DIAi > 31)) ou ((MESi == 4 ou MESi == 6 ou MESi == 7 ou MESi == 9 ou MESi == 11) e (DIAi > 30)) ou ((MESi == 2) e (DIAi > 29)) ou ((ANOi % 4 != 0) e (MESi == 2) e (DIAi > 28)) ou (DIAi <= 0)){
			escreva("Você digitou um dia inicial que não existe no mês inicial. Refaça...\n")
			inicio()
		}
		
		se (((MESf == 1 ou MESf == 3 ou MESf == 5 ou MESf == 8 ou MESf == 10 ou MESf == 12) e (DIAf > 31)) ou ((MESf == 4 ou MESf == 6 ou MESf == 7 ou MESf == 9 ou MESf == 11) e (DIAf > 30)) ou ((MESf == 2) e (DIAf > 29)) ou ((ANOf % 4 != 0) e (MESf == 2) e (DIAf > 28)) ou (DIAf <= 0)){
			escreva("Você digitou um dia final que não existe no mês final. Refaça...\n")
			inicio()
		}
		
	}
	
	funcao calculo(){
		
		DIASMESi = DiasMes(MESi,ANOi) - DIAi
		
		se ((ANOi == ANOf) e (MESi == MESf)){	// Anos iguais e meses iguais
		
			total_dias = DIAf - DIAi
			escreva("Tempo decorrido: ", total_dias, " dia(s).")
			
		}
		se(ANOi == ANOf){	//Anos iguais
			
			se(MESf == MESi + 1){	//Mês final é o seguinte do mês inicial
				total_dias = DIASMESi + DIAf
				escreva("Tempo decorrido: ", total_dias, " dia(s).\n")

				total_mes = total_dias / 30
				dias_resto = total_dias % 30

				escreva("Ou ", total_mes, " mes(es) e ", dias_resto, " dia(s) (considerando que cada mês tem 30 dias).")
				
			}
			senao{ //Mês final é pelo menos o segundo após o inicial

				mes_intervalo = MESi + 1
			
				dias_intervalo = 1
				
				enquanto(mes_intervalo < MESf){			
	
					dias_intervalo = dias_intervalo + DiasMes(mes_intervalo,ANOi) //executa a função de cálculo de dias

					mes_intervalo = mes_intervalo + 1
					
				}

				total_dias = DIASMESi + dias_intervalo + DIAf

				escreva("Tempo decorrido: ", total_dias, " dia(s).\n")

				total_mes = total_dias / 30
				dias_resto = total_dias % 30

				escreva("Ou ", total_mes, " mes(es) e ", dias_resto, " dia(s) (considerando que cada mês tem 30 dias).")
			}
			
		}
		se(ANOf == ANOi + 1){ //Ano final é subsequente ao ano inicial
			
			mes_intervalo = MESi + 1
			
			dias_intervalo = 1
			
			enquanto(mes_intervalo <= 12){			
	
				dias_intervalo = dias_intervalo + DiasMes(mes_intervalo,ANOi) //executa a função de cálculo de dias

				mes_intervalo = mes_intervalo + 1

			}
			
			ANOi_dias = DIASMESi + dias_intervalo

			//zero novamente as variáveis
			dias_intervalo = 1
			mes_intervalo = 1

			se(MESf == 1){

				ANOf_dias = DIAf
				
			}
			senao{			
				enquanto(mes_intervalo < MESf){
					
					dias_intervalo = dias_intervalo + DiasMes(mes_intervalo,ANOf) //executa a função de cálculo de dias

					mes_intervalo = mes_intervalo + 1
				
				}

				ANOf_dias = DIAf + dias_intervalo
				
			}

			total_dias = ANOi_dias + ANOf_dias

			escreva("\nTempo decorrido: ", total_dias, " dia(s).\n\n")

			total_mes = total_dias / 30
			dias_resto = total_dias % 30

			escreva("Ou ", total_mes, " mes(es) e ", dias_resto, " dia(s)\n(considerando que cada mês tem 30 dias).\n\n")

			total_ano = total_dias / 365
			total_mes = total_dias % 365 / 30
			dias_resto = total_dias % 365 % 30

			escreva("Ou ", total_ano, " ano(s), ", total_mes, " mes(es) e ", dias_resto, " dia(s)\n(considerando que cada ano tem 365 dias e cada mês tem 30 dias).\n")
			
		}
		se(ANOf >= ANOi + 2){ //Ano final é no mínimo 2 a mais que o inicial

			ano_intervalo = ANOi + 1
			
			mes_intervalo = MESi + 1

			enquanto(ano_intervalo < ANOf){
				se(ano_intervalo % 4 == 0){
					
					dias_intervalo = dias_intervalo + 366

					ano_intervalo = ano_intervalo + 1
					
				}
				senao{
					
					dias_intervalo = dias_intervalo + 365

					ano_intervalo = ano_intervalo + 1
					
				}
			}

			ANOS_intervalo_dias = dias_intervalo

			enquanto(mes_intervalo <= 12){			
	
				dias_intervalo = dias_intervalo + DiasMes(mes_intervalo,ANOi) //executa a função de cálculo de dias

				mes_intervalo = mes_intervalo + 1

			}
			
			ANOi_dias = DIASMESi + dias_intervalo

			dias_intervalo = 1

			ANOS_intervalo_dias = dias_intervalo

			se(MESf == 1){

				ANOf_dias = DIAf
				
			}
			senao{			
				enquanto(mes_intervalo < MESf){
					
					dias_intervalo = dias_intervalo + DiasMes(mes_intervalo,ANOf) //executa a função de cálculo de dias

					mes_intervalo = mes_intervalo + 1
				
				}

				ANOf_dias = DIAf + dias_intervalo
				
			}

			total_dias = ANOi_dias + ANOS_intervalo_dias + ANOf_dias

			escreva("\nTempo decorrido: ", total_dias, " dia(s).\n\n")

			total_mes = total_dias / 30
			dias_resto = total_dias % 30

			escreva("Ou ", total_mes, " mes(es) e ", dias_resto, " dia(s)\n(considerando que cada mês tem 30 dias).\n\n")

			total_ano = total_dias / 365
			total_mes = total_dias % 365 / 30
			dias_resto = total_dias % 365 % 30

			escreva("Ou ", total_ano, " ano(s), ", total_mes, " mes(es) e ", dias_resto, " dia(s)\n(considerando que cada ano tem 365 dias e cada mês tem 30 dias).\n")
			
		}

	}
	funcao inteiro DiasMes(inteiro mes, inteiro ano){ //Função que calcula quantos dias tem no mês

		inteiro dias_no_mes
		
		se(mes == 1 ou mes == 3 ou mes == 5 ou mes == 8 ou mes == 10 ou mes == 12){
			dias_no_mes = 31
		}
		senao se((ano % 4 != 0) e (mes == 2)){
			dias_no_mes = 28
		}
		senao se((ano % 4 == 0) e (mes == 2)){
			dias_no_mes = 29
		}
		senao{
			dias_no_mes = 30
		}
		
		retorne dias_no_mes

	}
	

}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 79; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */