/*
 *************************
Lote 01 - Exercício 32 - Receba um número inteiro. Calcule e mostre o seu 
fatorial.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */
import javax.swing.JOptionPane;

public class Lt01_Mod32 {    
    public static void main (String args[]) {
        int NRO;    

        NRO = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor inteiro positivo: "));


        FFAT (NRO);
        JOptionPane.showMessageDialog(null, "O fatorial do número digitado é: " +FFAT(NRO));
    }

    static int FFAT(int N) { 
        int FAT=0;
        if (N == 1) {
            return N;     
        } else {
           FAT = N * FFAT(N-1);
           return FAT; 
        }
    }
}