/*
 *************************
Lote 01 - Exercício 23 - Receba 3 valores obrigatoriamente em ordem crescente e um 4º valor não
                        necessariamente em ordem. Mostre os 4 números em ordem crescente.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */

import java.util.Arrays;
import javax.swing.JOptionPane;
public class Lt01_Mod23 {
    public static void main (String args[]) 
    {
   
    int valor[];
        valor = new int [4];
   
       for (int i = 0; i < 4; i++) {
           if (i == 0) {
               valor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro: "));
           } else if (i != 3) {
               Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro MAIOR que o anterior: "));
           } else {
               Integer.parseInt(JOptionPane.showInputDialog("Digite um valor qualquer: "));
           }
        }
       JOptionPane.showMessageDialog(null, Arrays.toString(bubbleSort(valor)));
    }
    
    static int [] bubbleSort (int [] n) {
        for (int i = 0; i < 4; i++) {
            for(int j = 1; j < 5; j++) {    //20   40   55  34  
                if(n[j-1] > n[j]) { // if (55 > 34) {
                    int aux = n[j-1];  // aux = 55
                    n[j-1] = n[j];  // 
                    n[j] = aux;
                }
            }
        }
        return n;
    }
}

