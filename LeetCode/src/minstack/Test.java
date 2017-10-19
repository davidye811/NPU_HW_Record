package minstack;

public class Test {
	public static void main(String[] argv){
		System.out.println(trailingZeroes(15));
	}
	 public static int trailingZeroes(int n) {
	        if(n<=0)
	        return 0;
	      
	        int sum=0;
	        int result=1;
	        int fac=1;
	        while(fac<=n){
	            result*=fac;
	            fac++;
	            if(result%10==0){
	                sum++;
	                result/=10;
	            }
	            if(result>10){
	            	result=result%10;
	            }
	          //  System.out.println(result);
	        }
	        return sum;
	    }
}
