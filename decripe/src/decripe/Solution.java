package decripe;

public class Solution {
	public static void main(String[] argv){
		String s= "TXZ0RDVqTWR6RmZRQzBiN2FOTGFuST0=";
		char[] aa=s.toCharArray();
		for(int i=-127;i<256;i++){
			for(char b:aa){
				System.out.print((char)(b+i));
			}
			System.out.println();
		}
	}
}
