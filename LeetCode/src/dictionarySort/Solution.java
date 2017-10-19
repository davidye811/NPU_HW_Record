package dictionarySort;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> result;
    int n ;
    public List<Integer> lexicalOrder(int n) {
        this.result=new ArrayList<Integer>();
        this.n=n;
        solve(1);
        return result;
    }
    void solve(int m){
        result.add(m);
        if(m*10<=n) solve(m*10);
        if(m<n&&m%10<9) solve(m+1);
    }
    public static void main(String[] argv){
    	Solution a = new Solution();
    	System.out.println(a.lexicalOrder(13));
    }
    
}