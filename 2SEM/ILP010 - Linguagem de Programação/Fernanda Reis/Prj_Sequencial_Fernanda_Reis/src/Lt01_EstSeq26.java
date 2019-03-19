/*
 *************************
Lote 01 - Exercício 26 - Receba 2 números inteiros. Verifique e mostre se o 
                         maior número é múltiplo do menor.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;
public class Lt01_EstSeq26 {
    public static void main (String args[]) {
     
        int maior, menor;
        double aux;
        

            menor = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro: "));
            maior = Integer.parseInt(JOptionPane.showInputDialog("Digite outro valor inteiro maior que o anterior: "));
        
        if (maior < menor) {
            JOptionPane.showMessageDialog(null,"O número inserido é menor que o anterior.");
        }
        else { 
            aux = maior % menor ;
            
        
            if (aux == 0) {
                JOptionPane.showMessageDialog(null, maior +" é múltiplo de " +menor);
            }
            else {
                JOptionPane.showMessageDialog(null, maior +" não é múltiplo de " +menor);
            }
        }
    }
}
