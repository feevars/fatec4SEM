/*
 *************************
Lote 1 - Array - Exercício 2: Criar e coletar um vetor [100] inteiro e exibir:
            a. O maior e o menor valor;
            b. A média dos valores.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************

 */

import javax.swing.JOptionPane;

public class Lt01_Array02 {
    public static void main (String args []) {
        
        
        int vetor[] = new int [100];
        int i = 0, maior = 0, menor = vetor[1];;
        double soma = 0.0;
        String fatores = "";
        
        for (i = 0; i < 100; i++) {
            vetor[i] = (int)(1 + (Math.random() * 400));
            soma += vetor[i];

            //fazer função ExibeValores
            if (i % 9 == 0 && i !=49  && i != 0) {
                fatores += vetor[i] + "\n";
            } else if (i == 49){
                fatores += vetor[i] + ".\n";
            } else {
                fatores += vetor[i] +", ";
            }
            
            if (vetor[i] < menor) {
                menor = vetor[i];
            }
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }
        soma = soma/100;
        JOptionPane.showMessageDialog(null, fatores + "\nO maior número entre os acima é: " +maior +"\nO menor número entre os acima é: " +menor +"\nA média entre os valores acima é: " +soma);
    }
    
    }
