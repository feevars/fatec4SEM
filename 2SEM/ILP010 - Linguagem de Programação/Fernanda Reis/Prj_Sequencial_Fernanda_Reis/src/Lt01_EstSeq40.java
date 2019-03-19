/*
 *************************
Lote 01 - Exercício 40 - Receba 2 números inteiros. Verifique e mostre todos os 
números primos existentes entre eles.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************


 */
import javax.swing.JOptionPane;

public class Lt01_EstSeq40 {
    public static void main (String args []){
        String fatores = "";
        String primos = "Os primos entre os valores inseridos são ";
        int menor, maior, i, j, x=0, aux, soma = 0;
      
        menor = Integer.parseInt(JOptionPane.showInputDialog("Calcularemos os número primos entre 2 valores. \nDigite o 1º valor: "));
        maior = Integer.parseInt(JOptionPane.showInputDialog("Digite o 2º valor: "));
      
        
        
        if (maior < menor) {
            aux = maior;
            maior = menor;
            menor = aux;
        } 
        
        
        for (i = menor+1; i < maior; i++) {
            for (j = 2; j < i; j++) {
                if (i % j == 0){
                    x = x + 1;
                }
            }
            if (x == 0) {
                fatores += i +" -----PRIMO----- \n";
                primos += i +" ";
            }
            else {
                fatores += i +"\n";
            }
        x = 0;
        }
        primos += ".";
            JOptionPane.showMessageDialog(null, fatores +primos);
    }
}
