/*
 *************************
Lote 01 - Exercício 22 - Receba 2 valores inteiros e diferentes. Mostre seus 
                        valores em ordem crescente.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;
public class Lt01_Mod22 {
    String resultado = "";
    public static void main (String args[]) 
    {
     
    
    int VALOR1, VALOR2; 
    
    VALOR1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro: "));
    VALOR2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro valor inteiro: "));
    
    Maior(VALOR1, VALOR2);
    //valor1 = maior || valor2 = menor
         
    JOptionPane.showMessageDialog(null,"OS VALORES DIGITADOS, EM ORDEM CRESCENTE SÃO: " +VALOR2 +" < " +VALOR1);
    }
    
    static String Maior (int v1, int v2) {
        int aux = 0;
        if (v1 > v2) {
          return 
        } else {
            return maior;
        }
    }
         
    
    }  
    }
    
    
