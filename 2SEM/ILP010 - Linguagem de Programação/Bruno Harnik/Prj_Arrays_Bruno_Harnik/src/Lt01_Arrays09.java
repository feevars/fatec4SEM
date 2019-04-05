/*
 * 9.   Criar e carregar uma matriz [4][4] com valores aleatórios, sendo que
 *      a diagonal principal terá seus dados carregados no programa segundo:
 *
 *          [  1 ][    ][    ][    ]
 *          [    ][  4 ][    ][    ]
 *          [    ][    ][ 16 ][    ]
 *          [    ][    ][    ][ 64 ]
 *
 */

/**
 *
 * @author Bruno Bega Harnik
 * Professor: Ricardo Satoshi
 * 
 */

import javax.swing.JOptionPane;

public class Lt01_Arrays09 {
    
    public static void main(String[] args){
        
        int [][] matriz = new int [4][4];
        
        String resultado = "";
        
        for(int i = 0; i < 4; i++){
            
            for(int j = 0; j < 4; j++){
                
                if(i == j){
                    
                    matriz[i][j] = (int) Math.pow(4, j);
                    
                }else{
                    matriz[i][j] = (int) (Math.random() * 100);
                }
                
                resultado += "[\t" + matriz[i][j] + "\t]";
            }
            
            resultado += "\n";
            
        }
        
        JOptionPane.showMessageDialog(null, resultado);
        
    }
    
}
