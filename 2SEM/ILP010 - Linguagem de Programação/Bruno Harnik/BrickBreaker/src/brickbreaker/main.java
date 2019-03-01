/*
 *************************
Criando um joguinho de BrickBreaker

Programador: Bruno Bega Harnik
 *************************
 */
package brickbreaker;

import javax.swing.JFrame;

public class main {

    public static void main(String[] args) {
        
        JFrame obj = new JFrame();
        Gameplay gamePlay = new Gameplay();
        obj.setBounds(10, 10, 800, 640);
        obj.setTitle("BrickBreaker do Bruninho");
        obj.setResizable(true);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gamePlay);
        
    }
    
}
