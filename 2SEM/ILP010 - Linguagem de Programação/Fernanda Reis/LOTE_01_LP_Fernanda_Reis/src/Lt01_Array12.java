/*
 *************************
Lote 1 - Array - Carregar códigos das peças em um tabuleiro de xadrez, onde:

                |código| 1  |  2  |  3   |  4  | 5 |  6   |  7  |
                |  peça|peão|torre|cavalo|bispo|rei|rainha|vazio|
                

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************

 */

import javax.swing.JOptionPane;

public class Lt01_Array12 {
    public static void main (String args []) {
        
        int xadrez [][] = new int [8][8];
        String chess_table = "Aqui está o tabuleiro organizado: \n";
        int soma = 0;
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                xadrez [i][j] = (int) (0 + (Math.random() * 7));
                chess_table += "| " +xadrez[i][j] + " |";
                soma += xadrez[i][j];
            }
            chess_table += "\n";
        }
        
        chess_table += "A soma do número das peças do tabuleiro é " +soma;
        JOptionPane.showMessageDialog(null, chess_table);
    }
}