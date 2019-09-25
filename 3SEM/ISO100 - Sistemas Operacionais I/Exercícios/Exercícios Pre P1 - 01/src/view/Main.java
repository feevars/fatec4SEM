package view;

import java.util.concurrent.Semaphore;

import controller.ThreadProcesso;

public class Main {

	public static void main(String[] args) {

		int qtdSimultanea = 1;
		
		Semaphore permissao = new Semaphore(qtdSimultanea);
		
		for (int idProcesso = 0; idProcesso < 20; idProcesso++) {
			Thread processo = new ThreadProcesso(idProcesso, permissao);
			processo.start();
		}
		
	}

}
