/*
 *************************
Lote 01 - Exercício 42
Calcule e mostre a série 1 + 2/3 + 3/5 + ... + 50/99
Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

import java.text.DecimalFormat;

public class Lt01_EstSeq42 {
    
    private static DecimalFormat casas0 = new DecimalFormat("");
    
    public static void main(String args[]){
        
        String resultado = "Calcule e mostre a série 1 + 2/3 + 3/5 + ... + 50/99\n\n";
        
        double dividendo = 1, divisor = 1, total = 0;
        
        while(dividendo <= 50 && divisor <= 99){
            
            if(divisor == 99){
                
                resultado += casas0.format(dividendo) + "/" + casas0.format(divisor) + " = ";
                
            }else{
                
                resultado += casas0.format(dividendo) + "/" + casas0.format(divisor) + " + ";
                
            }
            
            if(dividendo % 9 == 0){
                
                resultado += "\n";
                
            }
            
            total = total + (dividendo / divisor);
            
            dividendo++;
            
            divisor = divisor + 2;
            
        }
        
        resultado += total;
        
        JOptionPane.showMessageDialog(null, resultado);
        
    }
    
}
