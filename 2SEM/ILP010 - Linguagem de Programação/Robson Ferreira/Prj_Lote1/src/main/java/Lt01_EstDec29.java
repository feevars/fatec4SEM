/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 29
Receba o tipo de investimento (1 = poupança e 2 = renda fixa) e o valor do
investimento. Calcule e mostre o valor corrigido em 30 dias sabendo que a
poupança = 3% e a renda fixa = 5%. Demais tipos não serão considerados.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
import javax.swing.JOptionPane;

public class Lt01_EstDec29 {
    public static void main (String Args[]){
        int tipoInvestimento;
        double valorInvestimento;
        tipoInvestimento = Integer.parseInt(JOptionPane.showInputDialog("coloque 1 para poupança ou 2 para renda fixa"));
        valorInvestimento = Double.parseDouble (JOptionPane.showInputDialog("coloque o valor do investimento"));
                
        if (tipoInvestimento==1){
            JOptionPane.showMessageDialog(null, "o valor corrigido em 30 dias será de "+(valorInvestimento*1.03));
            
        } else{
            JOptionPane.showMessageDialog(null, "o valor corrigido em 30 dias será de "+(valorInvestimento*1.05));
        }
        
    }
    
}
