/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 05
Receba os coeficientes A, B e C de uma equação do 2º grau
(AX²+BX+C=0). Calcule e mostre as raízes reais (considerar que a
equação possue2 raízes).


Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */

import javax.swing.JOptionPane;
import java.lang.Math; 

public class Lt01_EstSeq05 
{
    public static void main (String args[])
    {
        double a, b, c, d, X1, X2;
        
        a = Double.parseDouble(JOptionPane.showInputDialog("Cálculo de equação de segundo grau\nDigite o valor de 'a'"));
        
        b = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de 'b' "));
        
        c = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de 'c' "));
        
        d = (b * b) - (4 * a * c);
        
        
        X1 = (- b + Math.sqrt(d)) / (2 * a);
        
        X2 = (- b - Math.sqrt(d)) / (2 * a);
        
        if(d < 0){
            
            JOptionPane.showMessageDialog(null,"Sua equação de segundo grau deu:\n\nNão há raiz possível para os valores declarados.");
            
        }else if(X1 == X2){
            
            JOptionPane.showMessageDialog(null,"Sua equação de segundo grau deu:\n\nHá apenas uma raiz real: " + X1);
            
        }else if(d >= 0 && X1 != X2)
            
            JOptionPane.showMessageDialog(null,"Sua equação de segundo grau deu:\n\n1ª raiz: " + X1 + "\n2ª raiz: " + X2);
        
    }
}