package com.ammar.dino.entity;
 

import com.ammar.dino.gfx.Assets;

public class Prey extends Entity{

	public Prey() {
		super(0, Assets.prey,Predator.E_WIDTH, Predator.E_HEIGHT);
	}

}
