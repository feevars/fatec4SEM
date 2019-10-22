package com.brunoharnik.jogox;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.brunoharnik.jogox.entidades.mob.Jogador;
import com.brunoharnik.jogox.entrada.Teclado;
import com.brunoharnik.jogox.graficos.Tela;
import com.brunoharnik.jogox.niveis.Nivel;
import com.brunoharnik.jogox.niveis.NivelAleatorio;
import com.brunoharnik.jogox.niveis.NivelSpawn;

public class Jogo extends Canvas implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static int largura = 320;
	public static int altura = largura / 16 * 9;
	public static int escala = 4;
	
	public static String titulo = "Jogo X";
	
	private Thread thread;
	private JFrame janela;
	private Teclado tecla;
	private Nivel nivel;
	private Jogador jogador;
	private boolean rodando = false;
	
	private Tela tela;
	
	private BufferedImage imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
	private int [] pixels = ((DataBufferInt) imagem.getRaster().getDataBuffer()).getData();
	
	
	public Jogo() {
		Dimension tamanho = new Dimension(largura*escala, altura*escala);
		setPreferredSize(tamanho);

		tela = new Tela(largura, altura);
		janela = new JFrame();
		tecla = new Teclado();
		nivel = new NivelSpawn("/texturas/nivel.png");
		jogador = new Jogador(64, 64, tecla);
		addKeyListener(tecla);
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
		
		long ultimoTempo = System.nanoTime();
		long temporizador = System.currentTimeMillis();
		
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		
		int quadros = 0;
		int atualizacoes = 0;
			
		requestFocus();
		
		while (rodando) {
			
			long agora = System.nanoTime();
			delta += (agora-ultimoTempo) / ns;
			ultimoTempo = agora;
			while (delta >= 1) {
				tick();
				atualizacoes++;
				delta--;
			}
			render();
			quadros++;
			
			if (System.currentTimeMillis() - temporizador > 1000) {
				temporizador += 1000;
				System.out.println();
				janela.setTitle(titulo + " — " + atualizacoes + " ups, " + quadros + " fps");
				atualizacoes = 0;
				quadros = 0;
			}
		}
	}
		
	public void tick() {
		tecla.tick();
		jogador.tick();
	}
	
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		tela.limpa();
		int rolamentoX = jogador.x - tela.largura / 2;
		int rolamentoY = jogador.y - tela.altura / 2;
		nivel.render(rolamentoX, rolamentoY, tela);
		jogador.render(tela);
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = tela.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.drawImage(imagem, 0, 0, getWidth(), getHeight(), null);
		
		g.setColor(Color.RED);
		g.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		g.drawString("X: " + jogador.x + ", Y: " + jogador.y, 15, 30);
		
		g.dispose();
		bs.show();
	}
	
	
	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		jogo.janela.setResizable(false);
		jogo.janela.setTitle(Jogo.titulo);
		jogo.janela.add(jogo);
		jogo.janela.pack();
		jogo.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jogo.janela.setLocationRelativeTo(null);
		jogo.janela.setVisible(true);
		
		jogo.start();
	}
}
