/*
 *************************
 ******MODULARIZAÇÃO******
Lote 01 - Exercício 27
Receba o número de voltas, a extensão do circuito (em metros) e o tempo de duração (minutos).
Calcule e mostre a velocidade média em km/h.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

public class Lt01_ModSeq27 {
    
    public static void main(String args[]){
        
        double voltas, circuito, tempo;
        
        circuito = Double.parseDouble(JOptionPane.showInputDialog("Digite o tamanho do percurso em metros: "));
        voltas = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de voltas realizadas: "));
        tempo = Double.parseDouble(JOptionPane.showInputDialog("Digite a duração da corrida em minutos: "));

        JOptionPane.showMessageDialog(null, "A velocidade média na corrida foi de " + VelocidadeMedia(voltas, circuito, tempo) + "Km/h.");                
        
    }
    
    public static double VelocidadeMedia(double v, double c, double t){
        
        double vm;
        
        
            vm = v * c;
            vm = vm / 1000;

            t = t / 60;

            vm = vm / t;
        
        return vm;
        
        
    }
    
}
