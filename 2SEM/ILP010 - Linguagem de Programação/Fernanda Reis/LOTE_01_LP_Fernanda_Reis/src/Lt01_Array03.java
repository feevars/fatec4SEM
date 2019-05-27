/*
 *************************
Lote 1 - Array - Exercício 3: Criar e coletar valores inteiros nos vetores 
VT1[3] e VT2[3]. Concatenar esses valores em um 3º vetor (VT3[6]) e mostrar 
os seus dados. P. ex:
                    VT1| 1| 2| 3| |VT2| 4| 5| 6| |VT3| 1| 2| 3| 4| 5| 6

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************

 */

import javax.swing.JOptionPane;

public class Lt01_Array03 {
    public static void main (String args []) {
        
        
        int v1[] = new int [3];
        int v2[] = new int [3];
        int v3[] = new int [6];
        int i = 0, j = 1;
        String vetores = "V1: ";
        
        //funcao Preenche V1
        for (i = 0; i < 3; i++) {
            v1[i] = i + 1;
            
            //exibirVetores
            if (i == 2) {
              vetores += v1[i] + ". \nV2: ";
            } else {
              vetores += v1[i] + " | ";  
            }
            
            //populaV3
            if (j % 2 == 1) {
            v3[j] = v1[i];
            j += 2;
            }
        }
        //funcao Preenche V2
        for (i = 0; i < 3; i++) {
           v2[i] = i + 4;
           
           //exibirVetores
            if (i == 2) {
              vetores += v2[i] + ". \nV3: ";
            } else {
              vetores += v2[i] + " | ";  
            }
           
           if (j % 2 == 0) {
           v3[j] = v2[i];
           j += 2;
           }
        }
        //Exibe 3 vetores
        for (j = 1; j < 7; j++) {
            if (j % 2 == 1) {
              v3[j] = v1[i];
              vetores += v3[j] + ".";
              i++;
            } else {
              v3[j] = v2[i];
              vetores += v3[j] + " | ";  
              i++;
            }   
        }
        JOptionPane.showMessageDialog(null, vetores);
    }
}