package _NumberComplement;

public class Solution {
    
    public int findComplement(int num) {
        int i = 1;
      while(i<=num){
          i=i<<1;
          if(i<0){
              return Integer.MAX_VALUE-num;
          }
      }
        return i-num-1;
    }
    public static void main(String[] argv){
    	System.out.println(new Solution().findComplement(2147483647));
    }
}