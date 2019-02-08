/*
 *************************
Lote 01 - Exercício 18 - Receba 2 valores inteiros. Calcule e mostre o 
                        resultado da diferença do maior pelo menos valor.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
public class LOTE01_EX_18 {
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