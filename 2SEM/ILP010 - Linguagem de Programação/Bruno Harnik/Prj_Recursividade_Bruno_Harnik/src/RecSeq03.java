/*
***********************************************

    3)   Serie3 = (1/1) + (1/2) + (1/3) + ....+ (1/N)   

    Programador: Bruno Bega Harnik
    Professor: Ricardo Satoshi

***********************************************
*/
import javax.swing.JOptionPane;

public class RecSeq03 {
    
    public static void main(String[] args){
        
        int N = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro positivo para N:"));
        
        JOptionPane.showMessageDialog(null, "3)   Serie3 = (1/1) + ... + (1/2) + (1/3) + ....+ (1/N)\nN = " + N
                                                                                    + "\n\nResultado:" + Serie(N));
        
    }
    
    public static double Serie(double n){
        
        if(n == 1){
            
            return 1;
        }
        
        return 1 / n + Serie(n - 1);
        
    }
}
