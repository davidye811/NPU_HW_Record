package Map;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer,Integer> aa = new HashMap<Integer,Integer>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(!aa.containsKey(nums[i])){
            	aa.put(nums[i], 0);
            	count++;
            }else{
            	if(aa.get(nums[i])==0){
            		aa.replace(nums[i], 1);
            		count++;
            	}
            }
        }
       
        return count;
    }
    public static void main(String[] argv){
    	Solution a =new Solution();
    	int[] nums = {1,1,2,2,1,2,3};
    	System.out.print(a.removeDuplicates(nums));
    }
}