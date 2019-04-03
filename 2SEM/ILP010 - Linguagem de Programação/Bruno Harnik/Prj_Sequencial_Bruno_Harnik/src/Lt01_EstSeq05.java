/*
 *************************
Lote 01 - Exercício 05
Receba os coeficientes A, B e C de uma equação do 2º grau (AX²+BX+C=0).
Calcule e mostre as raízes reais (considerar que a equação possue2 raízes).

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq05 {
    
    public static void main (String args[]){
        
        double A, B, C, Delta, X1, X2;
        
        A = Double.parseDouble(JOptionPane.showInputDialog("Equação de segundo grau: AX²+BX+C=0\n\n Digite o valor de A:"));
        
        B = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de B: "));
        
        C = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de C:"));
        
        Delta = (B * B) - (4 * A * C);
        
        
        X1 = (- B + Math.sqrt(Delta)) / (2 * A);
        
        X2 = (- B - Math.sqrt(Delta)) / (2 * A);
        
        if(Delta < 0){
            
            JOptionPane.showMessageDialog(null,"AX²+BX+C=0\n\nA = " + A + "   B =" + B + "   C =" + C +"\n\nNão há raiz possível para os valores declarados.");
            
        }else if(X1 == X2){
            
            JOptionPane.showMessageDialog(null,"AX²+BX+C=0\n\nA = " + A + "   B =" + B + "   C =" + C +"\n\nHá apenas uma raiz real: " + X1);
            
        }else if(Delta >= 0 && X1 != X2)
            
            JOptionPane.showMessageDialog(null,"AX²+BX+C=0\n\nA = " + A + "   B =" + B + "   C =" + C + "\n\n1ª raiz: " + X1 + "\n2ª raiz: " + X2);
        
    }
}
