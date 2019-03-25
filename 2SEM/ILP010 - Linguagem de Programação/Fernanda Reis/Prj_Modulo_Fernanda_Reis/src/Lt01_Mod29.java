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
public class Lt01_Mod29 {
    private static DecimalFormat casas2 = new DecimalFormat (".##");
    public static void main (String args[]) {
     
        int inv;
        double valor;
        

        inv = Integer.parseInt(JOptionPane.showInputDialog("[ 1 ] POUPANÇA   |   [ 2 ] RENDA FIXA"));
        
        if (inv == 1 || inv == 2) {
            valor =  Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser depositado: "));
            JOptionPane.showMessageDialog(null, "O valor digitado com reajuste é de R$ " + Rendimento(inv, valor) +".");
        } else {
                JOptionPane.showMessageDialog(null,"INVÁLIDO.");
        }   
    }       
    static double Rendimento(double inv, double valor) {
    if (inv == 1) {
        valor *= 1.03;
    } else {
        valor *= 1.05;
    }
    return valor;
    }
}