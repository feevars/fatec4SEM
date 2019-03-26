/*
 * 1.   Criar e coletar um vetor [50] inteiro. Calcular e exibir:
 *          a. A média dos valores entre 10 e 200;
 *          b. A soma dos números ímpares.
 */

/**
 *
 * @author Bruno Bega Harnik
 * Professor: Ricardo Satoshi
 * 
 */
import javax.swing.JOptionPane;

public class Lt01_Arrays01 {
    
    public static void main(String[] args){
        
        int [] vetor = new int [50];
        
        String vetor_texto = "";
        
        for(int i = 0; i < 50; i++){
            
            vetor[i] = 1 + (int) (Math.random() * 1000);
            vetor_texto += vetor[i];
            
            if(i < 49){
                
                vetor_texto += ",  ";
                
            }else{
                
                vetor_texto += ".";
                
            }
            
            if((i + 1) % 10 == 0){
                
                vetor_texto += "\n";
                
            }
            
        }
        
        JOptionPane.showMessageDialog(null, "Utilizaremos o seguinte vetor no exercício:\n" + vetor_texto);
        
        JOptionPane.showMessageDialog(null, vetor_texto + "\nA média dos valores entre 10 e 200 é:\n" + Media10e200(vetor));
        
        JOptionPane.showMessageDialog(null, vetor_texto + "\nA soma dos números ímpares é:\n" + SomaImpares(vetor));

    }
    
    public static int Media10e200(int vetor[]){
        
        int media = 0, total = 0;
        
        for(int i = 0; i < 50; i++){
            
            if(vetor[i] >= 10 && vetor[i] <= 200){
                
                media += vetor[i];
                total++;
                
            }
        }
        
        media = media / total;
        
        return media;
        
    }
    
    public static int SomaImpares(int vetor[]){
        
        int somaImpares = 0;
        
        for(int i = 0; i < 50; i++){
            
            if(vetor[i] % 2 != 0){
                 
                somaImpares += vetor[i];
                
            }
            
        }
        
        return somaImpares;
    }
    
}
