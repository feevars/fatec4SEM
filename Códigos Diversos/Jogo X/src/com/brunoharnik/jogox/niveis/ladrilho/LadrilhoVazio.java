package com.brunoharnik.jogox.niveis.ladrilho;

import com.brunoharnik.jogox.graficos.Celula;
import com.brunoharnik.jogox.graficos.Tela;

public class LadrilhoVazio extends Ladrilho {

	public LadrilhoVazio(Celula celula) {
		super(celula);
	}
	
	public void render(int x, int y, Tela tela) {
		tela.renderLadrilho(x << 4, y << 4, this);
	}
}
