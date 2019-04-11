/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 18
Receba 2 valores inteiros. Calcule e mostre o resultado da diferença do
maior pelo menor valor.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */

import javax.swing.JOptionPane;

public class Lt01_EstDec18 {

    public static void main(String Args[]) {
        double v1, v2;

        v1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor 1"));
        v2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor 2"));

        if (v1 > v2) {
            v1 = v1 - v2;
        }
        else
        {
            v1 = v2 - v1;
        }

        JOptionPane.showMessageDialog(null, "a diferença do maior pelo menor é " + v1);
    }

}
