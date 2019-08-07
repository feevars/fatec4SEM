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
    public static void main (String args[]) {
        double A, B, C, DELTA, X1, X2, RAIZ;
    
    
        A = Double.parseDouble(JOptionPane.showInputDialog("Digite o A:"));
        B = Double.parseDouble(JOptionPane.showInputDialog("Digite o B:"));
        C = Double.parseDouble(JOptionPane.showInputDialog("Digite o C:"));
        DELTA = B * B - 4 * A * C;
        RAIZ = Math.sqrt(DELTA);
        X1 = (- B + RAIZ) / ( 2 * A);
        X2 = (- B - RAIZ) / ( 2 * A);
    
    JOptionPane.showMessageDialog(null," X1/*: " +X1 + " X2: " + X2);
    
    }
}
