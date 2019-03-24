/*
 *************************
Lote 01 - Exercício 32
Receba um número inteiro. Calcule e mostre o seu fatorial.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */
import javax.swing.JOptionPane;

public class Lt01_EstSeq32 {
    
    public static void main(String args[]){
        
        int x, i;
        
        x = Integer.parseInt(JOptionPane.showInputDialog("Cálculo de fatorial.\nInsira um valor inteiro:"));
        
        for(i = x - 1; i > 0; i--){
            
            x = x * i;
            
        }
        
        JOptionPane.showMessageDialog(null, x);
        
    }
    
}
