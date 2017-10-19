package T1;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] argv){
		StringCombo aa=new StringCombo();
		String a;
		String b;
		Scanner in=new Scanner(System.in);
		while(true){
			System.out.println("your main String is:");
			a=in.next();
			System.out.println("your sub String is:");
			b=in.next();
		//System.out.println(aa.count("newroadnewcarnewnewnewpetfanfunnewgun","new"));
			System.out.println(b+" appears for "+aa.count(a,b)+" times in "+a);
		}
	}
}
