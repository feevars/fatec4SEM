package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Semaforo extends JPanel {
	
	private boolean vermelho;
	private boolean amarelo;
	private boolean verde;
	
	private int x;
	private int y;
	
	public void paint(Graphics g) {
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 60, 170);
		
		if (vermelho) {
			g.setColor(new Color(255,0,0));
		}else {
			g.setColor(new Color(50,0,0));
		}
		
		g.fillOval(5,5, 50, 50);

		if (amarelo) {
			g.setColor(new Color(255,255,0));
		}else {
			g.setColor(new Color(50,50,0));
		}
		
		g.fillOval(5,60, 50, 50);
		
		if (verde) {
			g.setColor(new Color(0,255,0));
		}else {
			g.setColor(new Color(0,50,0));
		}
		
		g.fillOval(5,115, 50, 50);
		
		g.dispose();
	}

}
