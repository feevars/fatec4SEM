package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import controller.ThreadSemaforos;

public class PainelSemaforos extends JPanel {
	
	private SemaforoGrafico [] sg;
	
	ThreadSemaforos ts;

	public PainelSemaforos(int quantidade, int tempoAberto) {
				
		setLayout(new GridLayout(0, quantidade));
		setBackground(new Color(100,100,100));
		
		this.sg = new SemaforoGrafico[quantidade];
		
		for (int i = 0; i < quantidade; i++) {
			sg[i] = new SemaforoGrafico();
			add(sg[i]);
		}
		
		ts = new ThreadSemaforos(sg, tempoAberto);

		
	}
	

}
