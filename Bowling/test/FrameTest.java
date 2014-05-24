import static org.junit.Assert.*;
import org.junit.Test;

public class FrameTest {

	private static final int MAX_POSSIBLE_FRAMES = 12;
	Frame frame;

	@Test
	public void computeFrameScoreWithoutMarks() {
		frame = new Frame(4, 5, 1);
		assertEquals(9, frame.roll());
	}

	@Test
	public void computeFrameScoreWithSpare() {
		frame = new Frame(4, 6, 1);
		assertEquals(10, frame.roll());
	}

	@Test
	public void frameNoStrike() {
		frame = new Frame(1, 8, 1);
		frame.roll();
		assertFalse(frame.isStrike());
	}

	@Test
	public void frameHasStrike() {
		frame = new Frame(10, 0, 1);
		frame.roll();
		assertTrue(frame.isStrike());
	}

	@Test
	public void frameHasSpare() {
		frame = new Frame(1, 9, 1);
		frame.roll();
		assertTrue(frame.isSpare());
	}

	@Test
	public void verifyAllFramesHaveFrameNumber() throws Exception {
		for (int i = 1; i <= MAX_POSSIBLE_FRAMES; i++) {
			createFrame(i);
			frame.roll();
			assertEquals(i, frame.getFrameNumber());
		}

	}

	private void createFrame(int i) {
		if (i < 10) {
			frame = new Frame(1, 0, i);
		} else if (i == 10) {
			frame = new Frame(10, 0, i);
		} else if (i == 11) {
			frame = new Frame(10, 0, i);
		} else if (i == 12) {
			frame = new Frame(10, 0, i);
		}
	}

}
