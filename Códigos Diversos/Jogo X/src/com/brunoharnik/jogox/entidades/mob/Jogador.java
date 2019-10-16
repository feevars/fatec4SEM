package com.brunoharnik.jogox.entidades.mob;

import com.brunoharnik.jogox.entrada.Teclado;
import com.brunoharnik.jogox.graficos.Celula;
import com.brunoharnik.jogox.graficos.Tela;

public class Jogador extends Mob {
	
	private Teclado entrada;
	private Celula celula;
	private int anim = 0;
	private boolean andando = false;
	
	
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
		if (anim < 7500)anim++;
		else anim = 0;
		if (entrada.cima) ya--;
		if (entrada.baixo) ya++;
		if (entrada.esquerda) xa--;
		if (entrada.direita) xa++;
		
		
		
		if (xa != 0 || ya != 0) {
			mover(xa, ya);
			andando = true;
		}else {
			andando = false;
		}
	}
	
	public void render(Tela tela) {
		int vira = 0;
		if (dir == 0) {
			celula = Celula.jogador_cima;
			if(andando) {
				if(anim % 20 > 10) {
					celula = Celula.jogador_cima_1;
				}else {
					celula = Celula.jogador_cima_2;
				}
			}
		}
		if (dir == 1) {
			celula = Celula.jogador_lado;
			if(andando) {
				if(anim % 20 > 10) {
					celula = Celula.jogador_lado_1;
				}else {
					celula = Celula.jogador_lado_2;
				}
			}
		}
		if (dir == 2) {
			celula = Celula.jogador_baixo;
			if(andando) {
				if(anim % 20 > 10) {
					celula = Celula.jogador_baixo_1;
				}else {
					celula = Celula.jogador_baixo_2;
				}
			}
		}
		if (dir == 3) {
			celula = Celula.jogador_lado;
			vira = 1;
			if(andando) {
				if(anim % 20 > 10) {
					celula = Celula.jogador_lado_1;
				}else {
					celula = Celula.jogador_lado_2;
				}
			}
		}
		tela.renderJogador(x - 16, y - 16, celula, vira);
	}
	
}
