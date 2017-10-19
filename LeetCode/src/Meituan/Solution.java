package Meituan;

public class Solution {
	public static void main(String[] argv){
		System.out.println(calculateAvgAge(5,5,0.2,3));
	}
	public static int calculateAvgAge(int W,int Y,double x,int N){
		if(x<=0||x>=1)
				return -1;
		double avg=Y;
		while(N>0){
			avg=((avg+1)*(W*(1-x))+W*x*21)/W;
			N--;
		}
		if(avg==(int)avg)
		return (int)avg;
		return (int)avg+1;
	}
}
