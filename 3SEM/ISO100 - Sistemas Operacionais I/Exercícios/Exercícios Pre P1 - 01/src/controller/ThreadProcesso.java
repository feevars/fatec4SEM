package controller;

import java.util.concurrent.Semaphore;

public class ThreadProcesso extends Thread {

	private int idProcesso;
	private Semaphore permissao;
	
	public ThreadProcesso(int idProcesso, Semaphore permissao) {
		this.idProcesso = idProcesso;
		this.permissao = permissao;
	}
	
	@Override
	public void run() {
		
		
		try {
			permissao.acquire();
			processoRolando();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			permissao.release();
			processoParou();
		}
		
	}
	
	private void processoRolando() {
		int dormir = (int) (Math.random() * 116000) + 4000;
		
		System.out.println("O processo " + idProcesso + " está rolando e vai dormir por " + dormir + " milisegundos.");
		
		try {
			Thread.sleep(dormir);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void processoParou() {
		System.out.println("O processo " + idProcesso + " parou.");
	}

}
