package business.services.util;

/**
 * Utility class that provides static methods for mathematical calculations.
 * 
 * @author Sascha Scheid
 *
 */
public class MathUtil {

	/**
	 * Converts linear scale to decibel scale.
	 * 
	 * @param toConvert (float) Linear scaled value.
	 * @return (float) Decibel scaled value.
	 */
	public static float convertLinearToDB(float toConvert) {
		return (float) (10 * Math.log10(toConvert));
	}

	/**
	 * Calculates Random int value in a given range.
	 * 
	 * @param min (int) Lower bound of the given range.
	 * @param max (int) Upper bound of the given range.
	 * @return (int) Random value between min and max.
	 */
	public static int getRandomInRange(int min, int max) {
		return min + (int) (Math.random() * (max - min + 1));
	}

}
