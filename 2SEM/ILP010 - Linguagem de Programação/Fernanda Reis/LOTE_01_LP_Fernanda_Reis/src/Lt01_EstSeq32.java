/*
 *************************
Lote 01 - Exercício 32 - Receba um número inteiro. Calcule e mostre o seu 
fatorial.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq32 {
    public static void main (String args[]) {
        
        String armazem = "";
        
        int numero, aux = 0, temp;
        
        numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Vamos calcular o fatorial de um número inteiro. \nDigite um número inteiro qualquer: "));
        temp = numero;
        
        do {
            /*
            exemplo: 5
            aux = aux + (5 * (5 - 1);
                aux == 20;
            
            */
            aux += numero * (numero - 1);
            armazem += " x " + (numero - 1);
            numero += -1;
            /*
            para exibir "numero x (numero - 1) x (numero - 2) etc" 
            */
                       
        }
        while (numero > 1);
        
        JOptionPane.showMessageDialog(null, "O fatorial de " + temp + " (" +temp + "!) é: \n" +temp +armazem + " = " +aux );
        
        
        
        
        
    }
}