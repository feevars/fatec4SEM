 /*
 *************************
Lote 01 - Exercício 10 - Receba 2 números reais. 
Calcule e mostre a diferença desses valores.
Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */ 
import javax.swing.JOptionPane;

public class Lt01_EstSeq10 {

public static void main (String args[]) 
    {
    double a, b, diferenca;
    
    a = Double.parseDouble(JOptionPane.showInputDialog("Digite o 1º valor: "));
    b = Double.parseDouble(JOptionPane.showInputDialog("Digite o 2º valor: "));
    diferenca = a - b ;
    diferenca = Math.abs(diferenca);
    JOptionPane.showMessageDialog(null,"A diferença dos números inseridos é: " +diferenca);
    
    }
}
   
