/*
***********************************************

    4)   Serie4 = (N/1) +(N-1 / 2 ) + (N-2 / 3) + .... + (1/N)  

    Programador: Bruno Bega Harnik
    Professor: Ricardo Satoshi

***********************************************
*/

import javax.swing.JOptionPane;

public class RecSeq04 {
    
    public static void main(String[] args){
        
        int N = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor N para a Série 4\n"
                                                            + "Serie4 = (N/1) + (N-1 / 2 ) + (N-2 / 3) + .... + (1/N)"));
        
        JOptionPane.showMessageDialog(null, Serie4(N, 1));

    }
    
    public static double Serie4(double n, double i){

        if(n == 1){
            
            return i;
            
        }
        
        return i/n + Serie4(n - 1,i + 1);
        
        
    }
    
}
