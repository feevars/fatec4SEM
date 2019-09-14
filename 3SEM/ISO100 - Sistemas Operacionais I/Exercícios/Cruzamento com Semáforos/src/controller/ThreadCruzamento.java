package controller;

import view.SemaforoDesenho;

public class ThreadCruzamento implements Runnable {
	
	private int qtdSemaforos;
	private int tempo;
	private SemaforoDesenho [] semaforos;
	private int x = 20;
	private int on = 255;
	private int off = 100;
	
	public ThreadCruzamento(int qtdSemaforos, int tempo) {
		this.qtdSemaforos = qtdSemaforos;
		this.tempo = tempo;
		this.semaforos = new SemaforoDesenho[qtdSemaforos];
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run() {
		for(int i = 0; i < qtdSemaforos; i++) {
			semaforos[i] = new SemaforoDesenho(x, 20, on, off, off);
			x += 80;
		}
	}
}
