
public class Frame {

	public boolean strike;
	public boolean spare;

	public int roll(int roll1, int roll2) {
		
		strike = false;
		spare = false;
		
		if (roll1 == 10){
			strike = true;
		}
		
		if (roll1 + roll2 == 10){
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


