package com.brunoharnik.jogox.entidades.mob;

import com.brunoharnik.jogox.entrada.Teclado;
import com.brunoharnik.jogox.graficos.Celula;
import com.brunoharnik.jogox.graficos.Tela;

public class Jogador extends Mob {
	
	private Teclado entrada;
	private Celula celula;
	
	
	public Jogador(Teclado entrada) {
		this.entrada = entrada;
		celula = celula.jogador_cima;
	}
	
	public Jogador(int x, int y, Teclado entrada) {
		this.x = x;
		this.y = y;
		this.entrada = entrada;
	}
	
	public void tick() {
		int xa = 0, ya = 0;
		if (entrada.cima) ya--;
		if (entrada.baixo) ya++;
		if (entrada.esquerda) xa--;
		if (entrada.direita) xa++;
		
		if (xa != 0 || ya != 0) mover(xa, ya);
	}
	
	public void render(Tela tela) {
		if (dir == 0) celula = celula.jogador_cima;
		if (dir == 1) celula = celula.jogador_direita;
		if (dir == 2) celula = celula.jogador_baixo;
		if (dir == 3) celula = celula.jogador_esquerda;
		tela.renderJogador(x - 16, y - 16, celula);
	}
	
}
