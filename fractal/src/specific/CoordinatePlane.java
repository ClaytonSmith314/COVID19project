package specific;

import java.awt.Color;
import java.awt.Graphics;
import java.math.BigDecimal;

import main.*;

public class CoordinatePlane extends Sprite{
	private boolean visable = false;
	
	public long XOrigin, YOrigin; //location in pixels of origin
	public double XScale, YScale; //in pixels per unit
	
	private Color color = Color.YELLOW;
	
	public CoordinatePlane(double right, double left, double top, double bottom, boolean keepScale){
		super(0.5,0);
		setBounds(right,left,top,bottom,keepScale);
	}
	public void render (Graphics g, double zoom){
		if (visable) {
			g.setColor(color);
			//g.drawLine(0, YOrigin, control.window.getWidth(), YOrigin);
			//g.drawLine(XOrigin, 0, XOrigin, control.window.getHeight());
		}
		//shift();
	}
	public void tick(){
		//shift();
	}
	
	public void setBounds (double left, double right, double top, double bottom, boolean keepScale){
		int w = control.window.getWidth();
		int h = control.window.getHeight();
		XScale = Math.abs(w / (right-left));
		YScale =  Math.abs(h / (top-bottom));
		XOrigin = (int) (-XScale*left);
		YOrigin = (int) (YScale*top);
		if (keepScale) {
			if (XScale < YScale) 
				YScale = XScale;
			else 
				XScale = YScale;
		}
		System.out.println("XScale: "+XScale+ " YScale: "+YScale + " XOrigin: "+XOrigin + " YOrigin: "+YOrigin);
	}
	
	public int getPXfromCX(double CX){
		return (int) ((CX*XScale) + XOrigin);
	}
	public int getPYfromCY(double CY){
		return (int) ((CY*YScale) + YOrigin);
	}
	public double getCXfromPX(int PX){
		return (PX-XOrigin)/XScale;
	}
	public double getCYfromPY(int PY){
		return (PY-YOrigin)/YScale;
	}
	public BigDecimal getBigCXfromPX(int PX){
		return BigDecimal.valueOf((PX-XOrigin)).divide(BigDecimal.valueOf(XScale), 20 /*-(int)Math.log10(XScale)-1*/, BigDecimal.ROUND_DOWN);
	}
	public BigDecimal getBigCYfromPY(int PY){
		return BigDecimal.valueOf((PY-YOrigin)).divide(BigDecimal.valueOf(YScale), 20 /*-(int)Math.log10(YScale)-1*/, BigDecimal.ROUND_DOWN);
	}
	
	public void shift(){
		int amount = 200;
		 if (input.keyDown(37)) {
			 XOrigin = XOrigin + amount;
			 control.picture.repaint();
		 }
		 if (input.keyDown(39)) {
			 XOrigin = XOrigin - amount;
			 control.picture.repaint();
		 }
		 if (input.keyDown(38)) {
			 YOrigin = YOrigin + amount;
			 control.picture.repaint();
		 }
		 if (input.keyDown(40)) {
			 YOrigin = YOrigin - amount;
			 control.picture.repaint();
		 }
	}
}
