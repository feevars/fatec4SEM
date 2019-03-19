/*
 *************************
Lote 01 - Exercício 04 - Receba a temperatura em graus Celsius. Calcule e mostre 
a sua temperatura convertida em fahrenheit F = (9*C+160) /5.
Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */ 
import javax.swing.JOptionPane;

public class Lt01_EstSeq04 {
    public static void main (String args[]) {
        double TEMPC, TEMPF;
    
        TEMPC = Double.parseDouble(JOptionPane.showInputDialog("Digite a temperatura em graus Celsius:"));
        TEMPF = (9 * TEMPC + 160) / 5;
    
        JOptionPane.showMessageDialog(null,TEMPC+ " em graus Fahrenheit é: " +TEMPF +".");
    }
}