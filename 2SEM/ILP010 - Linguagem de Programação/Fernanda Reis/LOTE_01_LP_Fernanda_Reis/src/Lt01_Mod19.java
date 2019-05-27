/*
 *************************
Lote 01 - Exercício 19 - Receba 2 valores reais. Calcule e mostre o maior deles.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
public class Lt01_Mod19 {
    static double menor, maior; 
    private static DecimalFormat casas2 = new DecimalFormat (".##");
public static void main (String args[]) {
       
    maior = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro valor: "));
    menor = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo valor: "));
    
    IdentificaMaiorValor();
    
    JOptionPane.showMessageDialog(null,"O maior valor entre os valores digitados é " +casas2.format(maior));
    
    }
static void IdentificaMaiorValor() { 
    
    int x;
    double aux;
    
    if (maior > menor) {
        x = 1;
    }
    else {
        x = 0;
    }
    switch (x) {
        case 0: 
            aux = maior;
            maior = menor;
            menor = aux;
        case 1:
        default:
    }
}
}