package test1;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame ManHinh=new JFrame();
		ManHinh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ManHinh.setTitle("May dang lam con cac gi voi cuoc doi nay");
		PanelGame Game=new PanelGame();
		ManHinh.add(Game);
		ManHinh.pack();
		ManHinh.setResizable(false);
		ManHinh.setLocationRelativeTo(null);
		ManHinh.setVisible(true);
		Game.ChayThread();
	}

}