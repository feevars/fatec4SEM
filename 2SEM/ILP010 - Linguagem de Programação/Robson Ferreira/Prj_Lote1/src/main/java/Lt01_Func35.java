/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 35
Receba 2 números inteiros, verifique qual o maior entre eles. Calcule e
mostre o resultado da somatória dos números ímpares entre esses valores.


Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
import javax.swing.JOptionPane;

public class Lt01_Func35 {

    public static void main(String Args[]) {
        int num1, num2, i, soma = 0;
        num1 = Integer.parseInt(JOptionPane.showInputDialog("insira o valor 1"));
        num2 = Integer.parseInt(JOptionPane.showInputDialog("insira o valor 2"));
        if (num1 > num2) {
            for (i = num2; (i <= num1); i++) {
                if (i % 2 != 0) {
                    soma = soma + i;
                }
            }
        } else {
            for (i = num1; (i <= num2); i++) {
                if (i % 2 != 0) {
                    soma = soma + i;
                }
            }
            JOptionPane.showMessageDialog(null, "a somatória dos valores ímpares entre os dois números é: " + soma);
        }

    }
}
