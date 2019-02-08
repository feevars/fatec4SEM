/*
 *************************
Lote 01 - Exercício 01
Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 
import javax.swing.JOptionPane;

public class LOTE_1_EX_01 {
    public static void main (String args[]) 
    {
    int lado, area;
    
    lado = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de lado do quadrado:"));
    area = lado * lado;
    
    JOptionPane.showMessageDialog(null,"O valor da área é:" +area);
    
    }
}
