package set3;

public class Main {
	public static void main(String[] argv){
		IncomeTax m1 = new IncomeTax(3000);
		System.out.println(m1);
		FederalIncomeTax m2 = new FederalIncomeTax(3000);
		System.out.println(m2);
		StateIncomeTax m3 = new StateIncomeTax(3000);
		System.out.println(m3);
	}
}
