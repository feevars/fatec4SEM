/*
 *************************
Lote 01 - Exercício 18
Receba 2 valores inteiros. Calcule e mostre o resultado da diferença do maior pelo menos valor.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq18 {
    
    public static void main (String args[]){
        
        int x, y, diferenca;
        
        x = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro:"));
        
        y = Integer.parseInt(JOptionPane.showInputDialog("Digite outro valor inteiro: "));
        
        if(x >= y){
            
            diferenca = x - y;
            
        }else{
            
            diferenca = y - x;
            
        }

        JOptionPane.showMessageDialog(null, "A diferença do maior valor pelo menor é " + diferenca);
    }
}
