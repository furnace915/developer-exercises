import java.util.List;

public class Game {

	public int bowl(List<Frame> frames) {
		int total = 0;
		boolean previousSpare = false;
		boolean previousStrike = false;

		for (Frame frame : frames) {
			if (!frameHasMark(frame)
					&& !previousFrameHasMark(previousStrike, previousSpare)) {
				total += frame.roll();
			} else if (frameHasMark(frame)) {
				total += 10;
			} else if (!frameHasMark(frame) && previousSpare == true) {
				total += frame.getRoll1();
				total += frame.roll();
			} else if (!frameHasMark(frame) && previousStrike == true) {
				total += frame.roll();
				total += frame.roll();
			}
			previousSpare = frame.hasSpare();
			previousStrike = frame.hasStrike();
		}
		return total;
	}

	private boolean frameHasMark(Frame frame) {
		return frame.hasSpare() || frame.hasStrike();
	}

	private boolean previousFrameHasMark(boolean previousSpare,
			boolean previousStrike) {
		return previousSpare || previousStrike;
	}

}
