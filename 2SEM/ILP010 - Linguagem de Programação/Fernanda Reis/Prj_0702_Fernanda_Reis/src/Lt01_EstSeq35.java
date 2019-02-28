/*
 *************************
Lote 01 - Exercício 35 - Receba 2 números inteiros, verifique qual o maior 
entre eles. Calcule e mostre o resultado da somatória dos números ímpares entre 
esses valores.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************

INCOMPLETO
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq35 {
    public static void main (String args []){
        String fatores = "";
        int menor, maior, i, j, x=0, aux, soma = 0;
      
        menor = Integer.parseInt(JOptionPane.showInputDialog("Calcularemos a soma dos ímpares entre 2 valores. \nDigite o 1º valor: "));
        maior = Integer.parseInt(JOptionPane.showInputDialog("Digite o 2º valor: "));
      
        /*
        para trocar a ordem caso o maior número seja o primeiro.
        */
        
        if (maior < menor) {
            aux = maior;
            maior = menor;
            menor = aux;
        } 
        
        /*
        
        */
        for (i = menor+1; i < maior; i++) {
            for (j = 2; j < i; j++) {
                if (i % j == 0){
                    x = x + 1;
                }
            }
            if (x == 0) {
                fatores += i +" =-----ÍMPAR----- \n";
                soma = soma + i;
            }
            else {
                fatores += i +" = PAR \n";
            }
        x = 0;
        }
            JOptionPane.showMessageDialog(null, fatores +"\nA soma de números ímpares entre os fatores é " +soma +".");
    }
}
