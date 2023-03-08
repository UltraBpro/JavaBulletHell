package entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import test1.PanelGame;

public class FPS extends Entity{
	PanelGame PG;
	public FPS(PanelGame Panel) {
		PG=Panel;
		setDefault();
	}
	public void setDefault() {
		x=0;
		y=0;
		Direction="0";
	}
	public void Update(int x) {
			Direction=Integer.toString(x);
	}
	public void Draw(Graphics2D g2) {
		g2.setColor(Color.GREEN);
		g2.setFont(new Font("Roboto Bold", Font.BOLD, PG.getSizeO()/2));
		g2.drawString(Direction, 0, PG.getSizeO()/2);
	}

}
