/*
 *************************
Lote 01 - Exercício 13
Receba a quantidade de alimento em quilos.
Calcule e mostre quantos dias durará esse alimento sabendo que a pessoa consome 50g ao dia.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq13 {
    
    public static void main (String args[]){
        
        double alimento, dias;
        
        alimento = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de alimento em kg: "));
        
        dias = alimento * 1000 / 50;
        
        JOptionPane.showMessageDialog(null, "O alimento durará por " + dias + " dias.");
    }
}
