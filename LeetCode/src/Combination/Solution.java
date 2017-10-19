package Combination;

import java.util.Scanner;

public class Solution {
	public static void main(String[] argv){
		while(true){
		Scanner in = new Scanner(System.in);
		try{
		System.out.print("Type in the value of \"n\":");
		int n=in.nextInt();
		System.out.print("Type in the value of \"k\":");
		int k=in.nextInt();
		if(n>k)
		System.out.println("The number of combinations for 7 items taken 4 at a time is: "+combination(n,k));
		if(n<k)
			System.out.println("n must be bigger than k");
		}catch(Exception e){
			System.out.println("valid input");
		}
	}
	}
	public static int combination(int n,int k){
		int cal=1;
		for(int i =n;i>(n-k);i--){
			cal*=i;
		}
		for(int i=1;i<=k;i++){
			cal/=i;
		}
		return cal;
		
	}
}
