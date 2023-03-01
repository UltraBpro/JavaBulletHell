package test1;

public class NhanVat {
	    private int power;
	    private int speed;
	    private int cost;
	    
	    public NhanVat(int power, int speed, int cost) {
	        this.power = power;
	        this.speed = speed;
	        this.cost = cost;
	    }
	    
	    public void showSpecialAbility() {
	        System.out.println("Nang luc dac biet");
	    }
	 
	    public int getPower() {
	        return power;
	    }
	 
	    public void setPower(int power) {
	        this.power = power;
	    }
	 
	    public int getSpeed() {
	        return speed;
	    }
	 
	    public void setSpeed(int speed) {
	        this.speed = speed;
	    }
	 
	    public int getCost() {
	        return cost;
	    }
	    
	}
