/*
 *************************
Lote 01 - Exercício 26 - Receba 2 números inteiros. Verifique e mostre se o 
                         maior número é múltiplo do menor.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;
public class Lt01_Mod26 {
    public static void main (String args[]) {
     
        int maior, menor;
        menor = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro: "));
        maior = Integer.parseInt(JOptionPane.showInputDialog("Digite outro valor inteiro maior que o anterior: "));
        
        if (maior < menor) {
            JOptionPane.showMessageDialog(null,"O número inserido é menor que o anterior.");
        } else {     
            if (Multiplo((int) maior, menor) == true) {
                JOptionPane.showMessageDialog(null, maior +" é múltiplo de " +menor);
            } else {
                JOptionPane.showMessageDialog(null, maior +" não é múltiplo de " +menor);
            }
        }
    }
    
    public static boolean Multiplo(int maior, int menor) {
        return (maior % menor == 0);
    }
}
