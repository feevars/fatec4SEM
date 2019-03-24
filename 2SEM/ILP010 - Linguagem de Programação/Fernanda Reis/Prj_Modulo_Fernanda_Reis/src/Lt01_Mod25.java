/*
 *************************
Lote 01 - Exercício 25 - Receba a hora de início e de final de um jogo (HH,MM) 
sabendo que o tempo máximo é de 24 horas e pode começar num dia e terminar 
noutro.

Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
 */

import javax.swing.JOptionPane;
public class Lt01_Mod25 {
    public static void main (String args[]) {
   INCOMPLETO  
        int Hi, Hf, Mi, Mf; 
        

            Hi = Integer.parseInt(JOptionPane.showInputDialog("FORMATO 24H \nDigite a hora inicial: "));
            Mi = Integer.parseInt(JOptionPane.showInputDialog("FORMATO 24H \nDigite os minutos iniciais: "));
            Hf = Integer.parseInt(JOptionPane.showInputDialog("FORMATO 24H \nDigite a hora final: "));
            Mf = Integer.parseInt(JOptionPane.showInputDialog("FORMATO 24H \nDigite os minutos finais: "));
        
        
       
            if (Hf > Hi) {       
                Hf = Hf - Hi;    
            }
            else {
                Hi = 24 - Hi;
                /* Hf = Hf */
                Hf = Hi + Hf;
            }
            if (Mi < Mf) {       /* 30 < 50 */
                Mf = Mf - Mi;    /* Mf = 50 - 30 */
            }
            else {
		Hf = Hf - 1;
		Mf = 60 - Mf;
		Mf = Mf + Mi;
            }
            if (Mf >= 60) {
                Hf = Hf + 1;
                Mf = 60 - Mf;
            }
    JOptionPane.showMessageDialog(null, "O tempo total de treino foi de " +Math.abs(Hf) +"h e " +Math.abs(Mf) +"min."); 
    }
}
