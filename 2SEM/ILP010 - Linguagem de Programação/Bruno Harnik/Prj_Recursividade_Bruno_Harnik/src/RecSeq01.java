/*
***********************************************

    1)   Serie1 = (1+2+3+...+100)

    Programador: Bruno Bega Harnik
    Professor: Ricardo Satoshi

***********************************************
*/

import javax.swing.JOptionPane;

public class RecSeq01 {
    
    public static void main(String[] args){
        
        JOptionPane.showMessageDialog(null, Soma1(1,0));
        
    }
    
    static int Soma1(int i, int Soma) { 
        
        if (i == 100) {
            
            Soma += i;
            
            return Soma;  
            
        } else {
           
           return Soma1(i + 1, Soma + i); 
        }
    }
    
}
