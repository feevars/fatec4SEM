/*
 *************************
Lote 01 - Exercício 08
Receba o valor de um depósito em poupança. Calcule e mostre o valor após 1 mês de aplicação sabendo que rende 1,3% a. m.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Lt01_EstSeq08 {
    
    private static DecimalFormat casas2 = new DecimalFormat(".##");
    
    public static void main (String args[]){
        
        double deposito, rendimento, valor;
        
        deposito = Double.parseDouble(JOptionPane.showInputDialog("Rendimento de 1,3% ao mês.\n\nDigite o valor do depósito na poupança: "));
        
        rendimento = deposito * 0.013;
        
        valor = deposito + rendimento;
        
        JOptionPane.showMessageDialog(null, "Ao depositar R$" + casas2.format(deposito) + ", com 1,3% de rendimento ao mês, você terá R$" + casas2.format(valor) + ", ou seja, rendeu R$" + casas2.format(rendimento));
    }
}
