/*
 *************************
Lote 01 - Exercício 33
Receba um número. Calcule e mostre a série 1 + 1/2 + 1/3 + ... + 1/N.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

import java.text.DecimalFormat;

public class Lt01_EstSeq33 {
    
    private static DecimalFormat casas4 = new DecimalFormat(".####");
    
    private static DecimalFormat casas0 = new DecimalFormat("");
    
    public static void main(String args[]){
        
        String resultado = "Resultado: \n";
   
        double numero, i, dividido, total = 0;
        
        numero = Double.parseDouble(JOptionPane.showInputDialog("Dividindo até o divisor.\nInsira um número: "));
        
        while(numero < 1){
            
            numero = Double.parseDouble(JOptionPane.showInputDialog("Por favor, insira um número maior que 1.\n\nDividindo até o divisor.\nInsira um número: "));
            
        }
        
        for(i = 1; i <= numero; i++){
            
            dividido = 1 / i;
            
            if(i != numero){
                
                resultado += "1/" + casas0.format(i) + " + ";
                
            }else{
                
                resultado += "1/" + casas0.format(i) + " = ";
                
            }
            
            total = total + dividido;
            
        }
        
        resultado += casas4.format(total);
        
        JOptionPane.showMessageDialog(null, resultado);
        
    }
    
}
