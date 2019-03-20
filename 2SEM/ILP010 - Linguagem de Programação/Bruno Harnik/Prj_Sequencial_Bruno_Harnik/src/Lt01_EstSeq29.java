/*
 *************************
Lote 01 - Exercício 29
Receba o tipo de investimento (1 = poupança e 2 = renda fixa) e o valor do investimento.
Calcule e mostre o valor corrigido em 30 dias sabendo que a poupança = 3% e a renda fixa = 5%.
Demais tipos não serão considerados.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */
import javax.swing.JOptionPane;

public class Lt01_EstSeq29 {
    
    public static void main(String args[]){
        
        int tipo_de_investimento;
        
        double valor;
        
        tipo_de_investimento = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo de investimento:\n1 - Poupança\n2 - Renda Fixa"));
        
        while(tipo_de_investimento < 1 || tipo_de_investimento > 2){
            
            tipo_de_investimento = Integer.parseInt(JOptionPane.showInputDialog("Opção inválida!\nDigite o tipo de investimento:\n1 - Poupança\n2 - Renda Fixa"));
            
        }
        
        valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor depositado em reais: "));
                
        switch(tipo_de_investimento){
            
            case 1: valor = valor * 1.03;
                    JOptionPane.showMessageDialog(null, "Após 30 dias, o valor será R$" + valor);
                    break;
                    
            case 2: valor = valor * 1.05;
                    JOptionPane.showMessageDialog(null, "Após 30 dias, o valor será R$" + valor);
                    break;
            
            default: JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
        }
        
    }
}
