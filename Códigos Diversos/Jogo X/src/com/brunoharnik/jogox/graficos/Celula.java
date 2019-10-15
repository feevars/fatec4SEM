package com.brunoharnik.jogox.graficos;

public class Celula {
	
	public final int TAMANHO;
	private int x, y;
	public int [] pixels;
	private Planilha planilha;
	
	public static Celula grama = new Celula(16,0,0, Planilha.ladrilhos);
	public static Celula celulaVazia = new Celula(16, 0x1B8798);
	
	public static Celula jogador_cima = new Celula(32, 0, 5, Planilha.ladrilhos);
	public static Celula jogador_baixo = new Celula(32, 2, 5, Planilha.ladrilhos);
	public static Celula jogador_esquerda = new Celula(32, 3, 5, Planilha.ladrilhos);
	public static Celula jogador_direita = new Celula(32, 1, 5, Planilha.ladrilhos);
	
	
	
	public Celula(int tamanho, int x, int y, Planilha planilha) {
		TAMANHO = tamanho;
		pixels = new int [TAMANHO * TAMANHO];
		this.x = x * tamanho;
		this.y = y * tamanho;
		this.planilha = planilha;
		carrega();
	}
	
	public Celula(int tamanho, int cor) {
		TAMANHO = tamanho;
		pixels = new int[TAMANHO * TAMANHO];
		setCor(cor);
	}
	
	private void setCor(int cor) {
		for (int i = 0; i < TAMANHO * TAMANHO; i++) {
			pixels[i] = cor;
		}
	}

	private void carrega() {
		for (int y = 0; y < TAMANHO; y++) {
			for (int x = 0; x < TAMANHO; x++) {
				pixels[x+y*TAMANHO] = planilha.pixels[(x + this.x) + (y + this.y)*planilha.TAMANHO];
			}
		}
	}
	
}
