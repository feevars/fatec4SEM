/*
 *************************
Lote 01 - Exercício 17 - Calcule a quantidade de litros gastos em uma viagem, 
        sabendo que o automóvel faz 12 km/l. Receber o tempo de percurso e a 
        velocidade média.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
public class Lt01_EstSeq17 {
     private static DecimalFormat casas2 = new DecimalFormat (".##");
public static void main (String args[]) 
    {
    
    double litros, tempo, velocidade, distancia; 
    
    tempo = (Double.parseDouble(JOptionPane.showInputDialog("Digite o tempo de percurso em minutos: "))/60);
    velocidade = Double.parseDouble(JOptionPane.showInputDialog("Digite a velocidade média (km/h): "));
    distancia = velocidade * tempo;
    litros = distancia / 12;
    
    
    
    JOptionPane.showMessageDialog(null,"Foram gastos " +casas2.format(litros) +"litros na viagem.");
    
    }
}