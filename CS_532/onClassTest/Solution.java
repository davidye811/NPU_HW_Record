package onClassTest;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	static int[] resource= {1,5,8,10,13,17,18,20,24,30};
	public static void main(String[] argv){
		System.out.println(maxPrice(35));
	}
	static int maxPrice(int length){
		if(length<=10)
			return resource[length-1];
		int max=Integer.MIN_VALUE;
		for(int i=1;i<=10;i++){
			int temp=maxPrice(length-i)+resource[i-1];
			if(temp>max)
				max=temp;
		}
		return max;
	}
}
