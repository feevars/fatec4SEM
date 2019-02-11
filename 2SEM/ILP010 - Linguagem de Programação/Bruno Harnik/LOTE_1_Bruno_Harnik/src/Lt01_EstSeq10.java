/*
 *************************
Lote 01 - Exercício 10
Receba 2 números reais. Calcule e mostre a diferença desses valores.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq10 {
    
    public static void main (String args[]){
        
        double minuendo, subtraendo, diferenca;
        
        minuendo = Double.parseDouble(JOptionPane.showInputDialog("Diferença entre valores.\n\nDigite o minuendo: "));
        
        subtraendo = Double.parseDouble(JOptionPane.showInputDialog("Digite o subtraendo: "));
        
        diferenca = minuendo - subtraendo;
        
        JOptionPane.showMessageDialog(null, minuendo + " - " + subtraendo + " = " + diferenca);
    }
}
