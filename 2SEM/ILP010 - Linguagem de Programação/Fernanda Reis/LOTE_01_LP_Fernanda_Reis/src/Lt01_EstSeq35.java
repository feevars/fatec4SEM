/*
 *************************
Lote 01 - Exercício 35 - Receba 2 números inteiros, verifique qual o maior 
entre eles. Calcule e mostre o resultado da somatória dos números ímpares entre 
esses valores.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************


 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq35 {
    public static void main (String args []){
        String fatores = "";
        int menor, maior, i, aux, soma = 0;
      
        menor = Integer.parseInt(JOptionPane.showInputDialog("Calcularemos a soma dos ímpares entre 2 valores. \nDigite o 1º valor: "));
        maior = Integer.parseInt(JOptionPane.showInputDialog("Digite o 2º valor: "));
      
        
        
        if (maior < menor) {
            aux = maior;
            maior = menor;
            menor = aux;
        } 
        
        
        for (i = menor+1; i < maior; i++) {
            if (i % 2 == 0){
                fatores += i +" = PAR \n";
            } else {
                fatores += i +" =-----ÍMPAR----- \n";
                soma += + i;
            }
        }
        JOptionPane.showMessageDialog(null, fatores +"\nA soma de números ímpares entre os fatores é " +soma +".");
    }
}
