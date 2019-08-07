/*
 *************************
Lote 01 - Exercício 11 - Receba o raio de uma circunferência. 
Calcule e mostre o comprimento da circunferência.
Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/
import java.text.DecimalFormat; 
import javax.swing.JOptionPane;

public class Lt01_EstSeq11 {

private static DecimalFormat casas2 = new DecimalFormat (".##");
public static void main (String args[]) 
    {
    double raio, comprimento;
    
    raio = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do raio da circunferência em cm: "));
    comprimento = 2 * 3.14 * raio;
        
    JOptionPane.showMessageDialog(null,"Adotando pi como 3,14, o comprimento da circunferência é de " +casas2.format(comprimento) +" cm");
    
    }
}
   
