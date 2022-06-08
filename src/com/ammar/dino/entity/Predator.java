package com.ammar.dino.entity;

import com.ammar.dino.gfx.Assets;
 
public class Predator extends Entity{
	public static float E_WIDTH;
	public static float E_HEIGHT;
	public Predator(int id) {
		super(id, Assets.predaor, E_WIDTH, E_HEIGHT);
		
	}
}
