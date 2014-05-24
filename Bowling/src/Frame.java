public class Frame {

	private boolean strike;
	private boolean spare;
	private int roll1;
	private int roll2;
	private int frameNumber;

	public Frame(int roll1prop, int roll2prop, int frameNumber) {
		this.roll1 = roll1prop;
		this.roll2 = roll2prop;
		setFrameNumber(frameNumber);
	}

	public int roll() {

		if (roll1 == 10) {
			strike = true;
		}
		if (roll1 != 10 && roll1 + roll2 == 10) {
			spare = true;
		}
		return roll1 + roll2;
	}

	public boolean hasStrike() {
		return strike;
	}

	public boolean hasSpare() {
		return spare;
	}

	public int getFrameNumber() {
		return frameNumber;
	}

	public int getRoll1() {
		return roll1;
	}

	public int getRoll2() {
		return roll2;
	}

	private void setFrameNumber(int frameNumber) {
		this.frameNumber = frameNumber;
	}

}
