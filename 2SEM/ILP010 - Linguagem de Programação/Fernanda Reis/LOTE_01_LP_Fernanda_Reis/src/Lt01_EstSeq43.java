/*
 *************************
Lote 01 - Exercício 43 - Calcule e mostre quantos anos serão necessários para 
que Ana seja maior que Maria sabendo que Ana tem 1,10 m e cresce 3 cm ao ano e 
Maria tem 1,5 m e cresce 2 cm ao ano.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************


 */
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Lt01_EstSeq43 {
    private static DecimalFormat casas2 = new DecimalFormat(".##");
    public static void main (String args []) {
        
        String result = "";
        String result_final = "";
        int anos=0;
        double altura_ana=1.10, altura_maria=1.5;
        
        do {
           altura_ana += +0.03;
           altura_maria += +0.02;
           anos += 1;
           result += "Ano: " +anos +" | Altura de Ana: " +casas2.format(altura_ana) +" | Altura de Maria: " +casas2.format(altura_maria) +"\n";
        }
        while (altura_ana <= altura_maria);
        
        altura_ana += +0.03;
        altura_maria += +0.02;
        anos += 1;
        result_final += "Ano: " +anos +" | Altura de Ana: " +casas2.format(altura_ana) +"m | Altura de Maria: " +casas2.format(altura_maria) +"m\n";
        result_final += "Após " +anos +" anos, Ana seria maior que Maria.... ";
        
        JOptionPane.showMessageDialog(null, result_final);
    }
}
