/*
 *************************
Lote 1 - Array - Exercício 8: Criar e carregar uma matriz [4][3] inteiro com 
quantidade de produtos vendidos em 4 semanas. Calcular e exibir:
                        a. A quantidade de cada produto vendido no mês;
                        b. A quantidade de produtos vendidos por semana;
                        c. O total de produtos vendidos no mês.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************

 */

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Lt01_Array08 {
    private static DecimalFormat casas2 = new DecimalFormat ("#.##");
    public static void main (String args []) {
        int produtos [][] = new int[3][4];
        int semana[] = new int [5]; 
        int i = 0, j = 0;
        double temp = 0.0;
        String resposta = "";
        
        
        //preenche semanas
        for (i = 0; i < 3; i++) { // i = produtos
            for (j = 0; j < 4; j++) { // j = semanas
                produtos[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de produto " +(i+1) +" vendidos na " +(j+1) +"ª semana: ")); 
                semana[i] += produtos[i][j];
            }
            semana[4] += semana[i];
            resposta += "Produto " +(i+1) +": " +semana[i] +" produtos no total. \n";
        }
        resposta += "Total de produtos vendidos no mês: " +semana[4];
        JOptionPane.showMessageDialog(null, resposta);
    }
}