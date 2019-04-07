/*
 * 10.  Criar uma matriz [8][8] onde o programa irá carregar segundo:
 *
 *      Casa    [ 1 ][ 2 ][ 3 ][ 4 ][...]   * Exibir a soma
 *      Valor   [ 1 ][ 2 ][ 4 ][ 8 ][...]     dos valores
 *
 */

/**
 *
 * @author Bruno Bega Harnik
 * Professor: Ricardo Satoshi
 * 
 */

import javax.swing.JOptionPane;

public class Lt01_Arrays10 {
    
    static int qti = 8, qtj = 8;
    
    public static void main (String[] args){
        
        int [][] matriz = new int [qti][qtj];
        
        int k = 1;
        
        String resultado = "";
        
        for(int i = 0; i < qti; i++){
        
            for(int j = 0; j < qtj; j++){
                
                if(i == 0){
                    
                    matriz[i][j] = j + 1;
                    
                }else{
                    
                    matriz[i][j] = (int) Math.pow(i + 1, j);
                    
                }
                
                resultado += "[\t" + matriz[i][j] + "\t]";
                
            }
            
            resultado += "\n";
            
        }
        
        JOptionPane.showMessageDialog(null, resultado);
        
    }
    
}
