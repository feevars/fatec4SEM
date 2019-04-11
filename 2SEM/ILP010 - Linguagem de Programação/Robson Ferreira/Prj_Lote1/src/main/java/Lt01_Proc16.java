/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 16
Receba a quantidade de horas trabalhadas, o valor por hora, o percentual
de desconto e o número de descendentes. Calcule o salário que serão as
horas trabalhadas x o valor por hora. Calcule o salário líquido (= Salário
Bruto – desconto). A cada dependente será acrescido R$ 100 no Salário
Líquido. Exiba o salário a receber.


Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
 
import javax.swing.JOptionPane;

public class Lt01_Proc16 
{
    public static void main (String Args[])
    { 
        
        procedure();
    }
     static void procedure (){           
                
        double ht, vh, pd, nd, sl;
               
        ht = Double.parseDouble (JOptionPane.showInputDialog("Digite a quantidade de horas trabalhadas"));
        vh = Double.parseDouble (JOptionPane.showInputDialog("Digite o valor da hora trabalhada"));
        pd = Double.parseDouble (JOptionPane.showInputDialog("Digite o percentual de desconto"));
        nd = Double.parseDouble (JOptionPane.showInputDialog("Digite o número de dependentes"));
        
        sl = ht * vh * (1-(pd/100));
        sl = sl + 100 * nd;
            
        JOptionPane.showMessageDialog(null, "O salário a receber é R$"+sl+".");
    }
    
}
