/*
 *************************
Lote 01 - Exercício 12
Receba o ano de nascimento e o ano atual.
Calcule e mostre a sua idade e quantos anos terá daqui a 17 anos.

Programador: Bruno Bega Harnik
Professor: Ricardo Satoshi
 *************************
 */ 

import javax.swing.JOptionPane;

public class Lt01_EstSeq12 {
    
    public static void main (String args[]){
        
        int ano_nasc, ano_atual, idade, idade17;
        
        ano_nasc = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento: "));
        
        ano_atual = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano atual: "));
        
        idade = ano_atual - ano_nasc;
        
        idade17 = idade + 17;
        
        JOptionPane.showMessageDialog(null, "A idade atual é " + idade + " e em 17 anos terá " + idade17);
    }
}
