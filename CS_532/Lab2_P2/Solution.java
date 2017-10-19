package Lab2_P2;

import java.util.*;

import Lab2.Book;
import Lab2.StringGenerator;

public class Solution {
	
	final static int SizeOfName=8;

	public static void main(String[] argv){
		StringGenerator sg=new StringGenerator(8);
		TreeSet<String> sortedStringWithSet = new TreeSet<String>(new MyStringComp());
		SortedString sortedString=new SortedString(SizeOfName);
		String NameToAdd;
		for(int i=0;i<SizeOfName;i++){
			NameToAdd=sg.generateStr();
			sortedString.addNameToSortedArrayList(NameToAdd);
			sortedStringWithSet.add(NameToAdd);
		}
	
			System.out.println(sortedString);
			for(String itr:sortedStringWithSet){
				System.out.println(itr);
			}
	}
	
}
class MyStringComp implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		if(o1.compareTo(o2)>0)
			return -1;
		if(o1.compareTo(o2)==0)
			return 0;
		// TODO Auto-generated method stub
		return 1;
	}

}