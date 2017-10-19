package Lib;

import java.util.*;


public class Solution {
	public static void main(String[] argv){
	//String[] s ={"4","3 1 3 4","3 1 2 3","2 1 3","3 1 4 2"};
		//String[] s ={"2","2 1 2","2 2 1"};
	String[] s = {"3","5 1 3 4 5 7","2 1 3","1 2"};
	Map<Integer, HashSet<Integer>> lib = new HashMap<Integer,HashSet<Integer>>();
	List<Integer> contain=new LinkedList<Integer>();
	int LibNum=Integer.parseInt(s[0]);
	for(int i=1;i<=LibNum;i++){
		String singlelib[]=s[i].split(" ");
			for(int j=1;j<singlelib.length;j++){
				int book=Integer.parseInt(singlelib[j]);
					if(!lib.containsKey(book))
						lib.put(book,new HashSet<Integer>() );
					
						lib.get(book).add(i);
					
			}
	}
	System.out.println(lib);
	for(Integer i:lib.keySet()){
		for(int j=1;j<=LibNum;j++){
			if(!lib.get(i).contains(j)){
				System.out.println(i+" "+lib.get(i).iterator().next()+" "+j);
			}
		}
	}
	System.out.println("done");
 }
}
