package dev.brunoharnik.jogoladrilhos;

public class Launcher {

	public static void main (String[] args) {
		Game game = new Game("Jogo dos Ladrilhos", 640, 640);
		game.start();
	}
	
}
