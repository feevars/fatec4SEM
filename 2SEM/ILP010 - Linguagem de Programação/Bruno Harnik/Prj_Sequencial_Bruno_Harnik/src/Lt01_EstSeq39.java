/*
 *************************
Lote 01 - Exercício 39
Calcule a quantidade de grãos contidos em um tabuleiro de xadrez onde:
Casa: 1 2 3 4 ... 64 Qte: 1 2 4 8 ... N

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq39 {
    
    public static void main(String args[]){
        
        int casa, qtd, total = 1;
        
        for(casa = 1; casa <= 64; casa++){
            
            qtd = casa * 2;
            
            total = total + qtd;
            
        }
        
        JOptionPane.showMessageDialog(null, "O total de grãos é " + total);
        
    }
    
}
