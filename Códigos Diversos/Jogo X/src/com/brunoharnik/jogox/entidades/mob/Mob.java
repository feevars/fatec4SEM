package com.brunoharnik.jogox.entidades.mob;

import com.brunoharnik.jogox.entidades.Entidade;
import com.brunoharnik.jogox.graficos.Celula;

public abstract class Mob extends Entidade {
	
	protected Celula celula;
	protected int dir = 0;
	protected boolean movendo = false;
	
	public void mover(int xa, int ya) {
		if (xa > 0) dir = 1;
		if (xa < 0) dir = 3;
		if (ya > 0) dir = 2;
		if (ya < 0) dir = 0;
		
		
		
		if (!colisao()) {
			x += xa;
			y += ya;			
		}
	}
	
	public void tick() {
		
	}
	
	private boolean colisao() {
		return false;
	}
	
}
