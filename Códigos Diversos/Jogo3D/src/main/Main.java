package main;

import motor.io.Janela;

public class Main implements Runnable{

	public Thread jogo;
	public static Janela janela;
	public static final int LARGURA = 1280, ALTURA = 720;
	
	public void start() {
		jogo = new Thread(this, "Jogo");
		jogo.run();
	}
	
	public static void inicializa() {
		 System.out.println("Iniciando o jogo...");
		 janela = new Janela(LARGURA, ALTURA, "Jogo");
		 janela.cria();
		  
	}
	
	public void run() {
		inicializa();
		while (true) {
			atualiza();
			render();
		}
	}
	
	private void atualiza() {
		System.out.println("Atualizando");
		janela.atualiza();
	}
	
	private void render() {
		System.out.println("Renderizando");
		janela.swapBuffers();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().start();
	}
}
