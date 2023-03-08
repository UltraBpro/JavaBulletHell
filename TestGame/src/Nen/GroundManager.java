package Nen;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import test1.PanelGame;

public class GroundManager{
	PanelGame PG;
	BufferedImage Tile0,Tile1,Tile2,Tile3;
	int[] GroundNum;
	public GroundManager(PanelGame Panel) {
		PG=Panel;
		getImg();
	}
	public void getImg() {
		try {
			Tile0=ImageIO.read(getClass().getResourceAsStream("/Environment/Ground/tile0.png"));
			Tile1=ImageIO.read(getClass().getResourceAsStream("/Environment/Ground/tile1.png"));
			Tile2=ImageIO.read(getClass().getResourceAsStream("/Environment/Ground/tile2.png"));
			Tile3=ImageIO.read(getClass().getResourceAsStream("/Environment/Ground/tile3.png"));
			GroundNum=new int[(PG.getDai()/PG.getSizeO()-1)*(PG.getRong()/PG.getSizeO()-1)];
			Random rand=new Random();
			for(int i=0;i<GroundNum.length;i++)GroundNum[i]=rand.nextInt(3);
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	public void Draw(Graphics2D g2) {
		BufferedImage img = null;int num=0;
		for(int j=1;j<=PG.getRong()/PG.getSizeO()-1;j++) {
			for(int i=1;i<=PG.getDai()/PG.getSizeO()-1;i++) {
				switch (GroundNum[num++]){
				case 0:img=Tile0;break;
				case 1:img=Tile1;break;
				case 2:img=Tile2;break;
				case 3:img=Tile3;break;}
				g2.drawImage(img,i*PG.getSizeO(),j*PG.getSizeO(),PG.getSizeO(),PG.getSizeO(),null);
		}
	}
}
}
	
