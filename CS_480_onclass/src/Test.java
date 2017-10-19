
public class Test implements Callback{
	static void callback(){
		System.out.print("mmm");
	}
	public static void main(String[] argv){
		String s1 ="Java";
		String s2 = "Java";
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		System.out.println(s1==s2);
	}
}
