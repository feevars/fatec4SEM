/*
 *************************
Lote 01 - Exercício 14 - Receba 2 ângulos de um triângulo. 
          Calcule e mostre o valor do 3º ângulo.
Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/
 
import javax.swing.JOptionPane;
public class Lt01_EstSeq14 {
public static void main (String args[]) 
    {
    int A1, A2;
    
    A1 = Integer.parseInt(JOptionPane.showInputDialog("Primeiro ângulo do triângulo: "));
    A2 = Integer.parseInt(JOptionPane.showInputDialog("Segundo ângulo do triângulo: "));
    A1 = 180 - A1 - A2;
    
    JOptionPane.showMessageDialog(null,"O terceiro ângulo possui " +A1 +"º graus.");
    
    }
}