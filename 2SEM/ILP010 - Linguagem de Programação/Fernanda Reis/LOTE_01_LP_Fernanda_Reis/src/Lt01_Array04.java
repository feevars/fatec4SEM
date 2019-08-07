/*
 *************************
Lote 1 - Array - Exercício 4: Criar e coletar em um vetor [30] real e calcular 
e exibir:
                a. A média do grupo;
                b. A quantidade de notas acima do grupo;
                c. As posições dos valores abaixo da média do grupo.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************

 */

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Lt01_Array04 {
    private static DecimalFormat casas2 = new DecimalFormat ("#.##");
    public static void main (String args []) {
        double vt[] = new double[30];
        double soma = 0.0;
        int i = 0, cont = 0;
        String vetor = "";
        
        for(i = 0; i < 30; i++) {
            vt[i] = (double) (0+ (Math.random()*10));
            soma += vt[i];
            
            //exibeValores
            if (i % 10 == 0 && i != 0) {
                vetor += casas2.format(vt[i]) + "\n";
            } else {
                vetor += casas2.format(vt[i]) +"  ";    
            }
        }
        soma = (soma/30);
        vetor += "\n Média das notas: " + casas2.format(soma) + "\nPosição das notas abaixo da média do grupo: \n";
        
        for(i = 1; i <= 30; i++) {
            if (vt[i-1] > soma) {
                cont++;
            } else if (vt[i-1] < soma) {
                vetor += i +"ª posição -- " + casas2.format(vt[i-1]) +"\n";
            }
        }
        vetor += "\n Número de notas acima da média do grupo:  " +cont;
        JOptionPane.showMessageDialog(null, vetor);
    }
}