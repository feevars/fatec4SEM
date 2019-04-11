/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 20
Receba 3 coeficientes A, B, e C de uma equação do 2º grau da fórmula
AX²+BX+C=0. Verifique e mostre a existência de raízes reais e se caso
exista, calcule e mostre.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_EstDec20 
{
    public static void main (String Args[])
    { 
        double a, b, c, d, x1, x2;
               
        a = Double.parseDouble (JOptionPane.showInputDialog("Equação de segundo grau.\n\nDigite o valor a"));
        b = Double.parseDouble (JOptionPane.showInputDialog("Digite o valor b"));
        c = Double.parseDouble (JOptionPane.showInputDialog("Digite o valor c"));
        
        if (b >=3 & b>=(a+c))
        {
            d = b * b - 4 * a * c;
            d = Math.sqrt(d);
            x1 = -b + d / 2 * a;
            x2 = -b - d / 2 * a; 
            JOptionPane.showMessageDialog(null, "A raiz 1 é "+x1+"\nA raiz 2 é "+x2);          
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Não há raizes para essa equação!");
        }
                   
        
    }
    
}
