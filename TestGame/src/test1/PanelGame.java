package test1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class PanelGame extends JPanel implements Runnable{
	final int SizeOGoc=16;
	final int PhongTo=2;
	final int SizeO=SizeOGoc*PhongTo;
	final int SLCot=40;
	final int SLHang=20;
	final int Rong=SLCot*SizeO;
	final int Dai=SLHang*SizeO;
	int FPS=60;
	Thread ThreadChayGame;
	KeyHandler PhimNhan=new KeyHandler();
//	Vi tri nguoi choi 1
	int P1X=100,P1Y=100,P1Speed=5;
	public PanelGame() {
		this.setPreferredSize(new Dimension(Rong,Dai));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(PhimNhan);
		this.setFocusable(true);
	}
	public void ChayThread() {
		ThreadChayGame=new Thread(this);
		ThreadChayGame.start();
	}
	int solanve=0;
	public void run() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			  public void run() {
			    System.out.println("FPS: "+solanve);
			    solanve=0;
			  }
			}, 1000, 1000);
		double TanSuatVe=1000000000/FPS;
		double LanVeTiep=System.nanoTime()+TanSuatVe;
		while(ThreadChayGame!=null) {
//			System.out.println("Dang chay.");
//		1. Vi tri
		Update();
//		2.Ve
		repaint();
		solanve++;
		
		try {
			double ThoiGianCho=LanVeTiep-System.nanoTime();
			ThoiGianCho/=1000000;
			if(ThoiGianCho<0)ThoiGianCho=0;
			Thread.sleep((long)ThoiGianCho);
			LanVeTiep+=TanSuatVe;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
}
	public void Update() {
		if(PhimNhan.Len) P1Y-=P1Speed;
		if(PhimNhan.Xuong)P1Y+=P1Speed;
		if(PhimNhan.Trai)P1X-=P1Speed;
		if(PhimNhan.Phai)P1X+=P1Speed;
		if(P1Y>=Dai)P1Y=Dai;
		if(P1X>=Rong)P1X=Rong;
	};
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D)g;
		g2.setColor(Color.WHITE);
		g2.fillRect(P1X, P1Y, SizeO, SizeO);
		g2.dispose();
	};
}
