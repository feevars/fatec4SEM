/*
 *************************
Lote 01 - Exercício 33
Receba um número. Calcule e mostre a série 1 + 1/2 + 1/3 + ... + 1/N.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq33 {
    
    public static void main(String args[]){
   
        double numero, dividido, i;
        
        numero = Double.parseDouble(JOptionPane.showInputDialog("Dividindo um valor.\nInsira um número: "));
        
        for(i = 2; i <= 10; i++){
            
            dividido = numero / i;
            
            JOptionPane.showMessageDialog(null, numero + " dividido por " + i + " é " + dividido );
            
        }
        
    }
    
}
