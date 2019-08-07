/*
 *************************
Exemplo Recursivo - Coletar um número positivo. Calcule e mostre seu fatorial 
a partir do modelo recursivo.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/

import javax.swing.JOptionPane;

public class Recursiv00 {    
public static void main (String args[]) {
    int NRO;    
    
    NRO = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor inteiro positivo: "));
    
    
    FFAT (NRO);
    JOptionPane.showMessageDialog(null, "O fatorial do número digitado é: " +FFAT(NRO));
}

static int FFAT(int N) { 
    if (N == 1) {
        return N;     
    } else {
       int FAT = N * FFAT(N-1);
       return FAT; 
    }
}
}


