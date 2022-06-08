package com.ammar.dino.quadtree;
 
import java.util.ArrayList;

import com.ammar.dino.quadtree.Rect.Circle;
import com.ammar.dino.quadtree.Rect.Point;
import com.ammar.dino.quadtree.Rect.Rectangle;



public class Quadtree{
	private Rectangle rect;
	private int n;
	private ArrayList<Point> point;
	private boolean divided;
	
	Quadtree noest;
	Quadtree nowest;
	Quadtree soest;
	Quadtree sowest;
	public Quadtree(Rectangle rect, int n) {
		this.rect = rect;
		this.n=n;
		point = new ArrayList<>();
		divided = false;
		
	}
	private void divide() {
		double x = rect.x;
		double y = rect.y;
		double w = rect.width/2;
		double h = rect.height/2;
		Rectangle rect = new Rectangle(x+w, y-h, w, h);
		noest = new Quadtree(rect, n);
		Rectangle rect1 = new Rectangle(x-w, y-h, w, h);
		nowest = new Quadtree(rect1, n);
		Rectangle rect2 = new Rectangle(x+w, y+h, w, h);
		soest = new Quadtree(rect2, n);
		Rectangle rect3 = new Rectangle(x-w, y+h, w, h);
		sowest = new Quadtree(rect3, n);
		divided = true;
	}
	
	public ArrayList<Point> query(Circle range, ArrayList<Point>found) {
		 if(found==null)
			 found=new ArrayList<>();
		if(!range.intersects(rect))
			return found;
		 
			for(Point p:point) {
				if(range.contains(p)) {
					found.add(p);
				}
			}
			if(divided) {
				nowest.query(range, found);
				noest.query(range, found);
				sowest.query(range, found);
				soest.query(range, found);
			}
	  
		return found;
	
	}
	
	public boolean insert(Point point) {
		if(!rect.contains(point))
			return false;
		if(this.point.size()<n) {
			this.point.add(point);
			return true; 
		}
		 
			if(!divided) {
				divide();
			
			}
		 
		if(noest .insert(point) ||nowest.insert(point) || soest .insert(point) || sowest.insert(point))
			return true;
		return false;

	
	}
}