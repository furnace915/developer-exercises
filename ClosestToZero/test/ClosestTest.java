import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class ClosestTest {

	
	@Test
	public void findClosestToZeroWhenInputIsZero() {
		Assert.assertEquals(0, Closest.findClosetToZero(0));
	}
	
	@Test
	public void findClosestToZeroWhenInputIsGreaterThanZero() {
		Assert.assertEquals(1, Closest.findClosetToZero(1));
	}
	
	@Test
	public void findClosestToZeroForMultipleNumbersGreaterThanZero() {
		Assert.assertEquals(2, Closest.findClosetToZero(2,4));
	}
	
	@Test
	public void findClosestToZeroForMultipleNumbersIncludingZero() {
		Assert.assertEquals(0, Closest.findClosetToZero(0,2,4));
	}
	
	@Test
	public void findClosestToZeroForPositiveAndNegativeNumbersWithZero() {
		Assert.assertEquals(0, Closest.findClosetToZero(-1,2,0,-3,4));
	}
	
	@Test
	public void findClosestToZeroForPositiveAndNegativeNumbersWithNegativeWinner() {
		Assert.assertEquals(-1, Closest.findClosetToZero(-1,2,-3,4));
	}
	
	@Test
	public void findClosestToZeroForPositiveAndNegativeNumbersWithTie() {
		Assert.assertEquals(1, Closest.findClosetToZero(-1,2,1,4));
	}
	
	@Test
	public void findClosestToZeroForPositiveAndNegativeNumbersWithTieAndZero() {
		Assert.assertEquals(0, Closest.findClosetToZero(-2,2,1,0,4));
	}
	
	@Test
	public void findClosestToZeroForPositiveAndNegativeNumbersWithTieReverseOrder() {
		Assert.assertEquals(1, Closest.findClosetToZero(1,2,-1,4));
	}
	
	@Test
	public void findClosestToZeroForAllNegatives() {
		Assert.assertEquals(-1, Closest.findClosetToZero(-2,-1,-3));
	}
	
	@Test
	public void findClosestToZeroForAllNegativesWithZero() {
		Assert.assertEquals(0, Closest.findClosetToZero(-2,-1,0,-3));
	}
	
	
}
