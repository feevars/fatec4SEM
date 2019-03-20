/*
 *************************
Lote 01 - Exercício 24
Receba um valor inteiro. Verifique e mostre se é divisível por 2 e 3.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq24 {
    
    public static void main(String args[]){
        
        int valor;
        
        valor = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro: "));
        
        if(valor % 2 == 0 && valor % 3 == 0){
            
            JOptionPane.showMessageDialog(null, valor + " é divisível por 2 e 3.");
            
        }else{
            
            JOptionPane.showMessageDialog(null, valor + " não é divisível por 2 e 3.");
            
        }
        
    }
    
}
