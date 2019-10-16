package com.brunoharnik.jogox.niveis;

import com.brunoharnik.jogox.graficos.Tela;
import com.brunoharnik.jogox.niveis.ladrilho.Ladrilho;

public class Nivel {
	
	protected int largura, altura;
	protected int [] ladrilhos;
	
	public Nivel(int largura, int altura) {
		this.largura = largura;
		this.altura = altura;
		ladrilhos = new int[largura * altura];
		geraNivel();
	}
	
	
	public Nivel (String caminho) {
		carregaNivel(caminho);
	}
	
	protected void geraNivel() {
		
	}
	
	private void carregaNivel(String caminho) {
		
	}
	
	public void tick() {
		
	}
	
	private void tempo() {
		
	}
	
	public void render(int rolamentoX, int rolamentoY, Tela tela) {
		tela.setDeslocamento(rolamentoX, rolamentoY);
		int x0 = rolamentoX >> 4;
		int x1 = (rolamentoX + tela.largura + 16) >> 4;
		int y0 = rolamentoY >> 4;
		int y1 = (rolamentoY + tela.altura + 16) >> 4;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getLadrilho(x, y).render(x, y, tela);
			}
		}
	}
	
	public Ladrilho getLadrilho(int x, int y) {
		if (x < 0 || y < 0 || x >= largura || y >= altura) return Ladrilho.ladrilhoVazio;
		if (ladrilhos[x + y * largura] == 0) return Ladrilho.grama;
		if (ladrilhos[x + y * largura] == 1) return Ladrilho.flor;
		if (ladrilhos[x + y * largura] == 2) return Ladrilho.pedra;
		return Ladrilho.ladrilhoVazio;
	}
	
	
}
