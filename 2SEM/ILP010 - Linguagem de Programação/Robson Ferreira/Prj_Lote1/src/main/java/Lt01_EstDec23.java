/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 23
Receba 3 valores obrigatoriamente em ordem crescente e um 4º valor não
necessariamente em ordem. Mostre os 4 números em ordem crescente.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_EstDec23 
{
    public static void main (String Args[])
    { 
        double v1, v2, v3, v4;
               
        v1 = Double.parseDouble (JOptionPane.showInputDialog("Digite os valores em ordem CRESCENTE.\nDigite o valor 1"));
        v2 = Double.parseDouble (JOptionPane.showInputDialog("Digite o valor 2"));
        if (v2 < v1)
        {
            v2 = Double.parseDouble (JOptionPane.showInputDialog("Digite um valor MAIOR que o valor 1!"));
        }
        v3 = Double.parseDouble (JOptionPane.showInputDialog("Digite o valor 3"));
        if (v3 < v2)
        {
            v2 = Double.parseDouble (JOptionPane.showInputDialog("Digite um valor MAIOR que o valor 2!"));
        }
        v4 = Double.parseDouble (JOptionPane.showInputDialog("Digite o valor 4"));
           
        if (v4 < v1)
        {
            JOptionPane.showMessageDialog(null, "A ordem crescente dos valores é: "+v4+" , "+v1+" , "+v2+" , "+v3);
        }
        else
        {
            if (v4<v2)
            {
                 JOptionPane.showMessageDialog(null, "A ordem crescente dos valores é: "+v1+" , "+v4+" , "+v2+" , "+v3);
            }
            else
            {
                if (v4<v3)
                {
                     JOptionPane.showMessageDialog(null, "A ordem crescente dos valores é: "+v1+" , "+v2+" , "+v4+" , "+v3);
                }
                else
                {
                     JOptionPane.showMessageDialog(null, "A ordem crescente dos valores é: "+v1+" , "+v2+" , "+v3+" , "+v4);
                }
            }
        }
                   
        
    }
    
}
