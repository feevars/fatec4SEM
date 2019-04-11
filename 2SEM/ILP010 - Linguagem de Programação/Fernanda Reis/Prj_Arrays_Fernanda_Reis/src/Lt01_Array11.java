/*
matriz preencher lalala
 */

import javax.swing.JOptionPane;

public class Lt01_Array11 {
    public static void main (String args[]) {
        int y = 0, x = 0;
        int matriz[][] = new int [8][8];
        String M = "Matriz[8][8] preenchida: \n";
        
        for (int z = 1; z <= 4; z++){ //z = diagonal
            for (x = (z - 1); x <= (8 - z); x++) {
                for (y = (z - 1); y <= (8 - z); y++) {
                    matriz[x][y] = z;
                    }
                }
            }
        
       for (x = 0; x <= 7; x++) {
           for (y = 0; y <= 7; y++) {
               M += " " +matriz[x][y];
               if (y == 7) {
                   M += "\n";
               }
           }
        }
       
        
      
        JOptionPane.showMessageDialog(null, M);
        
    }  
}
