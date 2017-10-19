package set2;

public class Test {
	public static void main(String[] argv){
		Acount a1=new Acount("David John");			//b.
		Acount a2=new Acount("Marin Jackson",5000);
		System.out.println(a1);
		System.out.println(a2);
		a1.SavingsAccount(100);
		System.out.println(a1);
		a2.SavingsAccount(2, true);
		System.out.println(a2);
	}
}
