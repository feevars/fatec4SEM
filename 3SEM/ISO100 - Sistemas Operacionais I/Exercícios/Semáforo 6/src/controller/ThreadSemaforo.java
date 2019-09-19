package controller;

import java.util.concurrent.Semaphore;

import model.Semaforo;

public class ThreadSemaforo implements Runnable {
	
	private boolean parar;
	private boolean corMudou;
	private Semaforo s;
	private Semaphore semaforo;
	
	public ThreadSemaforo() {
		new Thread(this).start();
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.s = new Semaforo("Verde", 20, 20);

		try {
			semaforo.acquire();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
	}

}
