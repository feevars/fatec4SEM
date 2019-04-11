/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 26
Receba 2 números inteiros. Verifique e mostre se o maior número é múltiplo
do menor.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_EstDec26 
{
    public static void main (String Args[])
    { 
        int v1, v2;
               
        v1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor 1"));
        v2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor 2"));
          
        if (v1 > v2)
        {
            if (v1 % v2 ==0)
            {
                JOptionPane.showMessageDialog(null, "O valor 1 é múltiplo do valor 2.");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "O valor 1 NÃO é múltiplo do valor 2.");
            }
        }
        else
        {
            if (v2 % v1 ==0)
            {
                JOptionPane.showMessageDialog(null, "O valor 2 é múltiplo do valor 1.");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "O valor 2 NÃO é múltiplo do valor 1.");
            }
        }

        
    }
    
}
