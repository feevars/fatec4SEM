/*
 *************************
Lote 01 - Exercício 31 - Calcule e mostre o quadrado dos números entre 10 e 150.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */
import javax.swing.JOptionPane;
public class Lt01_EstSeq31 {
   public static void main (String args[]) {
       
       String resultado = "";
       
       int aux=0, numero;
       JOptionPane.showMessageDialog(null,"Vamos calcular e mostrar o quadrado dos números entre 10 e 30.");
       
       for (numero = 11; numero < 30; numero++) {
         aux += (numero * numero);
         resultado += numero + "² = " + aux + "\n";
       }
       JOptionPane.showMessageDialog(null, "O quadrado de todos os números inteiros entre 10 e 30 é: \n" + resultado);
   } 
}
