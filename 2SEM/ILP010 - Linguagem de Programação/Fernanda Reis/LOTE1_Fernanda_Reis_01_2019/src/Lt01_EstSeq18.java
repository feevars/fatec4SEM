/*
 *************************
Lote 01 - Exercício 18 - Receba 2 valores inteiros. Calcule e mostre o 
                        resultado da diferença do maior pelo menos valor.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
public class Lt01_EstSeq18 {
    
public static void main (String args[]) 
    {
    int valor1, valor2; 
    
    valor1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro: "));
    valor2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro valor inteiro: "));
    if (valor1 > valor2) {
        valor1 = valor1 - valor2;
    }
    else {
        valor1 = valor2 - valor1;    
         }
        JOptionPane.showMessageDialog(null,"O resultado da diferença do nº maior pelo nº menor é: " + valor1);
    }
}