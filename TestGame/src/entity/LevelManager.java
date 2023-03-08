package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import test1.PanelGame;

public class LevelManager {
	String level;
	PanelGame PG;
	Player P1;
	public List<Bullet> Dan=new ArrayList<Bullet>();
	String[] PotentialDirect=new String[]{"PhaiXuong","Phai","PhaiLen","Len","TraiLen","Trai","TraiXuong","Xuong"};
	public LevelManager(PanelGame Panel,String lvl,Player P) {
		PG=Panel;
		level=lvl;
		P1=P;
		setLevel();
	}
	public void setLevel() {
		switch(level) {
		case "1":
			for(int j=PG.getSizeO();j<PG.getRong();j+=PG.getSizeO()) {
			if(j!=PG.getSizeO()*4)Dan.add(new Bullet(PG,PG.P1,PG.DoKho,PG.getDai()-100,j,"Trai"));
		}
		break;
		case "Free":{
			Random rand=new Random();
			Timer timer = new Timer();
			int QuangNghi=(int) (1000/PG.DoKho);
			timer.scheduleAtFixedRate(new TimerTask() {
				  public void run() {
						int index=rand.nextInt(PotentialDirect.length);
						String Direct=PotentialDirect[index];
						index=rand.nextInt(FindDirect(Direct).length);
						String BulletDir=FindDirect(Direct)[index];
						Dan.add(new Bullet(PG,PG.P1,PG.DoKho,findPos(Direct)[0],findPos(Direct)[1],BulletDir));
				  }
				 }, 5000, QuangNghi);
			timer.scheduleAtFixedRate(new TimerTask() {
				  public void run() {
						int index=rand.nextInt(PotentialDirect.length);
						String Direct=PotentialDirect[index];
						index=rand.nextInt(FindDirect(Direct).length);
						String BulletDir=FindDirect(Direct)[index];
						Dan.add(new Bullet(PG,PG.P1,PG.DoKho,findPos(Direct)[0],findPos(Direct)[1],BulletDir));
				  }
				 }, 7000, QuangNghi);
			break;}
		}
	}
	private String[] FindDirect(String Potdirect) {
		List<String> Direct=new ArrayList<String>();
		switch(Potdirect) {
		case "TraiXuong":Direct.add("PhaiXuong");break; case "PhaiLen":Direct.add("PhaiLen");break; 
		case "Trai":Direct.add("PhaiXuong");Direct.add("PhaiLen");Direct.add("Phai");break;
		case "PhaiXuong":Direct.add("TraiXuong");break; case "TraiLen":Direct.add("TraiLen");break; 
		case "Phai":Direct.add("TraiXuong");Direct.add("TraiLen");Direct.add("Trai");break;
		case "Len":Direct.add("Len");Direct.add("TraiLen");Direct.add("PhaiLen");break;
		case "Xuong":Direct.add("Xuong");Direct.add("TraiXuong");Direct.add("PhaiXuong");break;
		}
		return Direct.toArray(new String[Direct.size()]);
	}
	private int[] findPos(String PotDirect) {
		int [] xvay=new int[2];
		switch(PotDirect) {
		case "PhaiXuong":xvay[0]=P1.x+3*PG.getSizeO();xvay[1]=P1.y-3*PG.getSizeO();break; 
		case "PhaiLen":xvay[0]=P1.x+3*PG.getSizeO();xvay[1]=P1.y+3*PG.getSizeO();break; 
		case "Phai":xvay[0]=P1.x+4*PG.getSizeO();xvay[1]=P1.y;break;
		case "TraiXuong":xvay[0]=P1.x-3*PG.getSizeO();xvay[1]=P1.y-3*PG.getSizeO();break; 
		case "TraiLen":xvay[0]=P1.x-3*PG.getSizeO();xvay[1]=P1.y+3*PG.getSizeO();break; 
		case "Trai":xvay[0]=P1.x-4*PG.getSizeO();xvay[1]=P1.y;break;
		case "Xuong":xvay[0]=P1.x;xvay[1]=P1.y-4*PG.getSizeO();break;
		case "Len":xvay[0]=P1.x;xvay[1]=P1.y+4*PG.getSizeO();break;
	}
	return xvay;
	}
}
