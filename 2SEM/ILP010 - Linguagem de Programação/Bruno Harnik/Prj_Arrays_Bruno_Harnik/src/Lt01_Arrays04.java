/*
 * 4.   Criar e coletar em um vetor [30] real e calcular e exibir:
 *      a. A média do grupo;
 *      b. A quantidade de notas acima do grupo;
 *      c. As posições dos valores abaixo da média do grupo.
 */

/**
 *
 * @author Bruno Bega Harnik
 * Professor: Ricardo Satoshi
 * 
 */
import javax.swing.JOptionPane;

public class Lt01_Arrays04 {
    
    static int qt = 30;
    
    public static void main(String[] args){
        
        //Coletando os valores para o vetor.
        double [] Notas = new double [qt];
        
        String Notas_texto = "As notas inseridas neste programa são:\n";
        
        
        for(int i = 0; i < qt; i++){
            
            Notas[i] = Math.ceil((double) (Math.random() * 1000)) / 100;
            //Notas[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite a " + i +"ª nota:");
            
            if(i == (qt - 1)){
                Notas_texto += Notas[i] + ".";
            }else{
                Notas_texto += Notas[i] + ",   ";
            }
            
            if((i + 1) % 10 == 0){
                Notas_texto += "\n";
            }
            
        }
        
        JOptionPane.showMessageDialog(null, Notas_texto + "\nA média das notas é: " + Media(Notas)
                                                        + "\n" + Acima(Notas, Media(Notas)) + " notas acima da média;"
                                                        + "\n" + Abaixo(Notas, Media(Notas)) + " notas abaixo da média.");
         
    }
    
    public static double Media(double vetor[]){
        
        double media = 0.0;
        
        for(int i = 0; i < qt; i++){
            
            media += vetor[i];
            
        }
        //Os 100 e o Math.ceil são o arredondamento.
        //O Math.ceil arredonda para o teto inteiro mais próximo.
        //Ao multiplicar por 100, não perdemos as duas casas decimais.
        media = media / qt * 100;
        
        'media = Math.ceil(media) / 100;
        
        return media;
        
        JOptionPane.showMessageDialog(null, "As raízes são..." +String.format("%.2f", media));
    }
    
    public static int Acima(double vetor[], double media){
        
        int notas_acima = 0;
        
        for(int i = 0; i < qt; i++){
            
            if(vetor[i] > media){
                notas_acima++;
            }
            
        }

        return notas_acima;
    }
    
    public static int Abaixo(double vetor[], double media){
        
        int notas_abaixo = 0;
        
        for(int i = 0; i < qt; i++){
            
            if(vetor[i] < media){
                notas_abaixo++;
            }
        }

        return notas_abaixo;
    }
}