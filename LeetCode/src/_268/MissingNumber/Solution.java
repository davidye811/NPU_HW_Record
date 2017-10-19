package _268.MissingNumber;

public class Solution {
	 public int missingNumber(int[] nums) {
		return dfs(0,nums.length,nums);
	        
	    }
	 public int dfs(int begin,int end,int[] nums){
		 if(end-begin<2){
			 if(nums[begin]==begin)
				 return end;
			 else
				 return begin;
		 }
		 if(nums[(begin+end)/2]==(begin+end)/2)
			 return dfs((begin+end)/2,end,nums);
		 if(nums[(begin+end)/2]==(begin+end)/2+1)
			 return dfs(begin,(begin+end)/2,nums);
		 return 0;
	 }
	 
}
//{0,1,2,3,4,5,7,8,9,10}