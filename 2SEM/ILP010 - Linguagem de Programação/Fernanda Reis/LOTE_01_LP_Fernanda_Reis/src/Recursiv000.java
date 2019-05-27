/*
 *************************
Recursivo - 5)   Serie5 = (N)! + (N-1)! + (N-2)! + ... + (1)! 

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi

 *************************
*/
import java.util.Arrays;

public class Recursiv000 {  
    public static void main (String [] args) {
       int array [] = {34, 2, 67, 54, 1, 9}; 
       Arrays.sort(array);
       int elemento = 54;
       int resultado = BuscaBinariaRecursiva(array, elemento);
       if (resultado < 0) {
           System.err.println("Não encontrado");
       } else {
           System.out.println("Encontrado na posição " + resultado);
       }
    }
    
    public static int BuscaBinariaRecursiva (int [] array, int elemento) {
        return BuscaRecursiva(array, elemento, 0, array.length - 1);
    }
    public static int BuscaRecursiva (int [] array, int elemento, int menor, int maior) {
        int media = (menor + maior) / 2;
        if (menor > maior) {
            return -1;
        }
        if (array[media] == elemento) {
            return media;
        }
        if (array[media] < elemento) {
            return BuscaRecursiva(array, elemento, media+1, maior);
        } else {
            return BuscaRecursiva(array, elemento, menor, media - 1);
        }
    }
}