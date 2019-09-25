package view;

import java.util.concurrent.Semaphore;

import controller.ThreadSemaforo;

public class Main {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		
		for (int i = 1; i <= 20; i++) {
			ThreadSemaforo t = new ThreadSemaforo(i, semaforo);
			t.start();
		}

	}

}
