package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import test1.PanelGame;

public class Bullet extends Entity{
	double TyLeSize;
	PanelGame PG;
	Player Target;
	public boolean TuHuy=false;
	public Bullet(PanelGame Panel,Player TG,double DoKho,int posX,int posY,String Direct) {
		PG=Panel;
		Target=TG;
		TyLeSize=DoKho/4;
		x=posX;y=posY;
		Direction=Direct;
		setspeed((int)(PG.getDai()/200*(DoKho/2)));
		getImg();
	}
	public void getImg() {
		try {
			Xuong0=ImageIO.read(getClass().getResourceAsStream("/Bullet/Xuong0.png"));
			Xuong1=ImageIO.read(getClass().getResourceAsStream("/Bullet/Xuong1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void Update() {
		if(Direction.contains("Trai"))x-=getspeed();
		if(Direction.contains("Phai"))x+=getspeed();
		if(Direction.contains("Len"))y-=getspeed();
		if(Direction.contains("Xuong"))y+=getspeed();
		drawcount++;
		if(TraiPhai==0)if(drawcount>10) {TraiPhai=1;drawcount=0;}
		if(TraiPhai==1)if(drawcount>10) {TraiPhai=0;drawcount=0;}
		int LeftX=Target.x+Target.HitBox.x;
		int RightX=Target.x+Target.HitBox.x+Target.HitBox.width;
		int UpY=Target.y+Target.HitBox.y;
		int BotY=Target.y+Target.HitBox.y+Target.HitBox.height;
		if(CheckHit(LeftX,UpY)||CheckHit(LeftX,BotY)||CheckHit(RightX,UpY)||CheckHit(RightX,BotY)) {
			try {
				InputStream inputStream = getClass().getResourceAsStream("/Sound/MCDeath.wav");
			    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);
			    Clip clip = AudioSystem.getClip();
			    clip.open(audioInputStream);
			    clip.start();
			    if(PG.ThreadChayGame.isAlive()==false)clip.stop();
			  } catch (  IOException |LineUnavailableException|UnsupportedAudioFileException e) {
			    e.printStackTrace();
			  }
			Target.Die();}
		if(x>PG.getDai()+PG.getSizeO()||x<0||y>PG.getRong()+PG.getSizeO()||y<0)TuHuy=true;
	}
	public void Draw(Graphics2D g2) {
		BufferedImage img=null;
		if(TraiPhai==0)img=Xuong0;if(TraiPhai==1)img=Xuong1;
		g2.drawImage(img, x, y, (int)(TyLeSize*PG.getSizeO()), (int)(TyLeSize*PG.getSizeO()),null);
	}
	private boolean CheckHit(int x,int y) {
		return (x>this.x&&x<(this.x+(int)(TyLeSize*PG.getSizeO()))&&y>this.y&&y<(this.y+(int)(TyLeSize*PG.getSizeO())))	;
	}
}
