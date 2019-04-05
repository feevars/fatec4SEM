/*
 * 6.   Criar e coletar em um vetor [20] com números aleatórios.
 *      Classificar este vetor em ordem crescente e mostre os dados.
 */

/**
 *
 * @author Bruno Bega Harnik
 * Professor: Ricardo Satoshi
 * 
 */

import javax.swing.JOptionPane;

public class Lt01_Arrays06 {
    
    public static int qt = 20;
    
    public static void main(String[] args){
        
        int [] Vetor = new int [qt];
        
        String lista_de_numeros = "Lista de números:\n";
        
        String lista_ordenada = "Lista de números ordenada:\n";
        
        for(int i = 0; i < qt; i++){
            
            Vetor[i] = (int) (Math.random() * 1000);
            if(i == qt - 1){
                lista_de_numeros += Vetor[i] + ".";
            }else{
                lista_de_numeros += Vetor[i] + ",   ";
            }
            
            if((i + 1) % 5 == 0){
                lista_de_numeros += "\n";
            }
            
        }
        
        JOptionPane.showMessageDialog(null, "Neste exercício, devemos ordenar uma lista de números randômica.\n\n" + lista_de_numeros);
        
        
        for(int i = 0; i < qt; i++){
            
            if(i == qt - 1){
                lista_ordenada += Ordena(Vetor)[i] + ".";
            }else{
                lista_ordenada += Ordena(Vetor)[i] + ",   ";
            }
            
            if((i + 1) % 5 == 0){
                lista_ordenada += "\n";
            }
        }
        
        JOptionPane.showMessageDialog(null, lista_ordenada);
        
    }
    
    public static int [] Ordena(int Ordenado[]){

        int aux;

        
        for(int i = 0; i < qt; i++){
            
            for(int j = 1; j <= i; j++){
                
                if(Ordenado[j-1] > Ordenado[j]){
                    
                    aux = Ordenado[j - 1];
                    Ordenado[j - 1] = Ordenado[j];
                    Ordenado[j] = aux;
                    
                }

            }

        }    
        return Ordenado;
    }
}
