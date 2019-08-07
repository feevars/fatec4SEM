

/*
 *************************
Lote 01 - Exercício 01 - Coletar o valor do lado de um quadrado, calcular sua área e 
apresentar o resultado.
Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */ 
import javax.swing.JOptionPane;

public class Lt01_EstSeq01 {
    public static void main (String args[]) {
        
        int LADO, AREA;
    
        LADO = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de lado do quadrado em m²: "));
        AREA = LADO * LADO;
    
        JOptionPane.showMessageDialog(null,"O valor da área é: " +AREA +"m².");
    }
}