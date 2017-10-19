package reverseInt;
	public class Solution {
	    public int reverse(int x) {
	        if(x<0){
	            return -(helpreverse(-x));
	        }
	        return helpreverse(x);
	    }
	    int helpreverse(int x){
	        int sum=0;
	        while(x>0){
	            sum=(sum*10)+x%10;
	            x=x/10;
	            if(sum>Integer.MAX_VALUE/10)
	                return 0;
	        }
	        return sum;
	    }

	public static void main(String[] argv){
		Solution a = new Solution();
		System.out.println(new Solution().reverse(1534236469));
	}
}
