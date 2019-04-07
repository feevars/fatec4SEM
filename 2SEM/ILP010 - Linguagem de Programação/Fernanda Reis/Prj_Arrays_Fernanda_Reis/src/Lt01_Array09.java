/*
 *************************
Lote 1 - Array - Exercício 9: Criar e carregar uma matriz [4][4] com valores 
aleatórios, sendo que a diagonal principal terá seus dados carregados no 
programa segundo:

                | 1|  |  |  |
                |  | 4|  |  |
                |  |  | 8|  |
                |  |  |  |16|
                

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************

 */

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Lt01_Array09 {
    private static DecimalFormat casas0 = new DecimalFormat ("");
    public static void main (String args []) {
        
        double matriz [][] = new double [4][4];
        String output = "Aqui está a matriz com valores aleatórios e diagonal em múltiplos de 4: \n";
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //preencheMatriz
                if (i == j) {
                    matriz[i][j] = (int) Math.pow(4, j); //4^j
                } else {
                    matriz[i][j] = (int) (0 + (Math.random() * 100));
                }
                //escreverSaída
                if (j == 3) {
                    output += " | " + casas0.format(matriz[i][j]) + " |\n";
                } else {
                    output += " | " + casas0.format(matriz[i][j]);
                }
            }
        }
        JOptionPane.showMessageDialog(null, output);
    }
}