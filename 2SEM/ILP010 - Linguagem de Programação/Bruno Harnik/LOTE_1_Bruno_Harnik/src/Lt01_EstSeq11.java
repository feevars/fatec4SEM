/*
 *************************
Lote 01 - Exercício 11
Receba o raio de uma circunferência. Calcule e mostre o comprimento da circunferência.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq11 {
    
    public static void main (String args[]){
        
        double raio, comprimento;
        
        raio = Double.parseDouble(JOptionPane.showInputDialog("Comprimento da circunferência.\n\nDigite o raio: "));
        
        comprimento = 2 * 3.14 * raio;
        
        JOptionPane.showMessageDialog(null, "Considerando π = 3.14, o comprimento da circunferência é: " + comprimento);
    }
}
