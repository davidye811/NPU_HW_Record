import java.util.Scanner;

public class Stringbuffertext {
	public static void main(String[] argv){
		Scanner in = new Scanner(System.in);
		System.out.print("input your String here:");
		while(in.hasNext()){
			String mm = in.nextLine();
			System.out.print("the output is:");
			System.out.println(ChangetoResult(mm));
		}
		}
	public static String ChangetoResult(String in){
		StringBuffer aa= new StringBuffer(in);
		while(aa.indexOf(" ")!=-1){			//end while i cannot find any " " in the Stringbuffer
			int a =aa.indexOf(" ");
			aa.deleteCharAt(a);				//delete the blank and insert "you" at the index
			aa.insert(a, "you");
		}
		return aa.toString();
		
	}
}
