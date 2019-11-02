package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MenuInicial extends JFrame {

	private static final long serialVersionUID = 9043794852348744311L;
	
	public MenuInicial() {
		
		this.setLayout(new BorderLayout());
		this.setSize(600, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
