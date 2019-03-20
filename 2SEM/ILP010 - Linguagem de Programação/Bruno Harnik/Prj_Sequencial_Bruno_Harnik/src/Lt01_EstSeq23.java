/*
 *************************
Lote 01 - Exercício 23
Receba 3 valores obrigatoriamente em ordem crescente e um 4º valor não necessariamente em ordem.
Mostre os 4 números em ordem crescente.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq23 {
    
    public static void main(String args[]){
   
        double v1, v2, v3, v4;
    
        v1 = Double.parseDouble(JOptionPane.showInputDialog("Insira o primeiro valor: "));
        
        v2 = Double.parseDouble(JOptionPane.showInputDialog("Insira um valor maior que " + v1 + ":"));
        
        if(v2 < v1){
            
            JOptionPane.showMessageDialog(null, "O valor inserido não é maior que " + v1 + ".\nFim.");
                        
        }else{
            
            v3 = Double.parseDouble(JOptionPane.showInputDialog("Insira um valor maior que " + v2 + ":"));
            
            if(v3 < v2){
            
                JOptionPane.showMessageDialog(null, "O valor inserido não é maior que " + v2 + ".\nFim.");
                        
            }else{
                
                v4 = Double.parseDouble(JOptionPane.showInputDialog("Insira um quarto valor (não precisa seguir a ordem): "));
                
                if(v4 > v3){
                    
                    JOptionPane.showMessageDialog(null, "Valores inseridos em ordem crescente:\n" + v1 + " ; " + v2 + " ; " + v3 + " ; " + v4);
                    
                }else if(v4 > v2){
                    
                    JOptionPane.showMessageDialog(null, "Valores inseridos em ordem crescente:\n" + v1 + " ; " + v2 + " ; " + v4 + " ; " + v3);
                    
                }else if(v4 > v1){
                    
                    JOptionPane.showMessageDialog(null, "Valores inseridos em ordem crescente:\n" + v1 + " ; " + v4 + " ; " + v2 + " ; " + v3);
                    
                }else{
                    
                    JOptionPane.showMessageDialog(null, "Valores inseridos em ordem crescente:\n" + v4 + " ; " + v1 + " ; " + v2 + " ; " + v3);
                    
                }
                
            }
            
        }
        
     }
    
}
