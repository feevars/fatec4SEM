
import javax.swing.JOptionPane;

/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 31
Calcule e mostre o quadrado dos números entre 10 e 150.


Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
public class Lt01_Func31 {
    public static void main (String Args[]){
        double numero;
        //numero = Double.parseDouble(JOptionPane.showInputDialog("insira um numero"));
        //JOptionPane.showMessageDialog(null,ModCalc(numero));
        for (numero=10;numero<=100;numero++){
            System.out.println(ModCalc(numero));
        }
          
    }
    static double ModCalc(double quad){
        return (quad = quad*quad);
    }
}
