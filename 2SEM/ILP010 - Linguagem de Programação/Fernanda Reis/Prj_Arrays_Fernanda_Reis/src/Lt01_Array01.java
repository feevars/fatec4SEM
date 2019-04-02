/*
 *************************
Lote 1 - Array - Exercício 1: Criar e coletar um vetor [50] inteiro. Calcular 
e exibir:
    a. A média dos valores entre 10 e 200;
    b. A soma dos números ímpares.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************


 */
import javax.swing.JOptionPane;
import java.lang.Math;

public class Lt01_Array01 {
    public static void main (String args[]) {
        
        String fatores = "Vetor[1..50]: \n";
        int i = 0, somaimp = 0, media = 0, cont = 0;
        int vetor[] = new int[50];
        
        
        for (i = 0; i < 50; i++) {
            vetor[i] = (int) (0+ (Math.random()*400)); //número aleatório de 1 a 400.
            
            if (i % 9 == 0 && i !=49  && i != 0) {
                fatores += vetor[i] + "\n";
            } else if (i == 49){
                fatores += vetor[i] + ".\n";
            } else {
                fatores += vetor[i] +", ";
            }
            if (vetor[i] > 10 && vetor[i] < 200) {
                media += vetor[i];
                cont ++;
            }
            if (VerificaImp(vetor[i]) == true) {
                somaimp += vetor[i];
            }
        }  
        media /= cont;
        JOptionPane.showMessageDialog(null, fatores + "\nA soma dos ímpares é " + somaimp + "\nA média dos valores entre 10 e 200 é " + media);    
    }
    public static boolean VerificaImp(int i) {
        return (i % 2 == 1);
    }
}