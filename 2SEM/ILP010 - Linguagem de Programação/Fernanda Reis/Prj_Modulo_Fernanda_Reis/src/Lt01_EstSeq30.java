/*
 *************************
Lote 01 - Exercício 29 -    Receba a data de nascimento e atual em ano, mês e 
                            dia. Calcule e mostre a idade em anos, meses e dias,
                            considerando os anos bissextos.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************

INCOMPLETO
 */
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
public class Lt01_EstSeq30 {
    private static DecimalFormat casas2 = new DecimalFormat (".##");
    public static void main (String args[]) {
     
        int d_nasc, m_nasc, a_nasc, d_atual, m_atual, a_atual, meses, anos;
        
        

        d_nasc = Integer.parseInt(JOptionPane.showInputDialog("DATA DE NASCIMENTO \nDIA:"));
        m_nasc = Integer.parseInt(JOptionPane.showInputDialog("MÊS: "));
        a_nasc = Integer.parseInt(JOptionPane.showInputDialog("ANO: "));
        d_atual = Integer.parseInt(JOptionPane.showInputDialog("DATA DE HOJE \nDIA:"));
        m_atual = Integer.parseInt(JOptionPane.showInputDialog("MÊS ATUAL:"));
        a_atual = Integer.parseInt(JOptionPane.showInputDialog("ANO ATUAL:"));
 
        06/03/1987 - 01/03/2019
                teste do bissexto -- ano % 4 == 0 && ano % 100 == 1 
                
                 /*
                se dia atual = 29 e mes atual = 2, ano = bissexto (nao precisa somar esse)
                */
                if (dia_atual == 29 && mes_atual == 2) {
                    bissexto == true;
                } 
               
                /*
                se (mes de nascimento > 2) nao precisa fazer o teste do bissexto nesse ano.
                */
                else if (mes_nasc > 2) {
                    loop inicia com (ano_nasc+1);
                    pesquisa_ano == (ano_nasc+1);
                    conta_bissexto ();
                    
                } else if (mes_nasc == 2) {
                    if (dia_nasc == 29) {
                        bissexto == true (loop inicia com ano_nasc);
                        cont_dias_nasc == 0; (esse contador significa o número de dias)
                    } else {
                        cont_dias_nasc = nº de dias entre dia_nasc e o dia final daquele mês
                    }
                }
                
                /*
                teste do bissexto
                */
                
                            
                            a_nasc % 4 == resto_quatro ;
                            a_nasc % 100 == resto_cem;
                            if (resto_quatro == 0 && resto_cem == 1) {
                                if (mes == 2) {
                                    dia == 29;
                                   
                                } else {
                                 dia == 28;   
                                }                                            
                             
                                    o mês dois terá 29 dias para contabilizar
                            }
                        }
                        faz um contador para i somar 1 até chegar no último dia do mês.
                                transforma mes em dia até chegar em mês = 12 
                faz o teste do bissexto com todos os anos até o ano atual SE o mes atual for > 2. se nao for, faz até (ano atual - 1)
                
                    
                para exibição, contar o número de meses no ano atual e dia atual + i para calcular dias
                        se dia atual + i for maior que o número de dias do mes atual + 1, soma 1 a mês e conta apenas os dias excedentes.
                    ---- 
        
        
       dia de nascimento --> soma dias até chegar ao proximo mês
               se for mes de 31, soma i dias até chegar no dia 31.
               se for mes de 30, soma i dias até chegar no dia 30.
               se for mes de 29, soma i dias até chegar no dia 29.
               se for mes de 28, soma i dias até chegar no dia 28.
               
               conta principal do programa:
               pega número de números (cont_dia_nasc) necessários até o fim do mês de nascimento + 
               faz um contador (cont_mes_nasc) para adicionar 1 toda vez que completa o ciclo de varredura 
               mensal +
               adiciona 1 ao ano cada vez que o contador anterior chegar em 12 +
               usa um outro (ou o mesmo) contador (cont_dia_atual) para adicionar 1 a cada vez que 
               completar o ciclo de varredura mensal +
               somar os dias já corridos ao total, ou seja, somar o dia atual ao total.
                       
                       
                       PROBLEMA: caso a soma de dias até o fim do mês do ano inicial + 
                            o dia atual for maior ou igual ao número de dias do mês
                            seguinte do contador, soma 1 ao mês, subtrai o nº de dias 
                            do mês do contador e exibe somente o resultado.
                                    PROBLEMA2: caso a soma de meses seja = a 12 meses,
                                        adiciona 1 ao ano e subtrai 12 do número de 
                                        meses, deixando apenas o número de dias restantes.
                                                Caso o intervalo de anos/dias/mês seja = 0,
                                            não aparece no JOptionPane.
                                         
               
       /*
        Pegamos os meses e ano atuais e transformamos o tempo corrido em dias:
       */ 
       if (m_nasc == 1 || m_nasc == 3 || m_nasc == 5 || m_nasc == 7 || m_nasc == 8 || m_nasc == 10 || m_nasc == 12) {
           
       }