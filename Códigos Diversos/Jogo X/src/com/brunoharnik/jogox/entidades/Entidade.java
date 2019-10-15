package com.brunoharnik.jogox.entidades;

import java.util.Random;

import com.brunoharnik.jogox.graficos.Tela;
import com.brunoharnik.jogox.niveis.Nivel;

public abstract class Entidade {
	
	public int x, y;
	private boolean removido = false;
	protected Nivel nivel;
	protected final Random aleatorio = new Random();
	
	
	public void tick() {
		
	}
	
	public void render(Tela tela) {
		
	}
	
	public void remove() {
		
		removido = true;
	}
	
	public boolean isRemovido() {
		return removido;
	}
	
	
}
