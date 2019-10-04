package com.brunoharnik.jogo3d.graficos;

public class Render {

	public final int width;
	public final int height;
	public final int [] pixels;

	public Render(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void draw(Render render, int xOffset, int yOffset) {
		for (int y = 0; y < render.height; y++) {
			int yPx = y + yOffset;
			if (yPx < 0 || yPx >= 720) {
				continue;
			}
			for (int x = 0; x < render.width; x++) {
				int xPx = x + xOffset;
				if(xPx < 0 || xPx >= 1280) {
					continue;
				}
				pixels[xPx + yPx * width] = render.pixels[x + y * render.width];
			}
		}
	}
}
