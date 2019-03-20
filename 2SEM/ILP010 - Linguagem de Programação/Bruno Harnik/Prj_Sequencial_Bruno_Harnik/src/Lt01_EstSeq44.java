/*
 *************************
Lote 01 - Exercício 44
Receba o número da base e do expoente.
Calcule e mostre o valor da potência.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */
import javax.swing.JOptionPane;

import java.text.DecimalFormat;

public class Lt01_EstSeq44 {
    
    private static DecimalFormat casas4 = new DecimalFormat(".####");
    
    public static void main(String args[]){
        
        String resultado = "";
        
        int expoente;
        
        double valor, pot;
        
        valor = Double.parseDouble(JOptionPane.showInputDialog("Cálculo de potência simples.\n\nDigite um valor real: "));
        
        expoente = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor da potência (inteiro positivo): "));
        
        while(expoente < 0){
            
             expoente = Integer.parseInt(JOptionPane.showInputDialog("O valor da potência deve ser maior ou igual a 0.\nDigite o valor da potência (inteiro positivo): "));
            
        }
        
        if(expoente == 0){
            
            resultado += "Qualquer número elevado a 0 é 1.";
            
        }else if(expoente == 1){
            
            pot = valor;
            
            resultado += "Qualquer número elevado a 1 é ele mesmo.\n\n" + valor + " elevado a " + expoente + " tem potência " + pot;
            
        }else{
            
            resultado += valor + " elevado a " + expoente + " tem potência ";
            
            pot = valor;
            
            for(int i = 2; i <= expoente; i++){
            
                pot = pot * valor;
            
            }
            
            resultado += casas4.format(pot);
            
        }
        
        JOptionPane.showMessageDialog(null, resultado);
        
    }
    
}
