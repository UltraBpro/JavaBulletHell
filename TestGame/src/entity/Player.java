package entity;
import test1.PanelGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import test1.KeyHandler;
public class Player extends Entity{
	PanelGame PG;
	KeyHandler PhimNhan;
	public Player(PanelGame Panel,KeyHandler Phim) {
		PG=Panel;
		PhimNhan=Phim;
		setDefault();
		getImg();
	}
	public void setDefault() {
		x=100;
		y=100;
		setspeed(10);
		Direction="Xuong";
	}
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void getImg() {
		try {
			Xuong0=ImageIO.read(getClass().getResourceAsStream("/Player/Xuong0.png"));
			Xuong1=ImageIO.read(getClass().getResourceAsStream("/Player/Xuong1.png"));
			Xuong2=ImageIO.read(getClass().getResourceAsStream("/Player/Xuong2.png"));
			Len0=ImageIO.read(getClass().getResourceAsStream("/Player/Len0.png"));
			Len1=ImageIO.read(getClass().getResourceAsStream("/Player/Len1.png"));
			Len2=ImageIO.read(getClass().getResourceAsStream("/Player/Len2.png"));
			Trai0=ImageIO.read(getClass().getResourceAsStream("/Player/Trai0.png"));
			Trai1=ImageIO.read(getClass().getResourceAsStream("/Player/Trai1.png"));
			Trai2=ImageIO.read(getClass().getResourceAsStream("/Player/Trai2.png"));
			Phai0=ImageIO.read(getClass().getResourceAsStream("/Player/Phai0.png"));
			Phai1=ImageIO.read(getClass().getResourceAsStream("/Player/Phai1.png"));
			Phai2=ImageIO.read(getClass().getResourceAsStream("/Player/Phai2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	public void Update() {
		if(PhimNhan.Len) {y-=getspeed();if(Direction=="Len2")Direction="Len1";
		else
		if(Direction=="Len1")Direction="Len2";
		else
		if(Direction=="Len")Direction="Len1";
		else Direction="Len";
		}
		if(PhimNhan.Xuong) {y+=getspeed();if(Direction=="Xuong2")Direction="Xuong1";
		else
		if(Direction=="Xuong1")Direction="Xuong2";
		else
		if(Direction=="Xuong")Direction="Xuong1";
		else Direction="Xuong";}
		if(PhimNhan.Trai) {x-=getspeed();if(Direction=="Trai2")Direction="Phai1";
		else
		if(Direction=="Trai1")Direction="Trai2";
		else
		if(Direction=="Trai")Direction="Trai1";
		else Direction="Trai";}
		if(PhimNhan.Phai) {x+=getspeed();Direction="Phai";}
		if(x>PG.getDai()-PG.getSizeO())x=PG.getDai()-PG.getSizeO();if(x<0)x=0;
		if(y>PG.getRong()-PG.getSizeO())y=PG.getRong()-PG.getSizeO();if(y<0)y=0;
	}
	public void Draw(Graphics2D g2) {
		BufferedImage img=null;
		switch(Direction) {
		case "Len":img=Len0;break;case "Len1":img=Len1;break;case "Len2":img=Len2;break;
		case "Xuong":img=Xuong0;break;case "Xuong1":img=Xuong1;break;case "Xuong2":img=Xuong2;break;
		case "Trai":img=Trai0;break;case "Trai1":img=Trai1;break;case "Trai2":img=Trai2;break;
		case "Phai":img=Phai0;break;case "Phai1":img=Phai1;break;case "Phai2":img=Phai2;break;
		}
		g2.drawImage(img, x, y, PG.getSizeO(), PG.getSizeO(),null);
	}
}
