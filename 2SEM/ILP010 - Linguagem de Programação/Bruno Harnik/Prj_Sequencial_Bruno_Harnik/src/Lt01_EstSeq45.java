/*
 *************************
Lote 01 - Exercício 45
Calcule e mostre a série 1 - 2/4 + 3/9 - 4/16 + 5/25 - ... + 15/225

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

import java.text.DecimalFormat;

public class Lt01_EstSeq45 {
    
    private static DecimalFormat casas0 = new DecimalFormat("");
    
    private static DecimalFormat casas2 = new DecimalFormat("#.##");
    
    public static void main (String args[]){
        
        double dividendo = 1, divisor = 1, total = 1;
        
        String resultado = "Calcule e mostre a série 1 - 2/4 + 3/9 - 4/16 + 5/25 - ... + 15/225\n\n1 - ";

        while(dividendo < 15 && divisor < 225){
             
            dividendo++;
            
            divisor = dividendo * dividendo;
            
            if (dividendo % 2 != 0 && dividendo != 15){
                
                total = total + dividendo / divisor;
                resultado += casas0.format(dividendo) + "/" + casas0.format(divisor) + " - ";
                
            }else if(dividendo == 15){
                
                total = total + dividendo / divisor;
                resultado += casas0.format(dividendo) + "/" + casas0.format(divisor) + " = ";
                
            }else{
                
                total = total - dividendo / divisor;
                resultado += casas0.format(dividendo) + "/" + casas0.format(divisor) + " + ";
                
            }
            
            //Quebra de linha apenas...
            if(dividendo == 9){
                
                resultado += "\n";
                
            }
            
        }
        
        resultado += casas2.format(total);

        JOptionPane.showMessageDialog(null, resultado);
        
    }
    
}
