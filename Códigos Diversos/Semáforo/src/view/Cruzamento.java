package view;

import java.awt.Color;

import javax.swing.JFrame;

import controller.Semaforo;

public class Cruzamento {

	public static void main(String[] args) {
		
		JFrame tela = new JFrame();
		Semaforo semaforo = new Semaforo();
		
		tela.setBounds(10, 10, 905, 700);
		tela.setBackground(Color.GRAY);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.add(semaforo);
		
		tela.setVisible(true);

	}

}
