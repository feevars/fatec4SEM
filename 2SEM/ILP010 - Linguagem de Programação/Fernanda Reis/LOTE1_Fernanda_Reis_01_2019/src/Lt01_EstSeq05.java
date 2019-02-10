/*
 *************************
Lote 01 - Exercício 5 - Receba os coeficientes A, B e C de uma equação do 2º grau (AX²+BX+C=0). 
Calcule e mostre as raízes reais (considerar que a equação possui 2 raízes).
Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */ 
import javax.swing.JOptionPane;

public class Lt01_EstSeq05 {
    public static void main (String args[]) 
    {
    double A, B, C, delta, x1, x2, raiz;
    
    
    A = Double.parseDouble(JOptionPane.showInputDialog("Digite o A:"));
    B = Double.parseDouble(JOptionPane.showInputDialog("Digite o B:"));
    C = Double.parseDouble(JOptionPane.showInputDialog("Digite o C:"));
    delta = B * B - 4 * A * C;
    raiz = Math.sqrt(delta);
    x1 = (- B + raiz) / ( 2 * A);
    x2 = (- B - raiz) / ( 2 * A);
    
    JOptionPane.showMessageDialog(null," X1/*: " +x1 + " X2: " + x2);
    
    }
}
