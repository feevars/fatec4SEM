/*
 *************************
 ******MODULARIZAÇÃO******
Lote 01 - Exercício 20
Receba 3 coeficientes A, B, e C de uma equação do 2º grau da fórmula AX²+BX+C=0.
Verifique e mostre a existência de raízes reais e se caso exista, calcule e mostre.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_ModSeq20 {
    
    public static void main (String args[]){
        
        double A, B, C, X1, X2;
        
        A = Double.parseDouble(JOptionPane.showInputDialog("Equação de segundo grau: AX²+BX+C=0\n\n Digite o valor de A:"));
        
        B = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de B: "));
        
        C = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de C:"));

        if(Delta(A,B,C) < 0){
            
            JOptionPane.showMessageDialog(null,"AX²+BX+C=0\n\nA = " + A + "   B =" + B + "   C =" + C + "   Delta = " + Delta(A,B,C) +"\n\nNão há raiz possível para os valores declarados.");
            
        }else if(X1(A,B,C) == X2(A,B,C)){
            
            JOptionPane.showMessageDialog(null,"AX²+BX+C=0\n\nA = " + A + "   B =" + B + "   C =" + C + "   Delta = " + Delta(A,B,C) +"\n\nHá apenas uma raiz real: " + X1(A,B,C));
            
        }else if(Delta(A,B,C) >= 0 && X1(A,B,C) != X2(A,B,C))
            
            JOptionPane.showMessageDialog(null,"AX²+BX+C=0\n\nA = " + A + "   B =" + B + "   C =" + C + "   Delta = " + Delta(A,B,C) + "\n\n1ª raiz: " + X1(A,B,C) + "\n2ª raiz: " + X2(A,B,C));
        
    }
    
    public static double Delta(double a, double b, double c){
        
        double d = (b * b) - (4 * a * c);
        
        return d;
        
    }
    
    public static double X1(double a, double b, double delta){
        
        double x1 = (- b + Math.sqrt(delta)) / (2 * a);
        
        return x1;
        
    }
    
    public static double X2(double a, double b, double delta){
        
        double x2 = (- b - Math.sqrt(delta)) / (2 * a);
        
        return x2;
        
    }
}
