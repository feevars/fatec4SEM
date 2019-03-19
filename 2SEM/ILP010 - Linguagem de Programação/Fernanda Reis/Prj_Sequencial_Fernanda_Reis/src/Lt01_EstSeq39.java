/*
 *************************
Lote 01 - Exercício 39 - Calcule a quantidade de grãos contidos em um tabuleiro 
de xadrez onde:
Casa:   1 2 3 4 ... 64
Qte:    1 2 4 8 ... N

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************


 */
import javax.swing.JOptionPane;
public class Lt01_EstSeq39 {
   public static void main (String args []) {
       
       String tabuleiro = "";
       int casa, qte=1;
       
       
       for (casa = 1; casa <= 64; casa++) {
           if (casa == 1) {
               qte = 1;
               tabuleiro += "Casa: " +casa +"  || Qtdd: " +qte ;
           } else {
                qte *= 2; 
                tabuleiro += "  ||  Casa: " +casa +"  |  Qtdd: " +qte;
           }
           if (casa % 8 == 0) {
               tabuleiro += "\n";
           }
           
       }
       JOptionPane.showMessageDialog(null, tabuleiro);
    } 
}
