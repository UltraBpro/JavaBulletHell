package test1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import Nen.GroundManager;
import Nen.WallManager;
import entity.Bullet;
import entity.Player;

public class PanelGame extends JPanel implements Runnable{
	final int SizeOGoc=16;
	public final int PhongTo=3;
	final int SizeO=SizeOGoc*PhongTo;
	final int SLCot=20;
	final int SLHang=10;
	final int Rong=SLHang*SizeO;
	final int Dai=SLCot*SizeO;
	boolean Init=false;
	int FPS=60;
	public Thread ThreadChayGame;
	KeyHandler PhimNhan=new KeyHandler();
	Player P1=new Player(this,PhimNhan);
	WallManager tuong=new WallManager(this);
	GroundManager dat=new GroundManager(this);
	List<Bullet> BulletHell=new ArrayList<Bullet>();
//	Vi tri nguoi choi 1
	int P1X=100,P1Y=100,P1Speed=5;
	public PanelGame() {
		this.setPreferredSize(new Dimension(Dai+SizeO,Rong+SizeO));
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
			for(int j=SizeO;j<Rong;j+=SizeO) {
				if(j!=SizeO*4)BulletHell.add(new Bullet(this,P1,1,Dai-100,j,"Trai"));
			}
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
		P1.Update();
		for(int i=0;i< BulletHell.size();i++) {BulletHell.get(i).Update();if(BulletHell.get(i).TuHuy){
			BulletHell.remove(i);
			System.out.println("Het game roi do thang loz, demo nen ai cung qua duoc thoi cu");ThreadChayGame.stop();}
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D)g;
		dat.Draw(g2);
		P1.Draw(g2);
		for(Bullet i : BulletHell)i.Draw(g2);
		tuong.Draw(g2);
		g2.dispose();
	}
	public int getRong() {
		return Rong;
	}
	public int getDai() {
		return Dai;
	}
	public int getSizeO() {
		return SizeO;
	}
}
