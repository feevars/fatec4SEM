/*
 *************************
 ******MODULARIZAÇÃO******
Lote 01 - Exercício 17
Calcule a quantidade de litros gastos em uma viagem, sabendo que o automóvel faz 12 km/l.
Receber o tempo de percurso e a velocidade média.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_ModSeq17 {
    
    public static void main(String[] args){
        
        double tempo, vel_media;
    
        tempo = Double.parseDouble(JOptionPane.showInputDialog("Digite o tempo gasto no percurso (em horas):"));
        
        vel_media = Double.parseDouble(JOptionPane.showInputDialog("Digite a velocidade média da viagem em km/h: "));
        
        JOptionPane.showMessageDialog(null, "São necessários " + LitrosGasolina(tempo, vel_media) + " litros de gasolina para esse rolê.");
        
    }
    
    public static double LitrosGasolina(double t,  double vm){
        
        double distancia = vm * t;
        
        double l = distancia / 12;
        
        return l;
        
    }
}