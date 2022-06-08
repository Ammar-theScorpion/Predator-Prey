package com.ammar.dino.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
class Point{
	public Point(double x, double y) {
		this.x=x;
		this.y=y;
	}
	double x,y;
}
public class Text {
	public static int HEIGHT;
	public static int WIDTH;
	public static int originPredator;
	private static double x=200;
	private static ArrayList<Point> predotr= new ArrayList<>();
	private static ArrayList<Point> predotr2= new ArrayList<>();

	public static int predor_num;
	public static int h;
	public static void render(Graphics g, int predor_num, int prey_num) {
		g.setColor(Color.WHITE);
		g.fillRect(0, HEIGHT-125, WIDTH, 6); 
		g.setColor(Color.MAGENTA);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("PREDATORS: "+String.valueOf(predor_num), 10, HEIGHT-100);
		g.setColor(Color.WHITE);
		g.drawString("PREYS: "+String.valueOf(prey_num), WIDTH-g.getFontMetrics().stringWidth("PREYS: "+String.valueOf(prey_num))-30, HEIGHT-100);
	}
	
	public static void renderPGraph(Graphics g) {
 		predotr.add(new Point(x, Math.sin(x*3.14/180)));
 		predotr2.add(new Point(x, Math.cos(x*3.14/180)));

 		x+=0.1;
 		int i=0;
 		for(Point p: predotr) {
 			g.setColor(Color.MAGENTA);

				g.drawLine((int)p.x, h, (int)(p.x), h); 

				g.drawLine((int)p.x, (int)(h-(p.y*20)), (int)(p.x), (int)(h-(p.y*20))); 
				
				g.setColor(Color.WHITE);
				g.drawLine((int)p.x, (int)(h-(predotr2.get(i).y*20)), (int)(p.x), (int)(h-(predotr2.get(i).y*20))); 
				i++;

				
		}
		
	}
	
}
