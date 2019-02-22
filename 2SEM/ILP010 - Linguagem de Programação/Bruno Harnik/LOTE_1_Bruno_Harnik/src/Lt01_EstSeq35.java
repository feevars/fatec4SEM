/*
 *************************
Lote 01 - Exercício 35
Receba 2 números inteiros, verifique qual o maior entre eles. Calcule e mostre 
o resultado da somatória dos números ímpares entre esses valores.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq35 {
    
    public static void main(String args[]){
        
        String resultado = "";
        
        int v1, v2, aux, soma_impar = 0;
        
        
        
        v1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um valor inteiro: "));
        v2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite outro valor inteiro: "));
        
        if(v1 == v2){
            
            resultado += "Os valores inseridos são iguais... \n\n";
            
        }else if(v2 > v1){
            
            resultado += "O maior valor inserido foi " + v2 + ".\n\n";
            
        }else{
            
            resultado += "O maior valor inserido foi " + v1 + ".\n\n";
            
            aux = v1;
            v1 = v2;
            v2 = aux;
            
        }
        
        for(aux = v1 + 1; aux < v2; aux++){
            
            if(aux % 2 != 0){
                
                soma_impar = soma_impar + aux;
                
            }
            
        }
        
        resultado += "A soma dos números ímpares entre " + v1 + " e " + v2 + " é " + soma_impar + ".";
        
        JOptionPane.showMessageDialog(null, resultado);
        
    }
}
