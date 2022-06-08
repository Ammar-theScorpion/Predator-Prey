package com.ammar.dino.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
 

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import com.ammar.dino.Display;
import com.ammar.dino.entity.Predator;
import com.ammar.dino.gfx.Assets;
import com.ammar.dino.gfx.Text;
import com.ammar.dino.world.World;
 
public class Game implements Runnable, MouseWheelListener{
	private int WIDTH, HEIGHT;
	
	private Display display;
	private Thread thread;
	private BufferStrategy bfs;
	private Graphics g;
	private boolean running;
 	private Road road;
 	private World world;
 
 	public static int xof;
 	public static int yof;
	public Game(int width, int height) {
		Assets.init();
		display = new Display(width, height);
		display.getCanvas().addMouseWheelListener(this);
		display.getFrame().addMouseWheelListener(this);
		world = new World("res/worlds/world.txt", height, width);
		road = new Road(width, height, world.width);
		Predator.E_WIDTH = Predator.E_HEIGHT = (height/world.width)/2 ;
		Text.h=height-100;
		System.err.println(height);
		WIDTH = width;
		HEIGHT = height;
		Text.WIDTH = WIDTH;
		Text.HEIGHT = HEIGHT;

	}
	@Override
	public void run() {
		while(running) {
			render();
			tick();
		}
		stop();
	}
	private void render() {
		bfs = display.getCanvas().getBufferStrategy();
		if(bfs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bfs.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		Text.renderPGraph(g);
		world.render(g);
		Text.render(g, world.predotr_num, world.prey_num); 
		road.render(g);
		bfs.show();
		g.dispose();
	}
	private void tick() {
	 
	}
	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
		/*int a;
		for (int i = 0; i < border.length; i++) {
			for (int j = 0; j < 200; j++)  {
				a = (int)(Math.random()*3);
		 
			if(a==1)
				border[i][j]=new Predator(i*(int)Predator.E_WIDTH,j*(int)Predator.E_HEIGHT);
			else
				border[i][j]=new Prey(i*(int)Predator.E_WIDTH,j*(int)Predator.E_HEIGHT);
			}
		}	*/
	}
	
	private synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.isControlDown())
        {
     
        }
        else
        {
            if (e.getWheelRotation() < 0) {
            	Predator.E_WIDTH-=0.1;
            	Predator.E_HEIGHT-=0.1;
            	
            }else {
            	Predator.E_WIDTH+=0.1;
            	Predator.E_HEIGHT+=0.1;
            	/*xof = Display.atX-WIDTH/2;
            	yof = Display.atY-HEIGHT/2;
                if(xof<0)xof = 0;
                if(yof<0)yof = 0;
                if(xof>world.width*Predator.E_WIDTH-WIDTH)
                	xof = (int)(world.width*Predator.E_WIDTH-WIDTH);   
                if(yof>world.width*Predator.E_HEIGHT-HEIGHT)
                    yof= (int)(world.width*Predator.E_HEIGHT-HEIGHT); */
            }
        }
		
	}
}
