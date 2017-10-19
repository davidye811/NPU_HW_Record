package _22.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public boolean validPalindrome(String s) {
       int[] result = new int[26];
        char[] source = s.toCharArray();
        for(char m:source){
            if(result[m-'a']==0){
                result[m-'a']++;
            }else{
                result[m-'a']--;
            }
        }
        int sum=0;
        for(int i:result){
            if(i!=0){
                sum++;
            }
        }
        if(sum<=2){
        	return true;
        	
        }return false;
    }
    public static void main(String[] argv){
    	System.out.println(new Solution().validPalindrome("aba"));
    }
}
