/*
 *************************
Lote 01 - Exercício 02
Receba o salário de um funcionário e mostre o novo salário com reajuste de 15%.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq02 {
    public static void main (String args[]) 
    {
    double salario, liquido;
    
    salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário com duas casas decimais.\nSepare as casas decimais com ponto.\nR$ "));
    liquido = salario + (salario * 0.15);
    
    JOptionPane.showMessageDialog(null,"O salário com reajuste de 15% é R$" +liquido);
    
    }
}
