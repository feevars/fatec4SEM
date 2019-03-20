/*
 *************************
Lote 01 - Exercício 06
Receba os valores em x e y. Efetua a troca de seus valores e mostre seus conteúdos.
Calcule e mostre as raízes reais (considerar que a equação possue2 raízes).

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq06 {
    
    public static void main (String args[]){
        
        double X, Y, aux;
        
        X = Double.parseDouble(JOptionPane.showInputDialog("Troca de valores.\n\nDigite o valor de X: "));
        
        Y = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de Y: "));
        
        aux = X;
        X = Y;
        Y = aux;
        
        JOptionPane.showMessageDialog(null, "Valores trocados: \n\nX = " + X + " e Y = " + Y);
    }
}
