/*
 *************************
Recursivo - 2)   Serie2 = (N) + (N-1) + (N-2) + ... + (1).

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/
import javax.swing.JOptionPane;

public class Recursiv02 {  

    public static void main (String args[]) { 
        int Serie;
        Serie = Integer.parseInt(JOptionPane.showInputDialog("Calcularemos a série Serie2 = (N) + (N-1) + (N-2) + ... + (1) \n\nDigite um número N: "));
        RecSOMA (Serie);
    
        JOptionPane.showMessageDialog(null, "Serie2 = : "  +RecSOMA(Serie));
    }

static int RecSOMA(int i) { //i recebe o valor digitado (série)
    int Soma = 0;
    if (i == 1) {
        return i;    
    } else {
       Soma = i + RecSOMA(i-1);
       return Soma; 
    }
}
}