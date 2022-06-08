package com.ammar.dino.entity;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.ammar.dino.Display;
import com.ammar.dino.game.Game;
public class Entity {

	protected float width;
	protected float height;
	private BufferedImage image;
 
	public static Entity[] entities = new Entity[3];
	public static Predator predator = new Predator(1);
	public static Prey prey = new Prey();
	public static Ground ground = new Ground();
	public Entity(int id, BufferedImage image, float width,float height) {
		this.image=image;
		this.width = width;
		this.height = height;
		entities[id]=this;
		 
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(image, x-Game.xof, y-Game.yof, (int)Predator.E_WIDTH, (int)Predator.E_HEIGHT, null);
	}
	public void tick() {
	 
			
	};
	
}
