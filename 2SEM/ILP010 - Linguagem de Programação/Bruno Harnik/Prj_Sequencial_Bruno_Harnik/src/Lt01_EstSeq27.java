/*
 *************************
Lote 01 - Exercício 27
Receba o número de voltas, a extensão do circuito (em metros) e o tempo de duração (minutos).
Calcule e mostre a velocidade média em km/h.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq27 {
    
    public static void main(String args[]){
        
        double voltas, circuito, tempo, percurso, vm;
        
        circuito = Double.parseDouble(JOptionPane.showInputDialog("Digite o tamanho do percurso em metros: "));
        voltas = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de voltas realizadas: "));
        tempo = Double.parseDouble(JOptionPane.showInputDialog("Digite a duração da corrida em minutos: "));
          
        percurso = voltas * circuito;
        percurso = percurso / 1000;
        
        tempo = tempo / 60;
        
        vm = percurso / tempo;
        
        JOptionPane.showMessageDialog(null, "A velocidade média na corrida foi de " + vm + "Km/h.");                
        
    }
    
}
