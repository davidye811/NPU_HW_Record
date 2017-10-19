package aaa;

import java.math.BigInteger;

public class Gen<T,V> {
	static <T,V extends T> boolean aa(T[] t,V[] v){
		if(t.length!=v.length)
			return false;
			for(int i=0;i>t.length;i++){
				if(t[i]!=v[i])
					return false;
			}
		return true;
		
	}
	public static void main(String[] argv){
		Gen<Integer,Double> m= new Gen<Integer,Double>();
		Integer[] a= {1,2,3};
		Double[] b = {1.0,2.0,3.0};
		System.out.println(aa(a, b));
		BigInteger a1 = new BigInteger("1");
		BigInteger b1 = new BigInteger("1");
		System.out.print(a1==b1);
	}
}
