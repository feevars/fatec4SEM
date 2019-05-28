/*
 *************************
Lote 01 - Exercício 12 - Receba o ano de nascimento e o ano atual. 
Calcule e mostre a sua idade e quantos anos terá daqui a 17 anos.
Programador: Fernanda Pinheiro Reis
Professor: Ricardo Satoshi
 *************************
*/

 
import javax.swing.JOptionPane;
public class Lt01_EstSeq12 {
    

public static void main (String args[]) 
    {
    int nasc, atual, idade;
    
    nasc = Integer.parseInt(JOptionPane.showInputDialog("Digite seu ano de nascimento: "));
    atual = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano atual: "));
    atual = atual - nasc;
    idade = atual + 17;
    
        
    JOptionPane.showMessageDialog(null,"Você tem " +atual +" anos e terá " +idade +" anos daqui 17 anos.");
    
    }
}
   
