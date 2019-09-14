package controller;

import javax.swing.JButton;

public class ThreadSemaforo implements Runnable{

	private CorSemaforo cor;
	private boolean parar;
	private boolean corMudou;
	private JButton btnIniciar;
	

	public ThreadSemaforo(JButton btnIniciar) {
		this.cor = CorSemaforo.VERMELHO;

		this.parar = false;
		this.corMudou = false;
		this.btnIniciar = btnIniciar;
		new Thread(this).start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!parar) {
			try {
				Thread.sleep(cor.getTempoEspera());
				this.mudarCor();
			} catch (Exception e) {
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
	
	public synchronized void esperaCorMudar() {
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
	
	public synchronized void ligarSemaforo() {
		this.parar = false;
	}

	public boolean isParar() {
		return parar;
	}

	public CorSemaforo getCor() {
		return cor;
	}
	
	
}
