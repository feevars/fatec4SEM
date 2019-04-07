/*
 * 11.  Criar uma matriz [8][8] inteiro e o programa irá carregar segundo:
 *
 *      [ 1 ][ 1 ][ 1 ][ 1 ][ 1 ][ 1 ][ 1 ][ 1 ]
 *      [ 1 ][ 2 ][ 2 ][ 2 ][ 2 ][ 2 ][ 2 ][ 1 ]
 *      [ 1 ][ 2 ][ 3 ][ 3 ][ 3 ][ 3 ][ 2 ][ 1 ]
 *      [ 1 ][ 2 ][ 3 ][ 4 ][ 4 ][ 3 ][ 2 ][ 1 ]
 *      [ 1 ][ 2 ][ 3 ][ 4 ][ 4 ][ 3 ][ 2 ][ 1 ]
 *      [ 1 ][ 2 ][ 3 ][ 3 ][ 3 ][ 3 ][ 2 ][ 1 ]
 *      [ 1 ][ 2 ][ 2 ][ 2 ][ 2 ][ 2 ][ 2 ][ 1 ]
 *      [ 1 ][ 1 ][ 1 ][ 1 ][ 1 ][ 1 ][ 1 ][ 1 ]
 *
 */

/**
 *
 * @author Bruno Bega Harnik
 * Professor: Ricardo Satoshi
 * 
 */

import javax.swing.JOptionPane;

public class Lt01_Arrays11 {
    
    static int qt = 18;
    
    public static void main (String[] args){
        
        int [][] matriz = new int [qt][qt];
        
        int i, j, k;
        
        String resultado = "Matriz preenchida:\n\n";
        
        for (k = 0; k < qt / 2; k++){
            
            for(i = k; i < qt - k; i++){
                
                for(j = k; j < qt - k; j++){
                    
                    matriz[i][j] = k + 1;
                    
                }
                
            }
        }
        
        for(i = 0; i < qt; i++){
            
            for(j = 0; j < qt; j++){
                
                resultado += "[\t" + matriz[i][j] + "\t]";
                
            }
            
            resultado += "\n";
            
        }
        
        JOptionPane.showMessageDialog(null, resultado);
        
    }
    
}
