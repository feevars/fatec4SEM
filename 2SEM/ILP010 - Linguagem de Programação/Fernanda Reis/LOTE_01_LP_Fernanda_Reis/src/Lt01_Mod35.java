/*
 *************************
Lote 01 - Exercício 35 - Receba 2 números inteiros, verifique qual o maior 
entre eles. Calcule e mostre o resultado da somatória dos números ímpares entre 
esses valores.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************


 */

import javax.swing.JOptionPane;

public class Lt01_Mod35 {
    public static int maior, menor;
    public static void main (String args []){
        String fatores = "";
        int i, soma = 0;
      
        menor = Integer.parseInt(JOptionPane.showInputDialog("Calcularemos a soma dos ímpares entre 2 valores. \nDigite o 1º valor: "));
        maior = Integer.parseInt(JOptionPane.showInputDialog("Digite o 2º valor: "));
      
        if (Verifica(menor, maior) == false) {
            Troca(menor, maior);
        }   
    
        JOptionPane.showMessageDialog(null, Fatores(menor, maior) + "\n" +SomaImp());
    }
    static void Troca (int n,int m) {   // 6 ------ 3
        int aux = m;                    //
        m = n;
        n = aux;
    } 
    static boolean Verifica(int n, int m) {
        return (n < m);
    }
    
    static int SomaImp (int i, int soma){
        return soma+i;
    }
    
    static String Fatores(int menor, int maior) {
            int soma = 0;
            String fatores = "";
            for (int i = menor+1; i < maior; i++) {
                if (i % 2 == 0){
                    fatores += i +" = PAR \n";
                } else {
                    fatores += i +" =-----ÍMPAR----- || " +soma +" + " +i +" = " +(soma+i) +"\n";
                    soma += i;
                }
            }
        return fatores;
        }
}