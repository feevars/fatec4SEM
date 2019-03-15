/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 13
Receba a quantidade de alimento em quilos. Calcule e mostre quantos dias
durará esse alimento sabendo que a pessoa consome 50g ao dia.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_EstSeq13 
{
    public static void main (String Args[])
    { 
        double alimento;
               
        alimento = Double.parseDouble (JOptionPane.showInputDialog("Digite a quantidade de alimento em quilos"));
                       
        alimento = alimento/0.05;
                      
        JOptionPane.showMessageDialog(null, "Seu alimento durará "+alimento+" dia(s) se você consumir 50g por dia.");
    }
    
}
