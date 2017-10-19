package _ReverseInt;

public class Solution {
    public int reverse(int x) {
        int flag = 0;
        if(x<0){
            flag = 1;
            x=-x;
        }
        int sum=0;
        while(x>0){
        		if(sum>Integer.MAX_VALUE/10){
        			flag=2;
        		}
            sum=sum*10;
            sum+=(x%10);
            x=x/10;
        }
        if(flag==1)
            return -sum;
        if(flag==2)
        	return 0;
        return sum;
    }
    public static void main(String[] argv){
    	System.out.print(new Solution().reverse(1534236469));
    }
}