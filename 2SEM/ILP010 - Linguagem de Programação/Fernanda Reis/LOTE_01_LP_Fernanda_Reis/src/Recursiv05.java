/*
 *************************
Recursivo - 5)   Serie5 = (N)! + (N-1)! + (N-2)! + ... + (1)! 

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi

 *************************
*/
import javax.swing.JOptionPane;

public class Recursiv05 {  
    static int FAT = 0; 
    public static void main (String args[]) { 
        int Serie = Integer.parseInt(JOptionPane.showInputDialog("Calcularemos a série Serie5 = (N)! + (N-1)! + (N-2)! + ... + (1)!.\n\nDigite um número N: "));
            // 4! + 3! + 2! + 1!
            // (4x3x2x1) + (3x2x1) + (2x1) + (1) ----> 24 + 6 + 2 + 1 ----> 33
        int aux = 0;
        String staux = "";
        for (int i = Serie; i >= 1; i--) {
          int j = FFAT(i);
          aux += j;
          if (j == 1) {
              staux += j;
          } else {
          staux += j +" + ";
          }
        }
        staux += " = " +aux;
        JOptionPane.showMessageDialog(null, staux);
    }

public static int FFAT(int N) {  //3
    if (N == 1) {
        return N;
    } else {
       int FATT = N * FFAT(N-1); //3 * (FFAT 2) --> 2 * (FFAT 1) --> 1
       return FATT;  // 6
    }
}
}
