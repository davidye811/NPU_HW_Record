package class16;

public class Test {
	public static void main(String[] argv){
		int []a1={1,3,5,7,9,-1,-1,-1};
		int []b1={2,4,6};
		int []a2={1,3,5,-1,-1,-1,-1,-1};
		int []b2={2,4,6,8,10};
		int []aex1={1,3,5,7,9};
		int []aex2={1,3,5};
		sortarray m=new sortarray();
		//int[] c =m.algor1(aex1,b1);
		//int[] c =m.algor1(aex2,b2);
		//int[] c =m.algor2(a1,b1);
		int[] c =m.algor2(a1,b1);
		for(int i=0;i<c.length;i++){
			System.out.print(c[i]+"\t");
		}
		System.out.println();
	}
	
}

