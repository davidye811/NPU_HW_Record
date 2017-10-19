package HW3Ex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] argc){
		//Scanner in = new Scanner(System.in);
		String fileName="E://sourceFile.txt";
		 File file = new File(fileName);
	     Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String stdinBuf;
		System.out.print("java VowelCounter ");
		ArrayList<String> stdinBufs = new ArrayList<String>();
		while(in.hasNext()){
			stdinBuf=in.next();
		
			stdinBufs.add(stdinBuf);
			
		}
		Resource inResource=new Resource(stdinBufs);
		MyThread mm=new MyThread(inResource);
		for(String stdInBuf:stdinBufs){
			synchronized(inResource){
			if(!mm.getStrHistory().containsKey(stdInBuf)){
			new Thread(mm).run();
			}else{
				mm.num++;
				inResource.setCount(inResource.getCount()+mm.getStrHistory().get(stdInBuf));
				
			}
			}
		}
		try {
			mm.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.print("Number of vowels:");
		System.out.println(inResource.getCount());
		System.out.print("Number of threads created:");
		System.out.println(mm.countThread);
	}


}
