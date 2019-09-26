package controller;

import java.util.concurrent.Semaphore;

public class ThreadSemaforo extends Thread {
	
	Semaforo s;
	Semaphore permissao = new Semaphore(1);
	
	public ThreadSemaforo(Semaforo s) {
		this.s = s;
	}
	
	@Override
	public void run() {
		
		try {
			permissao.acquire();
			System.out.println("Verde");
			this.s.Verde();
			Thread.sleep(3000);
			System.out.println("Amarelo");
			this.s.Amarelo();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("Vermelho");
			this.s.Vermelho();
			permissao.release();
		}
		
	}
	
	
	
}
