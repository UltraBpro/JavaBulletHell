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
            int xPos = i * (characterWidth + spacing);
            characters.get(i).setPosition(xPos);
        }
    }
    
    public void movecharacter(character c, int distance) {
        int currentPos = characters.indexOf(c);
        int newPos = currentPos + distance;
        
        if (newPos < 0 || newPos >= length) {
            throw new IllegalArgumentException("Invalid position for character");
        }
        
        characters.remove(currentPos);
        characters.add(newPos, c);
        
        // update character positions
        for (int i = 0; i < characters.size(); i++) {
            int spacing = characters.get(i).getSpacing();
            int xPos = i * (characterWidth + spacing);
            characters.get(i).setPosition(xPos);
        }
    }
    
    public int getcharacterPosition(character c) {
        return c.getPosition();
    }
}
