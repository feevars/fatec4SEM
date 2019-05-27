/*
 *************************
Lote 01 - Exercício 02 - Receba o salário de um funcionário e mostre o novo 
                            salário com reajuste de 15%.
Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */ 
import javax.swing.JOptionPane;

public class Lt01_EstSeq02 {
    public static void main (String args[]) {
        
        double salario, novosal;
    
        salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário do funcionário com 2 decimais:"));
        novosal = (salario * 1.15) ;
    
        JOptionPane.showMessageDialog(null,"O salário com reajuste é de:" +novosal);
    }
}