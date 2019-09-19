package model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Semaforo extends JComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String corLigada;
	public int x;
	public int y;
	public int vermelho = 100;
	public int amarelo = 100;
	public int verde = 100;

	public Semaforo(String corLigada, int x, int y) {
		setBounds(x, y, 60, 170);
		this.setCorLigada(corLigada);
		if (this.getCorLigada() == "Verde") {
			verde = 255;
		}else if(this.getCorLigada() == "Amarelo") {
			amarelo = 255;
		}else {
			vermelho = 255;
		}
	}

	public String getCorLigada() {
		return corLigada;
	}

	public void setCorLigada(String corLigada) {
		this.corLigada = corLigada;
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, 60, 170);
		g.setColor(new Color(vermelho,0,0));
		g.fillOval(x + 5, y + 5, 50, 50);
		
		g.setColor(new Color(amarelo,amarelo,0));
		g.fillOval(x + 5, y + 60, 50, 50);
		
		g.setColor(new Color(0,verde,0));
		g.fillOval(x + 5, y + 115, 50, 50);
		
	}

}
