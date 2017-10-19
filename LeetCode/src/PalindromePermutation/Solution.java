package PalindromePermutation;

public class Solution {
    public static boolean canPermutePalindrome(String s) {
        int[] count = new int[256];
        for(int i = 0;i<s.length();i++){
            count[s.charAt(i)]++;
        }
        int number=0;
        for(int i =0; i <count.length;i++){
            if((count[i]&1)==1)
                if(++number>1)
                return false;
        }
        return true;
    }
    public static void main(String[] argv){
    	System.out.print(canPermutePalindrome("as"));
    }
}