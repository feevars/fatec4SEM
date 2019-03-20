/*
 *************************
Lote 01 - Exercício 36
Receba um número N. Calcule e mostre a série 1 + 1/1! + 1/2! + ... + 1/N!

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

import java.text.DecimalFormat;

public class Lt01_EstSeq36 {
    
    private static DecimalFormat casas3 = new DecimalFormat(".###");
    
    public static void main(String args[]){
        
        String resultado = "1 + ";
        
        double serie = 1, n, fatorial;
        
        n = Double.parseDouble(JOptionPane.showInputDialog("1 + 1/1! + 1/2! + ... + 1/N!\n\nDigite um número inteiro para fazer a conta acima: "));
        
        while (n < 1){
            
            n = Double.parseDouble(JOptionPane.showInputDialog("Você precisa digitar um número inteiro positivo para dar certo. Vamos lá...\n1 + 1/1! + 1/2! + ... + 1/N!\n\nDigite um número inteiro N para fazer a conta acima: "));
            
        }
        
        for(int i = 1; i <= n; i++){
            
            fatorial = 1;
                    
            for(int j = i; j >= 1; j--){
                
                fatorial = fatorial * j;
            }
            
            resultado += "1/" + i + "!";
                        
            if(i != n){
                
                resultado += " + ";
                
            }else{
                
                resultado += " = ";
                
            }
            
            if(i % 5 == 0 && i != n){
                
                resultado += "\n";
                
            }
            
            serie = serie + (1 / fatorial);
            
        }
        
        resultado += casas3.format(serie);
        
        JOptionPane.showMessageDialog(null, resultado);
        
    }
    
}
