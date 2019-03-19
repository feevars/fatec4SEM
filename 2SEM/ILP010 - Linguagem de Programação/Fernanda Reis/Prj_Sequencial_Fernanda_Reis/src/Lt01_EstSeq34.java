/*
 *************************
Lote 01 - Exercício 34 - Receba um número. Calcule e mostre os resultados da 
tabuada desse número.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq34 {
    public static void main (String args[]) {
        String tabuada = "";
        
        int numero, i, resultado;
        numero = Integer.parseInt(JOptionPane.showInputDialog("Vamos calcular a tabuada de um número! \nDigite um número inteiro: "));
        
        for (i = 1; i <= 10; i++) {
        resultado = i * numero; 
        tabuada += i +" x " +numero + " = " +resultado + "\n";
        }
        JOptionPane.showMessageDialog(null, tabuada);
    }
}
