/*
 *************************
Lote 01 - Exercício 22 - Receba 2 valores inteiros e diferentes. Mostre seus 
                        valores em ordem crescente.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;
public class Lt01_EstSeq22 {
    public static void main (String args[]) 
    {
     
    
    double VALOR1, VALOR2; 
    
    VALOR1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro: "));
    VALOR2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro valor inteiro: "));
    
    if (VALOR1 > VALOR2) {        
        JOptionPane.showMessageDialog(null,"OS VALORES DIGITADOS, EM ORDEM CRESCENTE SÃO: " +VALOR2 +" < " +VALOR1);
    }
    else {
        JOptionPane.showMessageDialog(null,"OS VALORES DIGITADOS, EM ORDEM CRESCENTE SÃO: " +VALOR1 +" < " +VALOR2);
        }
    }
    }
