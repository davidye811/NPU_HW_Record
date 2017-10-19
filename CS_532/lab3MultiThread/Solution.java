package lab3MultiThread;

import java.util.Arrays;

public class Solution {
	public static void main(String[] argv) throws InterruptedException{
		int[][] a={{1,2},{2,3}};
		int[] result=new int[a.length];
			multiTimes[] multiTimesa=new multiTimes[a.length];
			for(int i =0;i<a.length;i++){
				multiTimesa[i]=new multiTimes(a[i]);
				multiTimesa[i].run();
			}
			for(int i =0;i<a.length;i++){
				multiTimesa[i].join();
				result[i]=multiTimesa[i].get_result();
			}
			
			System.out.println(Arrays.toString(result));
	}
}
