package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Semaforo;
import controller.SemaforoController;

public class Cruzamento extends JFrame {

	public static void main(String[] args) {
		
		int qtd = 4;
		
		JPanel conteudo = new JPanel();
		conteudo.setLayout( new GridLayout(1, qtd + 1) );
		
		Semaforo [] semaforo = new Semaforo[qtd];
		for (int i = 0; i < qtd; i++) {
			semaforo[i] = new Semaforo();
			conteudo.add(semaforo[i]);
		}
		
		JButton botao = new JButton("Liga/Desliga");
		botao.setSize(400, 50);
		
		conteudo.add(botao);
		
		SemaforoController semaforoController = new SemaforoController(botao, semaforo);
		botao.addActionListener(semaforoController);
		
		Cruzamento c = new Cruzamento();
		c.getContentPane().add(conteudo);
		c.setVisible(true);
		
	}
	
	public Cruzamento() {

		this.setBackground(Color.GRAY);
		this.setResizable(true);
		this.setSize(600, 200);
		this.setMinimumSize(getSize());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
