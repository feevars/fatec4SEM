/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 09
Receba os 2 números inteiros. Calcule e mostre a soma dos quadrados.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_EstSeq09 
{
    public static void main (String Args[])
    { 
        double n1, n2;
               
        n1 = Double.parseDouble (JOptionPane.showInputDialog("Digite o valor do número 1"));
                
        n2 = Double.parseDouble (JOptionPane.showInputDialog("Digite o valor do número 2"));
        
        n1 = n1 * n1;
        
        n2 = n2 * n2;
        
        n1 = n1 + n2;
        
        JOptionPane.showMessageDialog(null, "A soma dos quadrados dos dois números é "+n1);
    }
    
}
