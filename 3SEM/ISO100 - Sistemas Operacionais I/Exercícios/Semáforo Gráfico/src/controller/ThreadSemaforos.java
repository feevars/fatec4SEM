package controller;

import java.util.concurrent.Semaphore;

import view.SemaforoGrafico;

public class ThreadSemaforos extends Thread {
	
	private SemaforoGrafico [] s;
	private Semaphore semaphore = new Semaphore(1);
	private int tempoAberto;
	private boolean status;
	
	public ThreadSemaforos(SemaforoGrafico [] s, int tempoAberto) {
		
		this.s = new SemaforoGrafico[s.length];	
		this.s = s;
		this.tempoAberto = tempoAberto;
	}
	
	
	@Override
	public void run() {
		
		for (int i = 0; i < s.length; i++) {
			try {
				semaphore.acquire();
				s[i].ligaVerde();
				s[i].repaint();
				Thread.sleep(tempoAberto);
				s[i].ligaAmarelo();
				s[i].repaint();
				Thread.sleep(tempoAberto / 4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				s[i].ligaVermelho();;
				s[i].repaint();
				semaphore.release();
			}
			
			if(i == s.length - 1) {
				i = -1;
			}
		}
		
		super.run();
	}
}
