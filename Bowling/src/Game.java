import java.util.List;

public class Game {

	public int bowl(List<Frame> frames) {
		ScoreHandler score = new ScoreHandler();
		int total = 0;
		
		preCalculateScoresForAllFrames(frames);
		
//		int frameNumber = 0;
//		for (Frame frame : frames){
//			total = score.scoreCurrentFrame(frames, frameNumber);
//			frameNumber++;
//		}

		for (int currentFrame = 0; currentFrame < 10; currentFrame++) {
			total = score.scoreCurrentFrame(frames, currentFrame);			
		}		
		return total;
	}

	private void preCalculateScoresForAllFrames(List<Frame> frames) {
		for (Frame frame : frames) {
			frame.roll();
		}
	}

}
