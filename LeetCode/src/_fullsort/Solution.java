package _fullsort;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null){
            return null;
        }
        List<List<Integer>> result=help(nums.length-1,nums);
        result.add(new ArrayList<Integer>());
        return result;
    }
    public List<List<Integer>> help(int index,int[] nums){
        if(index<0){
            return new ArrayList<List<Integer>>();
        }
         List<List<Integer>> pre=help(index-1,nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(List<Integer> column:pre){
            
            
            	List<Integer> temp = new ArrayList<Integer>();
                temp.addAll(column);
                temp.add(nums[index]);
                result.add(temp);
            
            result.add(column);
            
        }
        ArrayList<Integer> single =new ArrayList<Integer>();
        single.add(nums[index]);
        result.add(single);
        return result;
    }
    public static void main(String[] arv){
    	int[] nums={1,2,3};
    	System.out.println(new Solution().subsets(nums));
    }
}