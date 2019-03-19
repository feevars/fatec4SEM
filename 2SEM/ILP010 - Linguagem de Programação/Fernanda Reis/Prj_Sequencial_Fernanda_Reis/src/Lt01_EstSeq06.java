/*
 *************************
Lote 01 - Exercício 06 - Receba os valores em x e y. 
Efetua a troca de seus valores e mostre seus conteúdos.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */ 
import javax.swing.JOptionPane;
public class Lt01_EstSeq06 {
    public static void main (String args[]) {
        int x, y, a;
    
        x = Integer.parseInt(JOptionPane.showInputDialog("Digite X: "));
        y = Integer.parseInt(JOptionPane.showInputDialog("Digite Y: "));
        a = x;
        x = y;
        y = a;
       
        JOptionPane.showMessageDialog(null,"X: " +x +"\nY: " +y);
    }   
}


