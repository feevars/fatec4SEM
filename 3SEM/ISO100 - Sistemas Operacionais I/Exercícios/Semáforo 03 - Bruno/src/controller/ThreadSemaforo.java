package controller;

import view.SemaforoDesenho;

public class ThreadSemaforo implements Runnable {

	private SemaforoDesenho desenho;
	private boolean parar;
	private boolean corMudou;
	private int x;
	private int y;
	private int on = 255;
	private int off = 100;

	public ThreadSemaforo() {
		this.desenho = new SemaforoDesenho(x, y, on, off, off);
		new Thread(this).start();
	}

	@Override
	public void run() {

		while(!parar) {
			try {
				Thread.sleep(2000);
				this.mudarCor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	private synchronized void mudarCor() {
		switch (this.cor) {
		case VERMELHO:
			this.cor = CorSemaforo.VERDE;
			break;
		case AMARELO:
			this.cor = CorSemaforo.VERMELHO;
			break;
		case VERDE:
			this.cor = CorSemaforo.AMARELO;
			break;
		default:
			break;
		}
		this.corMudou = true;
		notify();
	}
	
	public synchronized void esperaCorMudar(){
		while(!this.corMudou) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.corMudou = false;
	}
	
	public synchronized void desligarSemaforo() {
		this.parar = true;
	}

	public CorSemaforo getCor() {
		return cor;
	}

}
