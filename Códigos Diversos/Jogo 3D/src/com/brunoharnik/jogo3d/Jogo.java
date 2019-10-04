package com.brunoharnik.jogo3d;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.brunoharnik.jogo3d.graficos.Render;
import com.brunoharnik.jogo3d.graficos.Tela;

public class Jogo extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final String TITULO = "Jogo 3D - Pre-Omega v0.01";

	private Thread thread;
	private Tela tela;
	private BufferedImage img;
	private boolean rodando = false;
	private Render render;
	private int [] pixels;

	public Jogo() {
		tela = new Tela(WIDTH,HEIGHT);
		img = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
	}

	private void start() {
		if(rodando)
			return;
		rodando = true;
		thread = new Thread(this);
		thread.start();

	}

	private void stop() {
		if(!rodando)
			return;
		rodando = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void run() {
		while(rodando) {
			tick();
			render();
		}
	}

	private void tick() {

	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		tela.render();
		
		for (int i = 0; i < WIDTH * HEIGHT; i++) {
			pixels[i] = tela.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, WIDTH, HEIGHT, null);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		JFrame quadro = new JFrame();
		quadro.add(jogo);
		quadro.pack();
		quadro.setTitle(TITULO);
		quadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quadro.setSize(WIDTH, HEIGHT);
		quadro.setLocationRelativeTo(null);
		quadro.setResizable(false);
		quadro.setVisible(true);

		System.out.println("Rodando...");

		jogo.start();
	}
}
