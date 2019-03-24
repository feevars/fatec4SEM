/*
 *************************
Lote 01 - Exercício 31 - Calcule e mostre o quadrado dos números entre 10 e 150.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */
import javax.swing.JOptionPane;
public class Lt01_Mod31 {
   public static void main (String args[]) {
       int n = 11;
       JOptionPane.showMessageDialog(null,"Vamos calcular e mostrar o quadrado dos números entre 10 e 30."); 
       JOptionPane.showMessageDialog(null, Soma(n));
   } 
   
   static String Soma(int N) {
       String soma = ""; 
       if (N < 30) {
           soma += N + "² = " +(N * N) + "\n" +Soma(N+1);
       }
       return soma;
   }
}