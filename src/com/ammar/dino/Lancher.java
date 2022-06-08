package com.ammar.dino;
 

import com.ammar.dino.game.Game;
import java.awt.Dimension;


public class Lancher {
	public static void main(String[] args)
	{
		Dimension s = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		System.err.println(s.getHeight());
		new Game((int) s.getWidth(), (int)s.getHeight()).start();
	}

}
