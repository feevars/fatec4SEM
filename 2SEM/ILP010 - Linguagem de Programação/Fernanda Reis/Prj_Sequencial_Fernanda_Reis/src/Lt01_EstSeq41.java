/*
 *************************
Lote 01 - Exercício 41 - Mostre todas as possibilidades de 2 dados de forma que 
a soma tenha como resultado 7.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************


 */
import javax.swing.JOptionPane;

public class Lt01_EstSeq41 {
    public static void main (String args []) {
        String soma = "";
        int d_um, d_dois;
        
        for (d_um = 1; d_um <= 6; d_um++) {
            for (d_dois = 1; d_dois <= 6; d_dois++) {
                if (d_um + d_dois == 7) {
                    soma += "DADO I = " +d_um + "  |  DADO II = " +d_dois +" \n";
                }
            }
        }
        JOptionPane.showMessageDialog(null, soma);
    }
}
