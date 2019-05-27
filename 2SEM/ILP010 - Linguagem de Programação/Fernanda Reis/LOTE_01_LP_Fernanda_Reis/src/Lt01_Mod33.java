/*
 *************************
Lote 01 - Exercício 33 - Receba um número. Calcule e mostre a série 1 + 1/2 + 
1/3 + ... + 1/N.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
INCOMPLETO
 */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Lt01_Mod33 {
    private static DecimalFormat casas2 = new DecimalFormat (".##");
    public static void main (String args []){
        
        double valor = Double.parseDouble(JOptionPane.showInputDialog("Vamos calular 1/1 + 1/2 + ... 1/N. \nDigite um número inteiro: "));
         
        JOptionPane.showMessageDialog(null, "\nA soma dos valores é: " +casas2.format(Soma(valor)));
    }
    static double Soma (double i) {
        
        if (i == 1) {
            return 1/i;
        } else {
            double soma = (1/i) + Soma(i-1);
            return soma;
        }
    }
}
