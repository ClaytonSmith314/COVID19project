package main;

import java.awt.Graphics;

public interface Renderable extends Tick{
	public void render(Graphics g, double zoom);
}
