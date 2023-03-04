package Nen;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import test1.PanelGame;

public class WallManager{
	PanelGame PG;
	BufferedImage Wall0,Wall1,Wall2,Wall3,Wall4;
	int[] WallNum;
	public WallManager(PanelGame Panel) {
		PG=Panel;
		getImg();
	}
	public void getImg() {
		try {
			Wall0=ImageIO.read(getClass().getResourceAsStream("/Environment/Wall/Wall0.png"));
			Wall1=ImageIO.read(getClass().getResourceAsStream("/Environment/Wall/Wall1.png"));
			Wall2=ImageIO.read(getClass().getResourceAsStream("/Environment/Wall/Wall2.png"));
			Wall3=ImageIO.read(getClass().getResourceAsStream("/Environment/Wall/Wall3.png"));
			Wall4=ImageIO.read(getClass().getResourceAsStream("/Environment/Wall/Wall4.png"));
			WallNum=new int[PG.getDai()/PG.getSizeO()*2+PG.getRong()/PG.getSizeO()*2];
			Random rand=new Random();
			for(int i=0;i<WallNum.length;i++) {
				WallNum[i]=rand.nextInt(4);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
	public void Draw(Graphics2D g2) {
		BufferedImage img = null;int num=0;
		for(int j=0;j<=PG.getRong()/PG.getSizeO();j++) {
			for(int i=0;i<=PG.getDai()/PG.getSizeO();i++) {
				if(!(j>0&&j<PG.getRong()/PG.getSizeO()&&i>0&&i<PG.getDai()/PG.getSizeO())) {
				switch (WallNum[num++]){
				case 0:img=Wall0;break;
				case 1:img=Wall1;break;
				case 2:img=Wall2;break;
				case 3:img=Wall3;break;
				case 4:img=Wall4;break;
					}
				g2.drawImage(img,i*PG.getSizeO(),j*PG.getSizeO(),PG.getSizeO(),PG.getSizeO(),null);
				}
		}
	}
}
}
	
