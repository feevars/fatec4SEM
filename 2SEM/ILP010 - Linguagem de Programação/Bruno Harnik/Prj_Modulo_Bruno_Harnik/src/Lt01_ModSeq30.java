/*
 *************************
Lote 01 - Exercício 30
Receba a data de nascimento e atual em ano, mês e dia.
Calcule e mostre a idade em anos, meses e dias, considerando os anos bissextos.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */
import javax.swing.JOptionPane;

public class Lt01_ModSeq30 {
    
    public static void main(String args[]){
        
        //Variáveis para data Atual e data Final
        int AN, MN = 0, DN = 0, AA = 0, MA = 0, DA = 0;
        
        //Data nascimento
        //Ano Nascimento
        AN = Integer.parseInt(JOptionPane.showInputDialog("Ano de nascimento: "));
        
        while(MN < 1 || MN > 12){
            
            //Mês Nascimento
            MN = Integer.parseInt(JOptionPane.showInputDialog("Mês de nascimento: "));
            
        }
        while(DN < 1 || DN > DiasNoMes(MN,AN)){
            
            //Dia Nascimento
            DN = Integer.parseInt(JOptionPane.showInputDialog("Dia de nascimento: "));
            
        }
        
        
        //Data atual
        AA = Integer.parseInt(JOptionPane.showInputDialog("Ano atual: "));
        MA = Integer.parseInt(JOptionPane.showInputDialog("Mês atual: "));
        DA = Integer.parseInt(JOptionPane.showInputDialog("Dia atual: "));
        
        
    
    }
    
    //Função que verifica se o ano é bissexto
    public static boolean VerificaBissexto(int ano){
        
        //Se o ano é divisível por 400, ou se o ano é divisível por 4 mas não é divisível por 100, retorna TRUE.
        return (ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0));
        
    }
    
    public static int DiasNoMes(int mes, int ano){
        
        if(mes == 1 || mes ==  3 || mes ==  5 || mes ==  7 || mes ==  8 || mes ==  10 || mes ==  12){
            
            return 31;
            
        }else if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
            
            return 30;
            
        }else if(mes == 2 && VerificaBissexto(ano) == true){
            
            return 29;
            
        }else{
            
            return 28;
            
        }
        
    }
   
}