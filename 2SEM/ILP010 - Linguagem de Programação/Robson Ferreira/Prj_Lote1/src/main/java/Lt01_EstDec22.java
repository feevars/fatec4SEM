/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 22
Receba 2 valores inteiros e diferentes. Mostre seus valores em ordem
crescente.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_EstDec22 
{
    public static void main (String Args[])
    { 
        int v1, v2;
               
        v1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor 1"));
        v2 = Integer.parseInt (JOptionPane.showInputDialog("Digite o valor 2"));
          
        if (v1 == v2)
        {
            v1 = Integer.parseInt (JOptionPane.showInputDialog("Digite um valor diferente para o valor 1"));
        }
        else 
        {
            if (v1 < v2)
            {
                JOptionPane.showMessageDialog(null, "Os valores em ordem crescente são: "+v1+", "+v2);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Os valores em ordem crescente são: "+v2+", "+v1);
            }
        }
                   
        
    }
    
}
