/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 21
Receba 4 notas bimestrais de um aluno. Calcule e mostre a média aritmética.
Mostre a mensagem de acordo com a média:
a. Se a média for >= 6,0 exibir “APROVADO”;
b. Se a média for >= 3,0 ou < 6,0 exibir “EXAME”;
c. Se a média for < 3,0 exibir “RETIDO”.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_EstDec21 
{
    public static void main (String Args[])
    { 
        double n1, n2, n3, n4, m;
               
        n1 = Double.parseDouble (JOptionPane.showInputDialog("Digite a nota 1"));
        n2 = Double.parseDouble (JOptionPane.showInputDialog("Digite a nota 2"));
        n3 = Double.parseDouble (JOptionPane.showInputDialog("Digite a nota 3"));
        n4 = Double.parseDouble (JOptionPane.showInputDialog("Digite a nota 4"));
        
        m = (n1 + n2 + n3 + n4) / 4;
          
        if (m >= 6)
        {
            JOptionPane.showMessageDialog(null, "APROVADO!");
        }
        if (m >=3 & m<6) 
            {
                JOptionPane.showMessageDialog(null, "EXAME!");
            }
        if (m < 3) 
                {
                    JOptionPane.showMessageDialog(null, "RETIDO!");
                }
                   
        
    }
    
}
