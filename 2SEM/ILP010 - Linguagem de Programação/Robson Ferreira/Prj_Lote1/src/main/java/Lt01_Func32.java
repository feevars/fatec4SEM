/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 32
Receba um número inteiro. Calcule e mostre o seu fatorial.


Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
import javax.swing.JOptionPane;

public class Lt01_Func32 {

    public static void main(String Args[]) {
        int numero;

        numero = Integer.parseInt(JOptionPane.showInputDialog("insira um número"));
        JOptionPane.showMessageDialog(null, FFat(numero));

    }

    static int FFat(int num) {
            if (num == 1) {
            return num;
        } else {
            return num * (FFat(num - 1));
        }
    }

}
