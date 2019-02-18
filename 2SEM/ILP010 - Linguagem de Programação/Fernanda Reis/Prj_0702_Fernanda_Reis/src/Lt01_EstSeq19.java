/*
 *************************
Lote 01 - Exercício 19 - Receba 2 valores reais. Calcule e mostre o maior deles.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
public class Lt01_EstSeq19 {
     private static DecimalFormat casas2 = new DecimalFormat (".##");
public static void main (String args[]) 
    {
    
    double VALOR1, VALOR2; 
    
    VALOR1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro valor: "));
    VALOR2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo valor: "));
    if (VALOR1 > VALOR2) {
        JOptionPane.showMessageDialog(null,"O maior valor entre os valores digitados é " +casas2.format(VALOR1));
    }
    else {
        JOptionPane.showMessageDialog(null,"O maior valor entre os valores digitados é " +casas2.format(VALOR2));
    }
    }
}