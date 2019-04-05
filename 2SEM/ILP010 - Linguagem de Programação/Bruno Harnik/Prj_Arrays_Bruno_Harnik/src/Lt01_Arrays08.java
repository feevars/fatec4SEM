/*
 * Criar e carregar uma matriz [4][3] inteiro com quantidade
 * de produtos vendidos em 4 semanas. Calcular e exibir:
 *      a. A quantidade de cada produto vendido no mês;
 *      b. A quantidade de produtos vendidos por semana;
 *      c. O total de produtos vendidos no mês.
 */

/**
 *
 * @author Bruno Bega Harnik
 * Professor: Ricardo Satoshi
 * 
 */
import javax.swing.JOptionPane;

public class Lt01_Arrays08 {
    
    public static void main(String[] args){
        
        int [][] Produtos = new int [4][3];
        
        for(int i = 0; i < 4; i ++){
            
            for(int j = 0; j < 3; j++){
                
                Produtos[i][j] = Integer.parseInt(JOptionPane.showInputDialog((i + 1) + "ª semana\n\nVendas do\nProduto #" + (j + 1)));
                
            }
            
        }
        
    }
    
    public static int [3] Produtos_vendidos
    
}
