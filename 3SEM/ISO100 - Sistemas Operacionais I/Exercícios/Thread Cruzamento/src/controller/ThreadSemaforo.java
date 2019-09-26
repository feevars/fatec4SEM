package controller;

import java.util.concurrent.Semaphore;

public class ThreadSemaforo implements Runnable{
	
	private boolean running = false;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		running = true;
		synchronized(this) {
			int i = 0;
			String [] sequencia = {"Vermelho","Verde","Amarelo","Vermelho"};
			while(running) {
				i++;
			}
		}
	}

	
}
