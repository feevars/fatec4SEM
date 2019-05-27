/*
 *************************
Recursivo - 1)   Serie1 = (1+2+3+...+100).

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/
import javax.swing.JOptionPane;

public class Recursiv01 {  
    static int Soma=0, i=1;
    public static void main (String args[]) { 
        String Serie = "Calcularemos a série Serie1 = (1+2+3+...+100).\n\n\n";
        RecSOMA (i);
    
        JOptionPane.showMessageDialog(null, Serie +"Serie1 = : "  +Soma);
    }

static int RecSOMA(int i) { 
    
    if (i == 100) {
        Soma += i;
        return Soma;     
    } else {
       Soma += i;
       return RecSOMA(i+1); 
    }
}
}
