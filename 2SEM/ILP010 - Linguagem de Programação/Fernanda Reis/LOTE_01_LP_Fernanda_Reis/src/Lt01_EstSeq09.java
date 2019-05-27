/*
 *************************
Lote 01 - Exercício 08 - Receba os 2 números inteiros. 
Calcule e mostre a soma dos quadrados.
Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */ 


import javax.swing.JOptionPane;

public class Lt01_EstSeq09 {
public static void main (String args[]) 
    {
    int a, b, soma;
    
    a = Integer.parseInt(JOptionPane.showInputDialog("Digite o 1º valor: "));
    b = Integer.parseInt(JOptionPane.showInputDialog("Digite o 2º valor: "));
    soma = (a * a) + (b * b);
    
    JOptionPane.showMessageDialog(null,"A soma dos quadrados dos números inseridos é: " +soma);
    
    }
}
