/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Jan 17, 2023
 */
package classes;

public class climberLogic {
	public String posOrNeg(climber randClimber) {
		int ape = randClimber.getWingspan() - randClimber.getHeight();
		if(randClimber.getHeight() < randClimber.getWingspan()) {
			return "Positive: +" + ape + "cm";
		}
		
		return "Negative: " + ape + "cm";
	}
	
	public String getBoulderLvl(climber randClimber) {
		String level = "Beginner";
		int boulderGrade = randClimber.getMaxBoulder();
		
		if(boulderGrade >= 14) {
			return "top 1%";
		} else if (boulderGrade >= 11) {
			return "Pro";
		} else if (boulderGrade >= 7) {
			return "Advanced";
		} else if (boulderGrade >= 3) {
			return "Intermediate";
		} 
		
		return level;
	}
	
	public String getRopeLvl(climber randClimber) {
		String level = "Beginner";
		double boulderGrade = randClimber.getMaxRope();
		
		if (boulderGrade >= 5.14) {
			return "Pro";
		} else if (boulderGrade >= 5.12) {
			return "Advanced";
		} else if (boulderGrade >= 5.10) {
			return "Intermediate";
		} 
		
		return level;
	}
}
