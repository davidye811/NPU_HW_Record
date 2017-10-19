package _62.UniquePaths;

public class Solution {
//	public static void main(String[] argv){
//		System.out.println(new Solution().uniquePaths(23, 12));
//	}
    static int[][] result;
   public int uniquePaths(int m, int n) {
      result = new int[m][n];
      result[0][0]=1;
      return dp(m-1,n-1);
   }
   int dp(int m,int n){
       if(result[m][n]!=0)
         return result[m][n];
           if(m!=0&&n!=0)
               return dp(m-1,n)+dp(m,n-1);
           if(m==0)
               return dp(m,n-1);
         
               return dp(m-1,n);
        }
}
