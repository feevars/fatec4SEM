/*
 *************************
Lote 01 - Exercício 38 - Receba 100 números inteiros reais. Verifique e mostre 
o maior e o menor valor. Obs.: somente valores positivos.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************


 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq38 {
    public static void main (String args []) {
        
        String lista = "Números inseridos: \n";
        int numero, i, menor=0, maior=0;
        
        for (i = 1; i <=10; i++) {
            numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o " +i +"º número: "));
            lista += i+ "º: " +numero + "\n";
            if (i == 1) {
                maior = numero;
                menor = numero;
            } 
                else if (numero > maior) {
                    maior = numero;
                } else if (numero < menor) {
                        menor = numero;
                    }
        }
        JOptionPane.showMessageDialog(null, lista +"\n O maior número inserido é " +maior +" enquanto o menor é " +menor +".");
    }
}
