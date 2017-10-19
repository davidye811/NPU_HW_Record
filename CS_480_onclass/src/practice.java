import java.util.Scanner;

public class practice {
	static int fac(int n){
		int mul = 1 ;
		for(int i = 1 ; i <= n; i++){
			mul*=i;
		}
		return mul;
	}
	public static void main(String[] argv){
		System.out.printf("%d%f",1,2.0);
	}
	
	static int fac1(int n){
		if(n==1)
			return 1;
		return n*fac1(n-1);
	}
}
