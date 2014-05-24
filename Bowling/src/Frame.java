public class Frame {

	private int roll1;
	private int roll2;
	private int frameNumber;

	public Frame(int roll1prop, int roll2prop, int frameNumber) {
		this.roll1 = roll1prop;
		this.roll2 = roll2prop;
		this.frameNumber = frameNumber;
	}

	public int roll() {
		return roll1 + roll2;
	}

	public boolean isStrike() {
		if (roll1 == 10) {
			return true;
		}
		return false;
	}

	public boolean isSpare() {
		if (roll1 != 10 && roll1 + roll2 == 10) {
			return true;
		}
		return false;
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

}
