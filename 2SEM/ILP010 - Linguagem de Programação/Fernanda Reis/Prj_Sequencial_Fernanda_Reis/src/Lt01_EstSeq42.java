/*
 *************************
Lote 01 - Exercício 42 - Calcule e mostre a série 1 + 2/3 + 3/5 + ... + 50/99

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************


 */
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Lt01_EstSeq42 {
    private static DecimalFormat casas0 = new DecimalFormat ("");
    public static void main (String args[]) {
        
        String fatores = "";
        double soma=0.0, i=0.0, j=0.0;
        
        for (i = 1; i<=50; i++) {
            if (i == 1) {
                j = 1;
                soma += (i/j);
            } else {
            j += 2;
            soma += (i/j);
            }
            if (i % 9 == 0) {
                fatores += "\n";
            }
            if (i<50) {
            fatores += casas0.format(i) +"/" +casas0.format(j) +" +";    
            } else {
                fatores += casas0.format(i) +"/" +casas0.format(j) +" = " +soma;
            }
        }
        JOptionPane.showMessageDialog(null, fatores);
    }
}
