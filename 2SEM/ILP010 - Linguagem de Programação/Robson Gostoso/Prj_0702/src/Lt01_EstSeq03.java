/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 03
Receba a base e a altura de um triângulo. Calcule e mostre a sua área.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
import javax.swing.JOptionPane;

public class Lt01_EstSeq03 
{
    public static void main (String args [])
        {
        double base, altura, area;
        String unidade;
        
        unidade = JOptionPane.showInputDialog("Digite a unidade de medida utilizada: ");
        base = Double.parseDouble (JOptionPane.showInputDialog("Digite o tamanho da base do triângulo: "));
        altura = Double.parseDouble(JOptionPane.showInputDialog("Digite o tamanho da altura do triângulo: "));
        area = base * altura / 2;
        JOptionPane.showMessageDialog(null,"A área do seu triângulo é "+area+" "+unidade+" quadradas");
               
                
                }
            
            }
