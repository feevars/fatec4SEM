/*
 *************************
Lote 01 - Exercício 37
Receba um número inteiro. Calcule e mostre a série de Fibonacci até o seu N'nésimo termo.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq37 {
            
    public static void main(String args[]){
        
        String resultado = "";
        
        int n, i, x = 0, y = 1, fiba, fiba_total = 0;
        
        n = Integer.parseInt(JOptionPane.showInputDialog("Digte a quantidade de posições na sequência de Fibonacci"));
        
        for(i = 0; i <= n; i++){
            
            if(i == 0){
                
                resultado += x;
                
            }else if(i == 1){

                resultado += " + " + y;
                
                fiba_total = 1;
                
            }else if(i > 1){
                
                fiba = y + x;
                
                fiba_total = fiba_total + fiba;
                
                x = y;
                y = fiba;
                
                resultado += " + " + fiba;
                
            }

        }
        
        resultado += " = " + fiba_total;
        
        JOptionPane.showMessageDialog(null, resultado);
    }
    
}
