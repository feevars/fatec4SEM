/*
 *************************
Lote 01 - Exercício 19
Receba 2 valores reais. Calcule e mostre o maior deles.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class LOTE_1_EX_19 {
    
    public static void main (String args[]){
        
        int x, y;
        
        x = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro:"));
        
        y = Integer.parseInt(JOptionPane.showInputDialog("Digite outro valor inteiro: "));
        
        if(x >= y){
            
            JOptionPane.showMessageDialog(null, "O maior número é " + x);
            
        }else{
            
            JOptionPane.showMessageDialog(null, "O maior número é " + y);
            
        }
    }
}
