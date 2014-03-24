
public class Closest {

	public static int findClosetToZero(int... iArr) {

		int closest = Integer.MAX_VALUE;
		for (int i = 0; i < iArr.length; i++) {
			if (Math.abs(iArr[i]) < Math.abs(closest)) {
				closest = iArr[i];
			}
			if (Math.abs(iArr[i]) == Math.abs(closest)) {
				closest = Math.max(iArr[i], closest);
			}
		}
		return closest;
	}

}
