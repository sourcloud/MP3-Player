package business.services.util;

public class MathUtil {

	public static float convertLinearToDB(float toConvert) {
		return (float) (10 * Math.log10(toConvert));
	}
	
	public static int getRandomInRange(int lowerBound, int upperBound) {
		return (int) (lowerBound + Math.random() * (upperBound - lowerBound));
	}
	
}
