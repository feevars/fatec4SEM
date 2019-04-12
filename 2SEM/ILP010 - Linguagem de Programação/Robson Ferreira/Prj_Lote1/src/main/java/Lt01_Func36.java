/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 36
Receba um número N. Calcule e mostre a série 1 + 1/1! + 1/2! + ... + 1/N!


Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
import javax.swing.JOptionPane;

public class Lt01_Func36 {

    public static void main(String Args[]) {
        double n;
        n = Double.parseDouble(JOptionPane.showInputDialog("insira um valor"));
        JOptionPane.showMessageDialog(null, "a série resulta em: " + calc(n));
    }

    static double calc(double num) {
        if (num == 1) {
            return num;
        }
        return 1 / (ffat(num)) + calc(num - 1);
    }

    static double ffat(double fat) {
        if (fat == 1) {
            return fat;
        }
        return fat * ffat(fat - 1);
    }
}
