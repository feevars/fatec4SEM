package com.brunoharnik.jogox.niveis;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class NivelSpawn extends Nivel {
		
	public NivelSpawn(String caminho) {
		super(caminho);
	}

	protected void carregaNivel(String caminho) {
		try {
			BufferedImage imagem = ImageIO.read(NivelSpawn.class.getResource(caminho));
			int l = largura = imagem.getWidth();
			int a = altura = imagem.getHeight();
			ladrilhos = new int[l * a];
			imagem.getRGB(0, 0, l, a, ladrilhos, 0, a);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exceção!!!\nNão foi possível carregar o arquivo do nível!");
		}
	}
	
	// Grama = 0x00FF00;
	// Flor = 0xFF0000;
	// Pedra = 0x666666;
	protected void geraNivel() {

	}

}
