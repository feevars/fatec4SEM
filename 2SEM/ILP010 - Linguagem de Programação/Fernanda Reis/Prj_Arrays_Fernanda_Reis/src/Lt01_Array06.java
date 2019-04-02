/*
 *************************
Lote 1 - Array - Exercício 6: Criar e coletar em um vetor [20] com números 
aleatórios. Classificar este vetor em ordem crescente e mostre os dados.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************

 */

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Lt01_Array06 {
    private static DecimalFormat casas2 = new DecimalFormat ("#.##");
    public static void main (String args []) {
        double vt[] = new double[20];
        int i = 0, somatorio = 0;
        double temp = 0.0;
        String vetor = "Números em ordem aleatória: \n";
        
        
        //populaVetor
        for (i = 0; i < 20; i++) {
            vt[i] = (double) (0 + (Math.random() *100));
            vetor += casas2.format(vt[i]) + "   ";
        }
        
        //bubbleSort
        for (i = 0; i < 20; i++) {
            for(int j = 1; j < (20-i); j++) {
                if(vt[j-1] > vt[j]) {
                    temp = vt[j-1];
                    vt[j-1] = vt[j];
                    vt[j] = temp;
                }
            }
        }
        
        //exibeCrescente 
        for (i = 0; i < 20; i++) {
            vetor += "\n" +(i+1) + "º : " + casas2.format(vt[i]);
        }
        JOptionPane.showMessageDialog(null, vetor);
    }
}
