/*
 *************************
Lote 01 - Exercício 25
Receba a hora de início e de final de um jogo (HH,MM)
sabendo que o tempo máximo é de 24 horas e pode começar num dia e terminar noutro.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;

public class Lt01_EstSeq25 {
    
    public static void main(String args[]){
        
        int Hi, Mi, Hf, Mf, TotalMi, TotalMf, TotalMjogo, Hjogo, Mjogo;
        
        JOptionPane.showMessageDialog(null, "O jogo tem no máximo 24 horas, pode começar em um dia e terminar no outro.\nA seguir você deverá inserir os valores para horas e minutos do dia separadamente.");
        
        /* Recebendo e validando o horário inicial */
        Hi = Integer.parseInt(JOptionPane.showInputDialog("Insira a hora que o jogo começou: "));
        while(Hi > 23 || Hi < 0){
            Hi = Integer.parseInt(JOptionPane.showInputDialog("As horas do dia vão de 0 a 23.\nInsira a hora que o jogo começou: "));
        }
        
        Mi = Integer.parseInt(JOptionPane.showInputDialog("Insira os minutos em que o jogo começou: "));
        while(Mi > 59 || Mi < 0){
            Mi = Integer.parseInt(JOptionPane.showInputDialog("Os minutos vão de 0 a 59.\nInsira os minutos em que o jogo começou: "));
        }
        
        /* Recebendo e validando o horário final */
        Hf = Integer.parseInt(JOptionPane.showInputDialog("Insira a hora que o jogo terminou: "));

        while(Hf > 23 || Hf < 0){
            Hf = Integer.parseInt(JOptionPane.showInputDialog("As horas do dia vão de 0 a 23.\nInsira a hora que o jogo terminou: "));
        }
        Mf = Integer.parseInt(JOptionPane.showInputDialog("Insira os minutos em que o jogo terminou: "));
        while(Mf > 59 || Mf < 0){
            Mf = Integer.parseInt(JOptionPane.showInputDialog("Os minutos vão de 0 a 59.\nInsira os minutos em que o jogo terminou: "));
        }
        
        /* Deixei tudo em minutos para calcular... */
        
        TotalMi = (Hi * 60) + Mi;
        
        TotalMf = (Hf * 60) + Mf;
        
        /*Se a a hora final for maior que a inicial é o caso mais simples...*/
        if(TotalMf > TotalMi){
            
            TotalMjogo = TotalMf - TotalMi;
            
            Hjogo = TotalMjogo / 60;
            Mjogo = TotalMjogo % 60;
            
            JOptionPane.showMessageDialog(null, "A duração do jogo foi de " + Hjogo + " hora(s) e " + Mjogo + " minuto(s).");
            
        }
        
        /*Se a a hora inicial é maior que a final, quer dizer que o jogo começou em um dia e terminou em outro...*/
        else {
            
            /* O dia tem 1440 minutos */
            TotalMjogo = 1440 - TotalMi + TotalMf;
            
            Hjogo = TotalMjogo / 60;
            Mjogo = TotalMjogo % 60;
            
            JOptionPane.showMessageDialog(null, "A duração do jogo foi de " + Hjogo + " hora(s) e " + Mjogo + " minuto(s).");

        }

    }
    
}
