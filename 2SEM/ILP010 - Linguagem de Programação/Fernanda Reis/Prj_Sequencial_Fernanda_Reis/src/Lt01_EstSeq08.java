/*
 *************************
Lote 01 - Exercício 08 - /**Receba o valor de um depósito em poupança. 
Calcule e mostre o valor após 1 mês de aplicação sabendo que rende 1,3% a. m.
Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */ 
/* 
*******!!!!!*****!!****!!!!!*******COMO LIMITAR O NÚMERO DE CASAS DECIMAIS?
*/
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
public class Lt01_EstSeq08 {
    
    private static DecimalFormat casas2 = new DecimalFormat (".##");
public static void main (String args[]) 
    {
    double deposito, novomes;
    
    deposito = Double.parseDouble(JOptionPane.showInputDialog("Valor de depósito: "));
    novomes = deposito * 1.013;
    
    JOptionPane.showMessageDialog(null,"Valor após 1 mês de investimento: " +casas2.format(novomes));
    
    }
}
