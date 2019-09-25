package controller;

import java.util.concurrent.Semaphore;

public class ThreadSemaforo extends Thread {
	
	private int idThread;
	private Semaphore semaforo;
	
	private int dormir = (int) (Math.random() * 10000);
	private int dormirS = dormir / 1000;
	
	public ThreadSemaforo(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		
		try {
			semaforo.acquire();
			inicioTarefa();
			conta();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			fimTarefa();
			semaforo.release();
		}

	}
	
	private void inicioTarefa() {
		
		System.out.println("A Thread " + idThread + " iniciou e vai dormir por " + dormirS + " segundos.");

	}
	
	private void conta() {
		for (int i = dormirS; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void fimTarefa() {
		System.out.println("A Thread " + idThread + " parou.");
	}

}
