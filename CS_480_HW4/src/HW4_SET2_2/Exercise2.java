package HW4_SET2_2;

import java.util.Scanner;

public class Exercise2 {
	private int a,b,c;
	public Exercise2(int a,int b,int c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public int getSum(){
		return a+b+c;
	}
	public double getAverage(){
		return (a+b+c)/3;
	}
	public int getProduct(){
		return a*b*c;
	}
	public int getSmallest(){
		if(a>b)
			return (b>c)?c:b;
		return(a>c)?c:a;
	}
	public int getBiggest(){
		if(a<b)
			return (b<c)?c:b;
		return(a<c)?c:a;
	}
	public static void main(String[] argv){
		Scanner in = new Scanner(System.in);
		System.out.println("print your 3 integer here:");
		while(in.hasNext()){
		Exercise2 new_ex = new Exercise2(in.nextInt(),in.nextInt(),in.nextInt());
		System.out.println("Sum is:"+new_ex.getSum());
		System.out.println("Average is:"+new_ex.getAverage());
		System.out.println("Product is:"+new_ex.getProduct());
		System.out.println("Smallest is:"+new_ex.getSmallest());
		System.out.println("Biggest is:"+new_ex.getBiggest());
		System.out.println("print your 3 integer here:");
		}
	}
}
