package specific;

import java.awt.Color;
import java.awt.Graphics;

import main.*;

public class Zoomer extends Sprite{
	private boolean dragging = false;
	private int x, y;
	private double XYratio;
	
	private Color color = Color.YELLOW;
	
	public Zoomer(){
		super(0,0);
		XYratio = (double)control.window.getWidth()/control.window.getHeight();
	}
	public void render(Graphics g, double zoom){
		if (dragging == true) {
			if (input.mouseDown(1)) {
				
				
				
				g.setColor(color);
				g.drawRect(x, y, input.mouseX()-x, (int)((input.mouseX()-x)/XYratio));
			} else {
				CoordinatePlane c = control.coordinateplane;
				double r = (double)control.window.getWidth()/(input.mouseX()-x);
				c.XOrigin -= x;
				c.YOrigin -= y;
				c.XOrigin *= r;
				c.YOrigin *= r;
				c.XScale *= r;
				c.YScale = c.XScale;
				control.picture.repaint();
				dragging = false;
				System.out.println(c.XScale);
			}
		} else if (input.mouseDown(1)){
			dragging = true;
			x = input.mouseX();
			y = input.mouseY();
		}
	}
	public void tick(){
	}
}
