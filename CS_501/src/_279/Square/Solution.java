package _279.Square;

import java.util.Arrays;

public class Solution {
    public int numSquares(int n) {
        int[] result = new int[n+1];
        
        Arrays.fill(result,-1);
        result[0]=0;
        help(result,n);
        return result[n];
    }
    void help(int[] result,int n){
        int maxSquare =(int) Math.sqrt(n);
        int min=Integer.MAX_VALUE;
        
        for(int i = maxSquare;i>0;i--){
            int temp=-1;
            if(result[n-i*i]==-1){
                help(result,n-i*i);
            }
            min=Math.min(min,result[n-i*i]);
        }
        result[n]=min+1;
    }
    public static void main(String[] argv){
    	new Solution().numSquares(1);
    }
}
