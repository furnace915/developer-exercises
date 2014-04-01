import java.util.List;

public class Game {

	public int bowl(List<Frame> frames) {
		
		int total = 0;
		preCalculateScoresForAllFrames(frames);

		for (int i = 0; i < frames.size(); i++) {
			if (i < 10) {
				if (frames.get(i).hasSpare()) {
					total += 10;
					total += frames.get(i + 1).getRoll1();
				} else if (!frames.get(i).hasSpare() && !frames.get(i).hasStrike()) {
					total += frames.get(i).roll();
				}
				
				if (frames.get(i).hasStrike()) {
					total += 10;
					if (!frames.get(i + 1).hasSpare() && !frames.get(i + 1).hasStrike()){
						total += frames.get(i+1).roll();
					}
					else if (!frames.get(i + 1).hasSpare() && frames.get(i + 1).hasStrike()){
						total += 10;
						total += frames.get(i + 2).getRoll1();
					}
					else if (frames.get(i + 1).hasSpare() && !frames.get(i + 1).hasStrike()){
						total += 10;
					}
				}
			}			
		}		
		return total;
	}

	private void preCalculateScoresForAllFrames(List<Frame> frames) {
		for (Frame frame : frames) {
			frame.roll();
		}
	}

}
