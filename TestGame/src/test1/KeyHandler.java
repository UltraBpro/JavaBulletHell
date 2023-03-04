package test1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	public boolean Len=false;
	public boolean Xuong=false;
	public boolean Trai=false;
	public boolean Phai=false;
	public boolean Stop=true;
	public void keyPressed(KeyEvent e) {
		char PhimNao=e.getKeyChar();
		switch(PhimNao) {
		case 'w':
			Len=true;
			Stop=false;
			break;
		case 's':
			Xuong=true;
			Stop=false;
			break;
		case 'a':
			Trai=true;
			Stop=false;
			break;
		case 'd':
			Phai=true;
			Stop=false;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		char PhimNao=e.getKeyChar();
		switch(PhimNao) {
		case 'w':
			Len=false;
			Stop=true;
			break;
		case 's':
			Xuong=false;
			Stop=true;
			break;
		case 'a':
			Trai=false;
			Stop=true;
			break;
		case 'd':
			Phai=false;
			Stop=true;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
