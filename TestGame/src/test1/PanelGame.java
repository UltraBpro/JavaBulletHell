package test1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanelGame extends JPanel implements Runnable{
	final int SizeOGoc=16;
	final int PhongTo=2;
	final int SizeO=SizeOGoc*PhongTo;
	final int SLCot=40;
	final int SLHang=20;
	final int Rong=SLCot*SizeO;
	final int Dai=SLHang*SizeO;
	Thread ThreadChayGame;
	public PanelGame() {
		this.setPreferredSize(new Dimension(Rong,Dai));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);	
	}
	public void ChayThread() {
		ThreadChayGame=new Thread(this);
		ThreadChayGame.start();
	}
	@Override
	public void run() {
		while(ThreadChayGame!=null) {
//			System.out.println("Dang chay.");
//		1. Vi tri
		Update();
//		2.Ve
		repaint();
	};
}
	public void Update() {
		
	};
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D)g;
		g2.setColor(Color.WHITE);
		g2.fillRect(5, 5, SizeO, SizeO);
		g2.dispose();
	};
	
	
}
