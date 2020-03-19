package specific;

import java.awt.Color;
import java.awt.Graphics;

import main.*;

public class ColorViewer extends Sprite{
	
	private static int[] rgb = new int[3];
	public static int MAX_ITERATIONS = 0;
	
	private Window window;
	
	boolean needsPaint = true;
	
	public ColorViewer(){
		super();
		window = GameControl.controler.window;
	}
	
	public void render(Graphics g, double zoom){
		double z;
		if (needsPaint){
			for(int i = 0; i < window.getWidth(); i++){
				z = (double)MAX_ITERATIONS/window.getWidth()*i;
				g.setColor(colorpicker(z));
				g.fillRect(i, 0, 1, window.getHeight());
			}
			needsPaint = false;
		}
	}
	public void tick(){};
	
	public static Color colorpicker(double z){
		try{
			return allcolorcontrast(z);
		} catch (java.lang.IllegalArgumentException e){
			return Color.ORANGE;
		}
	}
	public static Color allcolorcontrastrepeat(double z,boolean complete){
		if (!complete) {
			return Color.BLACK;
		}else {
			int a = (int)(z/800*6-1)%6+1;
			if(z < 133.333) a = 0;
			int b = (int)((z/800*6*255)%255);
			switch (a){
				case 0 : 
					rgb[0] = b;
					rgb[1] = 0;
					rgb[2] = 0;
					break;
				case 1 : 
					rgb[0] = 255-b;
					rgb[1] = b;
					rgb[2] = b;
					break;
				case 2 : 
					rgb[0] = b;
					rgb[1] = 255;
					rgb[2] = 255-b;
					break;
				case 3 : 
					rgb[0] = 255-b;
					rgb[1] = 255-b;
					rgb[2] = b;
					break;
				case 4 : 
					rgb[0] = 0;
					rgb[1] = b;
					rgb[2] = 255-b;
					break;
				case 5 : 
					rgb[0] = b;
					rgb[1] = 255-b;
					rgb[2] = b;
					break;
				case 6 : 
					rgb[0] = 255;
					rgb[1] = 0;
					rgb[2] = 255-b;
					break;
				case 7 : 
					rgb[0] = 255-b;
					rgb[1] = 0;
					rgb[2] = 0;
					break;
				default :
					rgb[0] = 0;
					rgb[1] = 0;
					rgb[2] = 0;
			}
			return new Color(rgb[0],rgb[1],rgb[2]);
		}
	}
	public static Color allcolorcontrastrepeatexponential(double z,boolean complete){
		return allcolorcontrastrepeat(Math.sqrt(z)*10,complete);
	}
	public static Color allcolorcontrast(double z){
		if (z==MAX_ITERATIONS) {
			return Color.BLACK;
		}else {
			int a = (int)(z/MAX_ITERATIONS*8);
			int b = (int)((z/MAX_ITERATIONS*8*255)%255);
			switch (a){
				case 0 : 
					rgb[0] = b;
					rgb[1] = 0;
					rgb[2] = 0;
					break;
				case 1 : 
					rgb[0] = 255-b;
					rgb[1] = b;
					rgb[2] = b;
					break;
				case 2 : 
					rgb[0] = b;
					rgb[1] = 255;
					rgb[2] = 255-b;
					break;
				case 3 : 
					rgb[0] = 255-b;
					rgb[1] = 255-b;
					rgb[2] = b;
					break;
				case 4 : 
					rgb[0] = 0;
					rgb[1] = b;
					rgb[2] = 255-b;
					break;
				case 5 : 
					rgb[0] = b;
					rgb[1] = 255-b;
					rgb[2] = b;
					break;
				case 6 : 
					rgb[0] = 255;
					rgb[1] = 0;
					rgb[2] = 255-b;
					break;
				case 7 : 
					rgb[0] = 255-b;
					rgb[1] = 0;
					rgb[2] = 0;
					break;
				default :
					rgb[0] = 0;
					rgb[1] = 0;
					rgb[2] = 0;
			}
			return new Color(rgb[0],rgb[1],rgb[2]);
		}
	}
	public static Color allcolorpallet(double z){
		if (z>=MAX_ITERATIONS) {
			return Color.BLACK;
		}else {
			int a = (int)(z/MAX_ITERATIONS*8);
			int b = (int)((z/MAX_ITERATIONS*7*255)%255);
			switch (a){
				case 0 : 
					rgb[0] = b;
					rgb[1] = 0;
					rgb[2] = 0;
					break;
				case 1 : 
					rgb[0] = 255;
					rgb[1] = b;
					rgb[2] = 0;
					break;
				case 2 : 
					rgb[0] = 255-b;
					rgb[1] = 255;
					rgb[2] = 0;
					break;
				case 3 : 
					rgb[0] = 0;
					rgb[1] = 255;
					rgb[2] = b;
					break;
				case 4 : 
					rgb[0] = 0;
					rgb[1] = 255-b;
					rgb[2] = 255;
					break;
				case 5 : 
					rgb[0] = b;
					rgb[1] = 0;
					rgb[2] = 255;
					break;
				case 6 : 
					rgb[0] = 255;
					rgb[1] = 0;
					rgb[2] = 255-b;
					break;
				case 7 : 
					rgb[0] = 255-b;
					rgb[1] = 0;
					rgb[2] = 0;
					break;
				default :
					rgb[0] = 0;
					rgb[1] = 0;
					rgb[2] = 0;
			}
			return new Color(rgb[0],rgb[1],rgb[2]);
		}
	}
	
