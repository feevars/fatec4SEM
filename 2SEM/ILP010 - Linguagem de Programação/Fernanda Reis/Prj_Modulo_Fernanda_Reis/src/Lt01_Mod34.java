/*
 *************************
Lote 01 - Exercício 34 - Receba um número. Calcule e mostre os resultados da 
tabuada desse número.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

public class Lt01_Mod34 {
    public static void main (String args[]) {
        
        int numero;
        numero = Integer.parseInt(JOptionPane.showInputDialog("Vamos calcular a tabuada de um número! \nDigite um número inteiro: "));
  
        JOptionPane.showMessageDialog(null, Tabuada(numero));
    }
    
    static String Tabuada (int n){
        String tabuada = "";
        for (int i = 1; i <= 10; i++) {
            int resultado = i * n; 
            tabuada += i +" x " +n + " = " +resultado + "\n";
        }
        return tabuada;
    }
}
