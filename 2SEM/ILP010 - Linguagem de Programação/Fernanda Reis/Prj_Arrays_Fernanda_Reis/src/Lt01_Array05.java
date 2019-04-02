/*
 *************************
Lote 1 - Array - Exercício 5: Criar e coletar em um vetor [20] inteiro. 
Calcule e exiba, segundo:
                somatório de A(i) - A(21 - i)

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************

 */

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Lt01_Array05 {
    private static DecimalFormat casas2 = new DecimalFormat ("#.##");
    public static void main (String args []) {
        int vt[] = new int[20];
        int sub = 0, i = 0, somatorio = 0;
        String vetor = "";
        
        //populaVetor
        for (i = 0; i < 20; i++) {
            vt[i] = (int) (0 + (Math.random() *100));
        }
        
        //conta        
        for(i = 0; i < 10; i++) {
            sub = (vt[i] - vt[19-i]);
            vetor += vt[i] +" - " +vt[19-i] + " = " +sub +"\n";
            somatorio += sub;
        }
        vetor += "O somatório de todos os valores obtidos é " +somatorio;
        JOptionPane.showMessageDialog(null, vetor);
    }
}
