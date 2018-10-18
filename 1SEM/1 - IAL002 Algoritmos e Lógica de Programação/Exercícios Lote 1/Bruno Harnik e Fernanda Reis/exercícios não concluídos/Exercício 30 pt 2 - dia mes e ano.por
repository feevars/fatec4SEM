programa
{
	funcao inicio()
	{
		inteiro nascano, nascmes, nascdia, hjano, hjmes, hjdia, ano, mes, dia

		escreva("Digite dia, mês e ano de nascimento: ")
		leia(nascdia)
		leia(nascmes)
		leia(nascano)

		escreva("Digite data de hoje: ")
		leia(hjdia)
		leia(hjmes)
		leia(hjano)
		
	public String Idade(String dt_nasc) {//yyyy-MM-dd
        Calendar calHoje = GregorianCalendar.getInstance();
        int diah = calHoje.get(Calendar.DAY_OF_MONTH);
        int mesh = calHoje.get(Calendar.MONTH) + 1;
        int anoh = calHoje.get(Calendar.YEAR);
        
        // Data do nascimento.
        String[] quebraDN = dt_nasc.split("-");
        int nascdia = Integer.valueOf(quebraDN[2]);
        int nascmes = Integer.valueOf(quebraDN[1]);
        int nascano = Integer.valueOf(quebraDN[0]);
        
        String strNiver = anoh+"-"+mesn+"-"+dian;        
        Calendar calNiver = Calendar.getInstance();
        try {
            calNiver.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(strNiver));
        } catch (ParseException ex) {
            Logger.getLogger(FormataData.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        ano = (calHoje.getTimeInMillis() < calNiver.getTimeInMillis())? (hjano-nascano-1):hjano-nascano ;
        mes;
        dia;
        
        mes = hjmes - nascmes;
        se (mes > 0) {//Verificando se já fez aniversário ou não
            se (hjdia < nascdia) {
                mes--;
            }
        }
        	senao 
        		se(mes < 0) {//Se o mês atual for menor que o mês do aniversário
            mes = 12 + mes;//Lembrar que meses está negativo, por isso a soma;
            //Da mesma forma, vamos comparar o dia atual com o dia do aniversário, para sabermos se o mês está completo ou não:
            se (hjdia < nascdia) {
                mes--;
            }
        } senao {//Se o mês atual for o mês do aniversário:
            se (diah<dian) {
                mes = 11;
            } 
        }
        
        dia = hjdia - nascdia;
        se (dia < 0) {//Se dia hoje menor que dia do niver, somar os dias desde o mês anterior:
            se (hjmes ==5 ou hjmes ==7 ou hjmes ==8 ou hjmes ==10 ou hjmes ==12 {
                dia = 30-nascdia + hjdia;
            } 
            senao
            		se (hjmes==1 ou hjmes==2 ou hjmes==4 ou hjmes==6 ou hjmes==9 ou hjmes==11) {
                		dia = 31-nascdia+hjdia;
            } 		senao {//Verificando se o ano é bissexto ou não: Esse else é para o mês 3, cujo anterior é fevereiro:
                		se (hjano%4 == 0) {
                    		dia = 29 - nascdia + hjdia;
                } 		senao {
                    			dia = 28 - nascdia + hjdia;
                }
            }
        }
        
        
        escreva(ano," anos, "mes" meses e "dia" dias.")
    }
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 659; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */