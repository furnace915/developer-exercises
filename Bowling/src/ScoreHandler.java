import java.util.ArrayList;
import java.util.List;

public class ScoreHandler {

	int frameScore;
	List<Frame> frames = new ArrayList<Frame>();

	public ScoreHandler(List<Frame> frames) {
		this.frames = frames;
	}

	public int scoreCurrentFrame(int position) {
		if (frames.get(position).hasStrike()) {
			handleStrike(position);
		} else if (frames.get(position).hasSpare()) {
			handleSpare(position);

		} else {
			frameScore += frames.get(position).roll();
		}

		return frameScore;
	}

	private void handleSpare(int position) {
		addTenToFrameScore();
		if (frames.get(position).getFrameNumber() < 11) {
			frameScore += getScoreForRoll1NextFrame(position);
		}
	}

	private int getScoreForRoll1NextFrame(int position) {
		return frames.get(position + 1).getRoll1();
	}

	private void handleStrike(int frame) {
		addTenToFrameScore();
		if (frames.get(frame).getFrameNumber() < 10) {
			rollNextFrame(frame);
			if (!nextFrameHasStrikeOrSpare(frame)) {
				frameScore += getScoreForNextFrame(frame);
			} else if (nextFrameHasStrike(frame)) {
				addTenToFrameScore();
				frameScore += frames.get(frame + 2).getRoll1();
			} else if (nextFrameHasSpare(frame)) {
				addTenToFrameScore();
			}
		}

	}

	private void addTenToFrameScore(){
		frameScore += 10;
	}
	
	private boolean nextFrameHasSpare(int frame) {
		return frames.get(frame + 1).hasSpare() && !frames.get(frame + 1).hasStrike();
	}

	private boolean nextFrameHasStrike(int frame) {
		return !frames.get(frame + 1).hasSpare() && frames.get(frame + 1).hasStrike();
	}

	private int getScoreForNextFrame(int frame) {
		return frames.get(frame + 1).roll();
	}

	private boolean nextFrameHasStrikeOrSpare(int frame) {
		return frames.get(frame + 1).hasSpare() || frames.get(frame + 1).hasStrike();
	}

	private void rollNextFrame(int frame) {
		getScoreForNextFrame(frame);
	}

}
