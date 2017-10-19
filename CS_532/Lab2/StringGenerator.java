package Lab2;

import java.util.Random;

public class StringGenerator {
	static private Random randomNumGenerator = new Random();
	static private String alphabet = "abcdefghijklmnopqrstuvwxyz";
	static private int alphabetSize = 26;
	private int maxStringLen;
	
	public StringGenerator(int maxStringSize) {
		maxStringLen = maxStringSize;
	}
	
	public int generateRandNum() {
		int randNum;
		
		randNum = randomNumGenerator.nextInt(maxStringLen);
		randNum = randNum + 1;   // so we will never have zero
		return randNum;
	}
	
	public String generateStr() {
		int strLen, i, strIdx;
		char newCh;
		StringBuilder strBuilder = new StringBuilder();
		
		strLen = generateRandNum();
		
		for (i=0; i<strLen; i++) {
			strIdx = randomNumGenerator.nextInt(alphabetSize); 
			newCh = alphabet.charAt(strIdx);
			strBuilder.append(newCh);
		}
		
		return strBuilder.toString();
	}

}