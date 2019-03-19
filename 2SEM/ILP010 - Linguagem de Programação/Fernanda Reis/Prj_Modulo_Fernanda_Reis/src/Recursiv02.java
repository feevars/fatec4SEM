/*
 *************************
Exercicio 1 - Recursivo - 1)   Serie1 = (1+2+3+...+100).

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/
import javax.swing.JOptionPane;

public class Recursiv02 {    
public static void main (String args[]) {
    int Serie;    
    
    Serie = Integer.parseInt(JOptionPane.showInputDialog("Calcularemos a série Serie1 = (1+2+3+...+100)."));
    
    
    RecSOMA (Serie);
    JOptionPane.showMessageDialog(null, "O fatorial do número digitado é: " +RecSOMA(Soma));
}

static int RecSOMA(int i) { 
    int Soma=0;
    if (i == 1) {
        return Soma;     
    } else {
       Soma += + i;
       return Soma; 
    }
}
}
