/*
 * 2.   Criar e coletar um vetor [100] inteiro e exibir:
 *          a. O maior e o menor valor;
 *          b. A média dos valores.
 */

/**
 *
 * @author Bruno Bega Harnik
 * Professor: Ricardo Satoshi
 * 
 */
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Lt01_Arrays02 {
    
    static int qt = 100;
    
    public static void main(String[] args){
        
        int [] vetor = new int [qt];
        
        ImageIcon icon = new ImageIcon("src/images/favicon.png");
        
        String vetor_texto = "";
        
        for(int i = 0; i < qt; i++){
            
            vetor[i] = (int) (Math.random() * 1000);
            
            vetor_texto += vetor[i];
            
            if((i + 1) == qt){
                
                vetor_texto += ".";
                
            }else if((i + 1) % 10 == 0){
                
                vetor_texto += ",\n";
                
            }else{
                
                vetor_texto += ",   ";
                
            }
            
        }
        
        JOptionPane.showMessageDialog(null, vetor_texto, "Criar e coletar um vetor [100] inteiro", 3, icon);
        
        JOptionPane.showMessageDialog(null, vetor_texto + "\n\nMaior número: " + Maior(vetor) + "\nMenor número: " + Menor(vetor) + "\nMédia dos valores: " + Media(vetor) , "Maior, menor e média", 3, icon);
        
        
        
        
    }
    public static int Maior(int vetor[]){
        
        int maior = vetor[0];
        
        for(int i = 1; i < qt; i++){
            
            if(vetor[i] > maior){
                
                maior = vetor[i];
                
            }
            
        }
       
        return maior;
        
    }
    
    public static int Menor(int vetor[]){
        
        int menor = vetor[0];
        
        for(int i = 1; i < qt; i++){
            
            if(vetor[i] < menor){
                
                menor = vetor[i];
                
            }
            
        }
        
        return menor;
        
    }
    
    public static double Media(int vetor[]){
        
        double media = 0;
        
        for(int i = 0; i < qt; i++){
            
            media = media + vetor[i];
            
        }
        
        media = media / qt;
        
        return media;
        
    }
}