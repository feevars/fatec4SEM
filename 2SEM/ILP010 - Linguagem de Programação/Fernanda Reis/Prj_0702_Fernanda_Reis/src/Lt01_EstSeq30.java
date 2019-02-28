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
        
   
        
       while (a_nasc <= a_atual) 
        pegar os meses e o ano atuais e transformar em dias:
        if (m_atual == 1 || m_atual == 3 || m_atual == 5 || m_atual == 7 || m_atual == 8 || m_atual == 10 || m_atual == 12)
            dias[m_atual] = 31; 
        else if (m_atual == 4 || m_atual == 6 || m_atual == 9 || m_atual == 11)
            dias[m_atual] = 30;
        else if (m_atual == 2)
                if (a_atual = contadobissexto)
                    dias[m_atual] = 29;
                else
                    dias[m_atual] = 28;
        fimse
                
        para contabilizar os meses do ano atual:        
        enquanto (m_atual >= 1)
            soma_meses = soma_meses + dias[m_atual];
            m_atual = m_atual - 1;
        fimenquanto
        
        enquanto (a_nasc <= a_atual)
        
        para (i == 1, i <= m_atual, i++)
        dif_ano = dias[i]a_atual - a_nasc;
        dias = dias
            dias[m_atual]
            
            dias < 32;
        mês < 13;
        dia == 28 || dia == 29 || dia == 30 || dia == 31;
        
        para (i = a_nasc, i <= a_atual, i++)
                if (i = contadoanobissexto)
                    if (m_atual == 2)
                        dia[2] = 29;
       
        if (a_atual > a_nasc) {
            
             /*mesmo ano de nascimento e atual */
             
            if (a_atual == a_nasc){
               anos = a_atual - a_nasc;
               if (m_atual > m_nasc) {
                   meses = m_atual - m_nasc;
               }   
            } 
            else {
                if (m_atual == m_nasc) {   
                    
            