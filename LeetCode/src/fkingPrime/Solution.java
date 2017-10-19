package fkingPrime;

class Solution {
    public int countPrimes(int n) {
        int sum=0;
        for(int i =1;i<n;i+=1){
            if(isPrime(i)){
                sum++;
            }
        }
        return sum;
    }
    private boolean isPrime(int n ){
        if(n==2)
            return true;
        if(n==1)
            return false;
        for(int i =2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
                
            }
        }
        return true;
    }
    public static void main(String[] arfv){
    	System.out.println(new Solution().countPrimes(5));
    }
}