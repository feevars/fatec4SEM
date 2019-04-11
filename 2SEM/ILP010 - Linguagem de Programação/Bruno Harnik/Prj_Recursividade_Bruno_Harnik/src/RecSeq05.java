/*
***********************************************

    5)   Serie5 = (N)! + (N-1)! + (N-2)! + ... + (1)!  

    Programador: Bruno Bega Harnik
    Professor: Ricardo Satoshi

***********************************************
*/

import javax.swing.JOptionPane;

public class RecSeq05 {
    
    public static void main(String[] args){
        
        int N = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor N para a Série 4\n"
                                                            + "Serie4 = (N/1) +(N-1 / 2 ) + (N-2 / 3) + .... + (1/N)"));
        
        JOptionPane.showMessageDialog(null, Serie(N));

    }
    
    public static int Serie(int n){
        
        if(n == 1){
            
            return 1;
        }
        
        return Fatorial(n) + Serie(n - 1);
        
    }
    public static int Fatorial(int x){
        
        if(x == 0){
            
            return 1;
        }
        
        return x * Fatorial(x - 1);
        
    }
    
}
