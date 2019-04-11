/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 24
Receba um valor inteiro. Verifique e mostre se é divisível por 2 e 3.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_EstDec24 
{
    public static void main (String Args[])
    { 
        int v1;
               
        v1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor"));
          
        if ((v1 % 2 == 0) && (v1 % 3 == 0))
        {
            JOptionPane.showMessageDialog(null, "O valor digitado é divisível por 2 e por 3");
        }
        else 
        {
          JOptionPane.showMessageDialog(null, "O valor digitado NÃO é divisível por 2 e por 3");
        }
                   
        
    }
    
}
