import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FrameTest {

	Frame frame;
	
	@Before
	public void setUp(){

	}
	
	@Test
	public void computeFrameScoreWithoutMarks() {
		frame = new Frame(4,5);
		assertEquals(9,frame.roll());
	}
	
	@Test
	public void computeFrameScoreWithSpare() {
		frame = new Frame(4,6);
		assertEquals(10,frame.roll());
	}
	
	@Test
	public void frameNoStrike(){
		frame = new Frame(1,8);
		frame.roll();
		assertFalse(frame.hasStrike());
	}
	
	@Test
	public void frameHasStrike(){
		frame = new Frame(10,0);
		frame.roll();
		assertTrue(frame.hasStrike());
	}
	
	@Test
	public void frameHasSpare(){
		frame = new Frame(1,9);
		frame.roll();
		assertTrue(frame.hasSpare());
	}

}
