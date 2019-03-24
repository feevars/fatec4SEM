/*
 *************************
Recursivo - 3)   Serie3 = (1/1) + (1/2) + (1/3) + ....+ (1/N).

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/
import javax.swing.JOptionPane;

public class Recursiv03 {  
    static double DIV = 0.0, soma=1.0; 
    public static void main (String args[]) { 
        double Serie;
        Serie = Double.parseDouble(JOptionPane.showInputDialog("Calcularemos a série Serie3 = (1/1) + (1/2) + (1/3) + ....+ (1/N).\n\nDigite um número N: "));
        RecDIV (Serie);
        
        JOptionPane.showMessageDialog(null, "Serie2 = : "  +RecDIV(Serie));
    }

static double RecDIV(double i) { //i recebe o valor digitado (Serie)
    if (i == 1) {
        return i;    
    } else {
       DIV = (1/i) + 1/RecDIV(i-1);
       return DIV; 
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