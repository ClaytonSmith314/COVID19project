package main;

import java.awt.Graphics;
import java.util.ArrayList;

public class Screen implements Renderable{
		
	public ArrayList<Object> renderables = new ArrayList<>();
	public ArrayList<Double> renderpriority = new ArrayList<>();
	
	public int x=0, y=0;
	
	public Screen(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Screen(){
	}
	
	public int addRenderable(Object O, double priority){
		int x;
		if (renderables.size() == 0){
			renderables.add(O);
			renderpriority.add(priority);
			x = renderables.size();
		}
		else if (priority > renderpriority.get(renderables.size()-1)){
			renderables.add(O);
			renderpriority.add(priority);
			x = renderables.size();
		}
		else {
			for (x=0; priority>renderpriority.get(x); x++);
			renderables.add(x, O); 
			renderpriority.add(x, priority);
		}
		return x;
	}
	public void clearRenderables(){
		renderables.clear();
	}
	
	public void render(Graphics g, double zoom){
		g.translate(x, y);
		for(int n = renderables.size()-1; n>=0; n--){
			((Renderable) renderables.get(n)).render(g, zoom);
		}
		g.translate(-x, -y);
	}
	
	public void tick(){
	}
}
