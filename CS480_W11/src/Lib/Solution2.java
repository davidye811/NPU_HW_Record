package Lib;
import java.util.*;


public class Solution2 {
	public static void main(String[] argv){
		String[] s ={"4","3 1 3 4","3 1 2 3","2 1 3","3 1 4 2"};
		//String[] s ={"2","2 1 2","2 2 1"};
		//String[] s = {"3","5 1 3 4 5 7","2 1 3","1 2"};
		Map<Integer, List<Integer>> lib = new HashMap<Integer,List<Integer>>();
		List<Integer> libcontainbook = new ArrayList<Integer>();
		Set<Integer> dic =new HashSet<Integer>();
	int LibNum=Integer.parseInt(s[0]);
	for(int i=1;i<=LibNum;i++){
		String singlelib[]=s[i].split(" ");
		libcontainbook = new ArrayList<Integer>();
			for(int j=1;j<singlelib.length;j++){
				int book=Integer.parseInt(singlelib[j]);
				libcontainbook.add(book);
				dic.add(book);
			}
		lib.put(i, libcontainbook);
	}					
	System.out.println(lib);
	System.out.println(dic);
	for(Integer book:dic){
		for(int i=1;i<=LibNum;i++){
			if(!lib.get(i).contains(book)){
				int missbook=book;
				int source=0;
				for(int j=1;j<=LibNum;j++){
					if(lib.get(j).contains(missbook))
						source=j;
				}
				System.out.println(missbook+" "+i+" "+source);
			}
		}
	}
 }
}
