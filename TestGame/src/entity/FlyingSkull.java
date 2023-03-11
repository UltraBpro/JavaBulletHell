package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import test1.PanelGame;

public class FlyingSkull extends Entity{
	PanelGame PG;
	Player P1;
	boolean Fire=false;
	public FlyingSkull(PanelGame Panel,Player Ng) {
		PG=Panel;
		P1=Ng;
		getImg();
	}
	public void getImg() {
		try {
			Xuong0=ImageIO.read(getClass().getResourceAsStream("/FlyingSkull/Xuong0.png"));
			Xuong1=ImageIO.read(getClass().getResourceAsStream("/FlyingSkull/Xuong1.png"));
			Xuong2=ImageIO.read(getClass().getResourceAsStream("/FlyingSkull/Xuong2.png"));
			Len0=ImageIO.read(getClass().getResourceAsStream("/FlyingSkull/Len0.png"));
			Len1=ImageIO.read(getClass().getResourceAsStream("/FlyingSkull/Len1.png"));
			Len2=ImageIO.read(getClass().getResourceAsStream("/FlyingSkull/Len2.png"));
			Trai0=ImageIO.read(getClass().getResourceAsStream("/FlyingSkull/Trai0.png"));
			Trai1=ImageIO.read(getClass().getResourceAsStream("/FlyingSkull/Trai1.png"));
			Trai2=ImageIO.read(getClass().getResourceAsStream("/FlyingSkull/Trai2.png"));
			Phai0=ImageIO.read(getClass().getResourceAsStream("/FlyingSkull/Phai0.png"));
			Phai1=ImageIO.read(getClass().getResourceAsStream("/FlyingSkull/Phai1.png"));
			Phai2=ImageIO.read(getClass().getResourceAsStream("/FlyingSkull/Phai2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void Update() {
		drawcount++;
		if(Fire==true){TraiPhai=0;drawcount=0;Fire=false;}
		if(TraiPhai==0)if(drawcount>40) {TraiPhai=1;drawcount=0;}
		if(TraiPhai==2)if(drawcount>20) {TraiPhai=1;drawcount=0;}
		if(TraiPhai==1)if(drawcount>20) {TraiPhai=2;drawcount=0;}
	}
	public void Draw(Graphics2D g2) {
		BufferedImage img=null;
		switch(Direction){
		case "Len": if(TraiPhai==0)img=Len0;if(TraiPhai==1)img=Len1;if(TraiPhai==2)img=Len2;break;
		case "Xuong": if(TraiPhai==0)img=Xuong0;if(TraiPhai==1)img=Xuong1;if(TraiPhai==2)img=Xuong2;break;
		case "Trai": if(TraiPhai==0)img=Trai0;if(TraiPhai==1)img=Trai1;if(TraiPhai==2)img=Trai2;break;
		case "Phai": if(TraiPhai==0)img=Phai0;if(TraiPhai==1)img=Phai1;if(TraiPhai==2)img=Phai2;break;
		}
		g2.drawImage(img, x, y, PG.getSizeO(), PG.getSizeO(),null);
	}
}
