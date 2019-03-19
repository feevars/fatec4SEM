/*
 *************************
Lote 01 - Exercício 23 - Receba 3 valores obrigatoriamente em ordem crescente e um 4º valor não
                        necessariamente em ordem. Mostre os 4 números em ordem crescente.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;
public class Lt01_EstSeq23 {
    public static void main (String args[]) 
    {
     
    int VALOR1, VALOR2, VALOR3, VALOR4; 
    
    VALOR1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro: "));
    VALOR2 = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro MAIOR que o anterior: "));
    VALOR3 = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro MAIOR que o anterior: "));
    VALOR4 = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor qualquer: "));
    
    if (VALOR4 < VALOR1) {       
        JOptionPane.showMessageDialog(null,VALOR4 +" < " +VALOR1 +" < " +VALOR2 +" < " +VALOR3);    
    }
    else if (VALOR4 < VALOR2) {
        JOptionPane.showMessageDialog(null,VALOR1 +" < " +VALOR4 +" < " +VALOR2 +" < " +VALOR3); 
    }
        else if (VALOR4 < VALOR3) {
            JOptionPane.showMessageDialog(null,VALOR1 +" < " +VALOR2 +" < " +VALOR4 +" < " +VALOR3); 
        }
            else {
                JOptionPane.showMessageDialog(null,VALOR1 +" < " +VALOR2 +" < " +VALOR3 +" < " +VALOR4);
            }           
    }
}
