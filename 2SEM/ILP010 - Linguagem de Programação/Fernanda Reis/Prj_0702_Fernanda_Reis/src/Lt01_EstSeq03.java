/*
 *************************
Lote 01 - Exercício 03 - Receba a base e a altura de um triângulo. Calcule e 
mostre a sua área.
Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */ 
import javax.swing.JOptionPane;

public class Lt01_EstSeq03 {
    public static void main (String args[]) {
        double base, altura, area;
    
        base = Double.parseDouble(JOptionPane.showInputDialog("Digite a base do triângulo:"));
        altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura do triângulo:"));
        area = base * altura;
    
        JOptionPane.showMessageDialog(null,"A área do triângulo é de:" +area);
    }
}