package test1;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		JFrame ManHinh=new JFrame();
		ManHinh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ManHinh.setTitle("May dang lam con cac gi voi cuoc doi nay");
		ManHinh.setResizable(false);
		Double DoKho=(double)2;String NhanVat="Player";
		PanelGame Game=new PanelGame(DoKho,NhanVat);
		ManHinh.add(Game);
		ManHinh.pack();
		ManHinh.setLocationRelativeTo(null);
		ManHinh.setVisible(true);
		Game.ChayThread();
	}	
}
