package com.ammar.dino.world;

import java.util.Random;

public class data{
	public
	double x, y, oldX, oldY;
	int type, ttl=110, will=-1, tox=-1, toy;
	Random rand=new Random(); 
	public boolean intersects(data other) {
		double distance = Math.sqrt(Math.pow(other.x-x, 2) +
			    Math.pow(other.y-y,2));
		 
 	    return distance <30;
	  }
	
	public void move() {
	    this.x += 1-(int)(Math.random()*3);
	    this.y += 1-(int)(Math.random()*3);
	  }

}