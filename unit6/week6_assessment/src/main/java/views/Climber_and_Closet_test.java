/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Feb 21, 2023
 */
package views;

import java.util.List;

import controller.ClimberHelper;
import controller.GearClosetHelper;
import model.climber;
import model.gearCloset;

public class Climber_and_Closet_test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		climber rick = new climber("Rick");
		gearCloset ricksCloset = new gearCloset("Ricks Closet", rick);
		
		ClimberHelper ch = new ClimberHelper();
		
		GearClosetHelper gch = new GearClosetHelper();
		
		ch.insertClimber(rick);
		
		gch.createCloset(ricksCloset);
		
		List<gearCloset> allClosets = gch.viewAllClosets();
		
		for(gearCloset gc : allClosets) {
			System.out.println(gc.toString());
		}
	}

}
