/*
 *************************
Lote 01 - Exercício 29 - Receba o tipo de investimento (1 = poupança e 
                        2 = renda fixa) e o valor do investimento. Calcule 
                        e mostre o valor corrigido em 30 dias sabendo que a
                        poupança = 3% e a renda fixa = 5%. Demais tipos não 
                        serão considerados.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
public class Lt01_EstSeq29 {
    private static DecimalFormat casas2 = new DecimalFormat (".##");
    public static void main (String args[]) {
     
        int inv;
        double valor;
        

        inv = Integer.parseInt(JOptionPane.showInputDialog("[ 1 ] POUPANÇA   |   [ 2 ] RENDA FIXA"));
        if (inv == 1 || inv == 2) {
            if (inv == 1){
                valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser depositado na poupança: "));
                valor = valor * 1.03;
                JOptionPane.showMessageDialog(null,"O valor depositado com reajuste de 3% após 30 dias é de R$ " +casas2.format(valor) +".");
            } else {
                valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser depositado como renda fixa: "));
                valor = valor * 1.05;
                JOptionPane.showMessageDialog(null,"O valor depositado com reajuste de 5% após 30 dias é de R$ " +casas2.format(valor) +".");
            }
        } else {
                JOptionPane.showMessageDialog(null,"INVÁLIDO.");
        }   
    }       
}
