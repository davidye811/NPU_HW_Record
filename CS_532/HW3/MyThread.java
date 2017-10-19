package HW3;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class MyThread extends Thread{
	MyThread(Resource resource){
		this.resource=resource;
		
	}
	static int countThread=0;
	static int num=0;
	static Resource resource;
	 Set<Character> VowelDictionary=new HashSet<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
	public void run(){
		countThread++;
		String line=resource.getInputPool().get(num);
		for(char m:line.toCharArray()){
			int lineCount=0;
			if(VowelDictionary.contains(m)){
				lineCount++;
			}
			synchronized(resource){
			resource.setCount(resource.getCount()+lineCount);
			}
		}
		num++;
		
	}
}
