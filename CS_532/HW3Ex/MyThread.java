package HW3Ex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;

public class MyThread extends Thread{
	MyThread(Resource resource){
		this.resource=resource;
		
	}
	static int countThread=0;
	static int num=0;
	HashMap<String,Integer> strHistory = new HashMap<String,Integer>();
	static Resource resource;
	 public static Resource getResource() {
		return resource;
	}
	Set<Character> VowelDictionary=new HashSet<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
	
	public void run(){
		countThread++;
		String line=resource.getInputPool().get(num);
		int lineCount=0;
		for(char m:line.toCharArray()){
			
			if(VowelDictionary.contains(m)){
				lineCount++;
			}
			
		}
		synchronized(strHistory){
			strHistory.put(line, lineCount);
			}
		synchronized(resource){
		resource.setCount(resource.getCount()+lineCount);
		}
		num++;
		
	}
	public HashMap<String,Integer> getStrHistory(){
		return strHistory;
	}
}
