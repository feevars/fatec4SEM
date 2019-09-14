package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SemaforoDesenho extends JComponent {
	
	int x;
	int y;
	
	int vermelho;
	int amarelo;
	int verde;

	public SemaforoDesenho(int x, int y, int vermelho, int amarelo, int verde) {
		setBounds(x, y, 60, 170);
		this.vermelho = vermelho;
		this.amarelo = amarelo;
		this.verde = verde;
		this.setBackground(Color.DARK_GRAY);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color(50,50,50));
		g.fillRect(x, y, 60, 170);
		
		g.setColor(new Color(vermelho,0,0));
		g.fillOval(x + 5, y + 5, 50, 50);
		
		g.setColor(new Color(amarelo,amarelo,0));
		g.fillOval(x + 5, y + 60, 50, 50);
		
		g.setColor(new Color(0,verde,0));
		g.fillOval(x + 5, y + 115, 50, 50);
		
		
	}
	
	

}
