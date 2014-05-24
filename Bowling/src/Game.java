import java.util.List;

public class Game {

	public int bowl(List<Frame> frames) {
		
		int total = 0;
		int frameNumber = 0;
		
		ScoreHandler score = new ScoreHandler(frames);
		
		for (Frame frame : frames) {
			frame.roll();
			total = score.scoreCurrentFrame(frameNumber);
			frameNumber++;
		}

		return total;
	}
}

