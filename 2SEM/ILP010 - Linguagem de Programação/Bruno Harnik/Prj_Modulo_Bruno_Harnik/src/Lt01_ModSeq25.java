/*
 *************************
 ******MODULARIZAÇÃO******
Lote 01 - Exercício 25
Receba a hora de início e de final de um jogo (HH,MM)
sabendo que o tempo máximo é de 24 horas e pode começar num dia e terminar noutro.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.*;

public class Lt01_ModSeq25 {
    
    public static void main(String args[]){
        
        ImageIcon icon = new ImageIcon("src/images/favicon.png");
        
        SpinnerNumberModel hora_inicial = new SpinnerNumberModel(0, 0, 23, 1);
        SpinnerNumberModel minuto_inicial = new SpinnerNumberModel(0, 0, 59, 1);
        SpinnerNumberModel hora_final = new SpinnerNumberModel(0, 0, 23, 1);
        SpinnerNumberModel minuto_final = new SpinnerNumberModel(0, 0, 59, 1);
        
        JSpinner HI = new JSpinner(hora_inicial);
        JSpinner MI = new JSpinner(minuto_inicial);
        JSpinner HF = new JSpinner(hora_final);
        JSpinner MF = new JSpinner(minuto_final);
        
        Object[] dados_partida = {
            
            "Hora inicial", HI,
            "Minuto inicial", MI,
            "Hora final", HF,
            "Minuto final", MF
        };
        
        JOptionPane.showConfirmDialog(null, dados_partida, "Duração da partida", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, icon);
         
        int h_inicial = Integer.parseInt(HI.getValue().toString());
        int m_inicial = Integer.parseInt(MI.getValue().toString());
        int h_final = Integer.parseInt(HF.getValue().toString());
        int m_final = Integer.parseInt(MF.getValue().toString());
        
        JOptionPane.showMessageDialog(null, TempoDeJogo(h_inicial, m_inicial, h_final, m_final));
        
    }
    
    public static String TempoDeJogo(int HI, int MI, int HF, int MF){
        
        int total_h, total_m;
        
        int total_mi = HI * 60 + MI;
        
        int total_mf = HF * 60 + MF;
        
       if(total_mf >= total_mi){
           
           total_h = (total_mf - total_mi) / 60;
           total_m = (total_mf - total_mi) % 60;

       }else{
           
           total_h = ((24 * 60 - total_mi) + total_mf) / 60;
           total_m = ((24 * 60 - total_mi) + total_mf) % 60;
           
       }
        
        return "O tempo da partida foi de " + total_h + " horas e " + total_m + " minutos.";
    }
}
