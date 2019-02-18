/*
 *************************
Lote 01 - Exercício 31
Calcule e mostre o quadrado dos números entre 10 e 150.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq31 {
    
    public static void main(String args[]){
        
        int i, quadrado;
        
        for(i = 11; i <= 15; i++){
            
            quadrado = i * i;
            JOptionPane.showMessageDialog(null, "O quadrado de " + i + " é " + quadrado);
            
        }
    }
}
