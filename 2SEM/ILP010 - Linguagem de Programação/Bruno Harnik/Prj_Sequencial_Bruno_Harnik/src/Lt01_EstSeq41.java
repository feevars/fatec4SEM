/*
 *************************
Lote 01 - Exercício 41
Mostre todas as possibilidades de 2 dados de forma que a soma tenha como resultado 7.
Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq41 {
    
    public static void main(String args[]){
        
       String resultado = "As possibilidades para que 2 dados somem 7 são:\n";
       
       int d1, d2;
       
       for(d1 = 1; d1 <= 6; d1++){
           
           for(d2 = 1; d2 <= 6; d2++){
               
               if(d1 + d2 == 7){
                   
                   resultado += d1 + " e " + d2 + "\n";
                   
               }
               
               
           }
           
       }
       
       JOptionPane.showMessageDialog(null, resultado);
        
    }
    
}
