
public class Closest {

	public static int findClosetToZero(int...iArr) {
			
		Integer closestToZeroValue = Integer.MAX_VALUE;
		for (int i = 0; i<iArr.length;i++){ 
			if (Math.abs(iArr[i]) <= Math.abs(closestToZeroValue)){
				closestToZeroValue = iArr[i];
			}
		}
		return closestToZeroValue;
	}

	
		
}
