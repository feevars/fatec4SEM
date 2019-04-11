/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 19
Receba 2 valores reais. Calcule e mostre o maior deles.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_EstDec19 
{
    public static void main (String Args[])
    { 
        double v1, v2;
               
        v1 = Double.parseDouble (JOptionPane.showInputDialog("Digite o valor 1"));
        v2 = Double.parseDouble (JOptionPane.showInputDialog("Digite o valor 2"));
          
        if (v1 > v2)
        {
            JOptionPane.showMessageDialog(null, "O maior dos números é "+v1);
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "O maior dos números é "+v2);
        }
                   
        
    }
    
}
