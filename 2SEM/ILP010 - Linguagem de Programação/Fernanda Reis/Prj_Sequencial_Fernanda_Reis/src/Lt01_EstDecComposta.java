/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernanda
 */

import javax.swing.JOptionPane;

public class Lt01_EstDecComposta {   
    public static void main (String args[]) {
        int idade; 
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do meliante: "));
    
        if (idade >= 18) {
            JOptionPane.showMessageDialog(null,"MAIOR DE IDADE");
        }
        else {
            JOptionPane.showMessageDialog(null,"MENOR DE IDADE");
        }
    }
}