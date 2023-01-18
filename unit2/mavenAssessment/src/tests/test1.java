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

public class test1 {
//		public climber(int height, int wingspan, int maxBoulder, double maxRope) {

	climber Yew;
	climberLogic cLogic;
	int SIX_FEET = 182;
	
	@Before 
	public void setUp() throws Exception {
		Yew = new climber(170, 182, 7, 5.12);
		cLogic = new climberLogic();
	}
	
	@Test
	public void shortClimber() {
		int climberHeight = Yew.getHeight();
		assertTrue(climberHeight < SIX_FEET);
	}
	
	@Test 
	public void positiveWingSpan() {
		String ape = cLogic.posOrNeg(Yew);
		String expected = "Positive: +12cm";
		assertEquals(expected, ape);
	}
	
	@Test
	public void advBoulderLvl() {
		String expected = "Advanced";
		assertEquals(expected, cLogic.getBoulderLvl(Yew));
	}
}
