package com.brunoharnik.jogox.graficos;

public class Tela {
	
	private int largura, altura;
	public int [] pixels;
	
	int tempoX = 0, tempoY = 0, contador = 0;
	
	public Tela(int largura, int altura) {
		this.largura = largura;
		this.altura = altura;
		pixels = new int [largura * altura];
	}
	
	public void limpa() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	
	
	public void render() {
		contador++;
		if (contador % 100 == 0) tempoX++;
		if (contador % 800 == 0) tempoY++;
		
		for (int y = 0; y < altura; y++) {
			for (int x = 0; x < largura; x++) {
				pixels[tempoX + tempoY *largura] = 0xFF00FF;
			}
		}
	}
}
