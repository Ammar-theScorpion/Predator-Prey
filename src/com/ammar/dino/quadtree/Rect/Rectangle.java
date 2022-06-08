package com.ammar.dino.quadtree.Rect;

 

public class Rectangle{
	public double x, y, width, height;
	public Rectangle(double x, double y, double w, double h) {
		this.x = x;
		this.y=y;
		this.width=w;
		this.height=h;
	}
	public boolean contains(Point point) {
		return(point.x>=x-width && 
				point.x<=x+width&&
				point.y>=y-height&&
				point.y<=y+height);
	}
	
	public boolean intersects(Rectangle range) {
		return !(range.x-range.width>x+width ||
				 range.x+range.width<x-width ||
				 range.y-range.height>y+height ||
				 range.y+range.height<y-height);
	}
}