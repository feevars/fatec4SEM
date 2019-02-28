/*
 *************************
Lote 01 - Exercício 43
Calcule e mostre quantos anos serão necessários para que Ana seja maior que Maria,
sabendo que Ana tem 1,10 m e cresce 3 cm ao ano e Maria tem 1,5 m e cresce 2 cm ao ano.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

import java.text.DecimalFormat;

public class Lt01_EstSeq43 {
    
    private static DecimalFormat casas2 = new DecimalFormat(".##");
    
    public static void main(String args[]){
        
        String resultado =  "Calcule e mostre quantos anos serão necessários para que Ana seja maior que Maria,\n" +
                            "sabendo que Ana tem 1,10m e cresce 3cm ao ano e Maria tem 1,5m e cresce 2cm ao ano.\n\n";
        
        double Ana = 1.10, Maria = 1.50;
        
        int ano = 0;
        
        while(Ana < Maria){
            
            ano++;
            
            Ana = Ana + 0.03;
            
            Maria = Maria + 0.02;
            
            if(ano == 1){
                
               resultado += "Após " + ano + " ano Ana medirá " + casas2.format(Ana) + "m e Maria " + casas2.format(Maria) + "m. ";
                
            }else{
                
                resultado += "Após " + ano + " anos Ana medirá " + casas2.format(Ana) + "m e Maria " + casas2.format(Maria) + "m. ";

            }
            if(ano % 2 == 0){
                
                resultado += "\n";
                
            }
            
        }
        
        resultado += "\nAna será mais alta que Maria após " + ano + " anos, o que é humanamente impossível...";
        
        JOptionPane.showMessageDialog(null, resultado);
        
    }
    
}
