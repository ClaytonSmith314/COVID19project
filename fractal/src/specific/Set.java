package specific;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import main.*;

public class Set extends Sprite{
	
	private int iterationstep = 100;
	private int iterations;
	
	private int w = control.window.getWidth();
	private int h = control.window.getHeight();
	
	private boolean[][] isComplete;		
	private double[][] aArray;
	private double[][] bArray;
 	int x, y; int z;

	public boolean needspaint = false;
	public void repaint(){
		needspaint = true;
		iterations = iterationstep;
		isComplete = new boolean[w][h];
		aArray = new double[w][h];
		bArray = new double[w][h];
	}
	
	int[] rgb = {0,0,0};
	
	
	public Set() {
		super();
		repaint();
	}
	public void tick(){
		
	}
	public void render(Graphics g, double notused){
		if(needspaint){
			for(x = 0; x<w; x++ ){
				for(y = 0; y<h; y++){
					if(!isComplete[x][y]) {
						calculate(x,y);
						if(z != iterations)
							isComplete[x][y] = true;
						g.setColor(colorpicker());
						g.fillRect(x, y, 1, 1);
					}
				}
				if(input.mouseDown(1)) needspaint = false;
			}
			if(needspaint == true) {
				iterations += iterationstep;
			}
			//needspaint = false;
			
		}
	}
	
	private void calculate(int x, int y){
		double cx = (double) control.coordinateplane.getCXfromPX(x);
		double cy = (double) control.coordinateplane.getCYfromPY(y);
			
		Mandelbrot(cx, cy, x, y);
	}
	
	private Color colorpicker(){
		return ColorViewer.allcolorcontrastrepeatexponential(z,isComplete[x][y]);
	}
	
	private void Mandelbrot(double x, double y, int px, int py){
		double a = aArray[px][py];
		double b = bArray[px][py];
		double temp;
		int i;
		for (i = iterations-iterationstep; a*a + b*b <= 4 && i < iterations; i++){
			 temp = a*a*a - b*b + x;
			 b = 2*a*b + y;
			 a = temp;
		}
		z = i;
		aArray[px][py] = a;
		bArray[px][py] = b;
	}

}
