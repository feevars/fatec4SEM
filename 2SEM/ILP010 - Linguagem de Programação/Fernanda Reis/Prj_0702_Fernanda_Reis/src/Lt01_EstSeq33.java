/*
 *************************
Lote 01 - Exercício 33 - Receba um número. Calcule e mostre a série 1 + 1/2 + 
1/3 + ... + 1/N.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
INCOMPLETO
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq33 {
    public static void main (String args []){
        
        String resultado = "";
        String soma = "";
        int valor, teste, i;
        double numero;
        
        valor = Integer.parseInt(JOptionPane.showInputDialog("Vamos calular 1/1 + 1/2 + ... 1/N. \nDigite um número inteiro: "));
        for (i=1; i<=valor; i++){
          resultado += "1/" + i " + ";
          soma += 1/i;
        }
        JOptionPane.showMessageDialog(null, "\nA soma dos valores acima é: " +soma )
        
        
        
        do {
            
          for (teste = valor; teste >= 1; teste--) {
              resultado += "1/" +teste + " + "; 
            }
          resultado += " = \n"; 
          numero += + (1/valor);
          valor += -1;
          
        }
        while (valor >= 1);
        
        JOptionPane.showMessageDialog(null,resultado +"\nA soma dos valores é: " +numero);
        
    }
}