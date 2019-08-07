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
public class Lt01_EstSeq301 {
    private static DecimalFormat casas2 = new DecimalFormat (".##");
    public static void main (String args[]) {
     
        int d_nasc, m_nasc, a_nasc, d_atual, m_atual, a_atual, meses, anos;
        
        

        d_nasc = Integer.parseInt(JOptionPane.showInputDialog("DATA DE NASCIMENTO \nDIA:"));
        m_nasc = Integer.parseInt(JOptionPane.showInputDialog("MÊS: "));
        a_nasc = Integer.parseInt(JOptionPane.showInputDialog("ANO: "));
        d_atual = Integer.parseInt(JOptionPane.showInputDialog("DATA DE HOJE \nDIA:"));
        m_atual = Integer.parseInt(JOptionPane.showInputDialog("MÊS ATUAL:"));
        a_atual = Integer.parseInt(JOptionPane.showInputDialog("ANO ATUAL:"));
 
        24/06/1998 - 13/04/2019
        
    }
}