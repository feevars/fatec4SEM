/*
 *************************
Recursivo - 3)   Serie3 = (1/1) + (1/2) + (1/3) + ....+ (1/N).

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/
import javax.swing.JOptionPane;

public class Recursiv03 {  
    
    static double div = 0.0, j=1.0; 
    
    public static void main (String args[]) { 
        double N = Double.parseDouble(JOptionPane.showInputDialog("Calcularemos a série Serie3 = (1/1) + (1/2) + (1/3) + ....+ (1/N).\n\nDigite um número N: "));
  
        JOptionPane.showMessageDialog(null, "Serie2 = : "  +recDiv(N));
    }

    static double recDiv(double i) { //i recebe o valor digitado (Serie)
        if (j == i) {
            return j;    
        } else {
           return (1/j) + (1/recDiv(j+1));
        }
    }
} // 1 + 0,5 + 
/*
i = 3
1/1 + 1/2 + 1/3 
j = 1; global
if (j == i)
    div += 1/j;
    return div;
else
    
    div += 1/j; 
    j+= 1;
    div += FuncDIV(i);
*/