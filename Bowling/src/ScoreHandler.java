import java.util.List;


public class ScoreHandler {

	int total;
	
	public int handleScoring(List<Frame> frames, int frame) {
		if (frame < 10) {
			if (frames.get(frame).hasStrike()) {
				handleStrike(frames, frame);
			}
			else if (frames.get(frame).hasSpare()) {
				total += 10;
				total += frames.get(frame + 1).getRoll1();
			} else  {
				total += frames.get(frame).roll();
			}
			
		}
		return total;
	}

	private void handleStrike(List<Frame> frames, int frame) {
			total += 10;
			if (!frames.get(frame + 1).hasSpare() && !frames.get(frame + 1).hasStrike()){
				total += frames.get(frame+1).roll();
			}
			else if (!frames.get(frame + 1).hasSpare() && frames.get(frame + 1).hasStrike()){
				total += 10;
				total += frames.get(frame + 2).getRoll1();
			}
			else if (frames.get(frame + 1).hasSpare() && !frames.get(frame + 1).hasStrike()){
				total += 10;
			}
	}
	
	
}
