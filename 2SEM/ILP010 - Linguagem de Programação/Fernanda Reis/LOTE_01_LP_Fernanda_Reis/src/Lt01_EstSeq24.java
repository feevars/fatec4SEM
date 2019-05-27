/*
 *************************
Lote 01 - Exercício 24 - Receba um valor inteiro. Verifique e mostre se é 
divisível por 2 e 3.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;
public class Lt01_EstSeq24 {
    public static void main (String args[]) {
     
        int VALOR; 
    
        VALOR = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro: "));
   
    
        if (VALOR % 3  == 0  && VALOR % 2 == 0) {       
            JOptionPane.showMessageDialog(null,"O VALOR É DIVISÍVEL POR 2 E POR 3.");    
        }
        else {
        JOptionPane.showMessageDialog(null,"O VALOR NÃO É DIVISÍVEL POR 2 E 3."); 
        }   
    }
}
