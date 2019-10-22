package com.brunoharnik.jogox.niveis;

import java.util.Random;

public class NivelAleatorio extends Nivel{
	
	private static final Random aleatorio = new Random();
	
	public NivelAleatorio(int largura, int altura) {
		super(largura, altura);
		
	}
	
	protected void geraNivel() {
		for (int y = 0; y < altura; y++) {
			for (int x = 0; x < largura; x++) {
				ladrilhosInt[x + y * largura] = aleatorio.nextInt(4);
			}
		}
	}

}
