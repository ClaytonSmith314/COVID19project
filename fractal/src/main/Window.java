package main;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Window extends Canvas {
		
	private static final long serialVersionUID = 1L;
	
	private GameControl control;
	
	private BufferStrategy buff;
	
	public int graphX = 0, graphY = 0;
	public double zoom = 1.0;
	
	public JFrame frame = new JFrame();
	
	private UserInput input;	
			
	public Window(){
		control = GameControl.controler;
		this.input = control.input;
		
		this.setSize(800, 800);
		this.setBackground(Color.BLACK);
		this.addMouseListener(input);
		this.addMouseMotionListener(input);
		this.addKeyListener(input);
		this.addMouseWheelListener(input);

		frame.setSize(500, 500);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);
		this.requestFocus();
		
		//graphX = this.getWidth()/2; graphY = this.getHeight()/2;
	}
	
	public void render(){
		buff = this.getBufferStrategy();

		if (buff == null){
			this.createBufferStrategy(3);
			return;
		}

		
		//shiftKeys();
		
		Graphics g = buff.getDrawGraphics();
			//g.translate(-graphX, -graphY);
			//g.setColor(Color.BLACK);
			//g.fillRect(-getWidth()/2-graphX, -getHeight()/2-graphY, this.getWidth(), this.getHeight());
					
			control.screen.render(g, zoom);
		
		g.dispose();
		buff.show();
	}
	public void show() {
		buff.show();
	}
	
}
