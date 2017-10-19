package _354.RussianDollEnvelopes;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public static void main(String[] argv){
		int[][] envelopes={{5,4},{6,4},{6,7},{2,3}};
		System.out.println((new Solution().maxEnvelopes(envelopes)));
		
	}
	@SuppressWarnings("unchecked")
	public int maxEnvelopes(int[][] envelopes) {
	        Arrays.sort(envelopes,new Comparator(){
				public int compare(Object o1, Object o2) {
					int[] a=(int[])o1;
					int[] b=(int[])o2;
					if(a[0]>b[0])
						return 1;
					if(a[0]<b[0])
						return -1;
					if(a[1]>b[1])
						return 1;
					if(a[1]<b[1])
						return -1;
					return 0;
				}});
	        for(int[] m:envelopes){
	        	System.out.print(Arrays.toString(m));

	        }

        	System.out.println();
	        int size=envelopes.length;
	        for(int i=0;i<envelopes.length-1;i++){
	        	if(envelopes[i][0]!=envelopes[i+1][0]&&envelopes[i][1]<envelopes[i+1][1])
	        		size--;
	        }
			return size;
	    }

}
