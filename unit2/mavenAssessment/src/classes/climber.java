/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Jan 17, 2023
 */
package classes;

public class climber {
	private String name;
	private int height;
	private int wingspan;
	private int maxBoulder;
	private double maxRope;
	

	public climber() {
		
	}
	
	public climber(int height, int wingspan, int maxBoulder, double maxRope) {
		this.height = height;
		this.wingspan = wingspan;
		this.maxBoulder = maxBoulder;
		this.maxRope = maxRope;
	}

	public String getName() {
		return name;
	}

	public int getHeight() {
		return height;
	}

	public int getWingspan() {
		return wingspan;
	}
	
	public int getMaxBoulder() {
		return maxBoulder;
	}

	public double getMaxRope() {
		return maxRope;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWingspan(int wingspan) {
		this.wingspan = wingspan;
	}
	
	public void setMaxBoulder(int maxBoulder) {
		this.maxBoulder = maxBoulder;
	}

	public void setMaxRope(double maxRope) {
		this.maxRope = maxRope;
	}
	
}
