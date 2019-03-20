/*
 *************************
Lote 01 - Exercício 07
Receba os valores do comprimento, largura e altura de um paralelepípedo.
Calcule e mostre seu volume.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq07 {
    
    public static void main (String args[]){
        
        double comprimento, largura, altura, volume;
        
        comprimento = Double.parseDouble(JOptionPane.showInputDialog("Volume do paralelepípedo.\n\nDigite o comprimento em cm: "));
        
        largura = Double.parseDouble(JOptionPane.showInputDialog("Digite a largura em cm: "));
        
        altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura em cm: "));
        
        volume = comprimento * largura * altura;
        
        JOptionPane.showMessageDialog(null, "O volume do paralelepípedo é: " + volume + "cm³, ou " + volume / 100 + "m³.");
    }
}
