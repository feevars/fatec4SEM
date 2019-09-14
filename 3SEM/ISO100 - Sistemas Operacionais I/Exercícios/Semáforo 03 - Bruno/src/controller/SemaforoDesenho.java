package controller;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class SemaforoDesenho extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int x;
	int y;
	
	int vermelho;
	int amarelo;
	int verde;
	
	
	



	public SemaforoDesenho(int x, int y, int vermelho, int amarelo, int verde) {
		super();
		this.x = x;
		this.y = y;
		this.vermelho = vermelho;
		this.amarelo = amarelo;
		this.verde = verde;
	}






	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.GRAY);
		
		g.setColor(new Color(50,50,50));
		g.fillRect(x, y, 60, 160);
		
		g.setColor(new Color(vermelho,0,0));
		g.fillOval(x + 5, y + 5, 50, 50);
		
		g.setColor(new Color(amarelo,amarelo,0));
		g.fillOval(x + 5, y + 55, 50, 50);
		
		g.setColor(new Color(0,verde,0));
		g.fillOval(x + 5, y + 105, 50, 50);
		
		
	}

}
