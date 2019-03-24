/*
 *************************
 ******MODULARIZAÇÃO******
Receba um valor inteiro. Verifique e mostre se é divisível por 2 e 3.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_ModSeq24 {
    
    public static void main(String args[]){
        
        int x;
        
        x = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro: "));
        
        if(Divisivel2e3(x) == true){
            
            JOptionPane.showMessageDialog(null, x + " é divisível por 2 e 3.");
            
        }else{
            
            JOptionPane.showMessageDialog(null, x + " não é divisível por 2 e 3.");
            
        }
        
    }
    
    public static boolean Divisivel2e3(int valor){
        
        return valor % 2 == 0 && valor % 3 == 0;
        
    }
}
