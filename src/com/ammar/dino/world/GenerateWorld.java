package com.ammar.dino.world;
 
public class GenerateWorld {

	public  int width, height, size;
	private int min = 200;
	private int max = 250;
	public int [][]world;
	public GenerateWorld(String string) {
		generateWorld(string);
	}
	public void generateWorld(String string) {
		height=width =  (int)(Math.random()*(max-min)+min);
 
 
		world = new int[width][height];
	 
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) { 
					world[j][i]=(int)(Math.random()*2);
				}
			}	
	 
	}
}
		
