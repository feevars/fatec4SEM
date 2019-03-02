/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 10
Receba 2 números reais. Calcule e mostre a diferença desses valores.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_EstSeq10 
{
    public static void main (String Args[])
    { 
        double n1, n2;
               
        n1 = Double.parseDouble (JOptionPane.showInputDialog("Digite o valor do número 1"));
                
        n2 = Double.parseDouble (JOptionPane.showInputDialog("Digite o valor do número 2"));
        
        n1 = n1 - n2;
        
        n1 = Math.abs(n1);
        
        JOptionPane.showMessageDialog(null, "A soma dos quadrados dos dois números é "+n1);
    }
    
}
