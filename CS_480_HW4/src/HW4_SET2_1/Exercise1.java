package HW4_SET2_1;

import java.util.Scanner;

public class Exercise1 {
	public static double getCelsius(double Fahrenheit ){
		return (Fahrenheit-32)*5/9;
		
	}
	public static void main(String[] argv){
		Scanner in = new Scanner(System.in);
		System.out.print("Print Your Fahrenheit degree:");
		while(in.hasNext()){
			System.out.print("So Your Celsius degree will be:");
		System.out.println(getCelsius(in.nextDouble()));
		System.out.print("Print Your Fahrenheit degree:");
		}
	}
}
