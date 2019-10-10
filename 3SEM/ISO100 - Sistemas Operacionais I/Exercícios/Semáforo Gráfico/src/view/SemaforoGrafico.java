package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SemaforoGrafico extends JComponent {
	
	private Color vermelho;
	private Color amarelo;
	private Color verde;
	
	public SemaforoGrafico() {
		super();
		vermelho = new Color(250,0,0);
		amarelo = new Color(120,120,0);
		verde = new Color(0,120,0);
	}
	
	public void ligaVermelho() {
		vermelho = new Color(250,0,0);
		amarelo = new Color(120,120,0);
		verde = new Color(0,120,0);
	}
	
	public void ligaAmarelo() {
		vermelho = new Color(120,0,0);
		amarelo = new Color(250,250,0);
		verde = new Color(0,120,0);
	}
	
	public void ligaVerde() {
		vermelho = new Color(120,0,0);
		amarelo = new Color(120,120,0);
		verde = new Color(0,250,0);
	}
	
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(10, 0, 60, 170);
		
		g.setColor(vermelho);
		g.fillOval(15, 5, 50, 50);

		g.setColor(amarelo);
		g.fillOval(15, 60, 50, 50);
		
		g.setColor(verde);
		g.fillOval(15, 115, 50, 50);
		
		g.dispose();
		
	}
}
