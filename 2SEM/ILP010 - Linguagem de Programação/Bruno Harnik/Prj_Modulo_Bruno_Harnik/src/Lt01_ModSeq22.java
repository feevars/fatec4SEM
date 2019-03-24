/*
 *************************
 ******MODULARIZAÇÃO******
Lote 01 - Exercício 22
Receba 2 valores inteiros e diferentes. Mostre seus valores em ordem crescente.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_ModSeq22 {
    
    public static void main(String args[]){
        
        int x, y;
        
        x = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro valor inteiro: "));
        
        y = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo valor inteiro: "));
        
        ExibeCrescente(x, y);
    }
    
    public static void ExibeCrescente(int x, int y){
        
        if(x <= y){
            
            JOptionPane.showMessageDialog(null, "Os valores inseridos, em ordem, são:\n" + x + " e " + y);
            
        }else{
            
            JOptionPane.showMessageDialog(null, "Os valores inseridos, em ordem, são:\n" + y + " e " + x);
            
        }
        
    }
    
}
