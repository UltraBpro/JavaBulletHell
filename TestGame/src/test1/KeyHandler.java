package test1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	public boolean Len=false;
	public boolean Xuong=false;
	public boolean Trai=false;
	public boolean Phai=false;
	public boolean Stop=true;
	public boolean Shift=false;
	public void keyPressed(KeyEvent e) {
		char PhimNao=e.getKeyChar();
		switch(PhimNao) {
		case 'w':
		case 'W':
			Len=true;
			Stop=false;
			break;
		case 's':
		case 'S':
			Xuong=true;
			Stop=false;
			break;
		case 'a':
		case 'A':
			Trai=true;
			Stop=false;
			break;
		case 'd':
		case 'D':
			Phai=true;
			Stop=false;
			break;			
		}
		if(e.isShiftDown())Shift=true;
		
	}

	public void keyReleased(KeyEvent e) {
		char PhimNao=e.getKeyChar();
		switch(PhimNao) {
		case 'w':
		case 'W':
			Len=false;
			Stop=true;
			break;
		case 's':
		case 'S':
			Xuong=false;
			Stop=true;
			break;
		case 'a':
		case 'A':
			Trai=false;
			Stop=true;
			break;
		case 'd':
		case 'D':
			Phai=false;
			Stop=true;
			break;
		}
		if(!e.isShiftDown())Shift=false;
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
