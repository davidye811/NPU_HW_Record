package lab3MultiThreadPlus;

import java.util.Random;

public class NumGenerator {
	static private Random randomGenerator = new Random();
	private int maxVal;

	public NumGenerator(int maxValForGenerator) {
		maxVal = maxValForGenerator;
	}
	
	public int retrieveRandomNum() {
		int randomInt;
		
		randomInt = randomGenerator.nextInt(maxVal);
		return randomInt;
	}
	
}
