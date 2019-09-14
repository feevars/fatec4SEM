package view;

import javax.swing.JFrame;

import controller.SemaforoDesenho;

public class Cruzamento{
	
	
	public static void main(String[] args) {
		
		int on = 255;
		int off = 200;
		
		SemaforoDesenho [] sd = new SemaforoDesenho[4];
		sd[0] = new SemaforoDesenho(20, 20, on, off, off);
		sd[1] = new SemaforoDesenho(100, 20, on, off, off);
		sd[2] = new SemaforoDesenho(180, 20, on, off, off);
		sd[3] = new SemaforoDesenho(260, 20, on, off, off);
		
		JFrame janela = new JFrame("Semáforo");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		

		janela.add(sd[2]);


		janela.setSize(640,480);
		janela.setVisible(true);
		
		
	}



}
