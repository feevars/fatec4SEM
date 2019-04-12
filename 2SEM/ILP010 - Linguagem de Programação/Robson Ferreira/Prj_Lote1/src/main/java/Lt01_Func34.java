/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 34
Receba um número. Calcule e mostre os resultados da tabuada desse número.


Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
import javax.swing.JOptionPane;

public class Lt01_Func34 {

    public static void main(String Args[]) {
        int numero, i;
        numero = Integer.parseInt(JOptionPane.showInputDialog("Insira um numero"));
        for (i = 1; i <= 10; i++) {
            System.out.println(numero+" x "+i+" = " + (numero * i));

        }
    }
}

    
