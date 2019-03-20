/*
 *************************
Lote 01 - Exercício 03
Receba a base e a altura de um triângulo. Calcule e mostre a sua área.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq03 {
    
    public static void main (String args[]){
        
        double base, altura, area;
        
        base = Double.parseDouble(JOptionPane.showInputDialog("Digite o tamanho da base do triângulo em metros: "));
        
        altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura do triângulo em metros: "));
        
        area = base * altura / 2;
        
        JOptionPane.showMessageDialog(null,"A área do triângulo é de " +area +"m².");
        
    }
}
