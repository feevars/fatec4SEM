package com.brunoharnik.jogox;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.brunoharnik.jogox.graficos.Tela;

public class Jogo extends Canvas implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static int largura = 320;
	public static int altura = largura / 16 * 9;
	public static int escala = 3;
	
	private Thread thread;
	private JFrame janela;
	private boolean rodando = false;
	
	private Tela tela;
	
	private BufferedImage imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
	private int [] pixels = ((DataBufferInt) imagem.getRaster().getDataBuffer()).getData();
	
	
	public Jogo() {
		Dimension tamanho = new Dimension(largura*escala, altura*escala);
		setPreferredSize(tamanho);

		tela = new Tela(largura, altura);
		
		janela = new JFrame();
	}
	
	
	public synchronized void start() {
		rodando = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	
	public synchronized void stop() {
		rodando = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		while (rodando) {
			tick();
			render();
		}
	}
	
	
	public void tick() {
		
	}
	
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		tela.limpa();
		tela.render();
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = tela.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.drawImage(imagem, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bs.show();
	}
	
	
	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		jogo.janela.setResizable(false);
		jogo.janela.setTitle("Jogo X");
		jogo.janela.add(jogo);
		jogo.janela.pack();
		jogo.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jogo.janela.setLocationRelativeTo(null);
		jogo.janela.setVisible(true);
		
		jogo.start();
	}
}
