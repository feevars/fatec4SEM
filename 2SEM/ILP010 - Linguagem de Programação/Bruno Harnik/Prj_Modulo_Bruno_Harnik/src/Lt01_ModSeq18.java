/*
 *************************
 ******MODULARIZAÇÃO******
Lote 01 - Exercício 18
Receba 2 valores inteiros. Calcule e mostre o resultado da diferença do maior pelo menos valor.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_ModSeq18 {
    
    public static void main (String args[]){
        
        int x, y;
        
        x = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro:"));
        
        y = Integer.parseInt(JOptionPane.showInputDialog("Digite outro valor inteiro: "));

        JOptionPane.showMessageDialog(null, "A diferença do maior valor pelo menor é " + CalcDiferenca(x,y) + ".");
    }
    
    public static int CalcDiferenca(int x, int y){
        
        if(x >= y){
            
            int diferenca = x - y;
            return diferenca;
            
        }else{
            
            int diferenca = y - x;
            return diferenca;
            
        }
    }
}
