package fib;

public class Solution {
	public static void main(String[] argv){
		System.out.println(fib(45));
	}
	public static int fib(int a){
		int[] aa =new int[a+1];
		if(a>=2)
			aa[1]=1;
		for(int i=0;i<a-1;i++){
			aa[i+2]=aa[i]+aa[i+1];
		}
		return aa[a];
	}
}
