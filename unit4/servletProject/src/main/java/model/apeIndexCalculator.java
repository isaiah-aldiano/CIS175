package model;
/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Feb 6, 2023
 */

public class apeIndexCalculator {
	private int height;
	private int wingspan;
	
	public apeIndexCalculator(int height, int wingspan) {
		this.height = height;
		this.wingspan = wingspan;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWingspan(int wingspan) {
		this.wingspan = wingspan;
	}
	
	public String apeComment(int someApe) {
		
		if(someApe >= 6) {
			return "DANG you got some long arms! Ever been climbing?";
		} else if (someApe >= 4) {
			return "Good ape index! Some reach on you!";
		} else if (someApe >= 2) {
			return "Solid ape! Pretty good for reaching those high shelves";
		} else if (someApe >= 0) {
			return "Average ape! Most people have a wingspan equal to their height";
		}
		
		return "Negative ape index is nothing to be sad about! You just have to be jumpy!!";
	}
	
	public String getApe() {
		int apeIndex = this.wingspan - this.height;
		String results = "";
		
		if(apeIndex > 0) {
			results = "+" + apeIndex + " "; 
		} else if (apeIndex < 0) {
			results = apeIndex + " ";
		}

		return results + apeComment(apeIndex);
	}
}
