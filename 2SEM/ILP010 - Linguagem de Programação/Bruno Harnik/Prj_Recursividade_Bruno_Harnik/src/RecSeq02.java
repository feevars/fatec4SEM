/*
***********************************************

    2) Serie2 = (N) + (N-1) + (N-2) + ... + (1) 

    Programador: Bruno Bega Harnik
    Professor: Ricardo Satoshi

***********************************************
*/
import javax.swing.JOptionPane;

public class RecSeq02 {
    
    public static void main(String[] args){
        
        int N = Integer.parseInt(JOptionPane.showInputDialog("Serie2 = (N) + (N-1) + (N-2) + ... + (1)\nDigite um número inteiro positivo:"));
        
        JOptionPane.showMessageDialog(null, "Serie2 = (N) + (N-1) + (N-2) + ... + (1)\nN = " + N
                                                                                    + "\n\nResultado:" + Serie2(N));
        
        
    }
    
    public static int Serie2(int N){
        
        if(N == 1){
            
            return N;
            
        }else{
            
            return N + Serie2(N - 1);
        }
        
    }
    
}
