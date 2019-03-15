/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 07
Receba os valores do comprimento, largura e altura de um paralelepípedo.
Calcule e mostre seu volume.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq07 
{
    public static void main (String Args[])
    { 
        double comprimento, largura, altura, volume;
        String unidade;
        
        unidade = JOptionPane.showInputDialog("Digite o tipo de unidade de medida que deseja utilizar (cm, m, mm, etc)");
        comprimento = Double.parseDouble (JOptionPane.showInputDialog("Volume de Paralelepípedo. \nDigite o comprimento"));
        largura = Double.parseDouble(JOptionPane.showInputDialog("Digite o largura"));
        altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura"));
        
        volume = comprimento * largura * altura;
        
        JOptionPane.showMessageDialog(null, "O volume do paralelepípedo é "+volume+" "+unidade+".");
    }
    
}
