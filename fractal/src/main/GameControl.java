package main;

import specific.*;

//Fractal

public class GameControl implements Runnable{
	
	public static GameControl controler;
	
	private final boolean inDeveloperMode = false;
	
	public String font = "OCR A Extended";
	
	public Thread thread;
	public UserInput input;
	public Window window;
	public Screen screen;
	public CoordinatePlane coordinateplane;
	public Set picture;
	
	private boolean running;
	
	public static void main(String[] args){
		new GameControl();
	}
	
	public GameControl(){
		GameControl.controler = this;
		
		input = new UserInput();
		window = new Window();
		screen = new Screen();
		coordinateplane = new CoordinatePlane(-1.5,1,1.5,-1.5,true);
		
		if (inDeveloperMode){
			new ColorViewer();
			start();
		}
		else {
			picture = new Set();
			new Zoomer();
			start();
		}
	}
		
	public void run(){
		long lastTime = System.nanoTime();
		double amountOfTicks = 100.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				Tick.tickAll();
				delta--;
			}
			if (running)
				render();
		}
		stop();
	}
	
	private void render(){
		window.render();
	}
		
	public synchronized void start(){
		if (thread == null) thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		running = false;
	}
	
}
