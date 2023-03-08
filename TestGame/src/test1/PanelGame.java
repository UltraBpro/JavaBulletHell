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
import entity.FPS;
import entity.LevelManager;

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
	public double DoKho;String NhanVat;
	public Thread ThreadChayGame;
	KeyHandler PhimNhan=new KeyHandler();
	public Player P1=new Player(this,PhimNhan);
	WallManager tuong=new WallManager(this);
	GroundManager dat=new GroundManager(this);
	List<LevelManager> BulletHell=new ArrayList<LevelManager>();
	FPS FPSdraw=new FPS(this);
//	Vi tri nguoi choi 1
	int P1X=100,P1Y=100,P1Speed=5;
	public PanelGame(Double DoKho,String NhanVat) {
		this.setPreferredSize(new Dimension(Dai+SizeO,Rong+SizeO));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(PhimNhan);
		this.setFocusable(true);
		this.DoKho=DoKho;this.NhanVat=NhanVat;
	}
	public void ChayThread() {
		ThreadChayGame=new Thread(this);
		ThreadChayGame.start();
	}
	int solanve=0;
	public void run() {
		BulletHell.add(new LevelManager(this,"Free",P1));
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			  public void run() {
			    FPSdraw.Update(solanve);
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
		for(LevelManager j : BulletHell)for(int i=0;i< j.Dan.size();i++) {
			(j.Dan.get(i)).Update();
			if(j.Dan.get(i).TuHuy){
			j.Dan.remove(i);
			}
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D)g;
				dat.Draw(g2);
		tuong.Draw(g2);
		P1.Draw(g2);
		for(LevelManager j : BulletHell)for(Bullet i : j.Dan)i.Draw(g2);
		FPSdraw.Draw(g2);
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
