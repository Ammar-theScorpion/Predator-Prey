package com.ammar.dino.gfx;

import java.awt.image.BufferedImage;
public class Spritesheet {

	private BufferedImage bufferedImage;
	public Spritesheet(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
	
	public BufferedImage crop(int startX, int startY, int width, int height) {
		return bufferedImage.getSubimage(startX, startY, width, height);
	}
}
