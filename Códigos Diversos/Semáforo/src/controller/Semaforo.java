package controller;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Semaforo extends JPanel {
	
	private boolean vermelho;
	private boolean amarelo;
	private boolean verde;
	
	private Rectangle fundo = new Rectangle(0, 0, 60, 170);
	private Ellipse2D circulo = new Ellipse2D.Double(0,0,50,50);

	
	public void paint(Graphics g) {
		
		
	}

}
