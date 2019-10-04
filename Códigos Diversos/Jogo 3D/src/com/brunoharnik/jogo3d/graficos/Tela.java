package com.brunoharnik.jogo3d.graficos;

import java.util.Random;

public class Tela extends Render{

	private Render test;

	public Tela(int width, int height) {

		super(width, height);

		Random random = new Random();
		test = new Render(256,256);
		for (int i = 0; i < 256*256; i++) {
			test.pixels[1] = random.nextInt();
		}
	}

	public void render() {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = 0;
		}
		for (int i = 0; i < 100; i++) {
			int anim = (int) ((Math.sin(System.currentTimeMillis() + i) %2000.0/2000)*Math.PI * 0.5) * 200;
			int anim2 = (int) ((Math.cos(System.currentTimeMillis()+ i) %2000.0/2000)*Math.PI * 0.5) * 200;
			draw(test, 24 + anim,(height-256) / 2 - anim2);
		}
		
	}

}
