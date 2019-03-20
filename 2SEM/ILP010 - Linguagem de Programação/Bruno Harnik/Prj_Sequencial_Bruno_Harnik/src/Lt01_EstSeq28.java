/*
 *************************
Lote 01 - Exercício 28
Receba o preço atual e a média de venda mensal de um produto.
Calcule e mostre o novo preço sabendo que:

Venda Mensal        Preço Atual         Preço Novo
< 500               < 30                + 10%
>= 500 e < 1000     >= 30 e < 80        +15%
>= 1000             >= 80               - 5%

Obs.: para outras condições, preço novo será igual ao preço atual.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */
import javax.swing.JOptionPane;

public class Lt01_EstSeq28 {
    
    public static void main(String Args[]){
        
        double venda, pAtual, pNovo;
        
        venda = Double.parseDouble(JOptionPane.showInputDialog("Digite a média de venda mensal do produto: "));
        
        pAtual = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço atual desse produto em reais: "));
        
        if(venda < 500 && pAtual < 30){
            
            pNovo = pAtual * 1.10;
            JOptionPane.showMessageDialog(null, "O preço do produto deverá ser reajustado para R$" + pNovo);
            
        }else if(venda >= 500 && venda < 1000 && pAtual >= 30 && pAtual < 80){
            
            pNovo = pAtual * 1.15;
            JOptionPane.showMessageDialog(null, "O preço do produto deverá ser reajustado para R$" + pNovo);
            
        }else if(venda >= 1000 && pAtual >= 80){
            
            pNovo = pAtual * 0.95;
            JOptionPane.showMessageDialog(null, "O preço do produto deverá ser reajustado para R$" + pNovo);
            
        }else{
            
            JOptionPane.showMessageDialog(null, "O preço do produto deverá se manter o mesmo.");
            
        }
        
    }
    
}
