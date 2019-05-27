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

public class Lt01_Mod17 {
    static double litros, tempo, velocidade, distancia; 
    private static DecimalFormat casas1 = new DecimalFormat (".#");
    public static void main (String args[]) {
            
        tempo = (Double.parseDouble(JOptionPane.showInputDialog("Digite o tempo de percurso em minutos: "))/60);
        velocidade = Double.parseDouble(JOptionPane.showInputDialog("Digite a velocidade média (km/h): "));
        
        LitrosGastos();
    
        JOptionPane.showMessageDialog(null,"Foram gastos " +casas1.format(litros) +" litros na viagem.");
    }
    
    static void LitrosGastos () {
        distancia = velocidade * tempo;
        litros = distancia / 12;
    }
}