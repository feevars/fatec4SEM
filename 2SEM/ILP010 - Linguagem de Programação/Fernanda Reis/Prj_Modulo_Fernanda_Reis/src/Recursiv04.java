/*
 *************************
Recursivo - 4)   Serie4 = (N/1) +(N-1 / 2 ) + (N-2 / 3) + .... + (1/N). 

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi

 *************************
*/
import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class Recursiv04 { 
    private static DecimalFormat casas2 = new DecimalFormat ("#.##");
    static double inv = 0.0, soma=1.0; 
    public static void main (String args[]) {
        double K = 1.0;
        double N = Double.parseDouble(JOptionPane.showInputDialog("Calcularemos a série Serie4 = (N/1) +(N-1 / 2 ) + (N-2 / 3) + .... + (1/N). ).\n\nDigite um número N: "));
        
        JOptionPane.showMessageDialog(null, "Serie2 = : "  +casas2.format(Serie4(N, K)));      //(5/1) + (4/2) + (3/3) + (2/4) + (1/5)
    }

static double Serie4(double n, double i) { 
    if (n == 1) {
        return n/i;    
    } else {
       return (n/i) + Serie4(n-1,i+1);
    }
}
} 