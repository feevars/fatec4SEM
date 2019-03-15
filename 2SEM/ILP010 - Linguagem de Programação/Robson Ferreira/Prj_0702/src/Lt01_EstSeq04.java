/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 04
Receba a temperatura em graus Celsius. Calcule e mostre a sua
temperatura convertida em fahrenheit F = (9*C+160) /5.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
import javax.swing.JOptionPane;
        
public class Lt01_EstSeq04 {
    public static void main (String args[])
    {   
        double celsius, fahrenheit;
        celsius = Double.parseDouble(JOptionPane.showInputDialog("Digite uma temperatura em Celsius "));
        fahrenheit = (9*celsius+60)/5;
        JOptionPane.showMessageDialog(null, celsius+" Celsius equivale a "+fahrenheit+" fahrenheit.");
    }   
}
