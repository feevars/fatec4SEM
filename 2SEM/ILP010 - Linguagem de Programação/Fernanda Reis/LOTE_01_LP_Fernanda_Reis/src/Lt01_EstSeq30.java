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
                teste_do_bissexto = ano % 4 == 0 && ano % 100 == 1 || ano % 400 == 0;
                se dia atual = 29 e mes atual = 2, ano = bissexto (nao precisa somar esse)
                
                se (mes de nascimento > 2) nao precisa fazer o teste do bissexto nesse ano.
                        if (m_nasc > 2) {
                           não precisa fazer o bissexto no ano de nascimento
                           ou seja, começa o loop com a_nasc+1
                        } else if (m_nasc == 2) {
                            começa o loop com a_nasc
                            
                            a_nasc % 4 == resto_quatro ;
                            a_nasc % 100 == resto_cem;
                            if (resto_quatro == 0 && resto_cem == 1) {
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
               
       /*
        Pegamos os meses e ano atuais e transformamos o tempo corrido em dias:
       */ 
       if (m_nasc == 1 || m_nasc == 3 || m_nasc == 5 || m_nasc == 7 || m_nasc == 8 || m_nasc == 10 || m_nasc == 12) {
           
       }