package _FizzBuzz;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();
        if(n<1)
            return result;
        for(int i =1;i<=n;i++){
        StringBuffer sbf= new StringBuffer();
        
            if(i%3!=0&&i%5!=0){
                sbf.append(i+"");
                result.add(sbf.toString());
                continue;
            }
            if(i%3==0){
                sbf.append("Fizz");
            }
            if(i%5==0){
                sbf.append("Buzz");
            }
            result.add(sbf.toString());
        }
        return result;
    }
    public static void main(String[] argv){
    	System.out.println(new Solution().fizzBuzz(3));
    }
}