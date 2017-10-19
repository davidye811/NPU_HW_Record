package T3;

import java.util.ArrayList;
import java.util.Scanner;

import T1.StringCombo;

public class Test {
	public static void main(String[] argv){
		StringCombo aa=new StringCombo();
		String a;
		String b;
		Scanner in=new Scanner(System.in);
		while(true){
			System.out.println("your String is:");
			a=in.next();
			System.out.println(aa.reverse(a));
		}
	
	}
}
