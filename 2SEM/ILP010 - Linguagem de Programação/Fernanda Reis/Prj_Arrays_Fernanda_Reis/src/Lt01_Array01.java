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
        int i = 0, somaimp = 0;
        int vetor[] = new int[50];
        
        
        for (i = 1; i <= 50; i++) {
            vetor[i] = (int) (0+ (Math.random()*400)); //número aleatório de 1 a 400.
            
            if (i % 10 == 0 && i != 50) {
                fatores += vetor[i] + "\n";
            } else if (i == 50){
                fatores += vetor[i] + ".\n";
            } else {
                fatores += vetor[i] +", ";
            }   
        }  
        JOptionPane.showMessageDialog(null, fatores);    
    }
    public static boolean VerificaImp(int i) {
        return (i % 2 == 1);
    }
    static int SomaValores(int vt) {
        int soma = 0;
        soma += vt;
        return soma;
        }
    static double MediaValores(int soma) {
        int cont = 0;
        cont ++;
        return soma/cont;
    }
    static int SomaImp(int imp) {
        int somaimp = 0;
        return somaimp += imp;
    }
}
if (vetor[i] > 10 && vetor[i] < 200) {
                MediaValores(SomaValores(vetor[i]));
            }
            if (VerificaImp(vetor[i]) == true) {
                somaimp += vetor[i]; // soma ímpares
            }
            i++;    
        fatores += "Média dos valores entre 10 e 200: " +MediaValores(SomaValores(vetor[50])) +"\n\nSoma dos ímpares: " +somaimp; 