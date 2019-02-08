 /*
 *************************
Lote 01 - Exercício 10 - Receba 2 números reais. 
Calcule e mostre a diferença desses valores.
Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */ 
import javax.swing.JOptionPane;

public class LOTE01_EX_10 {

public static void main (String args[]) 
    {
    int a, b, diferenca;
    
    a = Integer.parseInt(JOptionPane.showInputDialog("Digite o 1º valor: "));
    b = Integer.parseInt(JOptionPane.showInputDialog("Digite o 2º valor: "));
    diferenca = a - b ;
    
    JOptionPane.showMessageDialog(null,"A diferença dos números inseridos é: " +diferenca);
    
    }
}
   
