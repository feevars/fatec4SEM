/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JOptionPane;

public class Lt01_EstDecEncadeada {   
    public static void main (String args[]) {
        int idade; 
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do meliante: "));
    
        if (idade >= 18 && idade <= 76) {
            JOptionPane.showMessageDialog(null,"PODE VOTAR E DIRIGIR");
        }
        else if (idade >= 16 && idade < 18) {
            JOptionPane.showMessageDialog(null,"PODE VOTAR,\nPOREM NAO DIRIGIR");
        }
        else {
            JOptionPane.showMessageDialog(null,"NAO PODE VOTAR, \nNEM DIRIGIR");
        }
    }
}
