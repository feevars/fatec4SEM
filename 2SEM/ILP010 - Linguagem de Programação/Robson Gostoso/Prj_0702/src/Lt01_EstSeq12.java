/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 12
Receba o ano de nascimento e o ano atual. Calcule e mostre a sua idade e
quantos anos terá daqui a 17 anos.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_EstSeq12 
{
    public static void main (String Args[])
    { 
        double nas, atual, depois;
               
        nas = Double.parseDouble (JOptionPane.showInputDialog("Digite o ano de nascimento"));
        atual = Double.parseDouble (JOptionPane.showInputDialog("Digite o ano atual"));
                
        nas = atual - nas;
        depois = nas + 17;
               
        JOptionPane.showMessageDialog(null, "A idade é "+nas+" anos"+" e daqui 17 anos você terá "+depois+" anos.");
    }
    
}
