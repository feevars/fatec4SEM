/*
 *************************
Lote 01 - Exercício 40
Receba 2 números inteiros.
Verifique e mostre todos os números primos existentes entre eles.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq40 {
    
    public static void main(String args[]){
        
        String resultado = "Os números primos entre ";
        
        int a, b, i, j, aux, total = 0;
        
        a = Integer.parseInt(JOptionPane.showInputDialog("Verificação de números primos de um determinado intervalo.\n\nDigite o primeiro número:"));
        
        while(a < 1){
            
            a = Integer.parseInt(JOptionPane.showInputDialog("Você precisa digitar um número maior que zero.\n\nDigite o primeiro número:"));
            
        }
        
        b = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número:"));
        
        while(b < 1){
            
            b = Integer.parseInt(JOptionPane.showInputDialog("Você precisa digitar um número maior que zero.\n\nDigite o segundo número:"));
            
        }
        
        if(b < a){
            
            aux = b;
            b = a;
            a = aux;
            
        }
        
        resultado += a + " e " + b + " são:\n\n";
        
        for(i = a; i <= b; i++){
            
            if(i == 2){
                
               resultado += i + ", "; 
                
            }
            
            for(j = 2; j < i; j++){
                
                if(i % j == 0){
                    
                    j = i;
                    
                }else if(j == i - 1){
                    
                    resultado += i + ", ";
                    
                    total++;
                    
                    if(total % 10 == 0){
                        
                        resultado += "\n";
                        
                    }
                    
                    
                }
                
            }

        }
        
        JOptionPane.showMessageDialog(null, resultado);
        
    }
    
}
