/*
 *************************
Lote 01 - Exercício 27 - Receba o número de voltas, a extensão do circuito 
                        (em metros) e o tempo de duração (minutos). Calcule  
                        e mostre a velocidade média em km/h.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
public class Lt01_Mod27 {
    static double vm;
    private static DecimalFormat casas2 = new DecimalFormat (".##");
    public static void main (String args[]) {
     
        int Nvoltas, distancia, tempo;
        
        

        Nvoltas = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de voltas dadas: "));
        distancia = Integer.parseInt(JOptionPane.showInputDialog("Digite a extensão do circuito em metros: "));
        tempo = (Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo decorrido para completar as voltas em minutos: "))*60);
        
        VM((int) Nvoltas, distancia, tempo);
      
        JOptionPane.showMessageDialog(null,"A velocidade média do percurso foi de " +casas2.format(vm) +" Km/h.");
    }       
    static void VM (int v, int d, int t) {
        vm = (v*d)/t;
        vm = vm /3.6;
    }
}
