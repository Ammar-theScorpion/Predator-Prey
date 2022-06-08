package com.ammar.dino.quadtree.Rect;

public class Circle {
	private double x,y,r,rSquared;
	  public Circle(double x, double y, double r) {
	    this.x = x;
	    this.y = y;
	    this.r = r;
	    this.rSquared = this.r * this.r;
	  }

	  public boolean contains(Point point) {
	    // check if the point is in the circle by checking if the euclidean distance of
	    // the point and the center of the circle if smaller or equal to the radius of
	    // the circle
	    double d = Math.pow((point.x - this.x), 2) + Math.pow((point.y - this.y), 2);
	    return d <= this.rSquared;
	  }

	  public boolean intersects(Rectangle range) {
		double xDist = Math.abs(range.x - this.x);
	    double yDist = Math.abs(range.y - this.y);

	    // radius of the circle
	    double r = this.r;

	    double w = range.width;
	    double h = range.height;

	    double edges = Math.pow(xDist - w, 2) + Math.pow(yDist - h, 2);

	    // no intersection
	    if (xDist > (r + w) || yDist > (r + h)) return false;

	    // intersection within the circle
	    if (xDist <= w || yDist <= h) return true;

	    // intersection on the edge of the circle
	    return edges <= this.rSquared;
	  }
	}