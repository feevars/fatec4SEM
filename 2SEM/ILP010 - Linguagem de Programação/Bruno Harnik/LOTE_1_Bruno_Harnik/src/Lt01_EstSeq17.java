/*
 *************************
Lote 01 - Exercício 17
Calcule a quantidade de litros gastos em uma viagem, sabendo que o automóvel faz 12 km/l.
Receber o tempo de percurso e a velocidade média.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq17 {
    
    public static void main (String args[]){
        
        double tempo, vel_media, total, gasolina;
        
        tempo = Double.parseDouble(JOptionPane.showInputDialog("Digite o tempo gasto no percurso (em horas):"));
        
        vel_media = Double.parseDouble(JOptionPane.showInputDialog("Digite a velocidade média da viagem em km/h: "));
        
        total = vel_media / tempo;
        
        gasolina = total / 12;

        JOptionPane.showMessageDialog(null, "São necessários " + gasolina + " litros de gasolina para esse rolê.");
    }
}
