/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 06
Receba os valores em x e y. Efetua a troca de seus valores e mostre seus
conteúdos.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
import javax.swing.JOptionPane;

public class Lt01_EstSeq06 
{
    public static void main (String args[])
    {   
        int x, y, z;
        x = Integer.parseInt(JOptionPane.showInputDialog("Inversão de valores.\nDigite um valor para X"));
        y = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para y"));
        
        z = x;
        x = y;
        y = z;
        
        JOptionPane.showMessageDialog(null, "Após a inversão, x é "+x+" e y é "+y);
                    
    }
    
}
