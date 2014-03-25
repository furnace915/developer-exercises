
public class Frame {

	public Frame(int roll1prop, int roll2prop) {
		this.roll1 = roll1prop;
		this.roll2 = roll2prop;
		this.roll();
	}

	public int getRoll1() {
		return roll1;
	}

	public int getRoll2() {
		return roll2;
	}

	public boolean strike;
	public boolean spare;
	private int roll1;
	private int roll2;
	
	public int roll() {
		
		if (roll1 == 10){
			strike = true;
		}
		
		if (roll1 != 10 && roll1 + roll2 == 10){
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


}


