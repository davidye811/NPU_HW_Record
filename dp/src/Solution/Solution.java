package Solution;

public class Solution {
	public static void main(String[] argv){
		int[] a ={1,2,3,0,2};
		System.out.println(maxProfit(a));
	}
    public static int maxProfit(int[] prices) {
        
        int n =prices.length;
        if(n<=1) return 0;
        
        int[] s0= new int[n];
        int[] s1= new int[n];
        s1[0]=-prices[0];
        for(int i = 1;i<n;i++){
            s0[i]=max(s0[i-1],s1[i-1]+prices[i]);
            if(i==1)
                s1[i]=max(s1[i-1],-prices[i]);
                else
            s1[i]=max(s1[i-1],s0[i-2]-prices[i]);
        }
        return s1[n-1];
    }
    static int max(int a,int b){
        return (a>b)?a:b;
        
    }
}