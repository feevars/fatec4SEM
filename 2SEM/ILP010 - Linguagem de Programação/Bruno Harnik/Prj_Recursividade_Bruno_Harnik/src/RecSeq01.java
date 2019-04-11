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
        
        JOptionPane.showMessageDialog(null, "1)   Serie1 = (1+2+3+...+100)\nResultado: " + Soma1(1));
        
    }
    
    static int Soma1(int i) { 
        
        if (i == 100) {
            
            return i;  
            
        } else {
           
           return i + Soma1(i + 1); 
        }
    }
    
}
