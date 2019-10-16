package com.brunoharnik.jogox.niveis.ladrilho;

import com.brunoharnik.jogox.graficos.Celula;
import com.brunoharnik.jogox.graficos.Tela;

public class LadrilhoPedra extends Ladrilho {

	public LadrilhoPedra(Celula celula) {
		super(celula);
	}
	
	public void render(int x, int y, Tela tela) {
		tela.renderLadrilho(x << 4, y << 4, this);
	}
	
	public boolean solido() {
		return true;
	}

}
