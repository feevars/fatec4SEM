/*
 *************************
Lote 01 - Exercício 38
Receba 100 números inteiros reais.
Verifique e mostre o maior e o menos valor.
Obs.: somente valores positivos.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq38 {
    
    public static void main(String args[]){
        
        String resultado = "Valores digitados...\n";
        
        int i, n, maior = 0, menor = 0;
        
        for(i = 1; i <= 10; i++){
            
            n = Integer.parseInt(JOptionPane.showInputDialog(i + "º número inteiro positivo:"));
            
            while(n < 0){
                
                n = Integer.parseInt(JOptionPane.showInputDialog("Número inválido, digite novamente.\n" + i + "º número inteiro positivo:"));
                
            }
            
            resultado += i + "º valor: " + n + "\n";
            
            if(i == 1){
                
                maior = n;
                menor = n;
                
            }else{
                if(n > maior){
                    
                    maior = n;
                    
                }
                if(n < menor){
                    
                    menor = n;
                    
                }
                
                
            }
            
        }
        
        resultado += "\nO maior número é " + maior + ".\nO menor número é " + menor + ".";
        
        JOptionPane.showMessageDialog(null, resultado);
    }
    
}
