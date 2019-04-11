/*
 * Quicksort
 */

/**
 *
 * @author Bruno Bega Harnik
 * Professor: Ricardo Satoshi
 * 
 */
import javax.swing.JOptionPane;

public class Quicksort {
    
    static final int QTD = 200;
    
    public static void main(String[] args){
        
        int []v = new int[QTD];
        
        String vetor_desordenado = "Vetor desordenado:\n";
        String vetor_ordenado = "Vetor ordenado:\n";
        
        for(int i = 0; i < v.length; i++){
            
            v[i] = (int) (Math.random() * 89) + 10;
            vetor_desordenado += "[" + v[i] + "]";
            
            if((i+1)%25 == 0){
                
                vetor_desordenado += "\n";
            }
        }
        
        
        
        QS(v, 0, v.length-1);
        
        for(int i = 0; i < v.length; i++){
            
            vetor_ordenado += "[" + v[i] + "]";
            
            if((i+1)%25 == 0){
                
                vetor_ordenado += "\n";
            }
        }
        
        JOptionPane.showMessageDialog(null, vetor_desordenado + "\n\n" + vetor_ordenado);

        
    }
    
    //Procedimento do QuickSort recebe o vetor, a primeira e a última posições
    public static void QS(int[] v, int esquerda, int direita) {

        if(esquerda >= direita){
            
            return;
            
        }
        
        //Pivô no centro
        int pivo = v[(esquerda + direita) / 2];
        
        //O Índice será a partição gerada
        int indice = Particao(v, esquerda, direita, pivo);
        
        QS(v, esquerda, indice - 1);
        QS(v, indice, direita);

    }
    
    public static int Particao(int [] v, int esquerda, int direita, int pivo){
        
        //Enquanto esquerda e direita não se encontram
        while(esquerda <= direita){
            
            //Enquanto o valor da esquerda for menor que o pivô, o índice consulta o próximo
            while(v[esquerda] < pivo){
                esquerda++;
            }
            //Enquanto o valor da direita for maior que o pivô, consulta o anterior
            while(v[direita] > pivo){
                direita--;
            }
            
            //Se o é menor que o da direita e não caiu nos "enquantos" acima,
            //significa que ele deve ser trocado.
            if(esquerda <= direita ){
                
                //Chamo a função de troca
                Troca(v, esquerda, direita);
                
                //Incremento o da esquerda e decremento o da direita
                esquerda++;
                direita--;
            }
            
            
            
            
        }
        
        return esquerda;
         
    }

    public static void Troca(int[] v, int esquerda, int direita) {
        
        int aux = v[esquerda];
        v[esquerda] = v[direita];
        v[direita] = aux;

    }
    
}



