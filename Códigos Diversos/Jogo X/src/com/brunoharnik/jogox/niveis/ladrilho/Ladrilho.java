package com.brunoharnik.jogox.niveis.ladrilho;

import com.brunoharnik.jogox.graficos.Celula;
import com.brunoharnik.jogox.graficos.Tela;

public class Ladrilho {
	
	public int x, y;
	public Celula celula;
	
	public static Ladrilho grama = new LadrilhoGrama(Celula.grama);
	public static Ladrilho ladrilhoVazio = new LadrilhoVazio(Celula.celulaVazia);
	
	public Ladrilho(Celula celula) {
		
		this.celula = celula;
		
	}
	
	public void render(int x, int y, Tela tela) {
		
	}
	
	public boolean solido() {
		return false;
	}
	
}
