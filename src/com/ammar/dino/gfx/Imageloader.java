package com.ammar.dino.gfx;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class Imageloader {
	public static BufferedImage load(String string) {
		try {
			return ImageIO.read(Imageloader.class.getResource(string));
		}catch(Exception e) {
			
		}
		return null;
	}
}
