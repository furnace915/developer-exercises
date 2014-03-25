
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class GameTest {
	
	Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game();
	}
	
	@Test
	public void verifyScoreForMultipleFramesWithNoMarks() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		for (int i = 1; i<=10; i++){
			frames.add(new Frame(1,0));
		}
		assertEquals(10,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForMultipleFramesWithOneSpare() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1));
		frames.add(new Frame(1,9));
		frames.add(new Frame(1,1));
		assertEquals(15,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForMultipleFramesWithOneStrike() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1));
		frames.add(new Frame(10,0));
		frames.add(new Frame(8,1));
		assertEquals(30,game.bowl(frames));
	}

}
