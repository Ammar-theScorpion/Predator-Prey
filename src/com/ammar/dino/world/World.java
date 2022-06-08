package com.ammar.dino.world;
import java.awt.Graphics;
  
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.ammar.dino.Display;
import com.ammar.dino.entity.Entity;
import com.ammar.dino.entity.Predator;
import com.ammar.dino.game.Game;
import com.ammar.dino.quadtree.Quadtree;
import com.ammar.dino.quadtree.Rect.Circle;
import com.ammar.dino.quadtree.Rect.Point;
import com.ammar.dino.quadtree.Rect.Rectangle;


// class d{
//	 int type; int j; int i;
// }
// 
public class World {
	
	public int width;
	private int height;
	public int predotr_num;
	public int prey_num;
	
	public data tiles[][];
//	public d tiles_type[][];
	 Random rand = new Random();
	GenerateWorld generateWorld;
	int h, w;
	int size;
	Quadtree quad;
	public World(String string, int h, int w) {
		generateWorld = new GenerateWorld(string);
		width = generateWorld.width;
		height = generateWorld.height;;
		tiles = new data[width][height];

 //		tiles_type = new d[w][h];
		this.h=h;
		this.w=w;
		try {
			loadWorld(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void render(Graphics g) {
		quad=null;
		quad = new Quadtree(new Rectangle(w/2,h/2,w/2,h/2),4);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int s = (int) ((Predator.E_WIDTH*tiles[j][i].y)-Display.atY); 
				int d = (int) ((Predator.E_WIDTH*tiles[j][i].x)-Display.atX);
				
				if(s<h-130 && d<w&&s>0&&d>0) {
					if(tiles[j][i].type==2)continue;
					parseWorld(j, i).render(g, d, s);
 				}

 				move(j, i);
	 
			}
		}

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				Circle c = new Circle(tiles[j][i].x, tiles[j][i].y, Predator.E_WIDTH/2);
				ArrayList<Point>pointd = quad.query(c, null);
				for(Point p:pointd) {
					 
					data a = p.data;
					if(a!=tiles[j][i]&&tiles[j][i].intersects(a)&&a.type!=tiles[j][i].type && tiles[j][i].type!=2) {
						if(tiles[j][i].type==0) {
							tiles[j][i].type=1;
							prey_num--;
							predotr_num++;
							a.ttl=110;
						}
						else if(a.type==0) {
							a.type=1;
							tiles[j][i].ttl=110;
							prey_num--;
							predotr_num++;
						}
									 
					}
				}
			}
		}
	}    
 
	 
	private void move(int j, int i) {
		data hum=tiles[j][i]; 
 		if(tiles[j][i].tox==-1) {
			 tiles[j][i].tox = rand.nextInt(w);
			 tiles[j][i].toy = rand.nextInt(h);
		}
		 
 				tiles[j][i].ttl--;
 				if(tiles[j][i].ttl<0) {
	 				if(tiles[j][i].type==1) {
	 					if(predotr_num>5) {
	 						tiles[j][i].type=2;
	 						predotr_num--;
	 					}
	 				}
	 				else if(tiles[j][i].type==2) {
	 					tiles[j][i].type=0;
	 					prey_num++; 					
	 				}
 				}
			 
				if(tiles[j][i].type==2)return;

				Point point = new Point(tiles[j][i].x, tiles[j][i].y, tiles[j][i]);
				quad.insert(point);
 
				
					double distanceX = (tiles[j][i].tox-tiles[j][i].x);
					double disctanceY = (tiles[j][i].toy-tiles[j][i].y);
					
					double distance = Math.sqrt(Math.pow(tiles[j][i].tox-hum.x, 2) +
												Math.pow(tiles[j][i].toy-hum.y,2));
					double directionX = distanceX/distance;
					double directionY = disctanceY/distance;
					
				 
 					if(distance<1) {
						tiles[j][i].tox=-1;
						tiles[j][i].toy=-1;
					}
					
					tiles[j][i].x+=directionX;
					tiles[j][i].y+=directionY ;
				 
				return;
				}																																																						
			 
	private Entity parseWorld(int x, int y) {
		return Entity.entities[tiles[x][y].type];
	}
	
	private void loadWorld(String string) throws IOException {
 
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				
				int a = generateWorld.world[j][i];
				tiles[j][i] = new data();
				if(a==1) {
					predotr_num++;
					 
				}
				else
					prey_num++;
			 
				tiles[j][i].type = a;
	 
				tiles[j][i].oldX=tiles[j][i].x=rand.nextInt(h)+30;
				tiles[j][i].oldY=tiles[j][i].y=rand.nextInt(h)+30;
				
			}	
		 
		}
		 
	}
 
}
