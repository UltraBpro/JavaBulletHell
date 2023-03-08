package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	public int x,y;
	private int speed;
	public BufferedImage Len0,Len1,Len2,Xuong0,Xuong1,Xuong2,Trai0,Trai1,Trai2,Phai0,Phai1,Phai2;
	public String Direction;
	public int drawcount;
	public int TraiPhai=0;
	public Rectangle HitBox;
	public int getspeed() {
		return speed;
	}
	public void setspeed(int t) {
		 speed=t;
	}	
}
