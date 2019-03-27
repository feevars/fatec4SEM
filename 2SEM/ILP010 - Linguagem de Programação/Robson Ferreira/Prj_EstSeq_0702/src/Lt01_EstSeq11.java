/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 11
Receba o raio de uma circunferência. Calcule e mostre o comprimento da
circunferência.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_EstSeq11 
{
    public static void main (String Args[])
    { 
        double raio;
               
        raio = Double.parseDouble (JOptionPane.showInputDialog("Digite o valor do raio da circunferência"));
                
        raio = 2 * 3.14 * raio;
               
        JOptionPane.showMessageDialog(null, "O comprimento da circunferência é "+raio+"cm");
    }
    
}
