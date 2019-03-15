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
        //Título na janela
        obj.setTitle("BrickBreaker do Bruninho");
        //Não pode redimensionar
        obj.setResizable(false);
        //Quando clica no X fecha...
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Adiciona o objeto Gameplay
        obj.add(gamePlay);
        //Define o tamanho da janela (x, y, width, height)
        obj.setBounds(10, 10, 700, 600);
        //Posiciona no meio da tela a janela
        obj.setLocationRelativeTo(null);
        //Coloca o visible no final pra carregar tudo antes e não dar pau
        obj.setVisible(true);
    }
    
}
