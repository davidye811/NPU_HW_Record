package HW3;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] argv){
		String stdinBuf;
		System.out.print("java VowelCounter ");
		ArrayList<String> stdinBufs = new ArrayList<String>();
		for(String args:argv){
			System.out.print(args+" ");
			stdinBufs.add(args);
		}System.out.println();
		Resource inResource=new Resource(stdinBufs);
		MyThread mm=new MyThread(inResource);
		for(int i = 0;i<stdinBufs.size();i++){
			new Thread(mm).run();
		}
		try {
			mm.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("Number of vowels:");
		System.out.println(inResource.getCount());
	/*	System.out.print("Number of threads created:");
		System.out.println(mm.countThread);*/
	}


}
