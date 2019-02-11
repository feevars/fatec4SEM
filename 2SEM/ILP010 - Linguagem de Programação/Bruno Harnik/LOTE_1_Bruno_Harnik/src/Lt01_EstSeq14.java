/*
 *************************
Lote 01 - Exercício 14
Receba 2 ângulos de um triângulo. Calcule e mostre o valor do 3º ângulo.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq14 {
    
    public static void main (String args[]){
        
        double a1, a2, a3;
        
        a1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do primeiro ângulo do triângulo: "));
        
        a2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do segundo ângulo do triângulo: "));
        
        a3 = 180 - a1 - a2;
        
        if(a1 + a2 >= 180 || a1 <= 0 || a2 <= 0 ){
            
            JOptionPane.showMessageDialog(null, "Não é possível formar um triângulo com os valores inseridos.");
        
        }else{
            JOptionPane.showMessageDialog(null, "O terceiro ângulo terá: " + a3 + "°.");
        }   
    }
}
