/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 28
Receba o preço atual e a média mensal de um produto. Calcule e mostre o
novo preço sabendo que:
Venda Mensal Preço Atual Preço Novo
< 500 < 30 + 10%
>= 500 e < 1000 >= 30 e < 80 +15%
>= 1000 >= 80 - 5%
Obs.: para outras condições, preço novo será igual ao preço atual.

Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */

import javax.swing.JOptionPane;

public class Lt01_EstDec28 {

    public static void main(String Args[]) {
        double precoAtual, vendaMensal, precoNovo;
        precoAtual = Double.parseDouble(JOptionPane.showInputDialog("Insira valor de preço atual: "));
        vendaMensal = Double.parseDouble(JOptionPane.showInputDialog("Insira valor de Venda Mensal: "));

        if ((precoAtual < 30) && (vendaMensal < 500)) {
            precoNovo = 1.1 * precoAtual;
        } else if ((vendaMensal >= 500) && (vendaMensal < 1000) && (precoAtual >= 30) && (precoAtual < 80)) {

            precoNovo = 1.5 * precoAtual;
        } else if ((vendaMensal >= 1000) && (precoAtual >= 80)) {

            precoNovo = 0.95 * precoAtual;
        } else {
            precoNovo = precoAtual;
        }
        JOptionPane.showMessageDialog(null,"o preço novo é de: "+precoNovo);
    }

}

