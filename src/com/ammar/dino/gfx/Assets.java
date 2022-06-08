package com.ammar.dino.gfx;
import java.awt.image.BufferedImage;
public class Assets {

	public static final int Predator_width=96, Predator_height=96;
	public static final int Prey_width=40, Prey_height=45;
	public static BufferedImage predaor;
	public static BufferedImage prey;
	public static BufferedImage ground;
	public static void init() {
		Spritesheet spritSheet = new Spritesheet(Imageloader.load("/texture/mostersheet.png"));
		predaor = spritSheet.crop(0, 0, Predator_width, Predator_height);
		
		Spritesheet spritSheet1 = new Spritesheet(Imageloader.load("/texture/prey1.jpg"));
		prey = spritSheet1.crop(0, 0, Prey_width, Prey_height);
		
		Spritesheet spritSheet2 = new Spritesheet(Imageloader.load("/texture/ground.jpg"));
		ground = spritSheet2.crop(2, 2, Predator_width, Predator_height);
	}
}
