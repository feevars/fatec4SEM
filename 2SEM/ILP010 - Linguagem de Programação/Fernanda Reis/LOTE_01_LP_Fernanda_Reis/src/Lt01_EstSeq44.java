/*
 *************************
Lote 01 - Exercício 44 - Receba o número da base e do expoente. Calcule e mostre
o valor da potência.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************


 */
import javax.swing.JOptionPane;

public class Lt01_EstSeq44 {
    public static void main (String args[]) {
        
        String teste = "";
        int base, expoente, potencia, i;
        
        base = Integer.parseInt(JOptionPane.showInputDialog(null, "Calcularemos an = a . a . a . a \nDigite a base (a): "));
        expoente = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira um valor para n (expoente): "));
        
        teste += base + "^" +expoente +" = " +base;
        potencia = base;
        
        if (expoente == 0) {
            JOptionPane.showMessageDialog(null, base +"^" +expoente +" = " +" 1. (Todo número elevado a zero é um.)");
        } else if (expoente == 1) {
            JOptionPane.showMessageDialog(null, teste);
          } else if (base == 0) {
            JOptionPane.showMessageDialog(null, base +"^" +expoente +" = " +" 0. (Zero elevado a qualquer número continua sendo zero.)");  
            } else {
                for (i = 1; i<expoente; i++) {
            
                    potencia *= base;
                    teste += " x " +base;
                }
                teste += " = " +potencia;
                JOptionPane.showMessageDialog(null, teste);
              }
    }
}
