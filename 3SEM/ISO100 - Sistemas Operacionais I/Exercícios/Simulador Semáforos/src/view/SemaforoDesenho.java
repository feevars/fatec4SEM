package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SemaforoDesenho extends JComponent {
	
	int x;
	int y;
	private String cor;

	public SemaforoDesenho(int x, int y, String cor) {
		setBounds(x, y, 60, 170);
		this.cor = cor;
		this.setBackground(Color.DARK_GRAY);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color(50,50,50));
		g.fillRect(x, y, 60, 170);
		
		if(cor == "VERMELHO ") {
			
			g.setColor(new Color(255,0,0));
			g.fillOval(x + 5, y + 5, 50, 50);
			
			g.setColor(new Color(100,100,0));
			g.fillOval(x + 5, y + 60, 50, 50);
			
			g.setColor(new Color(0,100,0));
			g.fillOval(x + 5, y + 115, 50, 50);
			
		}else if(cor == "AMARELO ") {
			g.setColor(new Color(100,0,0));
			g.fillOval(x + 5, y + 5, 50, 50);
			
			g.setColor(new Color(255,255,0));
			g.fillOval(x + 5, y + 60, 50, 50);
			
			g.setColor(new Color(0,100,0));
			g.fillOval(x + 5, y + 115, 50, 50);
		}else if(cor == "VERDE ") {
			g.setColor(new Color(100,0,0));
			g.fillOval(x + 5, y + 5, 50, 50);
			
			g.setColor(new Color(100,100,0));
			g.fillOval(x + 5, y + 60, 50, 50);
			
			g.setColor(new Color(0,255,0));
			g.fillOval(x + 5, y + 115, 50, 50);
		}
	}
}
