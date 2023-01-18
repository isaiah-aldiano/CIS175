/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Jan 18, 2023
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classes.climber;
import classes.climberLogic;

public class test2 {
//	public climber(int height, int wingspan, int maxBoulder, double maxRope) {

	climber MeKyle;
	climberLogic cLogic;
	int SIX_FEET = 182;
	
	@Before
	public void setUp() throws Exception{
		MeKyle = new climber(197, 180, 5, 5.10);
		cLogic = new climberLogic();
	}
	
	@Test
	public void tallCLimber() {
		int climberHeight = MeKyle.getHeight();
		assertFalse(climberHeight < SIX_FEET);
	}
	
	@Test 
	public void negWingspan() {
		String expected = "Negative: -17cm";
		String ape = cLogic.posOrNeg(MeKyle);
		assertEquals(expected, ape);
	}
	
	@Test 
	public void interRopeLvl() {
		String expected = "Intermediate";
		assertEquals(expected, cLogic.getRopeLvl(MeKyle));
	}
}
