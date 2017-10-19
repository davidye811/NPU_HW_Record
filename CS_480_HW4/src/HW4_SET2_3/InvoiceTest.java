package HW4_SET2_3;

import java.util.Scanner;

public class InvoiceTest {
	public static void main(String[] argv){
		Scanner in = new Scanner(System.in);
		Invoice a1= new Invoice();
		Invoice a2= new Invoice();
		System.out.println(a1.getAmount());
		System.out.println("print your 4 items here(u should put an enter after each item):");
		a2= new Invoice(in.nextLine(),in.nextLine(),in.nextInt(),in.nextDouble());
		System.out.println(a2.toString());
		a2.set_number("Numberchanged");
		a2.set_description("Descriptionchanged");
		a2.set_quantity(13);
		a2.set_price(1.1);
		System.out.println(a2.get_number());
		System.out.println(a2.get_description());
		System.out.println(a2.get_quantity());
		System.out.println(a2.get_price());
		System.out.println(a2.toString());
		}
}
