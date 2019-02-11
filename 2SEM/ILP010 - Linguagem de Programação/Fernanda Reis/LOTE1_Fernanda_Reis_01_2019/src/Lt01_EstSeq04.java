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
    public static void main (String args[]) 
    {
    double tempc, tempf;
    
    tempc = Double.parseDouble(JOptionPane.showInputDialog("Digite a temperatura em graus Celsius:"));
    tempf = (9 * tempc + 160) / 5;
    
    JOptionPane.showMessageDialog(null,tempc+ " em graus Fahrenheit é: " +tempf);
    
    }
}