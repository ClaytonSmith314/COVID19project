package main;

import java.awt.Graphics;

public abstract class Sprite implements Renderable{
	
	protected GameControl control;
	protected UserInput input;
	
	public Sprite(){
		this.control = GameControl.controler;
		this.input = control.input;
		
		control.screen.addRenderable(this, 1.0);
		Tick.addTicker(this, 1);
	}
	public Sprite(double renderP, int tickP){
		this.control = GameControl.controler;
		this.input = control.input;
		
		control.screen.addRenderable(this, renderP);
		Tick.addTicker(this, tickP);
	}
	
	public abstract void tick();

	public abstract  void render(Graphics g, double zoom);
}
