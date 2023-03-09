package entity;
import test1.PanelGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import test1.KeyHandler;
public class Player extends Entity{
	PanelGame PG;
	KeyHandler PhimNhan;
	boolean Death=false;
	public Player(PanelGame Panel,KeyHandler Phim) {
		PG=Panel;
		PhimNhan=Phim;
		setDefault();
		getImg();
	}
	public void setDefault() {
		x=PG.getSizeO();
		y=PG.getSizeO();
		setspeed((int)(PG.getDai()/100*(PG.DoKho/2)));
		Direction="Xuong";
		HitBox=new Rectangle();
		HitBox.height=8*PG.PhongTo;
		HitBox.width=9*PG.PhongTo;
		HitBox.x=3*PG.PhongTo;
		HitBox.y=0*PG.PhongTo;
	}
	public void getImg() {
		String ImgFolder="/"+PG.NhanVat;
		try {
			Xuong0=ImageIO.read(getClass().getResourceAsStream(ImgFolder+"/Xuong0.png"));
			Xuong1=ImageIO.read(getClass().getResourceAsStream(ImgFolder+"/Xuong1.png"));
			Xuong2=ImageIO.read(getClass().getResourceAsStream(ImgFolder+"/Xuong2.png"));
			Len0=ImageIO.read(getClass().getResourceAsStream(ImgFolder+"/Len0.png"));
			Len1=ImageIO.read(getClass().getResourceAsStream(ImgFolder+"/Len1.png"));
			Len2=ImageIO.read(getClass().getResourceAsStream(ImgFolder+"/Len2.png"));
			Trai0=ImageIO.read(getClass().getResourceAsStream(ImgFolder+"/Trai0.png"));
			Trai1=ImageIO.read(getClass().getResourceAsStream(ImgFolder+"/Trai1.png"));
			Trai2=ImageIO.read(getClass().getResourceAsStream(ImgFolder+"/Trai2.png"));
			Phai0=ImageIO.read(getClass().getResourceAsStream(ImgFolder+"/Phai0.png"));
			Phai1=ImageIO.read(getClass().getResourceAsStream(ImgFolder+"/Phai1.png"));
			Phai2=ImageIO.read(getClass().getResourceAsStream(ImgFolder+"/Phai2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	public void Update() {
		if(PhimNhan.Shift)setspeed((int)(PG.getDai()/200*(PG.DoKho/2)));
		else setspeed((int)(PG.getDai()/100*(PG.DoKho/2)));
		if(PhimNhan.Len) {y-=getspeed();Direction="Len";}
		if(PhimNhan.Xuong) {y+=getspeed();Direction="Xuong";}
		if(PhimNhan.Trai) {x-=getspeed();Direction="Trai";}
		if(PhimNhan.Phai) {x+=getspeed();Direction="Phai";}
		if(x>PG.getDai()-PG.getSizeO())x=PG.getDai()-PG.getSizeO();if(x<PG.getSizeO())x=PG.getSizeO();
		if(y>PG.getRong()-PG.getSizeO())y=PG.getRong()-PG.getSizeO();if(y<PG.getSizeO())y=PG.getSizeO();
		drawcount++;
		if(TraiPhai==0)if(drawcount>20) {TraiPhai=1;drawcount=0;}
		if(TraiPhai==2)if(drawcount>20) {TraiPhai=1;drawcount=0;}
		if(TraiPhai==1)if(drawcount>20) {TraiPhai=2;drawcount=0;}
	}
	public void Draw(Graphics2D g2) {
		BufferedImage img=null;
		switch(Direction){
		case "Len":if(PhimNhan.Stop)img=Len0;else {if(TraiPhai==1)img=Len1;if(TraiPhai==2)img=Len2;}break;
		case "Xuong":if(PhimNhan.Stop)img=Xuong0;else {if(TraiPhai==1)img=Xuong1;if(TraiPhai==2)img=Xuong2;}break;
		case "Trai":if(PhimNhan.Stop)img=Trai0;else {if(TraiPhai==1)img=Trai1;if(TraiPhai==2)img=Trai2;}break;
		case "Phai":if(PhimNhan.Stop)img=Phai0;else {if(TraiPhai==1)img=Phai1;if(TraiPhai==2)img=Phai2;}break;
		}
		g2.drawImage(img, x, y, PG.getSizeO(), PG.getSizeO(),null);
		g2.setColor(Color.GREEN);
		if(PhimNhan.Shift)g2.drawRect(x+HitBox.x, y+HitBox.y, HitBox.width, HitBox.height);
		if(Death) {
			g2.setColor(Color.YELLOW);
		g2.setFont(new Font("Roboto Bold", Font.BOLD, 35));
		g2.drawString("Game Over roi con ga, song duoc "+(System.currentTimeMillis()-PG.TimeLast)/1000+"s", PG.getSizeO()*3, PG.getRong()/2);
		PG.ThreadChayGame.stop();}
	}
	public void Die() {
		System.out.println("Thua roi ngu vcl, dung may loz lam game deo bao h win duoc game");
		Death=true;
	}
}
