package com.ammar.dino.entity;

import com.ammar.dino.gfx.Assets;

public class Ground extends Entity{

	public Ground() {
		super(2, Assets.ground, Predator.E_WIDTH, Predator.E_HEIGHT);
	}

}
