/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 08
Receba o valor de um depósito em poupança. Calcule e mostre o valor
após 1 mês de aplicação sabendo que rende 1,3% a. m.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_EstSeq08 
{
    public static void main (String Args[])
    { 
        double valor;
               
        valor = Double.parseDouble (JOptionPane.showInputDialog("Digite o valor do depósito"));
                
        valor = valor * 1.013;
        
        JOptionPane.showMessageDialog(null, "Após 1 mês, seu saldo é "+"R$"+valor);
    }
    
}
