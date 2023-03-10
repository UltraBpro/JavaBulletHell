package test1;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		JFrame ManHinh=new JFrame();
		ManHinh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ManHinh.setTitle("May dang lam con cac gi voi cuoc doi nay");
		ManHinh.setResizable(false);
		ManHinh.add(new Menu(ManHinh));
		ManHinh.pack();
		ManHinh.setLocationRelativeTo(null);
		ManHinh.setVisible(true);
	}
}
