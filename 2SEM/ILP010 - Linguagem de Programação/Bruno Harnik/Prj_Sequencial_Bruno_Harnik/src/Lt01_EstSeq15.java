/*
 *************************
Lote 01 - Exercício 15
Receba os valores de 2 catetos de um triângulo retângulo.
Calcule e mostre a hipotenusa.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq15 {
    
    public static void main (String args[]){
        
        double cateto1, cateto2, hipotenusa;
        
        cateto1 = Double.parseDouble(JOptionPane.showInputDialog("Triângulo retângulo.\n\nDigite o valor do primeiro cateto: "));
        
        cateto2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do segundo cateto: "));
        
        hipotenusa = Math.sqrt(cateto1 * cateto1 + cateto2 * cateto2);

        JOptionPane.showMessageDialog(null, "O valor da hipotenusa é: " + hipotenusa);
    }
}
