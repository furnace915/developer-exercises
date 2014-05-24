import java.util.ArrayList;
import java.util.List;

public class ScoreHandler {

	private static final int TENTH_FRAME = 10;
	int frameScore;
	List<Frame> frames = new ArrayList<Frame>();

	public ScoreHandler(List<Frame> frames) {
		this.frames = frames;
	}

	public int scoreCurrentFrame(int position) {
		Frame frame = frames.get(position);
		if (frame.isStrike()) {
			handleStrike(position);
		} else if (frame.isSpare()) {
			handleSpare(position);

		} else {
			frameScore += frame.roll();
		}

		return frameScore;
	}

	private void handleSpare(int position) {
		addTenToFrameScore();
		Frame frame = frames.get(position);
		if (frame.getFrameNumber() <= TENTH_FRAME) {
			frameScore += getScoreForRoll1NextFrame(position);
		}
	}

	private int getScoreForRoll1NextFrame(int position) {
		return frames.get(position + 1).getRoll1();
	}

	private void handleStrike(int frame) {
		addTenToFrameScore();
		if (frames.get(frame).getFrameNumber() < TENTH_FRAME) {
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
		return frames.get(frame + 1).isSpare() && !frames.get(frame + 1).isStrike();
	}

	private boolean nextFrameHasStrike(int frame) {
		return !frames.get(frame + 1).isSpare() && frames.get(frame + 1).isStrike();
	}

	private int getScoreForNextFrame(int frame) {
		return frames.get(frame + 1).roll();
	}

	private boolean nextFrameHasStrikeOrSpare(int frame) {
		return frames.get(frame + 1).isSpare() || frames.get(frame + 1).isStrike();
	}

	private void rollNextFrame(int frame) {
		getScoreForNextFrame(frame);
	}

}
