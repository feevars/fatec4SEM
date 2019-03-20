/*
 *************************
Lote 01 - Exercício 26
Receba 2 números inteiros. Verifique e mostre se o maior número é múltiplo do menor.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq26 {
    
    public static void main (String args[]){
        
        int x, y, maior, menor;
        
        x = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro valor inteiro: "));
        y = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo valor inteiro: "));
        
        if(x >= y){
            
            maior = x;
            menor = y;
            
        }else{
            
            maior = y;
            menor = x;
        }
        
        if(maior % menor == 0){
            
            JOptionPane.showMessageDialog(null, maior + " é múltiplo de " + menor + ".");
            
        }else{
            
            JOptionPane.showMessageDialog(null, maior + " não é múltiplo de " + menor + ".");
            
        }
        
    }
}
