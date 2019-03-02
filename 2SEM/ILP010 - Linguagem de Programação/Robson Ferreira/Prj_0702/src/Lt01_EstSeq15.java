/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 15
Receba os valores de 2 catetos de um triângulo retângulo. Calcule e mostre
a hipotenusa.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_EstSeq15 
{
    public static void main (String Args[])
    { 
        double c1, c2;
               
        c1 = Double.parseDouble (JOptionPane.showInputDialog("Digite o cateto 1 do triângulo retângulo"));
        c2 = Double.parseDouble (JOptionPane.showInputDialog("Digite o cateto 2 do triângulo retângulo"));
        
        c1 = c1 * c1;
        c2 = c2 * c2;
        
        c1 = c1 + c2;
        c1 = Math.sqrt(c1);
                      
        JOptionPane.showMessageDialog(null, "A hipotenusa desse triângulo é "+c1);
    }
    
}
