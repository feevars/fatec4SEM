/*
 *************************
Lote 01 - Exercício 36 - Receba um número N. Calcule e mostre a série 1 + 1/1! 
+ 1/2! + ... + 1/N!

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************


 */
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Lt01_EstSeq36 {
    private static DecimalFormat casas0 = new DecimalFormat ("");
    private static DecimalFormat casas2 = new DecimalFormat (".####");
    public static void main (String args []){
        
        String resultado = "";
        double soma=2.0, i, numero, x=1.0;
                
        numero = Double.parseDouble(JOptionPane.showInputDialog(null,"Vamos calcular a série 1 + 1/1! + 1/2! + ... + 1/N!\nDigite um número N: "));
        
        
        for (i=1; i<=numero; i++){
          if (i < numero) {
              resultado += "1/" +casas0.format(i)  +"! + ";
          }
          else if (i == numero){
              resultado += "1/" +casas0.format(i) +"!";
          }
          /*
          fatorial
          */
        }
        for (i=1;i<numero;i++) {
            x *= (x+1);
            soma += (1/x);
        }    
          
        
          JOptionPane.showMessageDialog(null, resultado +"\nA soma dos valores acima é: " +casas2.format(soma));
        
    }
}