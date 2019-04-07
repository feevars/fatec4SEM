/*
 * 12.  Carregar códigos das peças em um tabuleiro de xadrez, onde:
 *
 *      Código: [    1   ][    2   ][    3   ][    4   ][    5   ][    6   ][    7   ]
 *      Peça    [  Peão  ][  Torre ][  Bispo ][ Cavalo ][ Rainha ][   Rei  ][  Vazio ]
 *
 *
 *      Calcular e mostrar a soma das peças do tabuleiro.
 *      Não pode utilizar estrutura de decisão e Escolha Caso na contagem das peça.
 */

/**
 *
 * @author Bruno Bega Harnik
 * Professor: Ricardo Satoshi
 * 
 */
import javax.swing.JOptionPane;

public class Lt01_Arrays12 {
    
    public static void main(String[] args){
        
        int [][] tabuleiro = new int [8][8];
        
        int soma = 0;
        
        String resultado = "O tabuleiro foi carregado da seguinte maneira:\n";
        
        for(int i = 0; i < 8; i++){
            
            for(int j = 0; j < 8; j++){
                
                tabuleiro[i][j] = (int) (Math.random() * 7) + 1;
                
                resultado += "[\t" + tabuleiro[i][j] + "\t]";
                
                soma += tabuleiro[i][j];
            }
            
            resultado += "\n";
        }
        
        resultado += "\nA soma dos valores das casas é " + soma + ".";
        
        JOptionPane.showMessageDialog(null, resultado);        
        
    }
    
}