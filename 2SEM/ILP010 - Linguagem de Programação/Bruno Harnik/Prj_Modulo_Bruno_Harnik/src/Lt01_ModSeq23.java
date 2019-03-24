/*
 *************************
 ******MODULARIZAÇÃO******
Lote 01 - Exercício 23
Receba 3 valores obrigatoriamente em ordem crescente e um 4º valor não necessariamente em ordem.
Mostre os 4 números em ordem crescente.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_ModSeq23 {
    
    public static void main(String args[]){
   
        double v1, v2, v3, v4;
    
        v1 = Double.parseDouble(JOptionPane.showInputDialog("Insira o primeiro valor: "));
        
        v2 = Double.parseDouble(JOptionPane.showInputDialog("Insira um valor maior que " + v1 + ":"));
        
        
        while(Maior(v1,v2) == false){
            
            v2 = Double.parseDouble(JOptionPane.showInputDialog(v2 + " não é maior que " + v1 + ".\n" + "Insira um valor maior que " + v1 + ":"));
                        
        }
        
        v3 = Double.parseDouble(JOptionPane.showInputDialog("Insira um valor maior que " + v2 + ":"));
        
        while(Maior(v2,v3) == false){
            
            v3 = Double.parseDouble(JOptionPane.showInputDialog(v3 + " não é maior que " + v2 + ".\n" + "Insira um valor maior que " + v1 + ":"));
                        
        }
        
        v4 = Double.parseDouble(JOptionPane.showInputDialog("Insira um quarto valor (não precisa seguir a ordem): "));
                
        Resultado(v1,v2,v3,v4);
        
        }
    
    public static boolean Maior(double a, double b){
        
        return b > a;
        
    }
    
    public static void Resultado(double v1, double v2, double v3, double v4){
        
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
