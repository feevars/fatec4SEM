/*
 +++++++++++++++++++++++++++++++++++
Lote 01 - Exercício 01
Criar e coletar um vetor [50] inteiro. Calcular e exibir:
a. A média dos valores entre 10 e 200;
b. A soma dos números ímpares.


Programador: Robson Henrique Ferreira
Professor: Ricardo Satoshi

 +++++++++++++++++++++++++++++++++++++
 */
import javax.swing.JOptionPane;

public class Lt01_Homogenea01 {

    public static void main(String Args[]) {
        int vetor[] = new int[5], media, soma;
        vetor = carregaVetor(vetor);
        media = mediaVetor(vetor);
        soma = somaImpar(vetor);
        JOptionPane.showMessageDialog(null, "a média dos valores entre 10 e 200 é "+media+" e a soma dos números ímpares é "+soma);
        

        // lerVetor(vetor);
    }

    static int[] carregaVetor(int vetor[]) {
        int i;
        for (i = 0; i < vetor.length; i++) {
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("insira um valor"));

        }
        System.out.println("foi a func");
        return vetor;
    }

    //static void lerVetor(int vetor[]) {
    //  int i;
    //for (i = 0; i < vetor.length; i++) {
    //  System.out.println(vetor[i]);
//
    //      }
    //}
    static int mediaVetor(int vetor[]) {
        int i, media = 0, cto = 0;
        for (i = 0; i < vetor.length; i++) {
            if ((vetor[i] >= 10) && (vetor[i] <= 200)) {
                media = vetor[i] + media;
                cto++;
            }

        }
        media = media / cto;
        return media;
    }
    static int somaImpar(int vetor[]){
        int i, soma = 0;
        for (i = 0; i < vetor.length; i++) {
            if (vetor[i]%2!=0) {
                soma = vetor[i] + soma;
                
            }

        }
        return soma;
    }
}
