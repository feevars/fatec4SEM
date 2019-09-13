package view;

import controller.ThreadSemaforo;

public class Semaforo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadSemaforo semaforo = new ThreadSemaforo();
		
		for (int i=0; i<10; i++) {
			System.out.println(semaforo.getCor());
			semaforo.esperaCorMudar();
		}
		
		semaforo.desligarSemaforo();
	}

}
