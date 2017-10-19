package Lab2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Solution {
	final static int SizeOfBook=30000;
	public static void main(String[] argv){
		BookLib BookGenerA=new BookLib(SizeOfBook);
		//for(Entry<Integer, Book> BookEntry:lib.entrySet()){
		//	System.out.println(BookEntry.getValue());
		//}
		System.out.println(BookGenerA);
		System.out.println();
		System.out.println();
		System.out.print("Which book is the one that u want to look for? ISBN:");
		Scanner in=new Scanner(System.in);
		int InputTemp;
		while(in.hasNext()){
			 InputTemp=in.nextInt();
			 if(InputTemp==0){
				 in.close();
				 break;
			 }else{
				 System.out.println("The Book is: "+BookGenerA.SearchBookByISBN(InputTemp));
				 System.out.print("Which book is the one that u want to look for? ISBN:");
			 }
		}
	}
}
