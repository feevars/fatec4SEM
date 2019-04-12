/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 33
Receba um número. Calcule e mostre a série 1 + 1/2 + 1/3 + ... + 1/N.


Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
import javax.swing.JOptionPane;

public class Lt01_Func33 {

    public static void main(String Args[]) {
        double numero;
        numero = Double.parseDouble(JOptionPane.showInputDialog("insira um numero"));
        JOptionPane.showMessageDialog(null, "o resultado da série é: " + func(numero));
    }
    static double func(double num){
        if (num == 1){
            return num;
        }
        else{
            return 1/num + func(num-1);
        }
    }

}
