package set1_1;

import java.util.Scanner;

public class test {
	public static void main(String[] argv){
		Scanner in = new Scanner(System.in);
		double[] aa= new double[10];
		for(int i=0;i<10;i++)
			aa[i]=in.nextDouble();
		upmthod nn=new upmthod();
		System.out.println(nn.average(aa));
		System.out.println(nn.average(nn.average(aa)));
	}
}
