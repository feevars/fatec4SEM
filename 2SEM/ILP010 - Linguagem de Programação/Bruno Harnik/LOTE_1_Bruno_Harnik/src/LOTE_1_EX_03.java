
import javax.swing.JOptionPane;

/*
 *************************
Lote 01 - Exercício 03
Receba a base e a altura de um triângulo. Calcule e mostre a sua área.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 


public class LOTE_1_EX_03 {
    
    public static void main (String args[]){
        
        double base, altura, area;
        
        base = Double.parseDouble(JOptionPane.showInputDialog("Digite o tamanho da base do triângulo: "));
        
        altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura do triângulo: "));
        
        area = base * altura / 2;
        
        JOptionPane.showMessageDialog(null,"A área do triângulo é de" +area +"m²");
        
    }
}