	public static Color pallet(double z){
		rgb[0] = (int) (255.0/(1+(z+1)*(z+1)));
		rgb[1] = (int) (255.0/(1+(z*z)));
		rgb[2] = (int) (255.0/(1+((z-1)*(z-1))));
		return new Color(rgb[0],rgb[1],rgb[2]);
	}
	public static Color grayscalepallet(double z){
		int grad = (int) (255*Math.pow(1.08, -z));
		return new Color(grad,grad,grad);
	}
	public static Color redscalepallet(double z){
		rgb[0] = 255 - (int) (255.0/MAX_ITERATIONS*z);
		rgb[1] = 0;
		rgb[2] = 0;
		return new Color(rgb[0],rgb[1],rgb[2]);
	}
	public static Color purplescalepallet(double z){
		rgb[0] = 200 - (int) (200.0/MAX_ITERATIONS*z);
		rgb[1] = 0;
		rgb[2] = 255 - (int) (255.0/MAX_ITERATIONS*z);
		return new Color(rgb[0],rgb[1],rgb[2]);
	}
	public static Color bluescalepallet(double z){
		rgb[0] = 0;
		rgb[1] = 0;
		rgb[2] = 255 - (int) (255.0/MAX_ITERATIONS*z);
		return new Color(rgb[0],rgb[1],rgb[2]);
	}
	public static Color extreemcontrast(double z){
		if (z>=MAX_ITERATIONS)
			return Color.BLACK;
		else
			return Color.RED;
	}
	public static Color contrast(double z){
		if (z>=500) {
			return Color.BLACK;
		}else {
			int gradent = 255 - (int) (255*Math.pow(1.08, -z)) ;
			return new Color(gradent,gradent,gradent);
		}
	}
	public static Color redcontrast(double z){
		if (z>=1000) {
			return Color.BLACK;
		}else {
			rgb[0] = (int)(Math.pow(z-250, 2)/-250)+255;
			rgb[1] = 0;
			rgb[2] = 0;
			return new Color(rgb[0],rgb[1],rgb[2]);
		}
	}
	public static Color purplecontrast(double z){
		if (z>=500) {
			return Color.BLACK;
		}else {
			rgb[0] = (int)(Math.pow(z-250, 2)/-250)+255;
			rgb[1] = 0;
			rgb[2] = (int)(Math.pow(z-250, 2)/-250)+255;
			return new Color(rgb[0],rgb[1],rgb[2]);
		}
	}
	
	public static Color hallcolorpallet(double z){
		if (z>=MAX_ITERATIONS) {
			return Color.BLACK;
		}else {
		rgb[0] = (int) (255.0/(1+Math.pow((z-1000)/100,2)));
		rgb[1] = (int) (255.0/(1+Math.pow((z-700)/100,2)));
		rgb[2] = (int) (255.0/(1+Math.pow((z-300)/100,2)));
		return new Color(rgb[0],rgb[1],rgb[2]);
		}
	}
}
