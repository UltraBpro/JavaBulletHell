package test1;

import java.util.ArrayList;
import java.util.List;

class character{
	private NhanVat KieuNhanVat;
	private int Position;
	
	public NhanVat getKieuNhanVat() {
		return KieuNhanVat;
	}
	public void setKieuNhanVat(NhanVat kieuNhanVat) {
		KieuNhanVat = kieuNhanVat;
	}
	public int getPosition() {
		return Position;
	}
	public void setPosition(int position) {
		Position = position;
	}
}

public class Lane {
    private int length; // length of the lane
    private List<character> characters; // list of characters on the lane
    
    public Lane(int length, int characterWidth) {
        this.length = length;
        characters = new ArrayList<character>();
    }
    
    public void addcharacter(character c, int spacing) {
        characters.add(c);
        for (int i = 0; i < characters.size(); i++) {
            int xPos = i * 1;
            characters.get(i).setPosition(xPos);
        }
    }
   }
