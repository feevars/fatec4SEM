/*
 *************************
Lote 1 - Array - Exercício 7: A partir do exercício 6 (vetor classificado) 
solicitar um valor qualquer e verificar a sua existência no vetor (utilizar 
pesquisa binária).

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************

 */

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Lt01_Array07 {
    private static DecimalFormat casas2 = new DecimalFormat ("#.##");
    public static void main (String args []) {
        double vt[] = new double[20];
        int i = 0, somatorio = 0;
        double temp = 0.0;
        String vetor = "Números em ordem aleatória: \n";
        
        
        //populaVetor
        for (i = 0; i < 20; i++) {
            vt[i] = (double) (0 + (Math.random() *100));
            vetor += casas2.format(vt[i]) + "   ";
        }
        
        double numero = Double.parseDouble(JOptionPane.showInputDialog(vetor +"\nDigite um valor para procura: "));
        
        //bubbleSort
        for (i = 0; i < 20; i++) {
            for(int j = 1; j < (20-i); j++) {
                if(vt[j-1] > vt[j]) {
                    temp = vt[j-1];
                    vt[j-1] = vt[j];
                    vt[j] = temp;
                }
            }
        }
        //pesquisaBinaria

int inicial = 1, fim = 20;
boolean x = false;

   do {
      mid =  (inicial + fim) div 2;
      i = mid;
      if (vt[j] == numero) {
          x = true;
      } else if (vt[j] > numero) {
          fim = (mid - 1);
      } else {
          inicial = (mid + 1);
      }
      while (inicial <= fim && x == false);
    }

      //Exibir Resultados da busca
      se x = 1 entao
         escreva ("O número foi encontrado na posição ", meio, " do vetor.")
      senao
         escreva ("O número informado não foi encontrado no vetor.")
      fimse
              
        //exibeCrescente 
        for (i = 0; i < 20; i++) {
            vetor += "\n" +(i+1) + "º : " + casas2.format(vt[i]);
        }
        JOptionPane.showMessageDialog(null, vetor);
    }
}
