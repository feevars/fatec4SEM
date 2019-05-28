/*
 *************************
Lote 1 - Array - Exercício 10: Criar uma matriz [2][8] onde o programa irá 
carregar segundo:

                | casa|1|2|3|4|...|
                |valor|1|2|4|8|...|
                

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************

 */

import javax.swing.JOptionPane;

public class Lt01_Array10 {
    public static void main (String args []) {
        
        int numeros [][] = new int[2][8]; 
        int i = 0, j = 0;
        String output = "Aqui está a matriz[2][8] pedida: \n";
        
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 8; j++) {
                //populaMatriz
                if (i == 0) {
                    numeros[i][j] = (j+1); 
                } else {
                    numeros[i][j] = (int) Math.pow(2, j);
                }
                //exibeSaída
                if (i == 0 && j == 7) {
                    output += numeros[i][j] + " |\n";
                } else {
                    output += "| " + numeros[i][j] + " |";
                }
            }
        }
        JOptionPane.showMessageDialog(null, output);
    }
}