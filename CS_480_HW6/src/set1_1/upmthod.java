package set1_1;

public class upmthod {
	public static int average(int[] array){
		int sum=0;
		for(int i = 0 ;i<array.length;){
			sum+=array[i++];
		}
		return sum/array.length;
	}
	public static double average(double[] array){
		double sum=0;
		for(int i = 0 ;i<array.length;){
			sum+=array[i++];
		}
		return sum/array.length;
	}
	public static  String average(double average){
		if(average<=0)
			return new String(average+"");
		StringBuffer aa=new StringBuffer(average+"");
		while(aa.indexOf("1")!=-1){			
			int a =aa.indexOf("1");
			aa.deleteCharAt(a);				
			aa.insert(a, "One");
		}
		while(aa.indexOf("2")!=-1){			
			int a =aa.indexOf("2");
			aa.deleteCharAt(a);				
			aa.insert(a, "Two");
		}
		while(aa.indexOf("3")!=-1){			
			int a =aa.indexOf("3");
			aa.deleteCharAt(a);				
			aa.insert(a, "Three");
		}
		while(aa.indexOf("4")!=-1){			
			int a =aa.indexOf("4");
			aa.deleteCharAt(a);				
			aa.insert(a, "Four");
		}
		while(aa.indexOf("5")!=-1){			
			int a =aa.indexOf("5");
			aa.deleteCharAt(a);				
			aa.insert(a, "Five");
		}
		while(aa.indexOf("6")!=-1){			
			int a =aa.indexOf("6");
			aa.deleteCharAt(a);				
			aa.insert(a, "Six");
		}
		while(aa.indexOf("7")!=-1){			
			int a =aa.indexOf("7");
			aa.deleteCharAt(a);				
			aa.insert(a, "Seven");
		}
		while(aa.indexOf("8")!=-1){			
			int a =aa.indexOf("8");
			aa.deleteCharAt(a);				
			aa.insert(a, "Eight");
		}
		while(aa.indexOf("9")!=-1){			
			int a =aa.indexOf("9");
			aa.deleteCharAt(a);				
			aa.insert(a, "Nine");
		}
		while(aa.indexOf("0")!=-1){			
			int a =aa.indexOf("0");
			aa.deleteCharAt(a);				
			aa.insert(a, "Zero");
		}
		return aa.toString();
	}
}
