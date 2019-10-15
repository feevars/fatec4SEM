package com.brunoharnik.jogox.graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Planilha {
	
	private String caminho;
	public final int TAMANHO;
	public int [] pixels;
	
	public static Planilha ladrilhos = new Planilha("/texturas/planilha.png", 256);
	
	public Planilha(String caminho, int tamanho) {
		this.caminho = caminho;
		this.TAMANHO = tamanho;
		pixels = new int [TAMANHO * TAMANHO];
		carrega();
	}
	
	private void carrega() {
		try {
			BufferedImage imagem = ImageIO.read(Planilha.class.getResource(caminho));
			int w = imagem.getWidth();
			int h = imagem.getHeight();
			imagem.getRGB(0, 0, w, h, pixels, 0, TAMANHO);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
