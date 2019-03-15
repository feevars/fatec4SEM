/*
 *************************
Lote 01 - Exercício 45 - Calcule e mostre a série 1 – 2/4 + 3/9 – 4/16 + 5/25 - 
... + 15/225.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************


 */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Lt01_EstSeq45 {
    private static DecimalFormat casas0 = new DecimalFormat("");
    private static DecimalFormat casas2 = new DecimalFormat("#.##");
    public static void main (String args []) {
        
        String aux = "1";
        double i=1.0, j, valor=0.0;
        
        
        
        for (i = 1; i<=15; i++) {
            j = i * i;
            if (i == 1) {
                valor += 1;
            } else if (i % 2 == 0) {
                valor -= (i/j);
                aux += " - " +casas0.format(i) +"/" +casas0.format(j);
              } else {
                    valor += (i/j);
                    aux += " + " +casas0.format(i) +"/" +casas0.format(j);
                }
            if (i % 8 == 0) {
                aux += "\n";
            }
        }
        aux += " = ";
        JOptionPane.showMessageDialog(null, aux +casas2.format(valor));
        
    }    
}
