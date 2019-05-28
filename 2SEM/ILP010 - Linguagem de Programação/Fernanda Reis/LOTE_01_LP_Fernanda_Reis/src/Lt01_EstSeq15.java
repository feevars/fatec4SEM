/*
 *************************
Lote 01 - Exercício 15 - Receba os valores de 2 catetos de um triângulo 
         retângulo. Calcule e mostre a hipotenusa.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/
 
import javax.swing.JOptionPane;
public class Lt01_EstSeq15 {
public static void main (String args[]) 
    {
    int cat1, cat2; 
    double hip;
    
    cat1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o comprimento do 1º cateto: "));
    cat2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o comprimento do 2º cateto: "));
    hip = Math.sqrt((cat1*cat1)+(cat2*cat2));
    
    
    JOptionPane.showMessageDialog(null,"O valor da hipotenusa é " +hip +".");
    
    }
}