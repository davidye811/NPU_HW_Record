package T1;
public class T1 {
	public String output(int a){
		return "a:"+a;
	}
	public String output(int a,int b){
		return "a and b:"+a+","+b;
	}
	public String output(double a){
		return "double a:"+a;
	}
	public String output(){
		return "OutPut:"+30.25;
	}
	public static void main(String []argv){
		T1 a=new T1();
		System.out.println(a.output(10));
		System.out.println(a.output(10,20));
		System.out.println(a.output(5.5));
		System.out.println(a.output());
	}
}
