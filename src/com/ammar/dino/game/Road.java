package com.ammar.dino.game;
import java.awt.Graphics;

import com.ammar.dino.Display;
import com.ammar.dino.entity.Predator;
import java.awt.Color;
public class Road {
	private int width;
	private int height;
	private int size;
	public Road(int width, int height, int size) {
		this.width = width;
		this.height = height;
		this.size = size;
	}
 
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		for (int i = 0; i < size; i++) {
//			g.drawLine(0, i* (int)Predator.E_WIDTH-Display.atX, width, i* (int)Predator.E_WIDTH-Display.atY);
//			g.drawLine(i* (int)Predator.E_WIDTH-Display.atX, 0, i* (int)Predator.E_WIDTH-Display.atY, height);
		}
	}
	
	public void tick() {
		
	}
}
