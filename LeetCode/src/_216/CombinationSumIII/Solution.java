package _216.CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] argv){
		new Solution().combinationSum3(3,9);
	}
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        getResult(results,1,result,k,n);
        return results;
    }
    public void getResult(List<List<Integer>> results,int itr,List<Integer> result,int k,int n){
        if(k<=0)
            return;
        int sum=0;
        for(int i:result){
            sum+=i;
        }
        for(int i=itr;i<=9;i++){
            if(sum+i<n){
            	result.add(i);
                getResult(results,i+1,result,k-1,n);
                return;
            }
            else if(sum+i==n){
                result.add(i);
                results.add(result);
                return;
            }else{
                return;
            }
        }    
    }
}