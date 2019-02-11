/*
 *************************
Lote 01 - Exercício 09
Receba os 2 números inteiros. Calcule e mostre a soma dos quadrados.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq09 {
    
    public static void main (String args[]){
        
        int A, B, soma_quadrados;
        
        A = Integer.parseInt(JOptionPane.showInputDialog("Soma dos quadrados.\n\nDigite um valor inteiro: "));
        
        B = Integer.parseInt(JOptionPane.showInputDialog("Digite outo valor inteiro: "));
        
        soma_quadrados = A * A + B * B;
        
        JOptionPane.showMessageDialog(null, A + "² + " + B + "² = " + soma_quadrados);
    }
}
