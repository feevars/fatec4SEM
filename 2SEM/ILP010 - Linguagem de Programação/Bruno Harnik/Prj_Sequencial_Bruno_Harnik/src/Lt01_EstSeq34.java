/*
 *************************
Lote 01 - Exercício 33
Receba um número. Calcule e mostre a série 1 + 1/2 + 1/3 + ... + 1/N.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq34 {
    
    public static void main(String args[]){

        String resultado = "";
        
        int numero;
        
        numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Escolha um numero inteiro para gerar a tabuada: "));
        
        for (int i = 1; i <= 10; i++){
            
            int multiplo = numero * i;

            resultado += numero + " × " + i + " = " + multiplo + "\n";

        }

       JOptionPane.showMessageDialog(null, "A tabuado de " + numero + " é: \n" + resultado);
    }
    
}
