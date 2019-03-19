/*
 *************************
Lote 01 - Exercício 20 - Receba 3 coeficientes A, B, e C de uma equação do 
                        2º grau da fórmula AX²+BX+C=0. Verifique e mostre a 
                        existência de raízes reais e caso exista, calcule 
                        e mostre.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi

 *************************
*/
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
public class Lt01_Mod20 {
    static double A, B, C, DELTA = 0, X1, X2; 
     private static DecimalFormat casas2 = new DecimalFormat ("#.##");
public static void main (String args[]) {
           
    A = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de A: "));
    B = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de B: "));
    C = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de C: "));
    
    RaizQuadrada ();
    
    if (DELTA > 0) {        
        JOptionPane.showMessageDialog(null,"X1: " +casas2.format(X1) +"        ||        X2: " +casas2.format(X2) +"\nAmbos os valores são raízes reais.");
    }
    else {
        if (DELTA == 0){
            JOptionPane.showMessageDialog(null,"X1: " +casas2.format(X1) +"        ||        X2: " +casas2.format(X2) +"\nA equação possui apenas uma raiz real.");
        }
        else {
            JOptionPane.showMessageDialog(null,"X1: " +casas2.format(X1) +"        ||        X2: " +casas2.format(X2) +"\nA equação não possui raizes reais.");
        }
    }
}
static void RaizQuadrada() {
    
    DELTA = ( B * B) - 4 * A * C;
    X1 = -B + Math.sqrt(DELTA);
    X2 = -B - Math.sqrt(DELTA);
}
}