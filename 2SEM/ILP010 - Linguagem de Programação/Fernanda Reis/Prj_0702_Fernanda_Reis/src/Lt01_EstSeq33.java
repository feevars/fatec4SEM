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

public class Lt01_EstSeq33 {
    private static DecimalFormat casas2 = new DecimalFormat (".##");
    private static DecimalFormat casas1 = new DecimalFormat ("");
    public static void main (String args []){
        
        String resultado = "";
        double soma=0, i, valor;
        
        valor = Double.parseDouble(JOptionPane.showInputDialog("Vamos calular 1/1 + 1/2 + ... 1/N. \nDigite um número inteiro: "));
        
        for (i=1; i<=valor; i++){
          if (i < valor) {
              resultado += "1/" +casas1.format(i)  +" + ";
          }
          else if (i == valor){
              resultado += "1/" +casas1.format(i);
          }
          soma += +(1/i);
        }
        JOptionPane.showMessageDialog(null, resultado +"\nA soma dos valores acima é: " +casas2.format(soma) );
    }
}