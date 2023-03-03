package test1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	public boolean Len=false;
	public boolean Xuong=false;
	public boolean Trai=false;
	public boolean Phai=false;

	public void keyPressed(KeyEvent e) {
		char PhimNao=e.getKeyChar();
		switch(PhimNao) {
		case 'w':
			Len=true;
			break;
		case 's':
			Xuong=true;
			break;
		case 'a':
			Trai=true;
			break;
		case 'd':
			Phai=true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		char PhimNao=e.getKeyChar();
		switch(PhimNao) {
		case 'w':
			Len=false;
			break;
		case 's':
			Xuong=false;
			break;
		case 'a':
			Trai=false;
			break;
		case 'd':
			Phai=false;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
