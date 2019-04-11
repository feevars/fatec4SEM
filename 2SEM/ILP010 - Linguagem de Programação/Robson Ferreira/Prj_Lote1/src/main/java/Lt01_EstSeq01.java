/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 01
Coletar o valor do lado de um quadrado, calcular sua área e apresentar o resultado.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
import javax.swing.JOptionPane;

public class Lt01_EstSeq01
{
    public static void main (String Args[]) 
    {
        int lado, area;
        lado = Integer.parseInt(JOptionPane.showInputDialog("Digite o Valor do lado: "));
        area = lado * lado;
        JOptionPane.showMessageDialog(null, "O valor da área é "+area);
    }
    
}
