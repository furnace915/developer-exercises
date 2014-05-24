
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
			frames.add(new Frame(1,0,i));
		}
		assertEquals(10,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreFor300Game() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		for (int i = 1; i<=12; i++){
			frames.add(new Frame(10,0,i));
		}
		assertEquals(300,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForGameHavingOneSpare() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1,1)); //2
		frames.add(new Frame(1,9,2)); //13
		frames.add(new Frame(1,1,3)); //15
		assertEquals(15,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForGameHavingOneStrike() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1,1));
		frames.add(new Frame(10,0,2));
		frames.add(new Frame(8,1,3));
		assertEquals(30,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForGameHavingTwoSparesInARow() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1,1));  //2
		frames.add(new Frame(2,8,2));	//17
		frames.add(new Frame(5,5,3)); //33
		frames.add(new Frame(6,2,4)); //41
		assertEquals(41,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForGameHavingTwoStrikesInARow() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1,1));  //2+
		frames.add(new Frame(10,0,2)); //10+10+6
		frames.add(new Frame(10,0,3)); //10+(6+2)
		frames.add(new Frame(6,2,4)); //8
		assertEquals(54,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForGameHavingThreeStrikesInARow() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1,1));  //2+
		frames.add(new Frame(10,0,2)); //32
		frames.add(new Frame(10,0,3)); //56
		frames.add(new Frame(10,0,4)); //75
		frames.add(new Frame(4,5,5));	//84
		assertEquals(84,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForGameHavingThreeSparesInARow() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1,1));  //2+
		frames.add(new Frame(5,5,2)); //15
		frames.add(new Frame(3,7,3)); //34
		frames.add(new Frame(9,1,4)); //48
		frames.add(new Frame(4,5,5));	//57
		assertEquals(57,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForAllStrikesAndOpen12thFrame() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(10,0,1));	//30	1
		frames.add(new Frame(10,0,2));	//60
		frames.add(new Frame(10,0,3));	//90
		frames.add(new Frame(10,0,4));	//120
		frames.add(new Frame(10,0,5));	//150	5	
		frames.add(new Frame(10,0,6));	//180
		frames.add(new Frame(10,0,7));	//210
		frames.add(new Frame(10,0,8));	//240
		frames.add(new Frame(10,0,9));	//270	9	
		frames.add(new Frame(10,0,10));	//299	10
		frames.add(new Frame(10,0,11));	//299	11
		frames.add(new Frame(9,0,12));		//299	12
		assertEquals(299,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForTenStrikesInARowAndNo10thFrameMark() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(10,0,1));
		frames.add(new Frame(10,0,2));
		frames.add(new Frame(10,0,3));
		frames.add(new Frame(10,0,4));
		frames.add(new Frame(10,0,5));  		
		frames.add(new Frame(10,0,6));
		frames.add(new Frame(10,0,7));
		frames.add(new Frame(10,0,8));
		frames.add(new Frame(10,0,9));	
		frames.add(new Frame(10,0,10));
		frames.add(new Frame(8,1,11));
		assertEquals(287,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForFullGameWithStrikesAndSparesInterspersedAnd12thFrameMark() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1,1));  //2  	#1
		frames.add(new Frame(2,2,2)); //6		#2
		frames.add(new Frame(3,6,3)); //15	#3 
		frames.add(new Frame(5,5,4)); //34	#4	spare
		frames.add(new Frame(9,0,5));  //43	#5
		frames.add(new Frame(10,0,6)); //63	#6	strike
		frames.add(new Frame(7,3,7)); //83	#7	spare
		frames.add(new Frame(10,0,8)); //101	#8	strike
		frames.add(new Frame(4,4,9)); //109	#9	
		frames.add(new Frame(10,0,10)); //129	#10
		frames.add(new Frame(6,4,11));

		assertEquals(129,game.bowl(frames));
	}
	
	@Test
	public void verifyScoreForFullGameWithStrikesAndSparesInterspersedAndNo10thFrameMarks() throws Exception{
		List<Frame> frames = new ArrayList<Frame>();
		frames.add(new Frame(1,1,1));  //2  	#1
		frames.add(new Frame(2,2,2)); //6		#2
		frames.add(new Frame(3,6,3)); //15	#3 
		frames.add(new Frame(5,5,4)); //34	#4	spare
		frames.add(new Frame(9,0,5));  //43	#5
		frames.add(new Frame(10,0,6)); //63	#6	strike
		frames.add(new Frame(7,3,7)); //83	#7	spare
		frames.add(new Frame(10,0,8)); //101	#8	strike
		frames.add(new Frame(4,4,9)); //109	#9	
		frames.add(new Frame(8,1,10)); //118	#10
		assertEquals(118,game.bowl(frames));
	}

}
