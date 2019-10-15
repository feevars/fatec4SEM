package com.brunoharnik.jogox.entrada;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

	private boolean [] teclas = new boolean[120];
	public boolean cima, baixo, esquerda, direita;

	public void tick() {
		cima = teclas[KeyEvent.VK_UP] || teclas[KeyEvent.VK_W];
		baixo = teclas[KeyEvent.VK_DOWN] || teclas[KeyEvent.VK_S];
		esquerda = teclas[KeyEvent.VK_LEFT] || teclas[KeyEvent.VK_A];
		direita = teclas[KeyEvent.VK_RIGHT] || teclas[KeyEvent.VK_D];
	}


	@Override
	public void keyPressed(KeyEvent e) {
		teclas[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		teclas[e.getKeyCode()] = false;
	}	

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
