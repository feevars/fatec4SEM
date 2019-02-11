/*
 *************************
Lote 01 - Exercício 04
Receba a temperatura em graus Celsius. Calcule e mostre a sua temperatura convertida em fahrenheit F = (9*C+160) / 5.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq04 {
    
    public static void main (String args[]){
        
        float C, F;
        
        C = Float.parseFloat(JOptionPane.showInputDialog("Digite a temperatura em graus Celsius: "));
        
        F = (9 * C + 160) / 5;
        
        JOptionPane.showMessageDialog(null,"A temperatura em Fahrenheit é " +F +"°F.");
        
    }
}
