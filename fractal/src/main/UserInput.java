package main;

import java.awt.event.*;
import java.util.ArrayList;


public class UserInput implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {
	
	GameControl control;
	
	public UserInput(){
		this.control = GameControl.controler;
	}
	
	//Mouse Input
		private int mouseX = 50, mouseY = 50; 
		private boolean[] mouseDown = {false,false,false};
		
		public int mouseX() {
			return mouseX;
		}
		public int mouseY() {
			return mouseY;
		}
		public boolean mouseDown(int button){
			return mouseDown[button-1];
		}

		
		
		public void mouseMoved(MouseEvent m){
			mouseX = m.getX(); mouseY = m.getY();
		}
		public void mouseDragged(MouseEvent m) {
			mouseX = m.getX(); mouseY = m.getY();
		}
		
		public void mousePressed(MouseEvent m){
			mouseDown[m.getButton()-1] = true;
		}
		public void mouseReleased(MouseEvent m) {
			mouseDown[m.getButton()-1] = false;
		}
		public void mouseClicked(MouseEvent m) {
		}
		public void mouseEntered(MouseEvent m) {
		}
		public void mouseExited(MouseEvent m) {
		}
		public void mouseWheelMoved(MouseWheelEvent m){
		}

		
	//Key Input
		private ArrayList<Integer> keysDown = new ArrayList<>();
			
		public boolean keyDown(int keycode){
			return keysDown.contains(keycode);
		}
		public void keyPressed(KeyEvent k) {
			if (!keysDown.contains(k.getKeyCode())) {
				keysDown.add(k.getKeyCode());
				if(k.getKeyCode() == 32) {
					control.coordinateplane.setBounds(-1.5,1,1.5,-1.5, true);
					control.picture.repaint();
				}
				if(k.getKeyCode() == 16) {
					control.picture.needspaint = true;
				}
			}
		}
		public void keyReleased(KeyEvent k) {
			keysDown.remove((Integer)k.getKeyCode());
		}
		public void keyTyped(KeyEvent k) {	
		}
			
}
