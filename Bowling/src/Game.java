import java.util.List;

public class Game {

	public int bowl(List<Frame> frames) {
		ScoreHandler score = new ScoreHandler();
		int total = 0;
		
		preCalculateScoresForAllFrames(frames);

		for (int i = 0; i < frames.size(); i++) {
			total = score.handleScoring(frames, i);			
		}		
		return total;
	}

	private void preCalculateScoresForAllFrames(List<Frame> frames) {
		for (Frame frame : frames) {
			frame.roll();
		}
	}

}
