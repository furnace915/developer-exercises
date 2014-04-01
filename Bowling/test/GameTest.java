
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
	public void verifyScoreForGameHavingNoMarks() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		for (int i = 1; i<=10; i++){
			frames.add(new Frame(1,0));
		}
		assertEquals(10,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForGameHavingOneSpare() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1)); //2
		frames.add(new Frame(1,9)); //13
		frames.add(new Frame(1,1)); //15
		assertEquals(15,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForGameHavingOneStrike() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1));
		frames.add(new Frame(10,0));
		frames.add(new Frame(8,1));
		assertEquals(30,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForGameHavingTwoSparesInARow() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1));  //2
		frames.add(new Frame(2,8));	//17
		frames.add(new Frame(5,5)); //33
		frames.add(new Frame(6,2)); //41
		assertEquals(41,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForGameHavingTwoStrikesInARow() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1));  //2+
		frames.add(new Frame(10,0)); //10+10+6
		frames.add(new Frame(10,0)); //10+(6+2)
		frames.add(new Frame(6,2)); //8
		assertEquals(54,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForGameHavingThreeStrikesInARow() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1));  //2+
		frames.add(new Frame(10,0)); //32
		frames.add(new Frame(10,0)); //56
		frames.add(new Frame(10,0)); //75
		frames.add(new Frame(4,5));	//84
		assertEquals(84,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForGameHavingThreeSparesInARow() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1));  //2+
		frames.add(new Frame(5,5)); //15
		frames.add(new Frame(3,7)); //34
		frames.add(new Frame(9,1)); //48
		frames.add(new Frame(4,5));	//57
		assertEquals(57,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreFor300Game() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));  		
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));	
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		assertEquals(300,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForAllStrikesAndOpen12thFrame() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(10,0));	//30	1
		frames.add(new Frame(10,0));	//60
		frames.add(new Frame(10,0));	//90
		frames.add(new Frame(10,0));	//120
		frames.add(new Frame(10,0));	//150	5	
		frames.add(new Frame(10,0));	//180
		frames.add(new Frame(10,0));	//210
		frames.add(new Frame(10,0));	//240
		frames.add(new Frame(10,0));	//270	9	
		frames.add(new Frame(10,0));	//299	10
		frames.add(new Frame(10,0));	//299	11
		frames.add(new Frame(9,0));		//299	12
		assertEquals(299,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForTenStrikesInARowAndNo10thFrameMark() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));  		
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));
		frames.add(new Frame(10,0));	
		frames.add(new Frame(10,0));
		frames.add(new Frame(8,1));
		assertEquals(287,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForFullGameWithStrikesAndSparesInterspersedAnd12thFrameMark() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1));  //2  	#1
		frames.add(new Frame(2,2)); //6		#2
		frames.add(new Frame(3,6)); //15	#3 
		frames.add(new Frame(5,5)); //34	#4	spare
		frames.add(new Frame(9,0));  //43	#5
		frames.add(new Frame(10,0)); //63	#6	strike
		frames.add(new Frame(7,3)); //83	#7	spare
		frames.add(new Frame(10,0)); //101	#8	strike
		frames.add(new Frame(4,4)); //109	#9	
		frames.add(new Frame(10,0)); //129	#10
		frames.add(new Frame(6,4)); //139	#11

		assertEquals(129,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForFullGameWithStrikesAndSparesInterspersedAndNo10thFrameMarks() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1));  //2  	#1
		frames.add(new Frame(2,2)); //6		#2
		frames.add(new Frame(3,6)); //15	#3 
		frames.add(new Frame(5,5)); //34	#4	spare
		frames.add(new Frame(9,0));  //43	#5
		frames.add(new Frame(10,0)); //63	#6	strike
		frames.add(new Frame(7,3)); //83	#7	spare
		frames.add(new Frame(10,0)); //101	#8	strike
		frames.add(new Frame(4,4)); //109	#9	
		frames.add(new Frame(8,1)); //118	#10
		assertEquals(118,game.bowl(frames));
	}

}
