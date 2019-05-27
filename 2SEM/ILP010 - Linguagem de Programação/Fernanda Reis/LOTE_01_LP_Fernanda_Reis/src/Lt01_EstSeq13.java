/*
 *************************
Lote 01 - Exercício 13 - Receba a quantidade de alimento em quilos. 
Calcule e mostre quantos dias durará esse alimento sabendo que a pessoa 
consome 50g ao dia.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/
 
import javax.swing.JOptionPane;
public class Lt01_EstSeq13 {
public static void main (String args[]) 
    {
    double quilos, dias;
    
    quilos = Double.parseDouble(JOptionPane.showInputDialog("Quantidade de alimento em quilos: "));
    dias = quilos / 0.05;
    
    
    JOptionPane.showMessageDialog(null,"Os alimentos durarão " +dias +" dias.");
    
    }
}