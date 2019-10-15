package com.brunoharnik.jogox.graficos;

import java.util.Random;

import com.brunoharnik.jogox.niveis.ladrilho.Ladrilho;

public class Tela {

	public int largura, altura;
	public int [] pixels;
	public final int TAMANHO_MAPA = 64;
	public final int MASCARA_TAMANHO_MAPA = TAMANHO_MAPA - 1;
	
	public int deslocamentoX, deslocamentoY;
	
	public int [] ladrilhos = new int[TAMANHO_MAPA * TAMANHO_MAPA];
	
	private Random random = new Random();


	public Tela(int largura, int altura) {
		this.largura = largura;
		this.altura = altura;
		pixels = new int [largura * altura];

		for (int i = 0; i < TAMANHO_MAPA * TAMANHO_MAPA; i++) {

			ladrilhos[i] = random.nextInt(0xFFFFFF);
		}

	}

	public void limpa() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderLadrilho(int xp, int yp, Ladrilho ladrilho) {
		
		xp -= deslocamentoX;
		yp -= deslocamentoY;
		
		for (int y = 0; y < ladrilho.celula.TAMANHO; y++) {
			int ya = y + yp;
			for (int x = 0; x < ladrilho.celula.TAMANHO; x++) {
				int xa = x + xp;
				if (xa < -ladrilho.celula.TAMANHO || xa >= largura || ya < 0 || ya >= altura) break;
				if (xa < 0) xa = 0;
				pixels[xa + ya * largura] = ladrilho.celula.pixels[x + y * ladrilho.celula.TAMANHO];
				
			}
		}
	}
	
	public void renderJogador(int xp, int yp, Celula celula) {
		xp -= deslocamentoX;
		yp -= deslocamentoY;
		
		for (int y = 0; y < 32; y++) {
			int ya = y + yp;
			for (int x = 0; x < 32; x++) {
				int xa = x + xp;
				if (xa < -32 || xa >= largura || ya < 0 || ya >= altura) break;
				if (xa < 0) xa = 0;
				int cor = celula.pixels[x + y * 32];
				if (cor != 0xFFFF00FF) pixels[xa + ya * largura] = cor;
				
			}
		}
	}
	
	public void setDeslocamento(int deslocamentoX, int deslocamentoY) {
		this.deslocamentoX = deslocamentoX;
		this.deslocamentoY = deslocamentoY;
	}
}
