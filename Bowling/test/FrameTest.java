import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FrameTest {

	Frame frame;
	
	@Before
	public void setUp(){
		frame = new Frame();
	}
	
	@Test
	public void computeFrameScoreWithoutMarks() {
		assertEquals(9,frame.roll(4,5));
	}
	
	@Test
	public void computeFrameScoreWithSpare() {
		assertEquals(10,frame.roll(4,6));
	}
	
	@Test
	public void frameNoStrike(){
		frame.roll(1,8);
		assertFalse(frame.hasStrike());
	}
	
	@Test
	public void frameHasStrike(){
		frame.roll(10,0);
		assertTrue(frame.hasStrike());
	}
	
	@Test
	public void frameHasSpare(){
		frame.roll(1,9);
		assertTrue(frame.hasSpare());
	}

}
