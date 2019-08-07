/*
 Matriz = Variável de memória onde seus conteúdos serão manipulados
a partir de 2 ou mais índices.

Preenchendo matriz
 */

import javax.swing.JOptionPane;

public class Lt01_Array00 {
    public static void main (String args[]) {
        int m2[][] = new int[3][2];
        int s = 0;
        String fatores = "";
        
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 2; y++) {
                m2[x][y] = Integer.parseInt(JOptionPane.showInputDialog("Insira um valor inteiro: "));
                s += m2[x][y];
                
                if (x == 2 && y == 1) {
                    fatores += m2[x][y];
                } else {
                    fatores += m2[x][y] + " || ";
                } 
                
            }
        }
        
        JOptionPane.showMessageDialog(null,fatores + "\nA soma dos fatores inseridos é " +s);
    } 
}
