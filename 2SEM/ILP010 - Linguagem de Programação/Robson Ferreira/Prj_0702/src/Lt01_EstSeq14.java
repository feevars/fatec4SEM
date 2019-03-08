/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 14
Receba 2 ângulos de um triângulo. Calcule e mostre o valor do 3º ângulo.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_EstSeq14 
{
    public static void main (String Args[])
    { 
        double a1, a2;
               
        a1 = Double.parseDouble (JOptionPane.showInputDialog("Digite o ângulo 1 do triângulo"));
        a2 = Double.parseDouble (JOptionPane.showInputDialog("Digite o ângulo 2 do triângulo"));
                       
        a1 = 180 - a1 - a2;
                      
        JOptionPane.showMessageDialog(null, "O ângulo 3 desse triângulo é de "+a1+" graus.");
    }
    
}
