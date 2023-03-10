package test1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu extends JPanel {
	static String NV="Mage";
	static double DK;
	static JFrame MH;
    public Menu(JFrame ManHinh) {
        setLayout(new BorderLayout()); // Sử dụng BorderLayout để chia Panel thành 3 vùng: NORTH, CENTER và SOUTH
        setPreferredSize(new Dimension(500, 300)); // Thiết lập kích thước ưu tiên cho Panel
        // Tạo thành phần ở phía Bắc (NORTH)
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Sử dụng FlowLayout để căn giữa các thành phần và tạo khoảng trống giữa chúng
        JLabel label = new JLabel("Độ khó:");
        JTextField textField = new JTextField(10);
        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(c!=KeyEvent.VK_PERIOD)if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });
        topPanel.add(label);
        topPanel.add(textField);
        add(topPanel, BorderLayout.NORTH);

        // Tạo thành phần ở giữa (CENTER)
        JPanel centerPanel = new JPanel(new GridLayout(1, 3, 10, 10)); // Sử dụng GridLayout để tạo lưới 1 hàng x 3 cột cho các phím
        ImageIcon icon1 = new ImageIcon("res/Mage/Xuong0.png");
        JButton button1 = new JButton(icon1);
        button1.setText("Mage");
        ImageIcon icon2 = new ImageIcon("res/Knight/Xuong0.png");
        JButton button2 = new JButton(icon2);
        button2.setText("Knight");
        ImageIcon icon3 = new ImageIcon("res/FemaleWarrior/Xuong0.png");
        JButton button3 = new JButton(icon3);
        button3.setText("Bitch");
        centerPanel.add(button1);button1.addActionListener(new ChonNV("Mage"));
        centerPanel.add(button2);button2.addActionListener(new ChonNV("Knight"));
        centerPanel.add(button3);button3.addActionListener(new ChonNV("FemaleWarrior"));
        add(centerPanel, BorderLayout.CENTER);

        // Tạo thành phần ở phía Nam (SOUTH)
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton startButton = new JButton("Start");
        bottomPanel.add(startButton);
        add(bottomPanel, BorderLayout.SOUTH);
        startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText() == null || textField.getText().isEmpty())DK=2;
				else DK=Double.parseDouble(textField.getText());
				ManHinh.dispose();
				runGame();
			}
		});
    }
	static void runGame() {
		JFrame MH=new JFrame();
		MH.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MH.setTitle("May dang lam con cac gi voi cuoc doi nay");
		MH.setResizable(false);
		PanelGame Game=new PanelGame(DK,NV);
		MH.add(Game);
		MH.pack();
		MH.setLocationRelativeTo(null);
		MH.setVisible(true);
		Game.ChayThread();
	}
	class ChonNV implements ActionListener{ 
		String ThisNV;
		ChonNV(String NhanVat){
		ThisNV=NhanVat;
		}
		public void actionPerformed(ActionEvent e) {
			NV=ThisNV;
		}
	}
}